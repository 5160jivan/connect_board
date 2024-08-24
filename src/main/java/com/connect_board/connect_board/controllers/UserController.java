package com.connect_board.connect_board.controllers;

import com.connect_board.connect_board.dto.BoardDTO;
import com.connect_board.connect_board.dto.UserDTO;
import com.connect_board.connect_board.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PatchMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return userService.updateUser(id, updates);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody @Valid UserDTO userDTO) {
        log.info("Creating user with parameters: {}", userDTO);
        return userService.createUser(userDTO);
    }

    @GetMapping("/{id}/boards")
    public List<BoardDTO> getUserBoards(@PathVariable Long id) {
        return userService.getUserBoards(id);
    }
}
