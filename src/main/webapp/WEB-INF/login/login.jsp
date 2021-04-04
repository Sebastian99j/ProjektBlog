<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zaloguj się</title>
    <style>
        * {
            text-align: center;
        }
        h1 {
            margin-top: 100px;
        }
        fieldset {
            width: 400px;
            display: inline-block;
            float: contour;
        }
        .fields {
            margin-left: -94px;
        }
        body {
            background-color: #c6c8ca;
        }
    </style>
</head>
<body>
<h1>Zaloguj się</h1>
<form action="j_security_check" method="post">
    <fieldset>
        <legend>Wprowadź swoje dane</legend>
        <div class="fields">
            <label for="username">Nazwa użytkownika:</label>
            <input name="j_username" placeholder="username" id="username">
        </div>
        <div>
            <label for="password">Hasło:</label>
            <input name="j_password" placeholder="password" type="password" id="password">
        </div>
        <button type="submit">Zaloguj się</button>
    </fieldset>
</form>
</body>
</html>