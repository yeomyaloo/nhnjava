package com.nhnacademy.edu.board.service;


import com.nhnacademy.edu.board.entity.Board;
import com.nhnacademy.edu.board.exception.UserNotFoundException;
import com.nhnacademy.edu.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Validated
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{


    private final BoardRepository boardRepository;


    @Override
    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found!" + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Board createdBoard(@Valid Board board) {
        return boardRepository.save(board);
    }

//    @Override
//    @Transactional(readOnly = true)
//    public Board modifyBoardById(Long id) {
//
//        Optional<Board> byId = Optional.ofNullable(boardRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found " + id)));
//
//        return boardRepository.save(byId.get());
//    }

    @Override
    @Transactional(readOnly = true)
    public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }
}
