package com.nhnacademy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class UserRegisterFormController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        return "/userRegister.jsp";
    }
}
