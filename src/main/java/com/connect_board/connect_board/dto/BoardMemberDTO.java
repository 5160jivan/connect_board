package com.connect_board.connect_board.dto;

import com.connect_board.connect_board.utils.BoardMemberID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardMemberDTO {
    @NotNull
    private BoardMemberID id;

    @NotBlank(message = "Permission level cannot be empty")
    private String permissionLevel;

    private UserDTO user;


    private BoardDTO board;

}
