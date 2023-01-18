package com.furkanbulut.example.serviceImpl;

import com.furkanbulut.example.dto.CategoryDto;
import com.furkanbulut.example.model.Category;
import com.furkanbulut.example.repository.CategoryRepository;
import com.furkanbulut.example.service.CategoryService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    @Transactional
    public CategoryDto createCategory(CategoryDto dto) {
        checkCategoryExist(dto);
        Category category = toEntity(dto);
        return toDto(repository.save(category));
    }
    @Override
    @Transactional
    public CategoryDto updateCategory(String id, CategoryDto dto) {
        return repository.findById(id)
                .map(category -> checkCategoryUpdate(dto,category))
                .map(repository::save)
                .map(this::toDto)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Category getByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Category not found   " + getClass().getName()));
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public Category getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found   " + getClass().getName()));
    }

    @Override
    public void deleteCategory(String id) {
        repository.deleteById(id);
    }

    public Category toEntity(CategoryDto dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;

    }
    public CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .creaDate(category.getCreaDate())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }
    private Category checkCategoryUpdate(CategoryDto dto, Category category) {
        category.setName(dto.getName()==null?category.getName():dto.getName());
        category.setDescription(dto.getDescription()==null?category.getDescription():dto.getDescription());
        return category;
    }

    private void checkCategoryExist(CategoryDto dto) {
        repository.findByName(dto.getName()).ifPresent(category -> {
            throw new EntityExistsException(
                    String.format("Entity %s already exists", category.getClass().getName())
            );
        });
    }
}