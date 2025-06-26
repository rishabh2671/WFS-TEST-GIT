package com.example.ProjectService_WFS.mapper;

import com.example.ProjectService_WFS.DTO.ProductRequestDTO;
import com.example.ProjectService_WFS.DTO.ProductResponseDTO;
import com.example.ProjectService_WFS.fakestoreapi.FakeStoreProductResponse;
import com.example.ProjectService_WFS.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {

    public static Product getProductFromFakeStore(FakeStoreProductResponse dto){
        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setImage(dto.getImage());

        return product;
    }

    public static List<Product> getProductListFromFakeStore(FakeStoreProductResponse[] dto){
        List<Product> products = new ArrayList<>();
        for(FakeStoreProductResponse f : dto){
            products.add(getProductFromFakeStore(f));
        }
        return products;
    }

    public static Product getProductFromProductRequestDTO(ProductRequestDTO dto){
        Product product = new Product();

        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setImage(dto.getImage());

        return product;
    }

    public static ProductResponseDTO getProductResponseDtoFromProduct(Product product){
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setImage(product.getImage());

        return dto;
    }

    public static List<ProductResponseDTO> getListOfProductResponseDtoFromProductList(List<Product> products){
        List<ProductResponseDTO> listDTO = new ArrayList<>();

        for (Product p : products){
            listDTO.add(getProductResponseDtoFromProduct(p));
        }
        return listDTO;
    }

}
