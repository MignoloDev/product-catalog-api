package com.practice.app.product;

import com.practice.app.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto){
        return Product.builder()
                .name(dto.name())
                .price(dto.price())
                .build();
    }

    public ProductResponseDTO toResponseDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }

}
