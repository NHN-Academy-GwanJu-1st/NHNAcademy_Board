package com.nhnacademy.board.listener;

import com.nhnacademy.board.domain.UserDTO;
import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.repository.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("WebAppListener");

        UserRepository userRepository = new UserRepositoryImpl();
        /* Admin */
        userRepository.addUser(new UserDTO("admin", "12345", "관리자", ""));

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("userRepository", userRepository);
    }
}
