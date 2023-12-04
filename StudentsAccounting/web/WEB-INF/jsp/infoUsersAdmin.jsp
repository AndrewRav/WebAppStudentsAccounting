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
            <title><fmt:message key="info.page.title" /></title>
            <style><%@include file="/resources/css/infoStyle.css"%></style>
        </head>
        <body>
            <div class="header">
                <span class="header-title"><fmt:message key="all.users.info" /></span>  
                    <form action="transitionPage" method="post">
                        <input type="submit" value='<fmt:message key="button.back" />'/>
                    </form>
                </div>
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
                    <th><fmt:message key="th.action" /></th>
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
                        <td><form action="updateUser" method="get">
                                <input type="hidden" name="id" value="${ab.id}"/>
                                <input type="submit" value='<fmt:message key="edit" />'/></form></td>
                    </tr>
                </c:forEach>
            </table>
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