package edu.andrew.controller;

import edu.andrew.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User userLogin = userService.login(email, password);
        if (userLogin != null) {
            if (userLogin.getStatus().equals("user")) {
                jump("/WEB-INF/jsp/welcome.jsp", request, response);
            } else {
                jump("/WEB-INF/jsp/admin.jsp", request, response);
            }
        } else {
            request.setAttribute("status", "failed");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
