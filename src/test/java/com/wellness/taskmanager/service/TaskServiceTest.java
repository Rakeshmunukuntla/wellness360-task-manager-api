package com.wellness.taskmanager.service;

import com.wellness.taskmanager.dto.TaskRequestDTO;
import com.wellness.taskmanager.dto.TaskResponseDTO;
import com.wellness.taskmanager.entity.Task;
import com.wellness.taskmanager.entity.TaskStatus;
import com.wellness.taskmanager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void testCreateTask() {

        TaskRequestDTO requestDTO = new TaskRequestDTO();

        requestDTO.setTitle("Learn Testing");
        requestDTO.setDescription("Practice Mockito");
        requestDTO.setDueDate(LocalDate.now());
        requestDTO.setStatus(TaskStatus.PENDING);

        Task task = new Task();

        task.setId(1L);
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setDueDate(requestDTO.getDueDate());
        task.setStatus(requestDTO.getStatus());

        when(taskRepository.save(org.mockito.ArgumentMatchers.any(Task.class)))
                .thenReturn(task);

        TaskResponseDTO responseDTO =
                taskService.createTask(requestDTO);

        assertEquals("Learn Testing", responseDTO.getTitle());

        assertEquals(TaskStatus.PENDING, responseDTO.getStatus());
    }
}