package com.krish.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Lob;

import org.springframework.data.annotation.Id;

import lombok.Builder;


@Entity
@Builder
public class ImageEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String type;
	
	@Lob
	private byte[] imageData;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public byte[] getImageData() {
		return imageData;
	}



	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}



	public ImageEntity(Integer id, String name, String type, byte[] imageData) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.imageData = imageData;
	}

	
	
}
