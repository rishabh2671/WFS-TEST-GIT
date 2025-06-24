package com.example.ProjectService_WFS.controller;

import com.example.ProjectService_WFS.DTO.CreateProductRequestDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/")    //localhost:8080/products/
    public String getAllProducts()
    {
        return "all products.....";
    }

    @PostMapping("/")
    public String createProduct(@RequestBody CreateProductRequestDTO dto) {
        return "All products created....." + dto.getProductName();
    }

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Integer productId){
        return "user is"+ productId;

    }
}
