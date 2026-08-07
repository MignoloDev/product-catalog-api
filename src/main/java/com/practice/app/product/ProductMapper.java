package com.practice.app.product;

import com.practice.app.entity.Maker;
import com.practice.app.entity.Product;
import com.practice.app.maker.MakerRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final MakerRepository makerRepository;

    public ProductMapper(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    public Product toEntity(ProductRequestDTO dto) {
        Maker maker = makerRepository.findById(dto.makerId())
                .orElseThrow(() -> new RuntimeException("Maker not found"));

        return Product.builder()
                .name(dto.name())
                .price(dto.price())
                .maker(maker)
                .build();
    }

    public ProductResponseDTO toResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getMaker().getName()
        );
    }
}
