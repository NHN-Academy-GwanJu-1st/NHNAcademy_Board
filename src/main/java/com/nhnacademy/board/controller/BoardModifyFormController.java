package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.repository.PostRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BoardModifyFormController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        long boardId = Long.parseLong(req.getQueryString().split("=")[1]);
        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");

        BoardDTO board = postRepository.findBoard(boardId);
        req.setAttribute("board", board);

        return "/boardModify.jsp";
    }
}
