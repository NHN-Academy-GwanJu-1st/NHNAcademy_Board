package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Command {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        String adminId = req.getServletContext().getInitParameter("adminId");
        String adminPassword = req.getServletContext().getInitParameter("adminPassword");

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        UserDTO user;

        /* admin login */
        if (adminId.equals(id) && adminPassword.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", userRepository.findUser("admin"));

            /* admin은 관리자 페이지로 리다이렉트*/
            return "redirect:/admin.do";

        } else if ((user = userRepository.findUser(id)) != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("id", user);

                return "redirect:/board.do?page=1&size=10";
            }

        } else {
            return "redirect:/loginForm.do";
        }
        return "redirect:/loginForm.do";

    }
}
