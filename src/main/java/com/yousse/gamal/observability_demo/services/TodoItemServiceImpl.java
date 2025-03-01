package com.yousse.gamal.observability_demo.services;


import com.yousse.gamal.observability_demo.models.TodoItem;
import com.yousse.gamal.observability_demo.repos.TodoItemRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoItemServiceImpl implements TodoItemServiceIfc {

    private final TodoItemRepo todoItemRepo;

    @Override
    public Page<TodoItem> findAll(Pageable pageable) {
        log.info("Service: Fetching all todo items with pageable: {}", pageable);
        return todoItemRepo.findAll(pageable);
    }

    @Override
    public TodoItem findById(String id) {
        log.info("Service: Fetching todo item by id: {}", id);
        return todoItemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo item not found with this id: " + id));
    }

    @Override
    public TodoItem create(TodoItem todoItem) {
        log.info("Service: Creating todo item: {}", todoItem);
        return todoItemRepo.save(todoItem);
    }

    @Override
    public TodoItem updateById(String id, TodoItem todoItem) {
        log.info("Service: Updating todo item by id: {}", id);
        TodoItem existingTodoItem = todoItemRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo item not found with this id: " + id));
        existingTodoItem.setTitle(todoItem.getTitle());
        existingTodoItem.setDescription(todoItem.getDescription());
        existingTodoItem.setCompleted(todoItem.isCompleted());
        return todoItemRepo.save(existingTodoItem);
    }

    @Override
    public void deleteById(String id) {
        log.info("Service: Deleting todo item by id: {}", id);
        todoItemRepo.deleteById(id);
    }

}
