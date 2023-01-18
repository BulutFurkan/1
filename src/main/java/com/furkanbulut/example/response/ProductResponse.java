package com.furkanbulut.example.response;

import com.furkanbulut.example.dto.CategoryDto;
import com.furkanbulut.example.dto.ProductDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ProductResponse {
    private String id;
    private String barcode;
    private Date creaDate;
    private String name;
    private String brand;
    private Double price;
    private String description;
    private CategoryDto category;

    public static ProductResponse toResponse(ProductDto dto){
        return ProductResponse.builder()
                .id(dto.getId())
                .barcode(dto.getBarcode())
                .creaDate(dto.getCreaDate())
                .name(dto.getName())
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .build();
    }
}
