package edu.andrew.controller.students;

import edu.andrew.controller.InitServlet;
import edu.andrew.controller.Jumpable;
import edu.andrew.model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "UpdateStudentServlet", urlPatterns = {"/updateStudent"})
public class UpdateStudentServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        Student student = studentService.getById(id);
        request.setAttribute("student", student);
        jump("/WEB-INF/jsp/updateStudents.jsp", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stringUserID = request.getParameter("userID");
        int userID = Integer.parseInt(stringUserID);
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String birthDate = request.getParameter("birthDate");
        String phoneNumber = request.getParameter("phoneNumber");
        String faculty = request.getParameter("faculty");
        String stringCourse = request.getParameter("course");
        int course = Integer.parseInt(stringCourse);
        String groupName = request.getParameter("groupName");
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);;
        boolean success = studentService.update(id, userID, lastName, firstName, middleName, birthDate, phoneNumber, faculty, course, groupName);
        request.setAttribute("success", success ? "Данные обновлены" : "Данные не обновлены");
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}
