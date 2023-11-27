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
                <span class="header-title"><fmt:message key="all.students.info" /></span>
                <form action="transitionPage" method="post">
                    <input type="submit" value='<fmt:message key="button.back" />'/>
                </form>
            </div>
            <table>
                <thead>
                <th>id</th>
                <th><fmt:message key="th.userid" /></th>
                <th><fmt:message key="th.lastname" /></th>
                <th><fmt:message key="th.firstname" /></th>
                <th><fmt:message key="th.middlename" /></th>
                <th><fmt:message key="th.birthdate" /></th>
                <th><fmt:message key="th.phonenumber" /></th>
                <th><fmt:message key="th.faculty" /></th>
                <th><fmt:message key="th.course" /></th>
                <th><fmt:message key="th.group" /></th>
                <th><fmt:message key="th.action" /></th>
                </thead>
                <c:forEach var="ab" items="${student}">
                    <tr>
                        <td>${ab.id}</td>
                        <td>${ab.userId}</td>
                        <td>${ab.lastName}</td>
                        <td>${ab.firstName}</td>
                        <td>${ab.middleName}</td>
                        <td>${ab.birthDate}</td>
                        <td>${ab.phoneNumber}</td>
                        <td>${ab.faculty}</td>
                        <td>${ab.course}</td>
                        <td>${ab.group}</td>
                        <td><form action="updateStudent" method="get">
                                <input type="hidden" name="id" value="${ab.id}"/>
                                <input type="submit" value='<fmt:message key="edit" />'/></form></td>
                    </tr>
                </c:forEach>
            </table>
        </body>
</fmt:bundle>
</html>