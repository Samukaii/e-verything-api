package com.magicmarket.magicmarket.controllers;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.magicmarket.magicmarket.domain.product.ProductRepository;
import com.magicmarket.magicmarket.domain.product.Product;
import com.magicmarket.magicmarket.domain.product.RequestCreateProduct;
import com.magicmarket.magicmarket.domain.product.RequestUpdateProduct;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String name) {
        if(name != null && !name.isBlank()) {
            var result = repository.searchProductsByName(name.toLowerCase());

            return ResponseEntity.ok(result);
        }


        return ResponseEntity.ok(repository.findAllByActiveTrue());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable String id) {
        Optional<Product> optionalProduct = repository.findByActiveTrueAndId(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(true);
            return ResponseEntity.ok(product);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @PostMapping
    public ResponseEntity<Product> registerProduct(@RequestBody @Valid RequestCreateProduct data) {
        Product newProduct = new Product(data);

        repository.save(newProduct);

        return ResponseEntity.ok(newProduct);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody @Valid RequestUpdateProduct data) {
        Optional<Product> optionalProduct = repository.findById(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @PutMapping("/{id}/recover")
    @Transactional
    public ResponseEntity<Product> recoverProduct(@PathVariable String id) {
        Optional<Product> optionalProduct = repository.findById(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(true);
            return ResponseEntity.ok(product);
        }
        else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Product> deleteProduct(@PathVariable String id) {
        Optional<Product> optionalProduct = repository.findById(id);

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.ok(product);
        }
        else {
            throw new EntityNotFoundException();
        }
    }
}
