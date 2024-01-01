package com.springboot.mywebapp.controller;

import com.springboot.mywebapp.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
//@RequestMapping("/image")
public class ImageController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/image")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
       String uploadImage = storageService.uploadImage(file);
       return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/image/{fileName}")
    public ResponseEntity<?> getImage(@PathVariable String fileName) {
        System.out.println("Get Image Method");
     byte [] bytes =  storageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(bytes);
    }

    @PostMapping("/filesystem/image")
    public ResponseEntity<?> uploadImageFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImageFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/filesystem/{fileName}")
    public ResponseEntity<?> getImageFromFileSystem(@PathVariable String fileName) throws IOException {
        System.out.println("Get Image Method");
        byte [] bytes =  storageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(bytes);
    }


}
