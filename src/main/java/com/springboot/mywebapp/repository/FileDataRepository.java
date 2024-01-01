package com.springboot.mywebapp.repository;

import com.springboot.mywebapp.modal.FileData;
import com.springboot.mywebapp.modal.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository  extends JpaRepository<FileData, Integer> {

    Optional<FileData> findByName(String filename);
}
