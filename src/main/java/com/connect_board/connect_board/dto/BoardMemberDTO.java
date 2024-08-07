package com.connect_board.connect_board.dto;

import com.connect_board.connect_board.utils.BoardMemberID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardMemberDTO {
    private BoardMemberID id;

    private String permissionLevel;

    private UserDTO user;


    private BoardDTO board;

}
