package com.leoisaiass.todolist.repository;

import com.leoisaiass.todolist.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoItem, Long> {
}
