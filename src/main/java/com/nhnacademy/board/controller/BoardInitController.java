package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.repository.Page;
import com.nhnacademy.board.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Slf4j
@Component
public class BoardInitController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {
        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");


        int size = Integer.parseInt(req.getParameter("size"));
        int pageNumber = Integer.parseInt(req.getParameter("page"));
        if (Objects.isNull(pageNumber)) {
            pageNumber = 1;
        }
        if (Objects.isNull(size)) {
            size = 10;
        }
        Page<BoardDTO> pagedPosts = postRepository.getPagedPosts(pageNumber, size);

        log.info("" + pageNumber);
        log.info("" + size);

        req.setAttribute("pagedPosts", pagedPosts);

        req.setAttribute("boardMap", postRepository.findAll());
        return "/board.jsp";
    }
}
