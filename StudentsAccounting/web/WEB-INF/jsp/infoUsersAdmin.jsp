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
        <title>Информация</title>
        <style><%@include file="/resources/css/infoStyle.css"%></style>
    </head>
    <body>
        <div class="header">
            <span class="header-title">Список данных всех пользователей</span>  
            <form action="transitionPage" method="post">
                <input type="submit" value="Назад"/>
            </form>
        </div>
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
            <th>Действие</th>
        </thead>
        <c:forEach var="ab" items="${user}">
            <tr>
                <td>${ab.id}</td>
                <td>${ab.login}</td>
                <td>${ab.password}</td>
                <td>${ab.lastName}</td>
                <td>${ab.firstName}</td>
                <td>${ab.middleName}</td>
                <td>${ab.email}</td>
                <td>${ab.status}</td>
                <td><a href="updateUsersAdmin.jsp?id=${ab.id}">Изменить</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>