package com.nhnacademy.board.controller;

import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LocaleController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String locale = "en";

        if (req.getParameter("locale") != null) {
            locale = req.getParameter("locale");
        }

        HttpSession session = req.getSession();
        session.setAttribute("locale", locale);

        return "redirect:/";
    }
}
