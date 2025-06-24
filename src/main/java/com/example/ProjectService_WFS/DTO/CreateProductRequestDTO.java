package com.example.ProjectService_WFS.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;


}
