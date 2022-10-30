package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.repository.PostRepository;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class BoardRegisterController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        PostRepository postRepository = (PostRepository) req.getServletContext().getAttribute("postRepository");

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String userId = req.getParameter("userId");

        BoardDTO board = new BoardDTO(title, content, userId);

        ServletContext servletContext = req.getServletContext();
        URL resource = null;
        File file = null;

        try {
            resource = servletContext.getResource("/WEB-INF/classes/post.json");
            file = Paths.get(resource.toURI()).toFile();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }


        postRepository.registerBoard(file, board);

        return "redirect:/board.do";
    }
}
