<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style><%@include file="/resources/css/timeoutStyle.css"%></style>
        <title>Страница таймаута</title>
    </head>
    <body>
        <div class="timeout-container">
            <h1>Упс..., кажется, время ожидания истекло</h1>
            <p>Вы были неактивны некоторое время. Пожалуйста, войдите в систему снова.</p>
            <form action="index.html">
                <input type="submit" value='<fmt:message key = "to.main"/>'/>
            </form>
        </div>
    </body>
    </fmt:bundle>
</html>
