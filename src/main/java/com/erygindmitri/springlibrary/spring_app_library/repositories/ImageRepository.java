package com.erygindmitri.springlibrary.spring_app_library.repositories;

import com.erygindmitri.springlibrary.spring_app_library.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
