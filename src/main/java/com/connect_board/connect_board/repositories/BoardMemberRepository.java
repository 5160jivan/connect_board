package com.connect_board.connect_board.repositories;

import com.connect_board.connect_board.entities.BoardMemberEntity;
import com.connect_board.connect_board.utils.BoardMemberID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardMemberRepository extends JpaRepository<BoardMemberEntity, BoardMemberID>{
}
