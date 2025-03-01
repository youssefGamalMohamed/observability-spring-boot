package com.yousse.gamal.observability_demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yousse.gamal.observability_demo.dtos.CommentDto;
import com.yousse.gamal.observability_demo.dtos.PostDto;
import com.yousse.gamal.observability_demo.integrations.JsonPlaceHolderRestClient;

import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostServiceImpl implements PostServiceIfc {

    private final JsonPlaceHolderRestClient postServiceRestClient;
    
    @Override
    public List<PostDto> findAllPosts() {
        log.info("Fetching all posts");
        return postServiceRestClient.findAllPosts();
    }

    @Override
    public PostDto findPostById(Integer id) {
        log.info("Fetching post by id: {}", id);
        return postServiceRestClient.findPostById(id);
    }

    @Override
    @Observed(name = "findPostComments", contextualName = "findPostComments")
    public List<CommentDto> findPostComments(Integer id) {
        log.info("Fetching post comments by post id: {}", id);
        PostDto post = postServiceRestClient.findPostById(id);
        log.info("Post: {}", post);
        List<CommentDto> comments = postServiceRestClient.findPostComments(id);
        return comments;
    }

}
