package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserViewController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        String userId = req.getQueryString().split("=")[1];
        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        UserDTO user = userRepository.findUser(userId);
        req.setAttribute("user", user);

        return "/userView.jsp";
    }
}
