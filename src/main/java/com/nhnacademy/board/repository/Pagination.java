package com.nhnacademy.board.repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Pagination implements Page {

    List list;

    // 현재 페이지 수
    int pageNumber;         // -> 얘는 request통해서 들어오는 얘일꺼고
    // 한 페이지에 보여줄 사이즈
    int pageSize;           // -> 얘는 대충 10으로 고정 시키면 될꺼같고
    // 총 페이지 수
    int totalPageCount;
    // 총 게시물 수
    int totalCount;         // -> 얘를 repo에서 갖고오고 위에 총 페이지수를 계산

    int skip;

    public Pagination(List list, int pageNumber, int pageSize, int totalCount) {
        this.list = list;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = (totalCount / pageSize) + 1;
        this.skip = (pageNumber - 1) * pageSize;

    }

    /* 총 게시글 수를 받아서 계산을 해야 한다.
    * 그러면 일단 게시글 수를 갖고 와야겠지?
    * */

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
        /* 스킵부터 pageSize까지 뽑아서 보내면 됨 단 만약 pageSize까지 가다가 null이뜨면 거기서는 그만 보여주기 */

        return (List) this.list.stream()
                .skip(this.skip)
                .limit(this.pageSize)
                .collect(Collectors.toList());
    }
}
