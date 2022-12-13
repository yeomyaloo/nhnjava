package com.nhnacademy.edu.board.service;

import com.nhnacademy.edu.board.entity.Board;

import java.util.List;

public interface BoardService {

    List<Board> getBoards();
    Board getBoard(Long id);
    Board createdBoard(Board board);
    //Board modifyBoardById(Long id);
    void deleteBoardById(Long id);


}
