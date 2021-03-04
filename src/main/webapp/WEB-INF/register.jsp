<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        * {
            text-align: center;
        }
        body {
            margin-top: 50px;
        }
        .xbutton {
            font-size: 20px;
            color: black;
            border: 1px solid black;
            background: none;
            padding: 10px 15px;
            font-weight: 400;
            font-family: 'Hammersmith One', sans-serif;
            border-radius: 2px;
            display: inline-block;
            margin: 0 auto;
            width: 200px;
        }
        .xbutton:hover {
            background: #075181;
            background: -webkit-linear-gradient(top, #075181, #3cddd1);
            background: -moz-linear-gradient(top, #075181, #3cddd1);
            background: -o-linear-gradient(top, #075181, #3cddd1);
            background: -ms-linear-gradient(top, #075181, #3cddd1);
            background: linear-gradient(top, #075181, #3cddd1);
        }
    </style>
</head>
<body>
    <article>
        <fieldset>
            <form method="post" action="register">
                <h1>Rejestracja</h1>
                <div>
                    <label for="nick_name_u">Nazwa:</label>
                    <input id="nick_name_u" name="nick_name_u" type="text">
                </div>
                <div>
                    <label for="password_u">Hasło:</label>
                    <input id="password_u" name="password_u" type="password">
                </div>
                <div>
                    <label for="age_u">Wiek:</label>
                    <input id="age_u" name="age_u" type="number">
                </div>
                <div>
                    <label for="city_u">Miasto:</label>
                    <input id="city_u" name="city_u" type="text">
                </div>
                <input class="xbutton" type="submit" value="Zatwierdź">
                <input class="xbutton" type="button" value="Wróć" onClick="location.href='${pageContext.request.contextPath}/';"/>
            </form>
        </fieldset>
    </article>
</body>
</html>
