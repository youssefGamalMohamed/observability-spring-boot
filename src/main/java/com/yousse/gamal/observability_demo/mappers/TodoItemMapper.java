package com.yousse.gamal.observability_demo.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.yousse.gamal.observability_demo.dtos.TodoItemDto;
import com.yousse.gamal.observability_demo.models.TodoItem;

@Mapper(componentModel = "spring")
public interface TodoItemMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "completed", source = "completed")
    TodoItem toEntity(TodoItemDto dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "completed", source = "completed")
    TodoItemDto toDto(TodoItem entity);

    default List<TodoItem> toEntityList(List<TodoItemDto> dtoList) {
        return dtoList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    default List<TodoItemDto> toDtoList(List<TodoItem> entityList) {
        return entityList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    default Set<TodoItem> toEntitySet(Set<TodoItemDto> dtoSet) {
        return dtoSet.stream()
                .map(this::toEntity)
                .collect(Collectors.toSet());
    }

    default Set<TodoItemDto> toDtoSet(Set<TodoItem> entitySet) {
        return entitySet.stream()
                .map(this::toDto)
                .collect(Collectors.toSet());
    }
}
