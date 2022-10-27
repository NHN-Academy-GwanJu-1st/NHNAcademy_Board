package com.nhnacademy.board.controller;


import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AdminUserViewController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        log.info("AdminUserViewController");

        String queryString = req.getQueryString();
        log.info(queryString);  // name=asdf

        String userName = queryString.split("=")[1];

        UserRepository userRepository = (UserRepository) req.getAttribute("userRepository");

        UserDTO user = userRepository.findUser(queryString);

        req.setAttribute("user", user);

        return "/adminView.jsp";
    }
}
