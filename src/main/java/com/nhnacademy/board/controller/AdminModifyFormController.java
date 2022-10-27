package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AdminModifyFormController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String queryString = req.getQueryString().split("=")[1];

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        UserDTO user = userRepository.findUserByName(queryString);

        req.setAttribute("user", user);

        return "/adminModify.jsp";
    }
}
