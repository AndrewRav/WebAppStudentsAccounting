package edu.andrew.controller.users;

import edu.andrew.controller.InitServlet;
import edu.andrew.controller.Jumpable;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends InitServlet implements Jumpable {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        request.getSession(true).setAttribute("id", id);
        jump("/WEB-INF/jsp/update.jsp", request, response);
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
        
        String stringUserID = (String) request.getSession().getAttribute("id");
        int id = Integer.parseInt(stringUserID);
        boolean success = userService.update(id, login, password, lastName, firstName, middleName, email, status);
        request.setAttribute("success", success ? "Данные обновлены" : "Данные не обновлены");
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}
