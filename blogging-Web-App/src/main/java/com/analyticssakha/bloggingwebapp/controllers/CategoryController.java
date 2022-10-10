package com.analyticssakha.bloggingwebapp.controllers;

import com.analyticssakha.bloggingwebapp.payloads.CategoryDto;
import com.analyticssakha.bloggingwebapp.payloads.UserDto;
import com.analyticssakha.bloggingwebapp.services.CategoryService;
import com.analyticssakha.bloggingwebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Define simple loger - will help during application debugging
    //public final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        //logger.info("Saving employee");
        CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<CategoryDto>(createCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable("categoryId") Integer id, @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, id);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok(Map.of("message", "Category deleted successfully"));
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategoryList() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("categoryId") Integer id) {
        return ResponseEntity.ok(this.categoryService.getCategoryById(id));
    }

}
