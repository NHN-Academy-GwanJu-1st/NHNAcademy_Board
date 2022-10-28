package com.nhnacademy.board.controller;

import com.nhnacademy.board.repository.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");

        long boardId = Long.parseLong(req.getQueryString().split("=")[1]);
        postRepository.removeBoard(boardId);

        return "redirect:/board.do";
    }
}
