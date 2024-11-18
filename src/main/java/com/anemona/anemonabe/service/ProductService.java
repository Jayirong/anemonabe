package com.anemona.anemonabe.service;

import java.util.List;

import com.anemona.anemonabe.model.Product;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long productId);
    Product updateProduct(Long productId, Product updatedProduct);
    void deleteProductById(Long productId);
}
