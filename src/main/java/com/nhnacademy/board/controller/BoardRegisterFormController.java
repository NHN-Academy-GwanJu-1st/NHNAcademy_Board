package com.nhnacademy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardRegisterFormController implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        return "/boardRegisterForm.jsp";
    }
}