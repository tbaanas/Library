<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Super Side!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.0.0-2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <jsp:include page="/WEB-INF/fragments/header.jspf"/>
    <div class="row">
    <div class="col-5">
        <table class="table table-bordered">
            <tbody>
            <tr>
                <th scope="row">Title</th>
                <td><c:out value="${requestScope.book.title}"/></td>

            </tr>
            <tr>
                <th scope="row">category</th>
                <td><c:out value="${requestScope.book.category}"/></td>

            </tr>
            <tr>
                <th scope="row">pages</th>
                <td><c:out value="${requestScope.book.pages}"/></td>

            </tr>
            <tr>
                <th scope="row">ISBN</th>
                <td><c:out value="${requestScope.book.isbn}"/></td>

            </tr>
            <tr>
                <th scope="row">Date</th>
                <td><c:out value="${requestScope.book.date}"/></td>

            </tr>
            <tr>
                <th scope="row">summary</th>
                <td colspan="2"><c:out value="${requestScope.book.summary}"/></td>

            </tr>
            </tbody>
        </table>
    </div>
    <div class="col-5">

        <c:if test="${requestScope.book.borrow==true}">
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col" colspan="2">Borrower</th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">First Name</th>
                    <td colspan="2"><c:out value="${requestScope.book.setCurrentBorrowerName}"/></td>
                </tr>

                </tbody>
            </table>
            <form action="/ReturnBook" method="post">

                <input type="text" name="bookId" value="${requestScope.book.id_book}" hidden>
                <button type="submit" class="btn btn-danger">RETURN</button>
            </form>
        </c:if>
        <c:if test="${requestScope.book.borrow==false}">
            <form action="/borrowAdd" method="post">
                <div class="form-group">
                    <div class="input-group mb-3 col-10">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Select</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01" name="borrowersList">
                            <option selected>Choose...</option>

                            <c:forEach var="borrowersList" items="${requestScope.borrowersList}">
                                <option value="${borrowersList.id}">${borrowersList.firstName} ${borrowersList.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="text" name="bookId" value="${requestScope.book.id_book}" hidden>
                </div>
                <button type="submit" class="btn btn-success">BORROW</button>
            </form>



        </c:if>


    </div>

        </div>
    <a href="/HomeServlets" class="btn btn-primary">Home</a>


    <%@ include file="/WEB-INF/fragments/footer.jspf" %>
    <script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>

</div>
</body>
</html>
