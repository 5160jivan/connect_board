package com.connect_board.connect_board.controllers;
import com.connect_board.connect_board.dto.BoardDTO;
import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.dto.BoardMemberIDDTO;
import lombok.RequiredArgsConstructor;
import com.connect_board.connect_board.services.BoardService;
import org.springframework.web.bind.annotation.*;
import  com.connect_board.connect_board.dto.BoardCategoryDTO;

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

    @PatchMapping("/{boardId}/addMember")
    public BoardDTO addBoardMember(@PathVariable Long boardId, @RequestBody BoardMemberDTO boardMemberDTO){
        try {
            return boardService.addBoardMember(boardId, boardMemberDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error adding board member to board "+ boardId + ": " + e.getMessage());
        }
    }

    @PatchMapping("/{boardId}/removeMember")
    public void removeBoardMember(@PathVariable Long boardId, @RequestBody BoardMemberDTO boardMemberDTO){
        boardService.removeBoardMember(boardId, boardMemberDTO);
    }

    @PatchMapping("/{boardId}/addCategory")
    public BoardDTO addBoardCategory(@PathVariable Long boardId, @RequestBody BoardCategoryDTO boardCategoryDTO){
        return boardService.addBoardCategory(boardId, boardCategoryDTO);
    }

    @PatchMapping("/{boardId}/removeCategory")
    public void removeBoardCategory(@PathVariable Long boardId, @RequestBody BoardCategoryDTO boardCategoryDTO){
        boardService.removeBoardCategory(boardId, boardCategoryDTO);
    }

}
