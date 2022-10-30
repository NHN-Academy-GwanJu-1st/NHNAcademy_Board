package com.nhnacademy.board.domain;

import lombok.Data;

import java.util.Date;

@Data
public class BoardDTO {

    private static int boardCount = 0;
    private long id;
    private String title;
    private String content;
    private String userId;
    private Date date;
    private int viewCount;

    public BoardDTO(String title, String content, String userId) {
        this.id = ++boardCount;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.date = new Date();
        this.viewCount = 0;
    }
}
