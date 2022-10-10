package com.analyticssakha.bloggingwebapp.services;

import com.analyticssakha.bloggingwebapp.payloads.CategoryDto;
import com.analyticssakha.bloggingwebapp.payloads.UserDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto category);
    CategoryDto updateCategory(CategoryDto category, Integer categoryId);
    CategoryDto getCategoryById(Integer categoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(Integer categoryId);

}
