package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardDTO;
import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.entities.BoardEntity;
import com.connect_board.connect_board.entities.BoardMemberEntity;
import com.connect_board.connect_board.exceptions.ResourceNotFoundException;
import com.connect_board.connect_board.repositories.BoardRepository;
import com.connect_board.connect_board.utils.BoardMemberID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    private final ModelMapper modelMapper;
    @Override
    public List<BoardDTO> getAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(boardEntity -> modelMapper.map(boardEntity, BoardDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO getBoardById(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board not found with id: " + id));
        return modelMapper.map(boardEntity, BoardDTO.class);
    }

    @Override
    public BoardDTO createBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = modelMapper.map(boardDTO, BoardEntity.class);
        BoardEntity savedBoardEntity = boardRepository.save(boardEntity);
        return modelMapper.map(savedBoardEntity, BoardDTO.class);
    }

    @Override
    public BoardDTO updateBoard(Long id, Map<String, Object> updates) {
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);
        if(!boardEntity.isPresent()) {
            throw new ResourceNotFoundException("Board not found with id: " + id);
        }

        updates.forEach((key, value) ->{
            Field field = ReflectionUtils.findField(BoardEntity.class, key);
            if(field != null){
                field.setAccessible(true);
                ReflectionUtils.setField(field, boardEntity.get(), value);
            }
            else{
                throw new IllegalArgumentException("Invalid field: " + key);
            }
        });
        BoardEntity updatedBoardEntity = boardRepository.save(boardEntity.get());
        return modelMapper.map(updatedBoardEntity, BoardDTO.class);

    }

    @Override
    public void deleteBoard(Long id) {
        isBoardExist(id);
        boardRepository.deleteById(id);
    }

    @Override
    public List<BoardMemberDTO> getBoardMembers(Long id) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board not found with id: " + id));
        return boardEntity.getBoardMembers()
                .stream()
                .map(boardMemberEntity -> modelMapper.map(boardMemberEntity, BoardMemberDTO.class))
                .collect(Collectors.toList()
        );
    }

    @Override
    public BoardDTO addBoardMember(Long id, BoardMemberDTO boardMemberDTO) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board not found with id: " + id));
        BoardMemberEntity boardMemberEntity = modelMapper.map(boardMemberDTO, BoardMemberEntity.class);
        boardEntity.addBoardMember(boardMemberEntity);
        BoardEntity savedBoardEntity = boardRepository.save(boardEntity);
        return modelMapper.map(savedBoardEntity, BoardDTO.class);
    }

    @Override
    public void removeBoardMember(Long id, BoardMemberID memberId) {
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Board not found with id: " + id));
        BoardMemberEntity boardMemberEntity = boardEntity.getBoardMembers()
                .stream()
                .filter(member -> member.getId().equals(memberId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Board Member not found with id: " + memberId));
        boardEntity.removeBoardMember(boardMemberEntity);
    }

    public  void isBoardExist(Long id) {
        boolean exists = boardRepository.existsById(id);
        if(!exists) {
            throw new ResourceNotFoundException("Board not found with id: " + id);
        }
    }


}
