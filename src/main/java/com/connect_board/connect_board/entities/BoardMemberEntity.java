package com.connect_board.connect_board.entities;

import com.connect_board.connect_board.utils.BoardMemberID;
import com.connect_board.connect_board.utils.Constants;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "board_members")
@Getter
@Setter
public class BoardMemberEntity {

    @Id
    private BoardMemberID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "permission_level", nullable = false)
    private Constants.PermissionLevel permissionLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board", nullable = false)
    private BoardEntity board;

    @Override
    public int hashCode(){
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object ob){
        if(this == ob){
            return true;
        }
        if(!(ob instanceof BoardMemberEntity)){
            return false;
        }

        return id != null && id.equals(((BoardMemberEntity) ob).getId());
    }

}
