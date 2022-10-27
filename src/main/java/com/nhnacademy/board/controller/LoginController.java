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

        UserDTO user;

        /* admin login */
        if (adminId.equals(id) && adminPassword.equals(password)) {
            user = new UserDTO(id, password);
            HttpSession session = req.getSession();
            session.setAttribute("admin", user);
            userRepository.addUser(user);

            /* admin은 관리자 페이지로 리다이렉트*/
            return "redirect:/admin.jsp";

            /* 그러면 여기가 repository에서 findUser해서 존재하는지 확인하고 id pw 확인 후 로그인 */
        } else if ((user = userRepository.findUser(id)) != null) {
            if (user.getPassword().equals(password)) {
                HttpSession session = req.getSession();
                session.setAttribute("id", user);
                userRepository.addUser(user);

                return "redirect:/user.jsp";
            }

        } else {
            return "redirect:/loginForm.do";
        }

//        else if (initId.equals(id) && initPassword.equals(password)) {
//            HttpSession session = req.getSession();
//            session.setAttribute("id", id);
//            UserDTO user = new UserDTO(id, password);
//            userRepository.addUser(user);
//
//            /* user은 */
//            return "redirect:/user.jsp";
//         else {
//            return "redirect:/loginForm.do";
//        }
        return "redirect:/loginForm.do";

    }
}
