package com.analyticssakha.bloggingwebapp.services.impl;

import com.analyticssakha.bloggingwebapp.entities.Category;
import com.analyticssakha.bloggingwebapp.entities.Post;
import com.analyticssakha.bloggingwebapp.entities.User;
import com.analyticssakha.bloggingwebapp.exceptions.ResourceNotFoundException;
import com.analyticssakha.bloggingwebapp.payloads.CategoryDto;
import com.analyticssakha.bloggingwebapp.payloads.PostDto;
import com.analyticssakha.bloggingwebapp.payloads.PostResponse;
import com.analyticssakha.bloggingwebapp.repositories.CategoryRepository;
import com.analyticssakha.bloggingwebapp.repositories.PostRepository;
import com.analyticssakha.bloggingwebapp.repositories.UserRepository;
import com.analyticssakha.bloggingwebapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId", userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","categoryId", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setPostDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost = this.postRepository.save(post);
        return this.postToDto(savedPost);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId", postId));
        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setPostDate(new Date());
        post.setImageName(postDto.getImageName());
        Post updatedPost = this.postRepository.save(post);
        PostDto postDto1 = this.postToDto(updatedPost);
        return postDto1;
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId", postId));
        this.postRepository.delete(post);
    }

    @Override
    public PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        Page<Post> pagePost = this.postRepository.findAll(pageable);
        List<Post> allPosts = pagePost.getContent();
        List<PostDto> postDtoList = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtoList);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getTotalElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());
        return postResponse;
    }

    /*
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> allPosts = this.postRepository.findAll();
        List<PostDto> postDtoList = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }
    */


    @Override
    public PostDto getPostById(Integer postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Integer categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","categoryId", categoryId));
        List<Post> posts = this.postRepository.findByCategory(category);
        List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> getPostsByUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userId", userId));
        List<Post> posts = this.postRepository.findByUser(user);
        List<PostDto> postDtoList = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        List<Post> posts = this.postRepository.findByPostTitleContaining("%"+keyword+"%");
        List<PostDto> postDtos = posts.stream().map((post) ->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    public Post dtoToPost(PostDto postDto) {
        Post post = this.modelMapper.map(postDto, Post.class);
        return post;
    }

    public PostDto postToDto(Post post) {
        PostDto postDto = this.modelMapper.map(post, PostDto.class);
        return postDto;
    }
}
