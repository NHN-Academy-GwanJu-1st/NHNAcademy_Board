package com.nhnacademy.board.initializer;

import com.nhnacademy.board.repository.PostRepository;
import com.nhnacademy.board.repository.PostRepositoryImpl;
import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.repository.UserRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@Slf4j
@HandlesTypes({
        javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        /* Admin ID and Password */
        servletContext.setInitParameter("adminId", "admin");
        servletContext.setInitParameter("adminPassword", "12345");

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

        ac.refresh();
        ac.register(UserRepositoryImpl.class);
        ac.register(PostRepositoryImpl.class);
        UserRepository userRepository = (UserRepository) ac.getBean("userRepositoryImpl");
        PostRepository postRepository = (PostRepository) ac.getBean("postRepositoryImpl");
        servletContext.setAttribute("userRepository", userRepository);
        servletContext.setAttribute("postRepository", postRepository);

    }
}
