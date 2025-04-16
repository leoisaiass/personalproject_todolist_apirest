package com.leoisaiass.todolist.controller;

import com.leoisaiass.todolist.dto.ToDoItemDto;
import com.leoisaiass.todolist.model.ToDoItem;
import com.leoisaiass.todolist.service.ToDoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController()
@RequestMapping("/todolist")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<Page<ToDoItemDto>> getToDoListDto(@PageableDefault(page = 0, size = 20, sort = "createdAt")
                                                                Pageable pageable) {
        Page<ToDoItemDto> list = toDoService.getAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoItemDto> getToDoItemDto(@PathVariable Long id) {
        ToDoItemDto itemDto = toDoService.getItemById(id);
        return ResponseEntity.ok(itemDto);
    }

    @PostMapping
    public ResponseEntity<ToDoItemDto> insertNewTask(@RequestBody ToDoItemDto dto, UriComponentsBuilder uriBuilder) {
        ToDoItem savedTask = toDoService.insertTask(dto);
        ToDoItemDto responseDto = toDoService.convertToDto(savedTask);

        URI uri = uriBuilder
                .path("/todolist/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();

        return ResponseEntity.created(uri).body(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoItemDto> updateTaskCompleted(@PathVariable Long id) {

        ToDoItem updatedTask = toDoService.updateTaskCompleted(id);
        ToDoItemDto responseDto = toDoService.convertToDto(updatedTask);

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (toDoService.deleteTask(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
