package com.example.ProjectService_WFS.DTO;

import com.example.ProjectService_WFS.fakestoreapi.Rating;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductResponseDTO {
    private Integer Id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

}
