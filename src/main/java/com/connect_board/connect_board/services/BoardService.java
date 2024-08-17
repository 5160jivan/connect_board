package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardCategoryDTO;
import com.connect_board.connect_board.dto.BoardDTO;
import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.dto.BoardMemberIDDTO;
import com.connect_board.connect_board.utils.BoardMemberID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardService {
    List<BoardDTO> getAllBoards();

    BoardDTO getBoardById(Long id);

    BoardDTO createBoard(BoardDTO boardDTO);

    BoardDTO updateBoard(Long id, Map<String, Object> updates);

    void deleteBoard(Long id);

    List<BoardMemberDTO> getBoardMembers(Long id);

    BoardDTO addBoardMember(Long id, BoardMemberDTO boardMemberDTO);

    void removeBoardMember(Long id,
                           BoardMemberDTO boardMemberDTO);


    BoardDTO addBoardCategory(Long id, BoardCategoryDTO boardCategoryDTO);

    void removeBoardCategory(Long id, BoardCategoryDTO boardCategoryDTO);

}
