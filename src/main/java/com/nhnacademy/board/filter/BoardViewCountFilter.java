package com.nhnacademy.board.filter;


import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(filterName = "boardViewCountFilter", urlPatterns = "/board/view.do")
public class BoardViewCountFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("BoardViewCountFilter doFilter()");

        long boardId = Long.parseLong(request.getParameter("id"));

        PostRepository postRepository = (PostRepository) request.getServletContext().getAttribute("postRepository");

        BoardDTO board = postRepository.findBoard(boardId);
        board.setViewCount(board.getViewCount() + 1);

        chain.doFilter(request, response);

    }
}
