package com.nhnacademy.board.repository;

import java.util.List;

public interface Page<T> {

    /* 현재 페이지 번호*/
    public int getPageNumber();

    /* 한 페이지에 보여줄 게시물 갯수*/
    public int getPageSize();

    /* 총 페이지 수*/
    public int getTotalPageCount();

    /* 총 게시물 수*/
    long getTotalCount();

    /* 게시물 목록 */
    List<T> getList();
}
