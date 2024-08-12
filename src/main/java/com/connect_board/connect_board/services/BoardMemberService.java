package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.utils.BoardMemberID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface BoardMemberService {

    BoardMemberDTO getBoardMemberById(BoardMemberID id);

    BoardMemberDTO createBoardMember(BoardMemberDTO boardMemberDTO);



}
