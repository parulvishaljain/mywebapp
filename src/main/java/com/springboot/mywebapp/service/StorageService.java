package com.springboot.mywebapp.service;

import com.springboot.mywebapp.modal.FileData;
import com.springboot.mywebapp.modal.ImageData;
import com.springboot.mywebapp.repository.FileDataRepository;
import com.springboot.mywebapp.repository.StorageRepository;
import com.springboot.mywebapp.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    @Autowired
    private FileDataRepository fileDataRepository;

    public String uploadImage(MultipartFile file) throws IOException {
      ImageData imageData =  repository.save(ImageData.builder().name(file.getOriginalFilename()).type(file.getContentType()).imageData(ImageUtils.compressImage(file.getBytes())).build());

      if(null != imageData) {
          return "file uploaded successfully : "+ file.getOriginalFilename();
      }
      return null;
    }

    public String uploadImageFileSystem(MultipartFile file) throws IOException {
        String filePath = "D:\\Interview-Preparation\\fileSystem\\";
        String fullFilePath = filePath + file.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder().name(file.getOriginalFilename()).type(file.getContentType()).filePath(fullFilePath).build());
        file.transferTo(new File(fullFilePath));
        if(fileData != null) {
            return "file uploaded successfully : " + fullFilePath;
        }
        return null;
    }

    public byte[] downloadImage(String filename) {
       Optional<ImageData> dbImageData = repository.findByName(filename);
        byte[] byteArr = ImageUtils.decompressImage(dbImageData.get().getImageData());
        return byteArr;
    }
    public byte[] downloadImageFromFileSystem(String filename) throws IOException {

             Optional<FileData> fileData = fileDataRepository.findByName(filename);
        String filePath = fileData.get().getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }
}
