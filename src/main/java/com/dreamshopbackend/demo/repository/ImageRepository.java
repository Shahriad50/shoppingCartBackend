package com.dreamshopbackend.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dreamshopbackend.demo.entity.Image;
public interface ImageRepository extends JpaRepository<Image,Long> {
}
