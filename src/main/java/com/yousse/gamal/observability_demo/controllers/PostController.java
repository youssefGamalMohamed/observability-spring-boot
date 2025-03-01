package com.yousse.gamal.observability_demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yousse.gamal.observability_demo.dtos.CommentDto;
import com.yousse.gamal.observability_demo.dtos.PostDto;
import com.yousse.gamal.observability_demo.services.PostServiceIfc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController("/jsoonplaceholder")
@Slf4j
@RequiredArgsConstructor
public class PostController {

    private final PostServiceIfc postService;

    @GetMapping("/v1/posts")
    public List<PostDto> findAllPosts() {
        log.info("Fetching all posts");
        return postService.findAllPosts();
    }
    
    @GetMapping("/v1/posts/{id}")
    public PostDto findById(@PathVariable Integer id) {
       log.info("Fetching post by id: {}", id);
       return postService.findPostById(id);
    }

    @GetMapping("/v1/posts/{id}/comments")
    public List<CommentDto> findCommentsByPostId(@PathVariable Integer id) {
       log.info("Fetching post with it's comments by id: {}", id);
       return postService.findPostComments(id);
    }
    
}
