package com.example.ProjectService_WFS.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class ProductRequestDTO {
    private Integer Id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;


}
