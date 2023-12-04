<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "err" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="edu.andrew.localization.messages.msg">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title><fmt:message key="admin.page.title" /></title>
        <style><%@include file="/resources/css/adminNewStyle.css"%></style>
    </head>

    <body>
        <!-- Добро пожаловать-->
        <div class="header">
            <h2 class="header-title"><fmt:message key="admin.welcome.message">
                    <fmt:param><%= session.getAttribute("firstName")%></fmt:param>
                    <fmt:param><%= session.getAttribute("middleName")%></fmt:param>
                </fmt:message></h2>
        </div>
        <!-- Добавление студента -->
        <div class="forms-container">
            <div class="login">
                <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
                <form method="post" action="createStudent" class="register-form" id="register-form">
                    <h2 class="active_1"><fmt:message key="section.students.title" /></h2>
                    <input type="number" min="0" name="userID" id="userID" placeholder='<fmt:message key="th.userid" />' class="text" required />
                    <input type="text" name="lastName" id="lastName" placeholder='<fmt:message key="th.lastname" />' class="text" required />
                    <input type="text" name="firstName" id="firstName" placeholder='<fmt:message key="th.firstname" />' class="text" required />
                    <input type="text" name="middleName" id="middleName" placeholder='<fmt:message key="th.middlename" />' class="text" required />
                    <input type="date" name="birthDate" id="birthDate" placeholder='<fmt:message key="th.birthdate" />' class="text" required />
                    <input type="text" name="phoneNumber" id="phoneNumber" placeholder='<fmt:message key="th.phonenumber" />' class="text" required />
                    <input type="text" name="faculty" id="faculty" placeholder='<fmt:message key="th.faculty" />' class="text" required />
                    <input type="number" min="0" name="course" id="course" placeholder='<fmt:message key="th.course" />' class="text" required />
                    <input type="text" name="groupName" id="groupName" placeholder='<fmt:message key="th.group" />' class="text" required />            
                    <br>
                    <input type="submit" name="signup" id="signup" class="signin" value='<fmt:message key="button.add" />' required />
                </form>
            </div>
            <div class="login">
                <!-- Добавление пользователя -->
                <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">
                <form method="post" action="createUser" class="register-form" id="register-form">
                    <h2 class="active_2"><fmt:message key="section.users.title" /></h2>
                    <input type="text" name="login" id="login" placeholder='<fmt:message key="th.user.login" />' class="text" required />
                    <input type="password" name="password" id="password" placeholder='<fmt:message key="th.user.password" />' class="text" required />
                    <input type="text" name="lastName" id="lastName" placeholder='<fmt:message key="th.user.lastname" />' class="text" required />
                    <input type="text" name="firstName" id="firstName" placeholder='<fmt:message key="th.user.firstname" />' class="text" required=""/>
                    <input type="text" name="middleName" id="middleName" placeholder='<fmt:message key="th.user.middlename" />' class="text" required />
                    <input type="email" name="email" id="email" placeholder="Email" class="text" required />
                    <select name="status" id="status" class="text_select" required>
                        <option value="" disabled selected hidden><fmt:message key="select.status" /></option>
                        <option value="user"><fmt:message key="status.user" /></option>
                        <option value="admin"><fmt:message key="status.admin" /></option>
                    </select>
                    <br>
                    <br>
                    <err:userError />
                    <input type="submit" name="signup" id="signup" class="signin_reg" value='<fmt:message key="button.add" />' />
                </form>
            </div>
        </div>

        <div class="main_part">       
            <div class="forms-container">
                <form method="post" action="deleteStudent" class="delete_student">
                    <h2 class="active_main_part_1"><fmt:message key="delete.student" /></h2>
                    <input type="number" class="text" min="1" name="id" id="id" placeholder='<fmt:message key="delete.id.student" />' />
                    <input type="submit" name="signup" id="signup" class="signin_student" value='<fmt:message key="button.delete" />' />
                </form>

                <form method="post" action="deleteUser" class="delete_user">
                    <h2 class="active_main_part_2"><fmt:message key="delete.user" /></h2>
                    <input type="number" class="text" min="1" name="id" id="id" placeholder='<fmt:message key="delete.id.user" />' />
                    <br>
                    <input type="submit" name="signup" id="signup" class="signin_user" value='<fmt:message key="button.delete" />' />
                </form>
            </div>
            <!-- Вывод данных -->
            <div class="forms-container">
                <form action="readStudent" method="get" class="all_students">
                    <input type="hidden" name="status" value="admin">
                    <h2 class="active_main_part_3"><fmt:message key="section.output.students" /></h2>
                    <input class="signin_all_students" type="submit" value='<fmt:message key="all.students.info" />'/>
                </form>
                <form action="readUser" method="get" class="all_users">
                    <h2 class="active_main_part_4"><fmt:message key="section.output.users" /></h2>
                    <input class="signin_all_users" type="submit" value='<fmt:message key="all.users.info" />'/>
                </form>
            </div>
        </div>
        <form action="index.html">
            <input type="hidden" name="logout" value="true"/>
            <input class="signin_leave" type="submit" value='<fmt:message key="logout.admin.button" />'/>
        </form> 
                
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="alert/dist/sweetalert.css">

        <script type="text/javascript">
            var status = document.getElementById("status").value;
            if (status == "success") {
                swal("Поздравляем!", "Операция прошла успешно!", "success");
            } else if (status == "failed") {
                swal("Извините", "Кажется, вы ввели неверные данные", "warning");
            }
        </script>
    </body>
    </fmt:bundle>
</html>

