package edu.andrew.controller;

import edu.andrew.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User authorizedUser = userService.login(email, password);
        
        if (authorizedUser != null) {
            session.setAttribute("firstName", authorizedUser.getFirstName());
            session.setAttribute("middleName", authorizedUser.getMiddleName());
            session.setAttribute("status", authorizedUser.getStatus());
            session.setAttribute("id", authorizedUser.getId());
            
            if (authorizedUser.getStatus().equals("user")) {
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
