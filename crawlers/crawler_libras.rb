#!/bin/env ruby
# encoding: utf-8

require "rubygems"
require "open-uri"
require "net/http"
require "nokogiri"
require "i18n"	
require 'watir-webdriver'

class CrawlerLibras
 ALFABETO = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','w','y','z']
 ALFABETO_IMAGEM = ['0zero','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','J','k','L','m','n','o','p','q','R','s','t','U','V','x','W','Y','z']
 BASE_ARASAAC_URL = 'http://www.catedu.es/arasaac/'
 DATA_DIR = "/home/paulo/"
 RUBY_VERSION = "1.9.3p374"
 
 HEADERS_HASH = {"User-Agent" => "Ruby/#{RUBY_VERSION}"}
 Dir.mkdir(DATA_DIR) unless File.exists?(DATA_DIR)
 
 def get_content_swf	
 	ALFABETO.each { |letra|
		Net::HTTP.start("www.acessobrasil.org.br",80) do |http|
				resp = http.get("/libras/filme/"+ letra +"Sm_Prog001.swf")
				file = File.new("/home/paulo/libras/swf/"+ letra +".swf", "wb")
				file.write(resp.body)
				file.close
		end
	}	
	puts "SWF Done."
 end
 
 def get_content_imagem
 	ALFABETO_IMAGEM.each { |letra|
		Net::HTTP.start("www.libras.org.br",80) do |http|
				resp = http.get("/Thumbnails/images/libras_"+ letra +".jpg")
				file = File.new("/home/paulo/libras/imagens/"+ letra.upcase() +".jpg", "w")
				file.write(resp.body)
				file.close
		end
	}	
	puts "Imagem Done."
 end
	
	def get_content_palavras
		ALFABETO_SWF.each { |letra|
			Net::HTTP.start("www.acessobrasil.org.br",80) do |http|
				resp = http.get("/libras/consultaPersonalizada.php?opcao=1&minhapalavra="+ letra)
				xml = resp.body
				doc = Nokogiri::XML(xml)
					doc.xpath('//products/item').each { |node|
					 palavra = node['palavra']
						 if(!palavra.nil? && !palavra.empty?)
							 	palavra = tratar_palavra(palavra)
							 	get_content_swf(palavra) 
						 end
					}
			end
		}
		puts "Palavras Done."
 	end
 	def tratar_palavra(palavra)
 		I18n.transliterate(palavra).downcase
  end
 def get_content_swf(palavra)	
		Net::HTTP.start("www.acessobrasil.org.br",80) do |http|
				resp = http.get("/libras/filme/"+ palavra +"Sm_Prog001.swf")
				if(!resp.nil? && resp.code == "200")
					palavra = palavra.encode "UTF-8"
					file = File.new("/home/paulo/libras/palavras/swf/"+ palavra +".swf", "wb")
					file.write(resp.body)
					file.close
					puts "palavra #{palavra} salva !!!"
				end
		end
 end
 
 def get_libras_w3ca
 	count = 0
 	libras = Hash.new
 	ALFABETO.each { |letra|
 		Net::HTTP.start("libras.w3ca.com.br",80) do |http|
				resp = http.get("/letra/#{letra}/")
				doc = Nokogiri::HTML(resp.body)
				linhas = doc.css('tbody/tr')
					linhas.each{ |linha|
						palavra = linha.css('td/a').text
						puts "palavra: #{palavra}"
						palavra_tratada = palavra.gsub(' ', '-')
						begin
							browser = Watir::Browser.start 'http://libras.w3ca.com.br/dicionario/' + palavra_tratada
							page = Nokogiri::HTML.parse(browser.html)
							browser.close
							url = page.css('object#myytplayer')[0]["data"]
							puts "url: #{url}"
							libras[palavra] = url
							count += 1
							puts "total: #{count}"
						rescue Exception => e
							puts "Erro palavra: #{palavra}"
   						file = File.new("#{DATA_DIR}libras_erros.txt", "a")
							file.puts(palavra)
							file.close
 						end
					}
		end
 	}
 	write_xml(libras)
 end
 
 def write_xml(libras)
 		builder = Nokogiri::XML::Builder.new do |xml|
		xml.palavras {
			libras.each do|palavra,url|
				xml.palavra {
					xml.palavra(palavra.downcase)
					xml.url(url)
				}
			end
		}
	end
	xml_file = File.new("#{DATA_DIR}libras.xml", "w")
	xml_file.write(builder.to_xml)
	xml_file.close
 end
end

crawler = CrawlerLibras.new
#crawler.get_content_swf()
#crawler.get_content_imagem()
#crawler.get_content_palavras()
crawler.get_libras_w3ca()

