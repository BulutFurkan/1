package com.furkanbulut.example.request;

import com.furkanbulut.example.dto.CategoryDto;
import com.furkanbulut.example.dto.ProductDto;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ProductRequest {
    private final String name;
    private final String brand;
    private final Double price;
    private final CategoryDto category;
    private final String barcode;
    private final String description;

    public ProductDto toDto() {
        return ProductDto.builder()
                .name(name)
                .brand(brand)
                .price(price)
                .description(description)
                .category(category)
                .barcode(barcode)
                .build();
    }
}
