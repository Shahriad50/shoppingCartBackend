package com.dreamshopbackend.demo.mapper;

import com.dreamshopbackend.demo.dto.CategoryDto;
import com.dreamshopbackend.demo.dto.ImageDto;
import com.dreamshopbackend.demo.entity.Category;
import com.dreamshopbackend.demo.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ImageMapper {
      ImageDto mapToImageDto(Image imageDto);

    Image mapToImage(ImageDto dto);
}
