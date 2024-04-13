package com.krish.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krish.entity.ImageEntity;

public interface ImageRepository extends JpaRepository<ImageEntity, Integer>{

	Optional<ImageEntity> findByName(String fileName);
}
