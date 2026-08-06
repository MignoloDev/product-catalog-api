package com.practice.app.product;

import java.math.BigDecimal;

public record ProductRequestDTO(String name, BigDecimal price) {
}
