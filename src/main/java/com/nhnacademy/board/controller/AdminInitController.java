package com.nhnacademy.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class AdminInitController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        return "/admin.jsp";
    }
}
