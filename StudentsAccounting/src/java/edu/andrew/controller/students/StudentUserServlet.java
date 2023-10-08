package edu.andrew.controller.students;

import edu.andrew.controller.InitServlet;
import edu.andrew.controller.Jumpable;
import edu.andrew.model.Student;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "StudentUserServlet", urlPatterns = {"/studentsUserServlet"})
public class StudentUserServlet extends InitServlet implements Jumpable {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getSession().getAttribute("id").toString();
        int currentId = Integer.parseInt(idString);
        Set<Student> student = studentService.getByUserId(currentId);
        request.setAttribute("student", student);
        jump("/WEB-INF/jsp/info.jsp", request, response);
    }
}
