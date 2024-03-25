package com.magicmarket.magicmarket.domain.product;

public record RequestUpdateProduct(
        String name,
        Integer price_in_cents
) { }
