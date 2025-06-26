package com.example.ProjectService_WFS.service;

import com.example.ProjectService_WFS.models.Product;

import java.util.List;

public interface IProductService {

     Product getProductById(Long productId);
     List<Product> getAllProducts();
     Product createProducts(Product product);
     Product patchProducts(Long productId, Product product);
}
