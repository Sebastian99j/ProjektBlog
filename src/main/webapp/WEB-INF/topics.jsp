<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Blog o niczym</title>
    <meta charset="UTF-8">
    <meta name="description" content="Jest to blog o niczym. Można tworzyć tu różne tematy,
    komentować, lajkować i wiele więcej.">
    <link rel="shortcut icon" href="slajdy/logo.png">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700&amp;subset=latin-ext" rel="stylesheet">

    <!--[if lt IE 9]>-->
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>--%>
    <!--<![endif]-->
    <style>
        <%@ include file="css/bootstrap.min.css"%>
        <%@ include file="css/mainPage.css"%>
    </style>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<body>

<header>
    <nav class="navbar navbar-dark bg-primary navbar-expand-lg">

        <a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="slajdy/logo.png"></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu" aria-controls="mainmenu" aria-expanded="false" aria-label="Przełącznik nawigacji">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainmenu">

            <ul class="navbar-nav mr-auto">

                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}"> Start </a>
                </li>

                <c:if test="${pageContext.request.remoteUser == null }">
                    <li class="nav-item">
                        <a class="nav-link" href="join"> Zaloguj </a>
                    </li>
                </c:if>
                <c:if test="${pageContext.request.remoteUser != null }">
                    <li class="nav-item">
                        <a class="nav-link" href="logout"> Wyloguj </a>
                    </li>
                </c:if>

                <li class="nav-item">
                    <a class="nav-link" href="users"> Lista użytkowników </a>
                </li>

                <li class="nav-item active">
                    <a class="nav-link" href="topics"> Tematy </a>
                </li>

            </ul>

            <form class="form-inline" id="search" method="get" action="">

                <input class="form-control mr-1 mt-2" type="text" placeholder="Wyszukaj" aria-label="Wyszukaj" name="q">
                <input type="hidden" name="sitesearch" value="${pageContext.request.contextPath}/">
                <button class="btn btn-light mt-2" type="submit">Znajdź</button>
            </form>

        </div>
    </nav>
</header>

<article style="text-align: center">
    <h1>Tematy:</h1>
    <input class="xbutton" type="button" value="Dodaj post" onClick="location.href='${pageContext.request.contextPath}/addPost';"/>
    <div style="margin-top: 100px">
    <c:forEach var="topics" items="${requestScope.topics}">
        <form method="post" action="posts">
        <input style="min-width: 500px" type="submit" name="topic" value="${topics}">
        </form>
    </c:forEach>
    </div>
</article>

<footer style="position: relative;">
    <div class="stopka">
        <p id="trescStopki">Copyright 2021 oNiczym.blog wszelkie prawa zastrzeżone</p>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>