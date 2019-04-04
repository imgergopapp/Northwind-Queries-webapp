<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Task5Result" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task5</title>
</head>
<body>
    <div class="navbar">
            <a href="welcome">index</a>
            <a href="task1">task1</a>
            <a href="task2">task2</a>
            <a href="task3">task3</a>
            <a href="task4">task4</a>
            <a href="task5">task5</a>
        </div>
    <h1>Task5</h1>
    <form method="post" action="task5">
      <input type="number" step="0.01" placeholder="Min price" name="minPrice" required>
      <input type="submit" value="Filter!">
    </form>
    <br>
    <table border="1" border-color="white">
        <tr>
            <th>Company</th>
            <th>Product</th>
            <th>Price</th>
        </tr>
            <c:forEach var="result" items="${result5}">
                <tr>
                <td>${result.company}</td>
                <td>${result.product}</td>
                <td>${result.price}</td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
