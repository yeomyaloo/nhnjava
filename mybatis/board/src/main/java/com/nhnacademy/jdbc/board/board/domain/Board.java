package com.nhnacademy.jdbc.board.board.domain;

import com.nhnacademy.jdbc.board.user.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;



@Getter
@NoArgsConstructor
public class Board {

    private Long boardId;
    private String title;
    private String content;
    private Date createdAt;
    private int visitCnt;
    private String writeName;
    private String modifyName;
    private Long writeID;

    public Board(Long boardId, String title, String writeName,Date createdAt) {
        this.boardId = boardId;
        this.title = title;
        this.writeName = writeName;
        this.createdAt = createdAt;
    }

    public Board(String title, String content, String writeName, Long writeID) {
        this.title = title;
        this.content = content;
        this.writeName = writeName;
        this.writeID = writeID;
    }

    // new sql.Date(util.Date().getTime());


}
