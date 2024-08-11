package com.connect_board.connect_board.dto;

import com.connect_board.connect_board.entities.BoardEntity;
import com.connect_board.connect_board.entities.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    private Long id;

    @NotNull
    private BoardEntity board;

    @NotNull
    private UserEntity user;

    @NotNull
    private String message;


    private String createdDate;

    private String updatedDate;

    private String deletedDate;
}
