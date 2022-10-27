package com.nhnacademy.board.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes({
        javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        /* Admin ID and Password*/
        servletContext.setInitParameter("id", "admin");
        servletContext.setInitParameter("password", "12345");
    }
}
