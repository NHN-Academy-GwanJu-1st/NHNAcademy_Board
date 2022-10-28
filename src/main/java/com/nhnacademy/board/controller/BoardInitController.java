package com.nhnacademy.board.controller;

import com.nhnacademy.board.repository.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardInitController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");
        req.setAttribute("boardMap", postRepository.findAll());
        return "/board.jsp";
    }
}
