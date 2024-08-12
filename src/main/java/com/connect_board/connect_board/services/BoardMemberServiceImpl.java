package com.connect_board.connect_board.services;

import com.connect_board.connect_board.dto.BoardMemberDTO;
import com.connect_board.connect_board.entities.BoardMemberEntity;
import com.connect_board.connect_board.repositories.BoardMemberRepository;
import com.connect_board.connect_board.utils.BoardMemberID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardMemberServiceImpl implements BoardMemberService {
    private final BoardMemberService boardMemberService;
    private final BoardMemberRepository boardMemberRepository;
    private final ModelMapper modelMapper;

    @Override
    public BoardMemberDTO getBoardMemberById(BoardMemberID id) {
        BoardMemberEntity boardMember= boardMemberRepository.findById(id).orElseThrow(() -> new RuntimeException("Board Member not found with id: " + id));
        return modelMapper.map(boardMember, BoardMemberDTO.class);
    }

    @Override
    public BoardMemberDTO createBoardMember(BoardMemberDTO boardMemberDTO) {
        BoardMemberEntity boardMemberEntity = modelMapper.map(boardMemberDTO, BoardMemberEntity.class);
        BoardMemberEntity savedBoardMemberEntity = boardMemberRepository.save(boardMemberEntity);
        return modelMapper.map(savedBoardMemberEntity, BoardMemberDTO.class);
    }

}
