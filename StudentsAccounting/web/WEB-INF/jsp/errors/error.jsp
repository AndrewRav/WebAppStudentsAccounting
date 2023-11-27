<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><fmt:message key = "error.page"/></title>
        </head>
        <body>
            <h1 style="color: red">
                <fmt:message key = "error">
                    <fmt:param value="${pageContext.exception.message}"/>
                </fmt:message>
            </h1>
            <h2 style="color: red">
                <fmt:message key = "error.code">
                    <fmt:param value="${pageContext.errorData.statusCode}"/>
                </fmt:message>                
            </h2>
            <h3>
                <fmt:message key = "error.name">
                    <fmt:param value="${pageContext.exception.getClass().getName}"/>
                    <fmt:param value="${pageContext.errorData.requestURI}"/>
                </fmt:message>                 
            </h3> 
            <form action="index.html">
                <input type="submit" value="<fmt:message key = "to.main"/>"/>
            </form>         
        </body>
    </fmt:bundle>
</html>
