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
@WebServlet(name = "UpdateUserServlet", urlPatterns = {"/updateUser"})
public class UpdateUserServlet extends InitServlet implements Jumpable {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        User user = userService.getById(id);
        request.setAttribute("user", user);
        if (request.getSession().getAttribute("status").equals("user")) {
         jump("/WEB-INF/jsp/updatePersonalData.jsp", request, response);   
        } else {
         jump("/WEB-INF/jsp/updateUsersAdmin.jsp", request, response);   
        }
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
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        boolean success = userService.update(id, login, password, lastName, firstName, middleName, email, status);
        // request.setAttribute("success", success ? "Данные обновлены" : "Данные не обновлены");
        // jump("/WEB-INF/jsp/result.jsp", request, response);
        if (success == true) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        doGet(request, response);
    }
}
