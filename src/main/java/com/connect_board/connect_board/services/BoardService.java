package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardDTO;
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
}
