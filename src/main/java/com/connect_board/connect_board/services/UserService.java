package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(Long id, Map<String, Object> updates);

    void deleteUser(Long id);


}
