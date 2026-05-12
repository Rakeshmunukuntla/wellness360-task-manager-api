package com.wellness.taskmanager.service;

import com.wellness.taskmanager.dto.TaskRequestDTO;
import com.wellness.taskmanager.dto.TaskResponseDTO;

import java.util.List;

public interface TaskService {

    TaskResponseDTO createTask(TaskRequestDTO requestDTO);

    List<TaskResponseDTO> getAllTasks();

    TaskResponseDTO getTaskById(Long id);

    TaskResponseDTO updateTask(Long id, TaskRequestDTO requestDTO);

    void deleteTask(Long id);

    TaskResponseDTO markTaskAsCompleted(Long id);
}