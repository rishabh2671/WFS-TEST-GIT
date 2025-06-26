package com.example.ProjectService_WFS.fakestoreapi;

import lombok.Data;

@Data
public class FakeStoreProductResponse {
    Integer id;
    String title;
    Double price;
    String description;
    String category;
    String image;
    Rating rating;
}
