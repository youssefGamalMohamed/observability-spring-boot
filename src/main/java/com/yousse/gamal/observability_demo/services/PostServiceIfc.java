package com.yousse.gamal.observability_demo.services;

import java.util.List;

import com.yousse.gamal.observability_demo.dtos.CommentDto;
import com.yousse.gamal.observability_demo.dtos.PostDto;

public interface PostServiceIfc {

    List<PostDto> findAllPosts();

    PostDto findPostById(Integer id);

    List<CommentDto> findPostComments(Integer id);
}
