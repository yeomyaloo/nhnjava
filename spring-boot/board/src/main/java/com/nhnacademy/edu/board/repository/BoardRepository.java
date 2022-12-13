package com.nhnacademy.edu.board.repository;

import com.nhnacademy.edu.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {


}
