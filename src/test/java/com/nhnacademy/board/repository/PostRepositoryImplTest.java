package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.BoardDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PostRepositoryImplTest {

    PostRepository postRepository = new PostRepositoryImpl();

    @Test
    public void boardRegister() {
        BoardDTO board = new BoardDTO("testTitle", "testContent", "testUser");

        long boardId = postRepository.registerBoard(board);

        Assert.assertEquals(boardId, 1);
    }

    @Test
    public void findBoard() {

        BoardDTO board = new BoardDTO("testTitle", "testContent", "testUser");

        long boardId = postRepository.registerBoard(board);

        long findBoardId = 1;

        BoardDTO findBoard = postRepository.findBoard(findBoardId);

        Assert.assertEquals(findBoard, board);
    }

    @Test
    public void findAll() {
        for (int i = 0; i < 10; i++) {
            postRepository.registerBoard(new BoardDTO("testTitle" + i, "testContent" + i, "testUser" + i));
        }

        Map<Long, BoardDTO> all = postRepository.findAll();

        Assert.assertEquals(all.size(), 10);

    }

    @Test
    public void modifyBoard() {
//        BoardDTO board = new BoardDTO("testTitle", "testContent", "testUser");
//
//        postRepository.boardRegister(board);
//        BoardDTO beforeBoard = postRepository.findBoard(board.getId());
//
//        BoardDTO modify = new BoardDTO("modifyTitle", "modifyContent", "testUser");
//        postRepository.modifyBoard(modify);
//
//        BoardDTO modifyBoard = postRepository.findBoard(board.getId());
//
//        Assert.assertEquals(modifyBoard.getContent(), modify.getContent());
    }

    @Test
    public void removeBoard() {
        BoardDTO board = new BoardDTO("testTitle", "testContent", "testUser");

        postRepository.registerBoard(board);

        boolean result = postRepository.removeBoard(board.getId());

        Assert.assertTrue(result);
    }
}