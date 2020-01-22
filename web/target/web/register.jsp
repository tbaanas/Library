<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>Jumbotron Template · Bootstrap</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css"/>
    <meta name="theme-color" content="#563d7c">
    <meta charset="UTF-8"/>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="index.jsp">HOME</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="index.jsp" tabindex="-1" aria-disabled="true">Disabled</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="index.jsp" id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
                   aria-expanded="false">Dropdown</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="WEB-INF/log/index.jsp">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<main role="main">


    <div class="jumbotron">
        <div class="container col-4">
            <form class="form-signin" action="/Register" method="post">
                <h1 class="h3 mb-3 font-weight-normal">Zarejestruj się</h1>
                <div class="form-group">
                    <label for="inputLogin" class="sr-only">Login</label>
                    <input type="text" id="inputLogin" class="form-control" placeholder="Login" name="username"
                           required>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="sr-only">Email</label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="email" name="email" required
                           autofocus>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="sr-only">Hasło</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Hasło" name="password"
                           required>
                </div>
                <div class="form-group">
                    <label for="inputPassword" class="sr-only">Powtórz hasło</label>
                    <input type="password" id="inputPassword2" class="form-control" placeholder="Powtórz hasło"
                           name="password2" required>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Zarejestruj się</button>
            </form>
            <%
                DateFormat dateFormat = new SimpleDateFormat("yyyy");
                Date date = new Date();
                String showDate = dateFormat.format(date);

                if (request.getParameter("error")!=null) {
                    String error = "Hasła muszą być takie same!";
            %>
            <div class="alert alert-danger col-10" role="alert">
                <%= error%>
            </div>
            <%
                }

            %>
        </div>


    </div>

    <%--    <hr>--%>

</main>

<footer class="card-footer">
    <p>&copy; <%=showDate%>
    </p>
</footer>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
</body>
</html>
