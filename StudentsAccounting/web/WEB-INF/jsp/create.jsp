<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Добавить</title>
    </head>
    <body>
        <form action="create" method="post">
            <label for="name">Введите имя</label>
            <input type="text" id="name" name="name"/>
            <input type="submit" value="Ввод"/>
        </form>
        <form action="index.html">
            <input type="submit" value="На главную"/>
        </form>        
    </body>
</html>
