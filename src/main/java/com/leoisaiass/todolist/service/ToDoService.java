package com.leoisaiass.todolist.service;

import com.leoisaiass.todolist.dto.ToDoItemDto;
import com.leoisaiass.todolist.model.ToDoItem;
import com.leoisaiass.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public Page<ToDoItemDto> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::convertToDto);
    }

    public ToDoItemDto getItemById(Long id) {
        ToDoItem item = repository.getReferenceById(id);
        return convertToDto(item);
    }

    public ToDoItemDto convertToDto(ToDoItem item) {
        return new ToDoItemDto(
                item.getId(),
                item.getTaskName(),
                item.getTaskDescription(),
                item.getCreatedAt(),
                item.getCompleted()
        );
    }

    public ToDoItem insertTask(ToDoItemDto dto) {
        ToDoItem item = new ToDoItem(dto);
        return repository.save(item);
    }

    public ToDoItem updateTaskCompleted(Long id) {
        ToDoItem item = repository.getReferenceById(id);
        item.setCompleted(true);
        repository.save(item);
        return item;
    }

    public Boolean deleteTask(Long id) {
        ToDoItem item = repository.getReferenceById(id);
        if (item != null) {
            repository.delete(item);
            return true;
        } else {
            return false;
        }
    }
}
