package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.UserDTO;
import com.connect_board.connect_board.entities.UserEntity;
import com.connect_board.connect_board.exceptions.ResourceNotFoundException;
import com.connect_board.connect_board.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().
                stream().
                map(userEntity -> modelMapper.map(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        // TO DO Add custom  response structure and exception handling
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return modelMapper.map(userEntity, UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity postEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity userEntity = userRepository.save(postEntity);
        return modelMapper.map(userEntity, UserDTO.class);

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
