package com.magicmarket.magicmarket.domain.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestCreateProduct(
        @NotBlank
        String name,
        @NotNull
        Integer price_in_cents
) { }
