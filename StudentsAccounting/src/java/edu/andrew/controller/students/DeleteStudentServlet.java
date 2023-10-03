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
        request.setAttribute("success",  success ? "Данные удалены" : "Данные не удалены");
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}
