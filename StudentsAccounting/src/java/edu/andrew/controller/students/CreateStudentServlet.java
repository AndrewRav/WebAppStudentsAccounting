package edu.andrew.controller.students;

import edu.andrew.controller.Jumpable;
import edu.andrew.model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.andrew.controller.InitServlet;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "CreateStudentServlet", urlPatterns = {"/createStudent"})
public class CreateStudentServlet extends InitServlet implements Jumpable {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        jump("/WEB-INF/jsp/createStudent.jsp", request, response);
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

        Student student = new Student(); // mapping таблицы в объект 
        student.setUserId(userID);
        student.setLastName(lastName);
        student.setFirstName(firstName);
        student.setMiddleName(middleName);
        student.setBirthDate(birthDate);
        student.setPhoneNumber(phoneNumber);
        student.setFaculty(faculty);
        student.setCourse(course);
        student.setGroup(groupName);
        boolean success = studentService.create(student);
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
