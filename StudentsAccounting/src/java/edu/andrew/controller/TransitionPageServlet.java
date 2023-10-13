package edu.andrew.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "TransitionPageServlet", urlPatterns = {"/transitionPage"})
public class TransitionPageServlet extends HttpServlet implements Jumpable {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("status").equals("user")) {
            jump("/WEB-INF/jsp/welcome.jsp", request, response);
        } else {
            jump("/WEB-INF/jsp/admin.jsp", request, response);
        }
    }
}
