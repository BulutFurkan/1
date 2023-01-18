package com.furkanbulut.example.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class CategoryDto {

    private String id;
    private String name;
    private String description;
    private Date creaDate;

}
