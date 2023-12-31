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
@WebServlet(name = "GroupServlet", urlPatterns = {"/groupServlet"})
public class GroupServlet extends InitServlet implements Jumpable {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String group = request.getParameter("group");
        Set<Student> student = studentService.getByGroup(group);
        request.setAttribute("student", student);
        jump("/WEB-INF/jsp/info.jsp", request, response);
    }
}
