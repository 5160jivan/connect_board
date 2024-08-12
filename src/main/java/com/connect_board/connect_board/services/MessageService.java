package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.MessageDTO;
import com.connect_board.connect_board.entities.MessageEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface MessageService {
    MessageDTO createMessage(MessageDTO messageDTO);

    MessageDTO getMessageById(Long id);

    void deleteMessage(Long id);

    MessageDTO updateMessage(Long id, MessageDTO messageDTO);
}
