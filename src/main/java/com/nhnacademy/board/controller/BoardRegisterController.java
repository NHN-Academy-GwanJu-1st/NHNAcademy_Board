package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.repository.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardRegisterController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String userId = req.getParameter("userId");

        BoardDTO board = new BoardDTO(title, content, userId);

        postRepository.registerBoard(board);

        return "redirect:/board.do";
    }
}
