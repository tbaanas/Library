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
        <table class="table table-bordered">
            <tbody>
            <c:forEach var="bookList" items="${requestScope.bookList}">
                <tr>
                    <th scope="row"><c:out value="${bookList.id_category}"/></th>
                    <td><c:out value="${bookList.category}"/></td>

                </tr>
            </c:forEach>

            </tbody>
        </table>
        <form action="/AddCategory" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Category</label>
                    <input type="text" class="form-control" id="inputEmail4" placeholder="Category" name="category">
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
