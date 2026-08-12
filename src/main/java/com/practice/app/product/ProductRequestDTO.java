package com.practice.app.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Price is required")
        @Positive(message = "Prince must be greater than zero")
        BigDecimal price,

        @NotNull(message = "Maker ID is required")
        Long makerId
) {}
