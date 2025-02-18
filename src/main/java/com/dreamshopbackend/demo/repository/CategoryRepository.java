package com.dreamshopbackend.demo.repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dreamshopbackend.demo.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
