package com.krish.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.krish.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageRestController {

	@Autowired
	private ImageService service;
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws Exception{
		String uploded = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK)
				             .body(uploded);
	}
	
	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(String fileName){
		byte[] downloded = service.downloadImage(fileName);
		
		return ResponseEntity.status(HttpStatus.OK)
				             .contentType(MediaType.valueOf("image/png"))
				             .body(downloded);
	}
}
