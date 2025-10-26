package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    // ✅ Get all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return tasks;
    }

    // ✅ Create a new task
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    // ✅ Get one task by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // ✅ Update task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        for (Task t : tasks) {
            if (t.getId() == id) {
                t.setTitle(updatedTask.getTitle());
                t.setDescription(updatedTask.getDescription());
                t.setCompleted(updatedTask.isCompleted());
                return t;
            }
        }
        return null;
    }

    // ✅ Delete task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}
