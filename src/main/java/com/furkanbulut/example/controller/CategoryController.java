package com.furkanbulut.example.controller;

import com.furkanbulut.example.dto.CategoryDto;
import com.furkanbulut.example.request.CategoryRequest;
import com.furkanbulut.example.response.CategoryResponse;
import com.furkanbulut.example.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@Valid @RequestBody CategoryRequest request) {
        CategoryDto category = categoryService.createCategory(request.toDto());
        return ResponseEntity.ok(CategoryResponse.toResponse(category));
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategory (){
        List<CategoryResponse> categoryResponseList = toResponse(categoryService.getAllCategory());
        return ResponseEntity.ok(categoryResponseList);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable(value = "id")String id,@Valid @RequestBody CategoryDto dto){
        CategoryDto category = categoryService.updateCategory(id, dto);
        return ResponseEntity.ok(CategoryResponse.toResponse(category));
    }

    @DeleteMapping("/{id}") void delete(@PathVariable String id ){
        categoryService.deleteCategory(id);
    }

    public List<CategoryResponse>toResponse(List<CategoryDto> categoryDtoList){
        return categoryDtoList.stream().map(CategoryResponse::toResponse).toList();

    }
}
