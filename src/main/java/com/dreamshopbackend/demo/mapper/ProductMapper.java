package com.dreamshopbackend.demo.mapper;

import com.dreamshopbackend.demo.dto.ProductDto;
import com.dreamshopbackend.demo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


// Convert Product entity to ProductDTO
@Component
public class ProductMapper{
    public ProductDto mapToProductDto(Product product) {
        ProductDto productDTO = new ProductDto();
        productDTO.setProduct_id(product.getProduct_id());
        productDTO.setProduct_name(product.getProduct_name());
        productDTO.setProduct_category(product.getProduct_category());
        productDTO.setProduct_brand(product.getProduct_brand());
        productDTO.setPrice(product.getPrice());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setInventory(product.getInventory());
        productDTO.setDescription(product.getDescription());

        // Map category_id
        if (product.getCategory() != null) {
            productDTO.setCategory_id(product.getCategory().getCategory_id());
        }

//        // Map image URLs
//        if (product.getImages() != null) {
//            List<String> imageUrls = product.getImages()
//                    .stream()
//                    .map(Image::getImage_url)
//                    .collect(Collectors.toList());
//            productDTO.setImage_urls(imageUrls);
//        }

        return productDTO;
    }

    // Convert ProductDTO to Product entity
    public static Product mapToProduct(ProductDto productDTO) {
        Product product = new Product();
        product.setProduct_id(productDTO.getProduct_id());
        product.setProduct_name(productDTO.getProduct_name());
        product.setProduct_category(productDTO.getProduct_category());
        product.setProduct_brand(productDTO.getProduct_brand());
        product.setPrice(productDTO.getPrice());
        product.setDiscount(productDTO.getDiscount());
        product.setInventory(productDTO.getInventory());
        product.setDescription(productDTO.getDescription());

        // Note: Category and Images need to be set separately in the service layer
        return product;
    }
}