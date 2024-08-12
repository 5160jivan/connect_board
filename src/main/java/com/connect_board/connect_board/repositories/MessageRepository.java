package com.connect_board.connect_board.repositories;

import com.connect_board.connect_board.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity,Long> {
}
