package com.furkanbulut.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProductDto {

    private String id;
    private String barcode;
    private Date creaDate;
    private String name;
    private String brand;
    private Double price;
    private String description;
    private CategoryDto category;

}
