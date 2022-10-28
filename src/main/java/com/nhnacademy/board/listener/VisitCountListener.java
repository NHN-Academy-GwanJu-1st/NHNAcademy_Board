package com.nhnacademy.board.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@WebListener
public class VisitCountListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("VisitCountListener Init");

        /* visit Counter File */
        ServletContext servletContext = sce.getServletContext();
        String countFile = "visitNumber.dat";
        String countFilePath = "/WEB-INF/classes/" + countFile;
        log.info("countFilePath " + countFilePath);

        servletContext.setAttribute("countFilePath", countFilePath);

        int visitCount = 0;
        try (DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(countFilePath))) {
            visitCount = dis.readInt();
        } catch (Exception e) {
            log.error("", e);
        }

        servletContext.setAttribute("visitCount", visitCount);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String countFilePath = (String) servletContext.getAttribute("countFilePath");

        int visitCount = (int) servletContext.getAttribute("visitCount");

        try (OutputStream os = Files.newOutputStream(Paths.get(servletContext.getResource(countFilePath).toURI()))){
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(visitCount);
        } catch (IOException | URISyntaxException e) {
            log.error("" + e);
        }
    }
}
