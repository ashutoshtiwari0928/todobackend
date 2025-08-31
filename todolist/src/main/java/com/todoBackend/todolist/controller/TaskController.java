package com.todoBackend.todolist.controller;

import com.todoBackend.todolist.Service.TaskService;
import com.todoBackend.todolist.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public List<Task> getTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public void addNewTask(@RequestParam String title, @RequestParam boolean isCompleted){
        taskService.createNewTask(title,isCompleted);
    }

    @PutMapping("/{id}/update")
    public void updateTask(@PathVariable Long id,
                           @RequestParam String title,
                           @RequestParam boolean isCompleted){
        taskService.updateTask(id,title,isCompleted);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}/toggle")
    public void toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
    }
}
