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
    <form action="/add" method="post">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Title</label>
                    <input type="text" class="form-control" id="inputEmail4" placeholder="Title" name="title">
                </div>

                <div class="form-group col-md-3">
                    <label for="inputAddress">Pages</label>
                    <input type="number" class="form-control" id="inputAddress" placeholder="Pages" name="pages">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">ISBN</label>
                    <input type="text" class="form-control" id="inputPassword4" placeholder="isbn" name="isbn">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">Category</label>
                    <select id="inputState" class="form-control" name="category" >
                        <option selected>Chose...</option>
                        <c:forEach var="bookList" items="${requestScope.bookList}">
                            <option name="bookList" value="${bookList.category}">${bookList.category}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group col-md-4">
                    <label for="inputS">Author</label>
                    <select id="inputS" class="form-control">
                        <option selected>Chose...</option>
                        <c:forEach var="author" items="${requestScope.author}">
                            <option name="author" value="${author.id}">${author.firstName} ${author.lastName}</option>
                        </c:forEach>

                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="validationTextarea">Summary</label>
                    <textarea class="form-control" id="validationTextarea" placeholder="Summary" name="summary"></textarea>
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
