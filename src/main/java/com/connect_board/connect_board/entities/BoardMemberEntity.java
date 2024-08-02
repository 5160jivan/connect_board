package com.connect_board.connect_board.entities;

import com.connect_board.connect_board.utils.BoardMemberID;
import com.connect_board.connect_board.utils.Constants;
import jakarta.persistence.*;

@Entity
@Table(name = "board_members")
public class BoardMemberEntity {

    @Id
    private BoardMemberID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission_level", nullable = false)
    private Constants.PermissionLevel permissionLevel;

    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;

}
