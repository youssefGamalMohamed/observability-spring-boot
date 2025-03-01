package com.yousse.gamal.observability_demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yousse.gamal.observability_demo.dtos.TodoItemDto;
import com.yousse.gamal.observability_demo.mappers.TodoItemMapper;
import com.yousse.gamal.observability_demo.models.TodoItem;
import com.yousse.gamal.observability_demo.services.TodoItemServiceIfc;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@Slf4j  
@RequiredArgsConstructor
public class TodoItemController {    
    
    private final TodoItemServiceIfc todoItemService;
    private final TodoItemMapper todoItemMapper;

    @PostMapping("/v1/todo-items")
    public TodoItemDto createTodoItem(@RequestBody @Valid TodoItemDto todoItem) {
        log.info("Controller: Creating todo item: {}", todoItem);
        TodoItem newCreatedItem = todoItemService.create(todoItemMapper.toEntity(todoItem));
        TodoItemDto newCreatedItemDto = todoItemMapper.toDto(newCreatedItem);
        log.info("Controller: Created todo item: {}", newCreatedItemDto);
        return newCreatedItemDto;
    }

    @GetMapping("/v1/todo-items")
    public Page<TodoItemDto> findAll(@ParameterObject Pageable pageable) {
        log.info("Controller: Fetching all todo items with pageable: {}", pageable);
        Page<TodoItem> todoItemPage = todoItemService.findAll(pageable);
        Page<TodoItemDto> todoItemDtoPage = todoItemPage.map(todoItemMapper::toDto);
        log.info("Controller: Fetched all todo items with pageable: {}", pageable);
        return todoItemDtoPage;
    }
    

    @GetMapping("/v1/todo-items/{id}")
    public TodoItemDto findById(@PathVariable String id) {
        log.info("Controller: Fetching todo item by id: {}", id);
        TodoItem todoItem = todoItemService.findById(id);
        TodoItemDto todoItemDto = todoItemMapper.toDto(todoItem);
        log.info("Controller: Fetched todo item by id: {}", todoItemDto);
        return todoItemDto;
    }
    

}
