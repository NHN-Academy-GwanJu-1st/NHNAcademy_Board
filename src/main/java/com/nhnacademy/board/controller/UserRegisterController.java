package com.nhnacademy.board.controller;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

@Slf4j
@Component
public class UserRegisterController implements Command {

    private static String IMAGE_DIR = System.getProperty("user.dir")+"/images";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    @Override
    public String excute(HttpServletRequest req, HttpServletResponse res) {

        String id = req.getParameter("id");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String profile = "";

        if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
            return "redirect:/userRegisterForm.do";
        }

        log.info("IMAGE_DIR " + IMAGE_DIR);

        try {
            for (Part part : req.getParts()) {
                String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

                if (contentDisposition.contains("filename=")) {
                    String fileName = id + "_" + extractFileName(contentDisposition);
                    profile = fileName;
                    if (part.getSize() > 0) {
                        part.write(IMAGE_DIR + File.separator + fileName);
                        part.delete();
                    }
                } else {
                    String formValue = req.getParameter(part.getName());
                    log.error("{}={}", part.getName(), formValue);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }

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

        userRepository.addUser(file, new UserDTO(id, password, name, profile));

        return "redirect:/admin.do";
    }

    private String extractFileName(String contentDisposition) {
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                String fileName = token.substring(token.indexOf("=") + 1).trim().replace("\"", "");
                int index = fileName.lastIndexOf(File.separator);
                return fileName.substring(index + 1);
            }
        }

        return null;
    }
}
