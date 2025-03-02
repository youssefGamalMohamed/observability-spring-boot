package com.yousse.gamal.observability_demo.dtos;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record TodoItemDto(String id, 
                        @NotBlank(message = "Title Must Not Be Empty or Null") String title, 
                        @NotBlank(message = "Description Must Not Be Empty or Null") String description,
                        boolean completed,
                        LocalDateTime createdDate,
                        LocalDateTime lastModifiedDate
    ) {

}
