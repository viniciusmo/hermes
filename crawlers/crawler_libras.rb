#!/bin/env ruby
# encoding: utf-8

require "rubygems"
require "open-uri"
require "net/http"
require "nokogiri"
require "i18n"	

class CrawlerLibras
 ALFABETO_SWF = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','x','w','y','z']
 ALFABETO_IMAGEM = ['0zero','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','J','k','L','m','n','o','p','q','R','s','t','U','V','x','W','Y','z']
 def get_content_swf	
 	ALFABETO_SWF.each { |letra|
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
end

crawler = CrawlerLibras.new
#crawler.get_content_swf()
#crawler.get_content_imagem()
crawler.get_content_palavras()

