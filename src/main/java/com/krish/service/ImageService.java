package com.krish.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.krish.entity.ImageEntity;
import com.krish.repo.ImageRepository;
import com.krish.utils.ImageUtils;

@Service
public class ImageService {

	@Autowired
	private ImageRepository repo;
	
	
	public String uploadImage(MultipartFile file)throws IOException {
		
		ImageEntity imageData = repo.save(ImageEntity.builder()
				             .name(file.getOriginalFilename())
				             .type(file.getContentType())
				             .imageData(ImageUtils.compressImage(file.getBytes())).build());
		
		    
		          if(imageData !=null) {
		        	  
		        	  return "File uploaded successfully"+file.getOriginalFilename();
		          }
		          
		          return null;
	}
	
	public byte[] downloadImage(String fileName) {
		Optional<ImageEntity> imageData = repo.findByName(fileName);
		byte[] image = ImageUtils.decompressImage(imageData.get().getImageData());
	
	    return image;
	}
}
