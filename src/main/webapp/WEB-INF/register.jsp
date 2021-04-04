<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        <%@include file="css/register.css"%>
    </style>
</head>
<body>
    <article>
        <fieldset>
            <form method="post" action="register">
                <h1>Rejestracja</h1>
                <div>
                    <label for="nick_name_u">Nazwa:</label>
                    <input class="inputx" id="nick_name_u" name="nick_name_u" type="text">
                </div>
                <div style="margin-left: 5px">
                    <label for="password_u">Hasło:</label>
                    <input class="inputx" id="password_u" name="password_u" type="password">
                </div>
                <div style="margin-left: 7px">
                    <label for="age_u">Wiek:</label>
                    <input class="inputx" id="age_u" name="age_u" type="number">
                </div>
                <div style="margin-left: -2px">
                    <label for="city_u">Miasto:</label>
                    <input class="inputx" id="city_u" name="city_u" type="text">
                </div>
                <input class="xbutton" type="submit" value="Zatwierdź">
                <input class="xbutton" type="button" value="Wróć" onClick="location.href='${pageContext.request.contextPath}/join';"/>
            </form>
        </fieldset>
    </article>
</body>
</html>
