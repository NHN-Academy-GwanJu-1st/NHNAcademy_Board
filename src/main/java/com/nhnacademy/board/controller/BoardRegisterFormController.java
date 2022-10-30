package com.nhnacademy.board.controller;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BoardRegisterFormController implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        return "/boardRegisterForm.jsp";
    }
}
