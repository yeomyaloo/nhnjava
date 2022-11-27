package com.nhnacademy.jdbc.board.board.domain;

import lombok.Data;
import lombok.Value;

import java.util.Date;


@Data
public class UpdateBoardDTO {

    private String title;
    private String content;
}
