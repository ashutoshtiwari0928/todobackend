package com.todoBackend.todolist.Service;


import com.todoBackend.todolist.model.Task;
import com.todoBackend.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createNewTask(String title, boolean isCompleted) {
        Task task = new Task();
        task.setTitle(title);
        task.setIsCompleted(isCompleted);
        taskRepository.save(task);
    }

    public void updateTask(Long id, String title, boolean isCompleted) {
        Task task = taskRepository.getReferenceById(id);
        task.setTitle(title);
        task.setIsCompleted(isCompleted);
        taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        Task task = taskRepository.getReferenceById(id);
        taskRepository.delete(task);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.getReferenceById(id);
        task.setIsCompleted(!task.getIsCompleted());
        taskRepository.save(task);
    }
}
