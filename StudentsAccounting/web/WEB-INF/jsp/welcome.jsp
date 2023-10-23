<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><fmt:message key="welcome.page.title" /></title>
                <style><%@include file="/resources/css/indexStyle1.css"%></style>
            </head>
            <body>
                <h1><fmt:message key="welcome.message">
                        <fmt:param><%= session.getAttribute("firstName")%></fmt:param>
                        <fmt:param><%= session.getAttribute("middleName")%></fmt:param>
                    </fmt:message></h1>
                <form action="readStudent" method="get" class="form_1">
                    <input type="hidden" name="status" value="user">
                    <input class="signin" type="submit" value='<fmt:message key="list.all.students" />'/>
                </form>
                <form action="studentsUserServlet" method="get" class="form_2">
                    <input class="signin" type="submit" value='<fmt:message key="list.enrolled.students" />'/>
                </form>
                <form id="facultyForm" action="facultyServlet" method="get" class="form_3">
                    <label for="faculty"><fmt:message key="enter.faculty.label" /></label>
                    <input type="text" class="text" id="faculty" name="faculty" placeholder='<fmt:message key="enter.faculty.placeholder" />' required/><br/>
                    <input class="signin" type="submit" value='<fmt:message key="enter.faculty.button" />'/>
                </form>
                <form action="birthDateServlet" method="get" class="form_4">
                    <label for="faculty"><fmt:message key="enter.birth.year.label" /></label>
                    <input type="text" class="text" id="birthDate" name="birthDate" placeholder='<fmt:message key="enter.birth.year.placeholder" />' required/><br/>
                    <input class="signin" type="submit" value='<fmt:message key="enter.birth.year.button" />'/>
                </form>
                <form action="groupServlet" method="get" class="form_5">
                    <label for="group"><fmt:message key="enter.group.label" /></label>
                    <input type="text" class="text" id="group" name="group" placeholder='<fmt:message key="enter.group.placeholder" />' required/><br/>
                    <input class="signin" type="submit" value='<fmt:message key="enter.group.button" />'/>
                </form>
                <form action="updateUser" method="get" class="form_6">
                    <input type="hidden" name="id" value="<%= request.getSession().getAttribute("id")%>"/>
                    <input class="signin" type="submit" value='<fmt:message key="edit.profile.button" />'/>
                </form>
                <form action="index.html" class="form_7">
                    <input type="hidden" name="logout" value="true"/>
                    <input class="signin_leave" type="submit" value='<fmt:message key="logout.button" />'/>
                </form>
            </body>
    </fmt:bundle>
</html>