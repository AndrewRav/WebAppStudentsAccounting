package edu.andrew.controller.users;

import edu.andrew.controller.InitServlet;
import edu.andrew.controller.Jumpable;
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
@WebServlet(name = "CreateUserServlet", urlPatterns = {"/createUser"})
public class CreateUserServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/createUser.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String email = request.getParameter("email");
        String status = request.getParameter("status");

        User user = new User(); // mapping таблицы в объект 
    	user.setLogin(login);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setEmail(email);
        user.setStatus(status);
        boolean success = userService.create(user);
        request.setAttribute("success", success ? "Данные добавлены" : "Данные не добавлены");
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}
