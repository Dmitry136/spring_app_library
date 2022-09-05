package com.erygindmitri.springlibrary.spring_app_library.controller;

import com.erygindmitri.springlibrary.spring_app_library.models.Image;
import com.erygindmitri.springlibrary.spring_app_library.repositories.ImageRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
public class ImageController {
    private final ImageRepository imageRepository;

    public ImageController(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Integer id){
        Image image = imageRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("fileName", image.getOriginalFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }
}
