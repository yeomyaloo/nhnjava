package com.nhnacademy.jdbc.board.board.domain;

import com.nhnacademy.jdbc.board.user.domain.User;
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

    public Board(Long boardId, String title, String writeName,Date created_at) {
        this.boardId = boardId;
        this.title = title;
        this.writeName = writeName;
        this.created_at = created_at;
    }

    public Board(String title, String content, String writeName, Long writeID) {
        this.title = title;
        this.content = content;
        this.writeName = writeName;
        this.writeID = writeID;
    }

    // new sql.Date(util.Date().getTime());


}
