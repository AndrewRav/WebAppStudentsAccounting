package edu.andrew.controller.students;

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
@WebServlet(name = "DeleteStudentServlet", urlPatterns = {"/deleteStudent"})
public class DeleteStudentServlet extends InitServlet implements Jumpable {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringStudentID = request.getParameter("id");
        int id = Integer.parseInt(stringStudentID);
        boolean success = studentService.delete(id);
        if (success == true) {
            request.setAttribute("status", "success");
        } else {
            request.setAttribute("status", "failed");
        }
        jump("/WEB-INF/jsp/admin.jsp", request, response);
    }
}
