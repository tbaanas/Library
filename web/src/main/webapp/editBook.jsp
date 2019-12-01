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
    <form action="/SaveEditBook" class="was-validated" method="post">
        <div class="mb-3">
            <label for="validationTextarea">Title</label>
            <input type="text" class="form-control is-invalid" id="validationTextarea" name="title"
                   value="<c:out value="${requestScope.book.title}"/>" required/>
        </div>
        <div class="mb-3">
            <label for="a">ISBN</label>
            <input type="text" class="form-control is-invalid" id="a" name="isbn"
                   value="<c:out value="${requestScope.book.isbn}"/>" required/>
        </div>

        <div class="form-group">
            <label>Category</label>
            <select class="custom-select" name="category" required>
                <c:forEach var="book" items="${requestScope.bookList}">
                    <option value="${book.category}">${book.category}</option>
                </c:forEach>
            </select>
            <div class="invalid-feedback">Example invalid custom select feedback</div>
        </div>
        <div class="mb-3">
            <label>Pages</label>
            <input type="number" class="form-control is-invalid" name="pages"
                   value="<c:out value="${requestScope.book.pages}"/>" required/>
        </div>
        <div class="mb-3">
            <label>Date</label>
            <input type="date" name="date" class="form-control is-invalid"
                   value="<c:out value="${requestScope.book.date}"/>">
        </div>
        <div class="mb-3">
            <label for="inputS">Author</label>
            <select id="inputS" class="form-control" name="author">
                <c:forEach var="author" items="${requestScope.author}">
                    <option name="author" value="${author.id}">${author.firstName} ${author.lastName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="mb-3">
            <label>Summary</label>
            <textarea maxlength="350" class="form-control is-invalid" name="summary" required><c:out value="${requestScope.book.summary}"/></textarea>
        </div>
        <input type="hidden" name="bID" value="${requestScope.book.id_book}" hidden/>
        <%--<input type="hidden" name="idAuthor" value="${requestScope.book.author.id}" hidden/>--%>

        <button type="submit" class="btn btn-success">SAVE</button>
    </form>
        </div>
    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
    <script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>
</div>
</body>
</html>


