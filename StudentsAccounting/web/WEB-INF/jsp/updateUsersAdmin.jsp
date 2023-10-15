<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Редактирование данных студентов</title>
        <style><%@include file="/resources/css/updateUserStyle.css"%></style>
    </head>
    <body>
        <div class="header">
            <span class="header-title">Редактирование данных преподавателей</span>
            <form action="transitionPage" method="post">
                <input class="button" type="submit" value="Назад"/>
            </form>
        </div>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <form method="post" action="updateUser">
            <table>
                <thead>
                <th>id</th>
                <th>Логин</th>
                <th>Пароль</th>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
                <th>Email</th>
                <th>Статус</th>
                </thead>
                <tr>
                    <td>${user.id}</td>
                    <td><input type="text" name="login" value="${user.login}" required></td>
                    <td><input type="text" name="password" value="${user.password}" required></td>
                    <td><input type="text" name="lastName" value="${user.lastName}" required></td>
                    <td><input type="text" name="firstName" value="${user.firstName}" required></td>
                    <td><input type="text" name="middleName" value="${user.middleName}" required></td>
                    <td><input type="text" name="email" value="${user.email}" required></td>
                    <td><select name="status" id="status" class="status">
                            <option value="${user.status}" hidden>${user.status}</option>
                            <option value="user">user</option>
                            <option value="admin">admin</option>
                        </select></td>
                </tr>
            </table>
            <div class="form-group form-button">
                <input type="hidden" name="id" value="${user.id}"/>
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
