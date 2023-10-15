<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Редактирование данных студентов</title>
        <style><%@include file="/resources/css/updateStudentStyle.css"%></style>
    </head>
    <body>
        <div class="header">
            <span class="header-title">Редактирование данных студентов</span>
            <form action="transitionPage" method="post">
                <input type="submit" value="Назад"/>
            </form>
        </div>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <form method="post" action="updateStudent">
            <table>
                <thead>
                <th>user_id</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Дата рождения</th>
                <th>Телефон</th>
                <th>Факультет</th>
                <th>Курс</th>
                <th>Группа</th>
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
                       class="form-submit" value="Обновить" />
            </div>
        </form>   

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">

        <script type="text/javascript">
            var status = document.getElementById("status").value;
            if (status == "success") {
                swal("Поздравляю", "Данные успешно обновлены", "success");
            } else if (status == "failed") {
                swal("Ошибка!", "Неверный ввод данных", "error");
            }
        </script>
    </body>
</html>
