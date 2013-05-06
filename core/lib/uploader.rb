class Uploader

	def self.upload folder,data
		path = "public/#{folder}/#{data.original_filename}"
		File.open(path,'wb') do |f|
			f.write data.read
		end
	end
	
end