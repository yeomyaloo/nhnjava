package com.nhnacademy.jdbc.board.board.domain;

import lombok.Getter;

import java.util.Date;



@Getter
public class Board {

    private Long boardId;
    private String title;
    private String content;
    private Date created_at;
    private int visitCnt;
    private String writeName;
    private Long writeID;

    public Board(String title, String content, String writeName, Long writeID) {
        this.title = title;
        this.content = content;
        this.writeName = writeName;
        this.writeID = writeID;
    }

    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // new sql.Date(util.Date().getTime());



}
