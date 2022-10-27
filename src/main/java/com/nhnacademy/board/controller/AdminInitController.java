package com.nhnacademy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminInitController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        
        return "/admin.jsp";
    }
}
