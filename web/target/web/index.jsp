<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super Side!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <meta charset="UTF-8"/>
</head>
<body>
<div class="container-fluid w-auto h-auto d-inline-block">
    <jsp:include page="/WEB-INF/fragments/header.jspf"/>
    <div class="jumbotron">
    <form action="/Action" method="post">
    <table class="table table-bordered table-dark">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Tytuł</th>
            <th scope="col">ilość stron</th>
            <th scope="col">Kategoria</th>
            <th scope="col">opis</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${requestScope.books}" varStatus="loop">
            <tr>
                <th scope="row"> ${loop.index + 1}</th>
                <td><c:out value="${book.title}"/></td>
                <td><c:out value="${book.pages}"/></td>
                <td><c:out value="${book.category}"/></td>
                <td><c:out value="${book.summary}"/></td>
                <td><input type="radio" name="bookId" value="${book.id_book}" checked></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="submit" class="btn btn-primary" name="action" value="ADD">
    <input type="submit" class="btn btn-success" name="action" value="EDIT">
    <input type="submit" class="btn btn-danger" name="action" value="SHOW">
    <input type="submit" class="btn btn-warning" name="action" value="DELETE">
    </form>
    </div>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
    <script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>
</div>
</body>
</html>
