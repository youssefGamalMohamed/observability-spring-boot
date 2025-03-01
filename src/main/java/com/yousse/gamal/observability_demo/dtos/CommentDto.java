package com.yousse.gamal.observability_demo.dtos;

public record CommentDto(
    int postId,
    int id,
    String name,
    String email,
    String body
) {

}
