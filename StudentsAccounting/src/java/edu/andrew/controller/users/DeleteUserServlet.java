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
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/deleteUser"})
public class DeleteUserServlet extends InitServlet implements Jumpable {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringUserID = request.getParameter("id");
        int id = Integer.parseInt(stringUserID);
        boolean success = userService.delete(id);
        if (success == true) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        jump("/WEB-INF/jsp/admin.jsp", request, response);
    }
}
