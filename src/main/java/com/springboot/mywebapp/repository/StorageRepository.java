package com.springboot.mywebapp.repository;

import com.springboot.mywebapp.modal.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Long> {

    Optional<ImageData> findByName(String filename);
}
