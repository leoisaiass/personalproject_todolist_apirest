package com.leoisaiass.todolist.model;

import com.leoisaiass.todolist.dto.ToDoItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_description")
    private String taskDescription;

    private LocalDateTime createdAt = LocalDateTime.now();
    private Boolean completed;

    public ToDoItem(ToDoItemDto dto) {
        this.taskName = dto.taskName();
        this.taskDescription = dto.taskDescription();
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

}
