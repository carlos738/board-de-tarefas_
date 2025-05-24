package com.example.board.de.tarefas.controllers;

import com.example.board.de.tarefas.entity.Board;
import com.example.board.de.tarefas.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;

    public Board createBoard(String name){
        return boardRepository.save(new Board(null,name));
    }
    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }
    public void deletarBoard(Long id){
        boardRepository.deleteById(id);
    }
}
