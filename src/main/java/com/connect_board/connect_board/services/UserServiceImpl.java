package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardDTO;
import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.dto.UserDTO;
import com.connect_board.connect_board.entities.BoardEntity;
import com.connect_board.connect_board.entities.BoardMemberEntity;
import com.connect_board.connect_board.entities.UserEntity;
import com.connect_board.connect_board.exceptions.ResourceNotFoundException;
import com.connect_board.connect_board.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
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
    public UserDTO getUserById(Long id)  throws Exception{
        // TO DO Add custom  response structure and exception handling]
        try{
            UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
            return modelMapper.map(userEntity, UserDTO.class);
        } catch (Exception e) {
            throw new Exception("Error during retrieving user by id : " + id + " " + e.getMessage());
        }


    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity postEntity = modelMapper.map(userDTO, UserEntity.class);
        UserEntity userEntity = userRepository.save(postEntity);
        return modelMapper.map(userEntity, UserDTO.class);

    }

    public void isUserExist(Long id) {
        boolean exists =  userRepository.existsById(id);
        if(!exists) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }
    @Override
    public UserDTO updateUser(Long id, Map<String, Object> updates) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if(!userEntity.isPresent()) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        updates.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(UserEntity.class, key);
            if(field != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field, userEntity.get(), value);
            }
            else{
                throw new IllegalArgumentException("Field not found: " + key);
            }

        });
        UserEntity updatedUserEntity = userRepository.save(userEntity.get());
        return modelMapper.map(updatedUserEntity, UserDTO.class);
    }

    @Override
    public void deleteUser(Long id) {
        isUserExist(id);
        userRepository.deleteById(id);
    }

    @Override
    public List<BoardDTO> getUserBoards(Long id) {
        Set<BoardEntity> boards = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id)).getBoards();
        return boards.stream().map(boardEntity -> modelMapper.map(boardEntity, BoardDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<BoardMemberDTO> getUserBoardMemberships(Long id) {
        Set<BoardMemberEntity> userMemberships = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id)).getBoardMemberships();
        return userMemberships.stream().map(boardMemberEntity -> modelMapper.map(boardMemberEntity, BoardMemberDTO.class)).collect(Collectors.toList());
    }
}
