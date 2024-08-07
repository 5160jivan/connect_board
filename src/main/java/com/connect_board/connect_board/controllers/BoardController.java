package com.connect_board.connect_board.controllers;
import com.connect_board.connect_board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import com.connect_board.connect_board.services.BoardService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping()
    public List<BoardDTO> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{id}")
    public BoardDTO getBoardById(@PathVariable Long id){
        return boardService.getBoardById(id);
    }

    @PostMapping
    public BoardDTO createNewBoard(@RequestBody BoardDTO board){
        if(board.getCreatedDate() ==  null){
            // TODO change to zoned time to follow format like "2024-07-28T13:01:15 PDT"
            board.setCreatedDate(String.valueOf(LocalDate.now()));
        }
        return boardService.createBoard(board);
    }

}
