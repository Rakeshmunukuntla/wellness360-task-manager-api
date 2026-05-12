package com.wellness.taskmanager.dto;

import com.wellness.taskmanager.entity.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

public class TaskRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;


    @NotBlank(message = "description is required")
    private String description;
    @NotNull(message = "Due date is required")
    private LocalDate dueDate;
    @NotNull(message = "TaskStatus date is required")
    private TaskStatus status;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }




}
