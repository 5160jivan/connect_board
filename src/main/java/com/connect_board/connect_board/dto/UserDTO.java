package com.connect_board.connect_board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import lombok.Data;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotBlank(message = "Username cannot be empty")
    private String userName;

    @Email(message = "Email should be valid")
    private String userEmail;

    private Set<UserDTO> boards;

    private Set<BoardMemberDTO> boardMemberships;
}
