package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardCategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BoardCategoryService {

    List<BoardCategoryDTO> getAllBoardCategories();

    BoardCategoryDTO createBoardCategory(BoardCategoryDTO boardCategoryDTO);

    BoardCategoryDTO updateBoardCategory(Long id, Map<String, Object> updates);

    void deleteBoardCategory(Long id);

}
