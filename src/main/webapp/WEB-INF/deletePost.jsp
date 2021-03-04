<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usuwanie postu</title>
</head>
<body>
    <form method="get" action="/delete">
        <input type="number" id="idDelete" name="idDelete">
        <label for="idDelete">Podaj id usuwanego tematu</label>
        <input type="submit" value="Zatwierdź">
    </form>
</body>
</html>
