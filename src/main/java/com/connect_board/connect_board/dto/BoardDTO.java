package com.connect_board.connect_board.dto;

import com.connect_board.connect_board.entities.BoardCategoryEntity;
import com.connect_board.connect_board.entities.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO{
    private Long id;

    @NotBlank
    private String title;

    @NotNull
    private UserDTO createdBy;

    private String createdDate;

    private String modifiedDate;

    private Set<BoardCategoryDTO> categories;

    private Set<BoardMemberDTO> boardMembers;



}
