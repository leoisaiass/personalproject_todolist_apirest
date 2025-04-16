package com.leoisaiass.todolist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ToDoItemDto(
        Long id,
        @NotBlank
        String taskName,
        @NotBlank
        String taskDescription,
        @NotBlank
        LocalDateTime createdAt,
        @NotNull
        Boolean completed) {
}
