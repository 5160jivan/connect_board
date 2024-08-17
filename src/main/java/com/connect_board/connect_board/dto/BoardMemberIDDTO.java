package com.connect_board.connect_board.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardMemberIDDTO {
    @NotNull
    private Long boardId;

    @NotNull
    private String userId;
}
