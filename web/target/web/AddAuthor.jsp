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
<jsp:include page="/WEB-INF/fragments/header.jspf"/>
<div class="container-fluid w-auto h-auto d-inline-block">

    <div class="jumbotron">
<div class="col-4">
            <c:forEach var="author" items="${requestScope.author}">
                <table class="table table-bordered col-3">
                    <tbody class="col-2">
                <tr class="col-2">
                    <th scope="row">First Name</th>
                    <td class="col-2"><c:out value="${author.firstName}"/></td>

                </tr>
                <tr class="col-2">
                    <th scope="row">Last Name</th>
                    <td><c:out value="${author.lastName}"/></td>

                </tr>
                <tr class="col-2">
                    <th scope="row">Birth Place</th>
                    <td><c:out value="${author.birthPlace}"/></td>

                </tr>
            </tbody>
        </table>
            </c:forEach>
</div>


        <form action="/AddAuthor" method="post">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="inputEmail1">First Name</label>
                    <input type="text" class="form-control" id="inputEmail1" placeholder="first Name" name="firstName">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEmail2">Last Name</label>
                    <input type="text" class="form-control" id="inputEmail2" placeholder="last Name" name="lastName">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputEmail32">Last Name</label>
                    <input type="text" class="form-control" id="inputEmail32" placeholder="birth Place" name="birthPlace">
                </div>
            </div>
            <button type="submit" class="btn btn-primary">ADD</button>
        </form>
    </div>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
    <script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>
</div>
</body>
</html>
