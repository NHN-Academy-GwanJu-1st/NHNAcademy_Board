package com.nhnacademy.board.controller;

import com.nhnacademy.board.repository.PostRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardModifyController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");

        long boardId = Long.parseLong(req.getQueryString().split("=")[1]);
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        postRepository.modifyBoard(boardId, title, content);

        req.setAttribute("board", postRepository.findBoard(boardId));

        return "redirect:/board/view.do?id="+boardId;
    }
}
