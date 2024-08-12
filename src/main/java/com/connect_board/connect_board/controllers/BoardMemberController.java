package com.connect_board.connect_board.controllers;

import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.services.BoardMemberService;
import com.connect_board.connect_board.utils.BoardMemberID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board-members")
@RequiredArgsConstructor
public class BoardMemberController {
    private final BoardMemberService boardMemberService;

    @GetMapping("/{id}")
    public BoardMemberDTO getBoardMemberById(@PathVariable BoardMemberID id) {
        return boardMemberService.getBoardMemberById(id);
    }
}
