package com.connect_board.connect_board.controllers;

import com.connect_board.connect_board.services.BoardCategoryService;
import com.connect_board.connect_board.dto.BoardCategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board-categories")
@RequiredArgsConstructor
public class BoardCategoryController {
    private final BoardCategoryService boardCategoryService;

    @GetMapping("")
    public List<BoardCategoryDTO> getAllBoardCategories() {
        return boardCategoryService.getAllBoardCategories();
    }

    @PostMapping("")
    public BoardCategoryDTO createBoardCategory(@RequestBody BoardCategoryDTO boardCategoryDTO) {
        return boardCategoryService.createBoardCategory(boardCategoryDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardCategory(@PathVariable Long id) {
        boardCategoryService.deleteBoardCategory(id);
    }
}
