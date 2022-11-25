package com.nhnacademy.jdbc.board.board.service.impl;


import com.nhnacademy.jdbc.board.board.domain.Board;
import com.nhnacademy.jdbc.board.board.exception.BoardNotExistException;
import com.nhnacademy.jdbc.board.board.exception.BoardNotFoundException;
import com.nhnacademy.jdbc.board.board.mapper.BoardMapper;
import com.nhnacademy.jdbc.board.board.service.BoardService;
import com.nhnacademy.jdbc.board.user.domain.User;
import com.nhnacademy.jdbc.board.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class DefaultBoardService implements BoardService {

    private final BoardMapper boardMapper;


    public DefaultBoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public Optional<Board> getBoard(Long boardId) {
        Optional<Board> board = boardMapper.selectBoardById(boardId);

        if(board.isPresent()){
            return board;
        }
        throw new BoardNotFoundException();
    }

    @Override
    public List<Board> getAllBoard() {
        if(Objects.nonNull(boardMapper.selectAllBoard())){
            return boardMapper.selectAllBoard();
        }
        throw new BoardNotExistException();
    }

    @Override
    public void addBoard(String title, String content, String writeName, Long writeId) {
        boardMapper.insertBoard(title, content, writeName, writeId);
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void modifyUser(Long id, Board board) {

    }

    @Override
    public List<Board> getAllBoardList() {

        List<Board> boards = boardMapper.selectJoinBoard();
        if(!boards.isEmpty()){
            return boards;
        }
        throw new BoardNotExistException();
    }
}
