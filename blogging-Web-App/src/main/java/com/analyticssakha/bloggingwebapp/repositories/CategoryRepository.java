package com.analyticssakha.bloggingwebapp.repositories;

import com.analyticssakha.bloggingwebapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
