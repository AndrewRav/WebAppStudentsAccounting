<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.sql.*"%>

<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title><fmt:message key="update.students" /></title>
        <style><%@include file="/resources/css/updateStudentStyle.css"%></style>
    </head>
    <body>
        <div class="header">
            <span class="header-title"><fmt:message key="update.students" /></span>
            <form action="readStudent" method="get">
                <input type="submit" value='<fmt:message key="button.back" />'/>
            </form>
        </div>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <form method="post" action="updateStudent">
            <table>
                <thead>
                <th><fmt:message key="th.userid" /></th>
                <th><fmt:message key="th.lastname" /></th>
                <th><fmt:message key="th.firstname" /></th>
                <th><fmt:message key="th.middlename" /></th>
                <th><fmt:message key="th.birthdate" /></th>
                <th><fmt:message key="th.phonenumber" /></th>
                <th><fmt:message key="th.faculty" /></th>
                <th><fmt:message key="th.course" /></th>
                <th><fmt:message key="th.group" /></th>
                </thead>
                <tbody>
                    <tr>
                        <td><input type="number" name="userID" value="${student.userId}" required></td>
                        <td><input type="text" name="lastName" value="${student.lastName}" required></td>
                        <td><input type="text" name="firstName" value="${student.firstName}" required></td>
                        <td><input type="text" name="middleName" value="${student.middleName}" required></td>
                        <td><input type="text" name="birthDate" value="${student.birthDate}" required></td>
                        <td><input type="text" name="phoneNumber" value="${student.phoneNumber}" required></td>
                        <td><input type="text" name="faculty" value="${student.faculty}" required></td>
                        <td><input type="number" min="0" name="course" value="${student.course}" required></td>
                        <td><input type="text" name="groupName" value="${student.group}" required></td>
                    </tr>
                </tbody>
            </table>
            <div class="form-group form-button">
                <input type="hidden" name="id" value="${student.id}">
                <input type="submit" name="signup" id="signup"
                       class="form-submit" value='<fmt:message key="update" />' />
            </div>
        </form>   

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">

        <script type="text/javascript">
            var status = document.getElementById("status").value;
            if (status === "success") {
                swal("Поздравляю", "Данные успешно обновлены", "success");
            } else if (status === "failed") {
                swal("Ошибка!", "Неверный ввод данных", "error");
            }
        </script>
    </body>
    </fmt:bundle>
</html>
