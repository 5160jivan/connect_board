package com.connect_board.connect_board.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String username;

    private String userEmail;
}
