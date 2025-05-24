package com.example.board.de.tarefas.entity;

import com.example.board.de.tarefas.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Board board;

    public Task(Long id, String name, String status, Board board) {

    }
}
