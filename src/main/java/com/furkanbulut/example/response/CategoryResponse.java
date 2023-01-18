package com.furkanbulut.example.response;

import com.furkanbulut.example.dto.CategoryDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CategoryResponse {

    private String id;
    private String name;
    private String description;
    private Date creaDate;

    public static CategoryResponse toResponse(CategoryDto dto){
        return CategoryResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .creaDate(dto.getCreaDate())
                .build();
    }
}
