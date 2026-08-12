package com.practice.app.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Price is required")
        @Positive(message = "Prince must be greater than zero")
        BigDecimal price,

        @NotBlank(message = "makerId is required")
        Long makerId
) {}
