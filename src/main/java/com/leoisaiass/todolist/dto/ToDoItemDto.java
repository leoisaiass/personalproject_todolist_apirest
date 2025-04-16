package com.leoisaiass.todolist.dto;

import java.time.LocalDateTime;

public record ToDoItemDto(
        Long id,
        String taskName,
        String taskDescription,
        LocalDateTime createdAt,
        Boolean completed) {
}
