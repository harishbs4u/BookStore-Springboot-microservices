package com.harish.bookstore.catalog.web.controllers;

import com.harish.bookstore.catalog.domain.PagedResult;
import com.harish.bookstore.catalog.domain.Product;
import com.harish.bookstore.catalog.domain.ProductNotFoundException;
import com.harish.bookstore.catalog.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {

        return productService.getProducts(pageNo);
    }
    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
       // log.info("Fetching product for code: {}", code);
        return productService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }

}
