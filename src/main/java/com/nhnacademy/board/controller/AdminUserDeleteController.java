package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
public class AdminUserDeleteController implements Command {
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        log.info("AdminUserDeleteController");

        String queryString = req.getQueryString().split("=")[1];

        UserRepository userRepository = (UserRepository) req.getServletContext().getAttribute("userRepository");

        ServletContext servletContext = req.getServletContext();
        URL resource = null;
        File file = null;

        try {
            resource = servletContext.getResource("/WEB-INF/classes/users.json");
            file = Paths.get(resource.toURI()).toFile();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        userRepository.deleteUser(file, queryString);

        return "redirect:/admin.do";
    }
}
