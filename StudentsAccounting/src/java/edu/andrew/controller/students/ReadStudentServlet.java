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
@WebServlet(name = "ReadStudentServlet", urlPatterns = {"/readStudent"})
public class ReadStudentServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Set<Student> student = studentService.read();
        request.setAttribute("student", student);
        if (request.getSession().getAttribute("status").equals("user")) { // Получение из действующей сессии статуса пользователя
           jump("/WEB-INF/jsp/info.jsp", request, response);
        } else {
           jump("/WEB-INF/jsp/infoStudentsAdmin.jsp", request, response);
        }
    }
}
