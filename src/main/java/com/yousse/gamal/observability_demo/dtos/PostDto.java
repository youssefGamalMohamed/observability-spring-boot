package com.yousse.gamal.observability_demo.dtos;

import java.util.List;

import lombok.Builder;

@Builder
public record PostDto(
	int userId,
	int id,
	String title,
	String body,
	List<CommentDto> comments
) {
}
