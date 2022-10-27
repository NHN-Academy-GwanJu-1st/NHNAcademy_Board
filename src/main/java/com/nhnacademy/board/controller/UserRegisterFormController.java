package com.nhnacademy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UserRegisterFormController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession(false);

        boolean loginCheck = false;

        /* user and admin session check */
        if (Objects.nonNull(session)) {
            if (session.getAttribute("id") != null || session.getAttribute("admin") != null) {
                loginCheck = true;
            }
        }

        if (!loginCheck) {
            return "/userRegister.jsp";
        } else {
            return "/user.jsp";
        }
    }
}
