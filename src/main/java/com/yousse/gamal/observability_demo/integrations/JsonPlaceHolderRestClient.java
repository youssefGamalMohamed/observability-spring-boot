package com.yousse.gamal.observability_demo.integrations;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import com.yousse.gamal.observability_demo.dtos.CommentDto;
import com.yousse.gamal.observability_demo.dtos.PostDto;

public interface JsonPlaceHolderRestClient {

    @GetExchange("/posts")
    List<PostDto> findAllPosts();

    @GetExchange("/posts/{id}")
    PostDto findPostById(@PathVariable Integer id);

    @GetExchange("/posts/{id}/comments")
    List<CommentDto> findPostComments(@PathVariable Integer id);
    
}
