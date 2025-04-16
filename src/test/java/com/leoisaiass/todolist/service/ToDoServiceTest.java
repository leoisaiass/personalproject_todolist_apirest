package com.leoisaiass.todolist.service;

import com.leoisaiass.todolist.dto.ToDoItemDto;
import com.leoisaiass.todolist.model.ToDoItem;
import com.leoisaiass.todolist.repository.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ToDoServiceTest {

    @InjectMocks
    private ToDoService toDoService;

    @Mock
    private ToDoRepository toDoRepository;

    private ToDoItemDto toDoItemDto;
    private ToDoItem toDoItem;

    @BeforeEach
    public void setup() {
        // Creating fake data to test
        toDoItemDto = new ToDoItemDto(1L, "Limpar a casa", "Lavar a louça", null, false);
        toDoItem = new ToDoItem(1L, "Limpar a casa", "Lavar a louça", null, false);
    }

    @Test
    public void testInsertTask() {
        // Arrange
        Mockito.when(toDoRepository.save(Mockito.any(ToDoItem.class))).thenReturn(toDoItem);

        // Act
        ToDoItem result = toDoService.insertTask(toDoItemDto);

        // Assert
        assertNotNull(result);
        assertEquals("Limpar a casa", result.getTaskName());
        assertEquals("Lavar a louça", result.getTaskDescription());
        assertFalse(result.getCompleted());
    }

}
