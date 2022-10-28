package com.nhnacademy.board.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet(name = "frontController", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    private static String locale = "ko";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("FrontController service()");

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        /* session locale check */
        if (req.getParameter("locale") != null) {
            locale = req.getParameter("locale");
        }

        HttpSession session = req.getSession();
        session.setAttribute("locale", locale);

        try {
            // 실제 처리 요청 servlet
            Command command = resolveServlet(req.getServletPath());

            String view = command.excute(req, resp);

            if (view.startsWith(REDIRECT_PREFIX)) {
                // redirect 하는 경우
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                // redircet가 아니면 해당 jsp에 처리를 위임하고 include 설정으로 인해 그 결과를 돌려 받음
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception e) {
            log.error("", e);
            req.setAttribute("exception", e);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveServlet(String servletPath) {
        Command command = null;

        if ("/loginForm.do".equals(servletPath)) {
            command = new LoginFormController();
        } else if ("/login.do".equals(servletPath)) {
            command = new LoginController();
        } else if ("/logout.do".equals(servletPath)) {
            command = new LogoutController();
        } else if ("/userRegisterForm.do".equals(servletPath)) {
            command = new UserRegisterFormController();
        } else if ("/userRegister.do".equals(servletPath)) {
            command = new UserRegisterController();
        } else if ("/admin.do".equals(servletPath)) {
            command = new AdminInitController();
        } else if ("/admin/view.do".equals(servletPath)) {
            command = new AdminUserViewController();
        } else if ("/admin/delete.do".equals(servletPath)) {
            command = new AdminUserDeleteController();
        } else if ("/admin/modifyForm.do".equals(servletPath)) {
            command = new AdminModifyFormController();
        } else if ("/admin/modify.do".equals(servletPath)) {
            command = new AdminUserModifyController();
        } else if ("/board.do".equals(servletPath)) {
            command = new BoardInitController();
        } else if ("/board/registerForm.do".equals(servletPath)) {
            command = new BoardRegisterFormController();
        } else if ("/board/register.do".equals(servletPath)) {
            command = new BoardRegisterController();
        } else if ("/board/view.do".equals(servletPath)) {
            command = new BoardViewController();
        } else if ("/board/modifyForm.do".equals(servletPath)) {
            command = new BoardModifyFormController();
        } else if ("/board/modify.do".equals(servletPath)) {
            command = new BoardModifyController();
        } else if ("/board/delete.do".equals(servletPath)) {
            command = new BoardDeleteController();
        } else if ("/user/view.do".equals(servletPath)) {
            command = new UserViewController();
        }

        return command;
    }


}
