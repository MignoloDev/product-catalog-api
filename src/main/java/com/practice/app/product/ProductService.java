package com.practice.app.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductResponseDTO> findAll();

    Optional<ProductResponseDTO> findById(Long id);

    ProductResponseDTO save(ProductRequestDTO dto);

    ProductResponseDTO update(Long id, ProductRequestDTO dto);

    void deleteById(Long id);

}