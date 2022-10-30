package com.nhnacademy.board.repository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class Pagination implements Page {

    List list;

    // 현재 페이지 수
    int pageNumber;
    // 한 페이지에 보여줄 사이즈
    int pageSize;
    // 총 페이지 수
    int totalPageCount;
    // 총 게시물 수
    int totalCount;

    int skip;

    public Pagination(List list, int pageNumber, int pageSize, int totalCount) {
        this.list = list;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = (totalCount / pageSize) + 1;
        this.skip = (pageNumber - 1) * pageSize;

    }

    @Override
    public int getPageNumber() {
        return this.pageNumber;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public int getTotalPageCount() {
        return this.totalPageCount;
    }

    @Override
    public long getTotalCount() {
        return this.totalCount;
    }

    @Override
    public List getList() {
        return (List) this.list.stream()
                .skip(this.skip)
                .limit(this.pageSize)
                .collect(Collectors.toList());
    }
}
