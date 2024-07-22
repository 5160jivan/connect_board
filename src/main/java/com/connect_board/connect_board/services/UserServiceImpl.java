package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.UserDTO;
import com.connect_board.connect_board.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
