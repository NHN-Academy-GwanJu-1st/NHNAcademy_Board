package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.BoardDTO;

import java.io.File;
import java.util.Map;

public interface PostRepository {

    public long registerBoard(File file, BoardDTO board);

    public BoardDTO findBoard(long id);

    public Map<Long, BoardDTO> findAll();

    public void modifyBoard(File file, long boardId, String title, String content);

    public boolean removeBoard(File file,long boardId);

    public int getTotalCount();

    Page<BoardDTO> getPagedPosts(int page, int size);



}
