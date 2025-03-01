package com.yousse.gamal.observability_demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yousse.gamal.observability_demo.models.TodoItem;

@Repository
public interface TodoItemRepo extends JpaRepository<TodoItem, String> {

}
