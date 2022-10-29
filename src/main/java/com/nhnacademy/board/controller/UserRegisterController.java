package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterController implements Command {

    private static String IMAGE_DIR = System.getProperty("user.dir");
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String profile = req.getParameter("profile");

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        userRepository.addUser(new UserDTO(id, password, name, profile));

        return "redirect:/admin.do";
    }
}
