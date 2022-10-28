package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.BoardDTO;

import java.util.Map;

public interface PostRepository {

    public long registerBoard(BoardDTO board);

    public BoardDTO findBoard(long id);

    public Map<Long, BoardDTO> findAll();

    public void modifyBoard(BoardDTO board);

    public boolean removeBoard(long boardId);



}
