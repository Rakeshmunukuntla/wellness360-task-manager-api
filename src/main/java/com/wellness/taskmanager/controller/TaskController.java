package com.wellness.taskmanager.controller;

import com.wellness.taskmanager.dto.TaskRequestDTO;
import com.wellness.taskmanager.dto.TaskResponseDTO;
import com.wellness.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskResponseDTO>> getAllTasks(){
        List<TaskResponseDTO> responseDTO=service.getAllTasks();
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO requestDTO){
        TaskResponseDTO responseDTO=service.createTask(requestDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> getTaskById(@PathVariable Long id){
        TaskResponseDTO responseDTO=service.getTaskById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDTO> updateTask(@PathVariable Long id,@Valid @RequestBody TaskRequestDTO requestDTO){
        System.out.println("requestDTO "+requestDTO.toString());
        TaskResponseDTO responseDTO=service.updateTask(id,requestDTO);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return new ResponseEntity<>("Task deleted succussfully",HttpStatus.OK);
    }
    @PatchMapping("/{id}/completed")
    public ResponseEntity<TaskResponseDTO> markAsCompleted(@PathVariable Long id){
        TaskResponseDTO responseDTO=service.markTaskAsCompleted(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
