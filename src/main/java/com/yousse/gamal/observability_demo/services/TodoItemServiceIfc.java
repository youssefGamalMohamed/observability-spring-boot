package com.yousse.gamal.observability_demo.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.yousse.gamal.observability_demo.models.TodoItem;

public interface TodoItemServiceIfc {

    Page<TodoItem> findAll(Pageable pageable);

    TodoItem findById(String id);

    TodoItem create(TodoItem todoItem);

    TodoItem updateById(String id, TodoItem todoItem);

    void deleteById(String id);

}
