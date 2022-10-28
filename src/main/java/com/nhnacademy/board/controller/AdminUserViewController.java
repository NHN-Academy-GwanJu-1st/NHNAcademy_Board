package com.nhnacademy.board.controller;


import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
public class AdminUserViewController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        log.info("AdminUserViewController");

        String queryString = req.getQueryString().split("=")[1];

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        UserDTO findUser = userRepository.findUser(queryString);

        if (Objects.isNull(findUser)) {
            return "redirect:/admin.do";
        }

        req.setAttribute("user", findUser);

        return "/adminView.jsp";
    }
}
