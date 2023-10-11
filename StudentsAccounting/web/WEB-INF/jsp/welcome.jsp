<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Личный кабинет</title>
        <style><%@include file="/resources/css/indexStyle1.css"%></style>
    </head>
    <body>
        <h1>Добро пожаловать, <%= session.getAttribute("name")%> <%= session.getAttribute("middleName")%>!</h1>
        <form action="readStudent" method="get" class="form_1">
            <input class="signin" type="submit" value="Список всех студентов в системе"/>
        </form>
        <form action="studentsUserServlet" method="get" class="form_2">
            <input class="signin" type="submit" value="Список студентов, которые записались к вам на факультатив"/>
        </form>
        <form id="facultyForm" action="facultyServlet" method="get" class="form_3">
            <label for="faculty">Введите название факультета:</label>
            <input type="text" class="text" id="faculty" name="faculty" placeholder="Например, ФЭБУ" required/><br/>
            <input class="signin" type="submit" value="Список студентов заданного факультета"/>
        </form>
        <form action="birthDateServlet" method="get" class="form_4">
            <label for="faculty">Введите год рождения:</label>
            <input type="text" class="text" id="birthDate" name="birthDate" placeholder="Например, 2002" required/><br/>
            <input class="signin" type="submit" value="Список студентов, родившихся после заданного года"/>
        </form>
        <form action="groupServlet" method="get" class="form_5">
            <label for="group">Введите группу:</label>
            <input type="text" class="text" id="group" name="group" placeholder="Например, ЭЭБ-1" required/><br/>
            <input class="signin" type="submit" value="Список учебной группы"/>
        </form>
        <form action="pesonalDataServlet" method="post" class="form_6">
            <input class="signin" type="submit" value="Редактирование ваших личных данных"/>
        </form>
        <form action="index.html" class="form_7">
            <input type="hidden" name="logout" value="true"/>
            <input class="signin_leave" type="submit" value="Выйти из аккаунта"/>
        </form>
    </body>
</html>
