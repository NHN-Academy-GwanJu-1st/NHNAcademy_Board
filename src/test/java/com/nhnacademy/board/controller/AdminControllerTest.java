package com.nhnacademy.board.controller;

import com.nhnacademy.board.repository.UserRepository;
import com.nhnacademy.board.repository.UserRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.util.Arrays;

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
    public void test() {
        String str = "[{id=admin, password=12345, name=Administrator, profileFileName=null}, {id=admin, password=12345, name=Administrator, profileFileName=null}, {id=admin, password=12345, name=Administrator, profileFileName=null}]";
        Arrays.stream(str.split(",")).forEach(o -> System.out.println(o));
    }
}