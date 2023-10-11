<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
        <style><%@include file="/resources/css/loginStyle.css"%></style>
    </head>
    <body>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
        <div class="login">
            <h2 class="active">Авторизация</h2>
            <form method="get" action="login">
                <input type="email" class="text" name="email" id="email" placeholder="" required/>
                <span>Почта</span>
                <br>
                <br>
                <input type="password" class="text" name="password" id="password" placeholder="" required/>
                <span>Пароль</span>
                <input type="submit" name="signin" id="signin" class="signin" value="Войти"/>
                <hr>
                <div class="system">Система — «Факультатив»</div>
            </form>
        </div>

        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">

        <script type="text/javascript">
            var status = document.getElementById("status").value;
            if (status == "failed") {
                swal("Извините", "Кажется, вы ввели неверные данные", "warning");
            }
        </script>
    </body>
</html>