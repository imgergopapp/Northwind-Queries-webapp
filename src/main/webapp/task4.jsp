<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.codecool.web.model.Task4Result" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task4</title>
</head>
<body>
    <div class="navbar">
        <a href="">index</a>
        <a href="task1">task1</a>
        <a href="task2">task2</a>
        <a href="task3">task3</a>
        <a href="task4">task4</a>
        <a href="task5">task5</a>
    </div>
    <h1>Task4</h1>
    <table border="1" border-color="white">
        <tr>
            <th>Company</th>
            <th>Order ID's</th>
        </tr>
            <c:forEach var="result" items="${result4}">
                <tr>
                <td>${result.company}</td>
                <td>${result.orders}</td>
                </tr>
            </c:forEach>
    </table>
</body>
</html>
