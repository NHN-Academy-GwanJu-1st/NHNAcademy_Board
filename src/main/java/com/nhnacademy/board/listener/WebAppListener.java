package com.nhnacademy.board.listener;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.PostRepository;
import com.nhnacademy.board.repository.PostRepositoryImpl;
import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.repository.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Slf4j
@WebListener
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("WebAppListener");

        ServletContext servletContext = sce.getServletContext();
        UserRepository userRepository = (UserRepository) servletContext.getAttribute("userRepository");
        PostRepository postRepository = (PostRepository) servletContext.getAttribute("postRepository");
        /* UserRepository */
//        UserRepository userRepository = new UserRepositoryImpl();

        try {
            readJsonUser(servletContext, userRepository);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        servletContext.setAttribute("userRepository", userRepository);

        /* BoardRepository */
//        PostRepository postRepository = new PostRepositoryImpl();

        try {
            readJsonBoard(servletContext, postRepository);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        servletContext.setAttribute("postRepository", postRepository);

    }

    public static void readJsonUser(ServletContext servletContext, UserRepository userRepository) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();

        URL resource = servletContext.getResource("/WEB-INF/classes/users.json");
        File file = Paths.get(resource.toURI()).toFile();
        List list = mapper.readValue(file, List.class);

        list.forEach(value -> {
            String valueString = value.toString();
            String[] split = valueString.split(",");
            UserDTO temp = new UserDTO(
                    split[0].substring(4),
                    split[1].substring(10),
                    split[2].substring(6),
                    split[3].substring(9, split[3].length() - 1)
            );
            userRepository.addUser(file ,temp);
        });
    }

    public static void readJsonBoard(ServletContext servletContext, PostRepository postRepository) throws IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();

        URL resource = servletContext.getResource("/WEB-INF/classes/post.json");
        File file = Paths.get(resource.toURI()).toFile();
        List list = mapper.readValue(file, List.class);

        list.forEach(value -> {
            String valueString = value.toString();
            String[] split = valueString.split(",");
            BoardDTO temp = new BoardDTO(
                    split[1].substring(7),
                    split[2].substring(9),
                    split[3].substring(8)
            );
            postRepository.registerBoard(file ,temp);
        });
    }
}
