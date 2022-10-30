package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.PostRepository;
import com.nhnacademy.board.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BoardViewController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        long boardId = Long.parseLong(req.getQueryString().split("=")[1]);

        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");
        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        BoardDTO board = postRepository.findBoard(boardId);
        UserDTO writer = userRepository.findUser(board.getUserId());

        req.setAttribute("board", board);
        req.setAttribute("writer", writer);

        return "/boardView.jsp";
    }
}
