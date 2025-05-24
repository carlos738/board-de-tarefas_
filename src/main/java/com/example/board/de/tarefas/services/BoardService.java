package com.example.board.de.tarefas.services;


import com.example.board.de.tarefas.entity.Board;
import com.example.board.de.tarefas.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board createBoard(String name) {
        return boardRepository.save(new Board(null, name));
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
