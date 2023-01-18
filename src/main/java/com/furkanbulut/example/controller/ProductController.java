package com.furkanbulut.example.controller;

import com.furkanbulut.example.dto.ProductDto;
import com.furkanbulut.example.request.ProductRequest;
import com.furkanbulut.example.response.ProductResponse;
import com.furkanbulut.example.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @PostMapping()
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductRequest request) {
        ProductDto product = service.createProduct(request.toDto());
        return ResponseEntity.ok(ProductResponse.toResponse(product));
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<List<ProductResponse>> getAllProducts(@PathVariable String categoryName){
        List<ProductResponse> productResponseList = toResponse(service.getProductByCategory(categoryName));
        return ResponseEntity.ok(productResponseList);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        List<ProductResponse> productResponseList = toResponse(service.getAllProducts());
        return ResponseEntity.ok(productResponseList);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable(value = "id")String id,@Valid @RequestBody ProductRequest request){
        ProductDto product = service.updateProduct(id, request.toDto());
        return ResponseEntity.ok(ProductResponse.toResponse(product));
    }


    @DeleteMapping("/{id}") void delete(@PathVariable String id){
        service.deleteProduct(id);
    }

    public List<ProductResponse>toResponse(List<ProductDto> productDtoList){
        return productDtoList.stream().map(ProductResponse::toResponse).toList();

    }

}
