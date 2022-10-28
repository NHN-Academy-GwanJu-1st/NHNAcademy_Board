package com.nhnacademy.board.repository;

import com.nhnacademy.board.domain.BoardDTO;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class PostRepositoryImplTest {

    PostRepository postRepository = new PostRepositoryImpl();
    BoardDTO board = new BoardDTO("testTitle", "testContent", "testUser");

    @Test
    public void boardRegister() {

        long boardId = postRepository.registerBoard(board);

        Assert.assertEquals(boardId, 1);
    }

//    @Test
//    public void findBoard() {
//
//        long boardId = postRepository.registerBoard(board);
//
//        long findBoardId = 1;
//
//        BoardDTO findBoard = postRepository.findBoard(findBoardId);
//
//        Assert.assertEquals(findBoard, board);
//    }

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
        String modifyTitle = "modifyTitle";
        String modifyContent = "modifyTitle";

        postRepository.registerBoard(board);
        BoardDTO findBoard = postRepository.findBoard(board.getId());
        findBoard.setTitle(modifyTitle);
        findBoard.setContent(modifyContent);


        Assert.assertEquals(findBoard.getTitle(), modifyTitle);
        Assert.assertEquals(findBoard.getContent(), modifyContent);

    }

    @Test
    public void removeBoard() {
        postRepository.registerBoard(board);

        boolean result = postRepository.removeBoard(board.getId());

        Assert.assertTrue(result);
    }
}