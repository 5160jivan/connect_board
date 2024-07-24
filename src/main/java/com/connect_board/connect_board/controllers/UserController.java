package com.connect_board.connect_board.controllers;

import com.connect_board.connect_board.dto.UserDTO;
import com.connect_board.connect_board.services.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        log.info("Creating user with parameters: {}", userDTO);
        return userService.createUser(userDTO);
    }
}
