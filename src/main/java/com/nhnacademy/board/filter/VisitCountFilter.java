package com.nhnacademy.board.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "visitCountFilter", urlPatterns = {"/board/view.do", "/user/view.do"})
public class VisitCountFilter implements Filter {
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("VisitCounterFilter doFilter()");

        ServletContext servletContext = request.getServletContext();
        int visitCount = (int) servletContext.getAttribute("visitCount");

        servletContext.setAttribute("visitCount", ++visitCount);

        chain.doFilter(request, response);
    }
}
