<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Burger Tracker</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <div class="main-container">
        <div class="table-show-all">
            <h1>Burger Tracker</h1>
            <table class="table text-center" >
                <thead>
                <tr>
                    <th scope="col">Burger Name</th>
                    <th scope="col">Restaurant Name</th>
                    <th scope="col">Rating (out of 5)</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${burgers}" var="burger">
                    <tr>
                        <td>${burger.name}</td>
                        <td>${burger.restaurant}</td>
                        <td>${burger.rating}</td>
                        <td class="actions-col">
                            <a href="/burgers/${burger.id}/edit">Edit</a>
                            <form:form action="/burgers/makeDelete" method="post" modelAttribute="toBeDeletedBurger">
<%--                                <input type="hidden" name="_method" value="delete">--%>
                                <form:hidden path="id" value="${burger.id}"/>
                                <input type="submit" value="Delete" class="btn btn-link">
                            </form:form>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="form-add-burger">
            <h2>Add a Burger:</h2>
            <form:form action="/addBurger" method="post" modelAttribute="burger" >
                <div class="mb-3">
                    <form:label path="name" cssClass="form-label" for="name">Burger Name</form:label>
                    <form:input path="name" class="form-control" id="name" />
                </div>
                <div class="mb-3">
                    <form:errors path="name" cssClass="alert alert-danger" />
                </div>
                <div class="mb-3">
                    <form:label path="restaurant" cssClass="form-label" for="restaurant">Burger Restaurant</form:label>
                    <form:input path="restaurant" class="form-control" id="restaurant" />
                </div>
                <div class="mb-3">
                    <form:errors path="restaurant" cssClass="alert alert-danger" />
                </div>
                <div class="mb-3">
                    <form:label path="rating" cssClass="form-label" for="rating">Rating</form:label>
                    <form:input path="rating" class="form-control" id="rating" />
                </div>
                <div class="mb-3">
                    <form:errors path="rating" cssClass="alert alert-danger"  />
                </div>
                <div class="mb-3">
                    <form:label path="notes" cssClass="form-label" for="notes">Notes</form:label>
                    <form:input path="notes" class="form-control" id="notes" />
                </div>
                <div class="mb-3">
                    <form:errors path="notes" cssClass="alert alert-danger" />
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>

    </div>


    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>
</body>
</html>