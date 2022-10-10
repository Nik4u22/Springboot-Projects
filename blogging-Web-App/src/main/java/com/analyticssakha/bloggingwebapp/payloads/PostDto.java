package com.analyticssakha.bloggingwebapp.payloads;

import com.analyticssakha.bloggingwebapp.entities.Category;
import com.analyticssakha.bloggingwebapp.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

    private Integer postId;

    @NotEmpty
    @Size(max = 50, message = "Post title should be maximum 50 characters")
    private String postTitle;

    @NotEmpty
    @Size(max = 100, message = "Post Content should be maximum 1500 characters")
    private String postContent;

    @NotEmpty
    private String ImageName;
    private Date postDate;
    private UserDto user;
    private CategoryDto category;

}
