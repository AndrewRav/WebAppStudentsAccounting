<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title><fmt:message key="edit.profile.button" /></title>
        <style><%@include file="/resources/css/infoStyle.css"%></style>
    </head>
    <body>
        <div class="header">
            <span class="header-title"><fmt:message key="edit.profile.button" /></span>
            <form action="transitionPage" method="post">
                <input class="button" type="submit" value='<fmt:message key="button.back" />'/>
            </form>
        </div>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <form method="post" action="updateUser">
            <table>
                <thead>
                <th>id</th>
                <th><fmt:message key="th.user.login" /></th>
                <th><fmt:message key="th.user.password" /></th>
                <th><fmt:message key="th.user.lastname" /></th>
                <th><fmt:message key="th.user.firstname" /></th>
                <th><fmt:message key="th.user.middlename" /></th>
                <th>Email</th>
                <th><fmt:message key="th.user.status" /></th>
                </thead>
                    <tr>
                        <td>${user.id}</td>
                        <td><input type="text" name="login" value="${user.login}" required></td>
                        <td><input type="text" name="password" value="${user.password}" required></td>
                        <td><input type="text" name="lastName" value="${user.lastName}" required></td>
                        <td><input type="text" name="firstName" value="${user.firstName}" required></td>
                        <td><input type="text" name="middleName" value="${user.middleName}" required></td>
                        <td><input type="text" name="email" value="${user.email}" required></td>
                        <td>${user.status}</td>
                    </tr>
            </table>
            <div class="form-group form-button">
                <input type="hidden" name="id" value="${user.id}"/>
                <input type="hidden" name="status" value="${user.status}"/>
                <input type="submit" name="signup" id="signup"
                       class="form-submit" value='<fmt:message key="update" />' />
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
    </fmt:bundle>
</html>
