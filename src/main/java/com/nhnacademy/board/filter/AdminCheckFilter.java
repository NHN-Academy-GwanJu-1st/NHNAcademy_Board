package com.nhnacademy.board.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@WebFilter(filterName = "adminCheckFilter", urlPatterns = {"/admin/*", "/admin.do", "/userRegisterForm.do"})
public class AdminCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("adminCheckFilter doFilter()");
        HttpSession session = ((HttpServletRequest) request).getSession(false);

        boolean adminCheck = false;

        if (Objects.nonNull(session)) {
            if (session.getAttribute("admin") != null) {
                adminCheck = true;
            }
        }

        if (Objects.isNull(session) && !adminCheck) {
            ((HttpServletResponse) response).sendRedirect("/loginForm.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }
}
