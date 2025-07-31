package com.harish.bookstore.catalog.domain;

class ProductMapper {
    static Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getCode(),
                productEntity.getName(),
                productEntity.getDescription(),
                productEntity.getImage_url(),
                productEntity.getPrice());
    }
}
