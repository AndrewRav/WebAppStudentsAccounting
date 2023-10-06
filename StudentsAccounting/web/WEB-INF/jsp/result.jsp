<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>результат запроса</title>
    </head>
    <body>
        <h1>${success}</h1>
        <form action="index.html">
            <input type="submit" value="На главную"/>
        </form>        
    </body>
</html>
