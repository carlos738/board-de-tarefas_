package com.example.board.de.tarefas.controllers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TaskRequest {
    private String name;
    private String status;
    private String boardId;
}
