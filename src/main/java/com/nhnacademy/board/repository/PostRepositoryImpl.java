package com.nhnacademy.board.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhnacademy.board.domain.BoardDTO;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PostRepositoryImpl implements PostRepository {

    Map<Long, BoardDTO> boardMap = new HashMap<>();

    List<BoardDTO> list = new ArrayList<>();

    @Override
    public long registerBoard(File file, BoardDTO board) {

        list.add(board);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boardMap.put(board.getId(), board);

        return board.getId();
    }

    @Override
    public BoardDTO findBoard(long id) {
        return boardMap.get(id);
    }

    @Override
    public Map<Long, BoardDTO> findAll() {
        return boardMap;
    }

    @Override
    public void modifyBoard(File file, long boardId, String title, String content) {
        BoardDTO board = findBoard(boardId);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == boardId) {
                list.get(i).setTitle(title);
                list.get(i).setContent(content);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        board.setTitle(title);
        board.setContent(content);

    }

    @Override
    public boolean removeBoard(File file, long boardId) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == boardId) {
                list.remove(i);
            }
        }

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        boolean removeCheck = false;

        if (boardMap.containsKey(boardId)) {
            boardMap.remove(boardId);
            removeCheck = true;
        }

        return removeCheck;
    }

    @Override
    public int getTotalCount() {
        return boardMap.size();
    }

    @Override
    public Page<BoardDTO> getPagedPosts(int page, int size) {
        int totalCount = this.getTotalCount();

       return new Pagination(list, page, size, totalCount);

    }
}
