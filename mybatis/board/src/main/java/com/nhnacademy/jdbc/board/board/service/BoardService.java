package com.nhnacademy.jdbc.board.board.service;

import com.nhnacademy.jdbc.board.board.domain.Board;
import com.nhnacademy.jdbc.board.board.domain.UpdateBoardDTO;
import com.nhnacademy.jdbc.board.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface BoardService {

    Optional<Board> getBoard(Long boardId);
    List<Board> getAllBoard();
    void addBoard(String title, String content, String writeName, Long writeId);
    void deleteUser(Long id);


    Optional<Board> getBoardInfo(Long boardId);

    List<Board> getAllBoardList();

    User selectUserByName(String userName);
    User getUser(Long userId);

    void updateBoard(Long id, UpdateBoardDTO board);




}
