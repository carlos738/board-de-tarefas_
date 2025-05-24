package com.example.board.de.tarefas.repository;

import com.example.board.de.tarefas.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
