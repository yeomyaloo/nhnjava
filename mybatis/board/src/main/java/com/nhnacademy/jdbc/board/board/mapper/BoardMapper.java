package com.nhnacademy.jdbc.board.board.mapper;

import com.nhnacademy.jdbc.board.board.domain.Board;
import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;


@Mapper
public interface BoardMapper {

    Optional<Board> selectBoardById(@Param("boardId") Long boardId);
    List<Board> selectAllBoard();
    void insertBoard(@Param("title") String title, @Param("content") String content, @Param("writeName") String writeName, @Param("writeId") Long writeId);

    void deleteById(Long id);
    void updateById(Long id, Board board);


    List<Board> selectJoinBoard();
}
