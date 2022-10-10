package com.analyticssakha.bloggingwebapp.repositories;

import com.analyticssakha.bloggingwebapp.entities.Category;
import com.analyticssakha.bloggingwebapp.entities.Post;
import com.analyticssakha.bloggingwebapp.entities.User;
import com.analyticssakha.bloggingwebapp.payloads.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

    @Query("select p from Post p where p.postTitle like :key")
    List<Post> findByPostTitleContaining(@Param("key") String title);

}
