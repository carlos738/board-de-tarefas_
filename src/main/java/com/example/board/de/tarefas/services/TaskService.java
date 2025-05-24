package com.example.board.de.tarefas.services;


import com.example.board.de.tarefas.entity.Board;
import com.example.board.de.tarefas.entity.Task;
import com.example.board.de.tarefas.enums.Status;
import com.example.board.de.tarefas.repository.BoardRepository;
import com.example.board.de.tarefas.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final BoardRepository boardRepository;

    public Task createTask(String name, String status, String boardId) {
        Board board = boardRepository.findById(Long.valueOf(boardId)).orElseThrow();
        return taskRepository.save(new Task(null, name, status, board));
    }

    public List<Task> getTasksByBoard(Long boardId) {
        return taskRepository.findByBoardId(boardId);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task createTask(String name, Status value, Long boardId) {
        return null;
    }
}
