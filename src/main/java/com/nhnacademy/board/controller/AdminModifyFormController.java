package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminModifyFormController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String queryString = req.getQueryString().split("=")[1];

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        UserDTO user = userRepository.findUserByName(queryString);

        req.setAttribute("user", user);

        return "/admin/modify.jsp";
    }
}
