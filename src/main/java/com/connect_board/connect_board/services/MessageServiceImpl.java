package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.MessageDTO;
import com.connect_board.connect_board.entities.MessageEntity;
import com.connect_board.connect_board.exceptions.ResourceNotFoundException;
import com.connect_board.connect_board.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    private final ModelMapper modelMapper;

    @Override
    public MessageDTO createMessage(MessageDTO messageDTO) {
       MessageEntity messageEntity = modelMapper.map(messageDTO, MessageEntity.class);
       MessageEntity savedMessageEntity = messageRepository.save(messageEntity);
       return modelMapper.map(savedMessageEntity, MessageDTO.class);
    }

    @Override
    public MessageDTO getMessageById(Long id) {
        Optional<MessageEntity> messageEntity = messageRepository.findById(id);
        if(messageEntity.isPresent()){
            throw new ResourceNotFoundException("No message found with id  "+ id);
        }
        return modelMapper.map(messageEntity, MessageDTO.class);

    }

    @Override
    public void deleteMessage(Long id) {
        isMessageExist(id);
        messageRepository.deleteById(id);
    }

    @Override
    public MessageDTO updateMessage(Long id, MessageDTO messageDTO) {
        MessageEntity messageEntity = messageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Message not found with id: " + id));;
        MessageEntity updatedEntity = modelMapper.map(messageDTO, MessageEntity.class);
        MessageEntity savedRepository = messageRepository.save(updatedEntity);
        return modelMapper.map(savedRepository, MessageDTO.class);
    }

    public  void isMessageExist(Long id) {
        boolean exists = messageRepository.existsById(id);
        if(!exists) {
            throw new ResourceNotFoundException("Message not found with id: " + id);
        }
    }
}
