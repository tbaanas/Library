<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super Side!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
<jsp:include page="/WEB-INF/fragments/header.jspf"/>
    <table>
    <c:forEach var="book" items="${sessionScope.books}">
     <tr><c:out value="${book.name}" /> </tr>

    </c:forEach>
    </table>

<%@ include file="/WEB-INF/fragments/footer.jspf" %>
<script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>
</div>
</body>
</html>
