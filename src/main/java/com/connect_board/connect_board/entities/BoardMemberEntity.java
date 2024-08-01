package com.connect_board.connect_board.entities;

import com.connect_board.connect_board.utils.Constants;
import jakarta.persistence.*;

@Entity
@Table(name = "board_members")
public class BoardMemberEntity {


    @Enumerated(EnumType.STRING)
    @Column(name = "permission_level", nullable = false)
    private Constants.PermissionLevel permissionLevel;

}
