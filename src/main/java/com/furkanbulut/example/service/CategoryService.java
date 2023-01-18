package com.furkanbulut.example.service;

import com.furkanbulut.example.dto.CategoryDto;
import com.furkanbulut.example.model.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto dto);
    List<CategoryDto> getAllCategory();
    Category getById(String id);
    void deleteCategory(String id);
    CategoryDto updateCategory(String id , CategoryDto dto);
    Category getByName(String name);


}
