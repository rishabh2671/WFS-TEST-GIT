package com.example.ProjectService_WFS.controller;

import com.example.ProjectService_WFS.DTO.ProductRequestDTO;
import com.example.ProjectService_WFS.DTO.ProductResponseDTO;
import com.example.ProjectService_WFS.fakestoreapi.FakeStoreProductResponse;
import com.example.ProjectService_WFS.mapper.ProductMapper;
import com.example.ProjectService_WFS.models.Product;
import com.example.ProjectService_WFS.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

     public ProductController(IProductService productService){
         this.productService = productService;
     }

    @GetMapping("/")    //localhost:8080/products/
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts()
    {
        List<Product> data = productService.getAllProducts();

        List<ProductResponseDTO> res = ProductMapper.getListOfProductResponseDtoFromProductList(data);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO dto) {

        Product product = ProductMapper.getProductFromProductRequestDTO(dto);

        Product data = productService.createProducts(product);

        ProductResponseDTO res = ProductMapper.getProductResponseDtoFromProduct(data);


        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable("productId") Long productId){


         try{
             Product product = productService.getProductById(productId);

             ProductResponseDTO res = ProductMapper.getProductResponseDtoFromProduct(product);

             if(Objects.isNull(res)){
                 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
             }

             MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
             headers.add("class-name" , "integrating APIs");

             return new ResponseEntity<>(res,headers,HttpStatus.OK);

         }catch(Exception e){
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }


    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> patchProductId(@PathVariable("productId") Long productId,
                                                                   @RequestBody ProductRequestDTO dto){
        Product product = ProductMapper.getProductFromProductRequestDTO(dto);

        Product updatedProduct = productService.patchProducts(productId,product);

        ProductResponseDTO res = ProductMapper.getProductResponseDtoFromProduct(updatedProduct);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}
