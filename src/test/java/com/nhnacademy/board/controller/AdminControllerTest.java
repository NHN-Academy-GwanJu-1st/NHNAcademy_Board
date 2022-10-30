package com.nhnacademy.board.controller;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhnacademy.board.domain.BoardDTO;
import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.repository.UserRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdminControllerTest {

    private HttpServletRequest req;
    private HttpServletResponse res;
    private ServletContext servletContext;
    private UserRepository userRepository;

    @Before
    public void setUp() {
        req = mock(HttpServletRequest.class);
        res = mock(HttpServletResponse.class);

    }

//    @Test
//    public void userRegisterTest() {
//
//        when(req.getServletContext()).thenReturn(servletContext);
//        when(servletContext.getAttribute("userRepository")).thenReturn(userRepository);
//
//        when(req.getParameter("id")).thenReturn("testId");
//        when(req.getParameter("password")).thenReturn("testPassword");
//        when(req.getParameter("name")).thenReturn("testName");
//        when(req.getParameter("profile")).thenReturn("testProfile");
//
//
//        Command command = new UserRegisterController();
//
//        System.out.println(command.excute(req, res));
//    }

//    @Test
//    public void test() {
//        File file = new File("src/main/resources/users.json");
//        System.out.println(file.isFile());
//    }

    @Test
    public void addBoard() {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        File file = new File("C:\\NHN Academy\\board\\NHNAcademy_Board\\src\\main\\resources\\post.json");

        List<BoardDTO> list = new ArrayList<>();

        for (int i = 1; i < 74; i++) {
            list.add(new BoardDTO("testTitle" + i, "testContent" + i, "test"));
        }

        try {
            writer.writeValue(file, list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}