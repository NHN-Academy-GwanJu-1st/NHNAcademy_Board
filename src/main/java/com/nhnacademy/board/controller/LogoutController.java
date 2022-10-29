package com.nhnacademy.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LogoutController implements Command{
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        HttpSession session = req.getSession(false);

        if (session != null && session.getAttribute("id") != null) {
            session.invalidate();
        }

        if (session != null && session.getAttribute("admin") != null) {
            session.invalidate();
        }

        return "redirect:/loginForm.do";
    }
}
