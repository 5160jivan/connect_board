package com.connect_board.connect_board.repositories;

import com.connect_board.connect_board.entities.BoardCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCategoryRepository extends JpaRepository<BoardCategoryEntity, Long> {
}
