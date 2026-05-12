package com.wellness.taskmanager.service;
import com.wellness.taskmanager.dto.TaskRequestDTO;
import com.wellness.taskmanager.dto.TaskResponseDTO;
import com.wellness.taskmanager.entity.Task;
import com.wellness.taskmanager.entity.TaskStatus;
import com.wellness.taskmanager.exception.TaskNotFoundException;
import com.wellness.taskmanager.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public TaskResponseDTO createTask(TaskRequestDTO requestDTO) {
        Task task = new Task();
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setDueDate(requestDTO.getDueDate());
        task.setStatus(requestDTO.getStatus());
        Task savedTask=taskRepository.save(task);
        return mapToResponse(savedTask);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {
       return taskRepository.findAll().stream().map(this::mapToResponse).toList();
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {
        Task task= taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id: " + id));
        return mapToResponse(task);

    }

    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO requestDTO) {
        Task task= taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id: " + id));
        task.setTitle(requestDTO.getTitle());
        task.setDescription(requestDTO.getDescription());
        task.setDueDate(requestDTO.getDueDate());
        task.setStatus(requestDTO.getStatus());
        Task updatedTask=taskRepository.save(task);
        return mapToResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task= taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id: " + id));
        taskRepository.delete(task);
//        System.out.println("Task deleted successfully");
    }

    @Override
    public TaskResponseDTO markTaskAsCompleted(Long id) {
        Task task= taskRepository.findById(id).orElseThrow(()->new TaskNotFoundException("Task not found with id: " + id));
        task.setStatus(TaskStatus.COMPLETED);
        Task updatedTask=taskRepository.save(task);
        return mapToResponse(updatedTask);
    }
    private TaskResponseDTO mapToResponse(Task task){
        TaskResponseDTO responseDTO=new TaskResponseDTO();
        BeanUtils.copyProperties(task, responseDTO);
        return responseDTO;
    }
}
