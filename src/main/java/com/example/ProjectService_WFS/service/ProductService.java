package com.example.ProjectService_WFS.service;

import com.example.ProjectService_WFS.DTO.ProductRequestDTO;
import com.example.ProjectService_WFS.fakestoreapi.FakeStoreClient;
import com.example.ProjectService_WFS.fakestoreapi.FakeStoreProductResponse;
import com.example.ProjectService_WFS.mapper.ProductMapper;
import com.example.ProjectService_WFS.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private RestTemplateBuilder templateBuilder;
    private RestTemplate template;

    @Autowired
    public ProductService(RestTemplateBuilder templateBuilder){
        if (templateBuilder == null) {
            throw new IllegalStateException("RestTemplateBuilder is not injected!");
        }
        this.templateBuilder = templateBuilder;
        this.template = templateBuilder.build();
    }

    @Override
    public Product getProductById(Long productId){


        FakeStoreProductResponse dto = template.
                getForObject("https://fakestoreapi.com/products/{Id}",
                FakeStoreProductResponse.class,
                productId);

        Product data = ProductMapper.getProductFromFakeStore(dto);

        return data;
    }

    @Override
    public List<Product> getAllProducts(){

        FakeStoreProductResponse[] dto = template.
                getForEntity("https://fakestoreapi.com/products",
                FakeStoreProductResponse[].class).getBody();

        List<Product> data = ProductMapper.getProductListFromFakeStore(dto);

        return data;
    }

    @Override
    public Product createProducts(Product product){

        FakeStoreProductResponse data = template.
                postForObject("https://fakestoreapi.com/products",
                        product,
                        FakeStoreProductResponse.class);

        Product res = ProductMapper.getProductFromFakeStore(data);

        return res;
    }

    public Product patchProducts(Long productId, Product product){

        Product res = FakeStoreClient.patchProduct(productId,product,template);

        return res;
    }


}
