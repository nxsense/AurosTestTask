<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Knowledge Package</title>
</head>
<body>
    <h1>Add new Knowledge Package</h1>
<form method="post" id="pac" action="${pageContext.request.contextPath}/kpacs/add"></form>
<table>
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="title" form="pac" required>
        </td>
        <td>
            <input type="text" name="description" form="pac" required>
        </td>
        <td>
            <input type="submit" name="add" form="pac">
        </td>
    </tr>
</table>
</body>
</html>
