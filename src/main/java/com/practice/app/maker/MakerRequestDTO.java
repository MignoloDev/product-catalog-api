package com.practice.app.maker;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MakerRequestDTO(
        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Country is required")
        String country,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Phone is required")
        String phone
) {}

