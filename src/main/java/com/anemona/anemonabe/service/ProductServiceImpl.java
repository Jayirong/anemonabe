package com.anemona.anemonabe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anemona.anemonabe.model.Product;
import com.anemona.anemonabe.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no pillado >:P"));
    }

    @Override
    public Product updateProduct(Long productId, Product updatedProduct) {
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setNombre(updatedProduct.getNombre());
        product.setDescripcion(updatedProduct.getDescripcion());
        product.setPrecio(updatedProduct.getPrecio());
        product.setTipo(updatedProduct.getTipo());
        product.setStock(updatedProduct.getStock());
        product.setImg_ruta(updatedProduct.getImg_ruta());

        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productRepository.deleteById(productId);
    }
    
}