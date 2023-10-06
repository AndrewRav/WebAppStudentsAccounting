<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Список группы</title>
    </head>
    <body>
        <table>
            <thead>
                <th>id</th>
                <th>имя</th>
                <th>удалить</th>
                <th>редактировать</th>
            </thead>
            <core:forEach var="gr" items="${group}">
                <tr>
                    <td>${gr.id}</td>
                    <td>${gr.name}</td>
                    <td>
                        <form action="delete" method="post">
                    	<input type="hidden" name="id" value="${gr.id}"/>
                    	<input type="submit" value="удалить"/>
                    </form>
                    </td>
                    <td>
                    <form action="update">
                    	<input type="hidden" name="id" value="${gr.id}"/>
                    	<input type="submit" value="редактировать"/>
                    </form>                    
                    </td>
                </tr>
            </core:forEach>
        </table>
        <form action="index.html">
            <input type="submit" value="На главную"/>
        </form>
    </body>
</html>
