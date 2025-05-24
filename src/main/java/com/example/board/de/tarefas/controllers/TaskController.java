package com.example.board.de.tarefas.controllers;

import com.example.board.de.tarefas.entity.Task;
import com.example.board.de.tarefas.repository.TaskRepository;
import com.example.board.de.tarefas.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskRequest request) {
        return taskService.createTask(request.getName(), request.getStatus(), request.getBoardId());
    }

    @GetMapping("/board/{boardId}")
    public List<Task> getTasksByBoard(@PathVariable Long boardId) {
        return taskService.getTasksByBoard(boardId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
