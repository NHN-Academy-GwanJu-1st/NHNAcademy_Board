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

        String initId = req.getServletContext().getInitParameter("id");
        String initPassword = req.getServletContext().getInitParameter("password");

        String adminId = req.getServletContext().getInitParameter("adminId");
        String adminPassword = req.getServletContext().getInitParameter("adminPassword");

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        /* admin login */
        if (adminId.equals(id) && adminPassword.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", id);
            UserDTO user = new UserDTO(id, password);
            userRepository.addUser(user);

            /* admin은 관리자 페이지로 리다이렉트*/
            return "redirect:/admin.jsp";
        } else if (initId.equals(id) && initPassword.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", id);
            UserDTO user = new UserDTO(id, password);
            userRepository.addUser(user);

            /* user은 */
            return "redirect:/user.jsp";
        } else {
            return "redirect:/loginForm.do";
        }
    }
}
