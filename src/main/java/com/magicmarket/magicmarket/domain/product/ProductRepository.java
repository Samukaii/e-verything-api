package com.magicmarket.magicmarket.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
    Optional<Product> findByActiveTrueAndId(String id);
    @Query(value = "select p from products p where p.active = true and lower(p.name) like %?1%")
    List<Product> searchProductsByName(String search);
}
