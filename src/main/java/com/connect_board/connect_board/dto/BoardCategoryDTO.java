package com.connect_board.connect_board.dto;

import com.connect_board.connect_board.entities.BoardEntity;
import jakarta.persistence.*;

import java.util.Set;

public class BoardCategoryDTO {

    private Long id;

    private String categoryName;


    private String description;


    private Set<BoardDTO> boards;
}
