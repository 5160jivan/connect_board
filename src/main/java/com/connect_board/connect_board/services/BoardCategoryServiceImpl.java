package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardCategoryDTO;
import com.connect_board.connect_board.entities.BoardCategoryEntity;
import com.connect_board.connect_board.repositories.BoardCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardCategoryServiceImpl implements BoardCategoryService{

    private final BoardCategoryRepository boardCategoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<BoardCategoryDTO> getAllBoardCategories() {
        return boardCategoryRepository.findAll().stream().map(
                boardCategory -> modelMapper.map(boardCategory, BoardCategoryDTO.class)
        ).collect(Collectors.toList());
    }

    @Override
    public BoardCategoryDTO createBoardCategory(BoardCategoryDTO boardCategoryDTO) {
        BoardCategoryEntity boardCategoryEntity = modelMapper.map(boardCategoryDTO, BoardCategoryEntity.class);
        BoardCategoryEntity savedBoardCategoryEntity = boardCategoryRepository.save(boardCategoryEntity);
        return modelMapper.map(savedBoardCategoryEntity, BoardCategoryDTO.class);
    }

    @Override
    public BoardCategoryDTO updateBoardCategory(Long id, Map<String, Object> updates) {
        BoardCategoryEntity boardCategoryEntity = boardCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Board Category not found with id: " + id));
        updates.forEach((key, value) -> {
            switch (key) {
                case "categoryName":
                    boardCategoryEntity.setCategoryName((String) value);
                    break;
                case "description":
                    boardCategoryEntity.setDescription((String) value);
                    break;
                default:
                    throw new RuntimeException("Invalid field: " + key);
            }
        });
        BoardCategoryEntity updatedBoardCategoryEntity = boardCategoryRepository.save(boardCategoryEntity);
        return modelMapper.map(updatedBoardCategoryEntity, BoardCategoryDTO.class);
    }

    @Override
    public void deleteBoardCategory(Long id) {
        BoardCategoryEntity boardCategoryEntity = boardCategoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Board Category not found with id: " + id));
        boardCategoryRepository.delete(boardCategoryEntity);
    }
}
