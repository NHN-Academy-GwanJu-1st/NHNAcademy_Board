package com.nhnacademy.board.controller;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
@Component
public class AdminUserModifyController implements Command{

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String profile = req.getParameter("profile");

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

        userRepository.modifyUser(file, new UserDTO(id, password, name, profile));

        return "redirect:/admin.do";
    }
}
