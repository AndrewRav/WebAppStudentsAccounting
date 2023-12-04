package edu.andrew.controller.users;

import edu.andrew.controller.InitServlet;
import edu.andrew.controller.Jumpable;
import edu.andrew.errors.UserValidationError;
import edu.andrew.model.User;
import edu.andrew.validator.UserValidator;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        
        UserValidationError errors = new UserValidationError();
        UserValidator.validate(login, password, errors);
        RequestDispatcher rd;
        if (!errors.getErrorList().isEmpty()) {
            request.setAttribute("result", errors);
            rd = getServletContext().getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
            rd.forward(request, response);
            return;
        }

        User user = new User(); // mapping таблицы в объект 
    	user.setLogin(login);
        user.setPassword(password);
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setMiddleName(middleName);
        user.setEmail(email);
        user.setStatus(status);
        boolean success = userService.create(user);
        // request.setAttribute("success", success ? "Данные добавлены" : "Данные не добавлены");
        // jump("/WEB-INF/jsp/result.jsp", request, response);
        if (success == true) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        jump("/WEB-INF/jsp/admin.jsp", request, response);
    }
}
