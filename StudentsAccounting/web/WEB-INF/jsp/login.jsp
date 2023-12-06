<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><fmt:message key = "login.page.title" /></title>
            <style><%@include file="/resources/css/loginStyle.css"%></style>
        </head>
        <body>
            <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
            <div class="login">
                <h2 class="active"><fmt:message key="heading" /></h2>
                <form method="get" action="login">
                    <input type="email" class="text" name="email" id="email" placeholder="" required/>
                    <span><fmt:message key="email" /></span>
                    <br>
                    <br>
                    <input type="password" class="text" name="password" id="password" placeholder="" required/>
                    <span><fmt:message key="password" /></span>
                    <input type="submit" name="signin" id="signin" class="signin" value='<fmt:message key="button.login" />'/>
                    <hr>
                    <div class="system"><fmt:message key = "name.system" /></div>
                </form>
                <table>
                    <tr>
                        <td>
                            <form action="local">
                                <input type="hidden" name="locale" value="en"/>
                                <input type="submit" value='<fmt:message key = "en" />'/>
                            </form>
                        </td>
                        <td><form action="local">
                                <input type="hidden" name="locale" value="ru"/>
                                <input type="submit" name="locale" value='<fmt:message key = "ru" />'/>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>

            <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
            <link rel="stylesheet" href="alert/dist/sweetalert.css">

            <script type="text/javascript">
                var status = document.getElementById("status").value;
                if (status === "failed") {
                    swal("Извините", "Кажется, вы ввели неверные данные", "warning");
                }
            </script>
        </body>
    </fmt:bundle>
</html>