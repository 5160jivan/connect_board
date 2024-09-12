package com.connect_board.connect_board.dto;

import com.connect_board.connect_board.entities.BoardEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardCategoryDTO {

    private Long id;

    private String categoryName;


    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<BoardDTO> boards;
}
