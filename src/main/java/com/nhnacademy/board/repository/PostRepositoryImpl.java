package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.BoardDTO;

import java.util.HashMap;
import java.util.Map;

public class PostRepositoryImpl implements PostRepository {

    Map<Long, BoardDTO> boardMap = new HashMap<>();

    @Override
    public long registerBoard(BoardDTO board) {

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
    public void modifyBoard(BoardDTO board) {
        /* TODO 나중에 구현 */
        board.setId(board.getId() - 1);
        boardMap.put(board.getId(), board);
    }

    @Override
    public boolean removeBoard(long boardId) {

        boolean removeCheck = false;

        if (boardMap.containsKey(boardId)) {
            boardMap.remove(boardId);
            removeCheck = true;
        }

        return removeCheck;
    }
}
