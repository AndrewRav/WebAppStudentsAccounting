package edu.andrew.controller.students;

import edu.andrew.controller.InitServlet;
import edu.andrew.controller.Jumpable;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "UpdateStudentServlet", urlPatterns = {"/UpdateStudentServlet"})
public class UpdateStudentServlet extends InitServlet implements Jumpable {

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
        
        String stringStudentID = (String) request.getSession().getAttribute("id");
        int id = Integer.parseInt(stringStudentID);
        boolean success = studentService.update(id, userID, lastName, firstName, middleName, birthDate, phoneNumber, faculty, course, groupName);
        request.setAttribute("success", success ? "Данные обновлены" : "Данные не обновлены");
        jump("/WEB-INF/jsp/result.jsp", request, response);
    }
}
