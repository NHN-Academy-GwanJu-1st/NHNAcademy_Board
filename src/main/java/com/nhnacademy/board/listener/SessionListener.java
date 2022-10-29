package com.nhnacademy.board.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {

    private static int sessionCount = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("SessionListener sessionCreated()" + (++sessionCount));

        HttpSession session = se.getSession();

        session.setAttribute("sessionCount", sessionCount);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.info("SessionListener sessionDestroyed()" + (--sessionCount));

        HttpSession session = se.getSession();
        session.setAttribute("sessionCount", sessionCount);
    }
}
