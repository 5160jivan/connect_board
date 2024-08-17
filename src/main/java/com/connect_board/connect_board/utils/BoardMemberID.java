package com.connect_board.connect_board.utils;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class BoardMemberID implements Serializable {
    private Long boardId;
    private Long userId;

}
