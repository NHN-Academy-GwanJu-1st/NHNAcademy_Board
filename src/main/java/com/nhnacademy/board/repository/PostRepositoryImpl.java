package com.nhnacademy.board.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhnacademy.board.domain.BoardDTO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        /* Pagination 객체에 리스트를 념겨줘서 거기서 skip 이런까지 다 계산해서 다시 리스트를 념겨준다? */

        /* 만약 현재 페이지가 2페이지면 11 번부터 20 번까지 보내줘야 됨 */



        /* 여기서 페이지 객체를 넘겨주라는 거보니까 여기서 뭐 10개씩 뽑아서 넘겨주는 방식? */

    }
}
