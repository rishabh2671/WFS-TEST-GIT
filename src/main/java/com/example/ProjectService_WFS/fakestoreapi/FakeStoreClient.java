package com.example.ProjectService_WFS.fakestoreapi;

import com.example.ProjectService_WFS.mapper.ProductMapper;
import com.example.ProjectService_WFS.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


public class FakeStoreClient {

    private final RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public static Product patchProduct(Long productId, Product product,RestTemplate template){

        FakeStoreProductResponse data = template.
                patchForObject("https://fakestoreapi.com/products/{Id}",
                        product,
                        FakeStoreProductResponse.class,
                        productId);

        Product res = ProductMapper.getProductFromFakeStore(data);

        return res;
    }

}
