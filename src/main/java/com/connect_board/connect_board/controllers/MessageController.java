package com.connect_board.connect_board.controllers;


import com.connect_board.connect_board.dto.MessageDTO;
import com.connect_board.connect_board.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/{id}")
    public MessageDTO getMessageById(Long id){
        return messageService.getMessageById(id);
    }

    @PostMapping
    public MessageDTO createMessage(MessageDTO messageDTO){
        return messageService.createMessage(messageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(Long id){
        messageService.deleteMessage(id);
    }

    @PostMapping("/{id}")
    public MessageDTO updateMessage(Long id, MessageDTO messageDTO){
        return messageService.updateMessage(id, messageDTO);
    }



}
