package edu.andrew.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Andrew
 */
@WebListener
public class SessionTimeOutListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        int timeout = 1;
        session.setMaxInactiveInterval(timeout);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
    }
}
