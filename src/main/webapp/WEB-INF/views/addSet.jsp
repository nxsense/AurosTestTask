<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Knowledge Package Set</title>
</head>
<body>
<h1>Add new Knowledge Package Set</h1>
<form method="post" id="pac" action="${pageContext.request.contextPath}/sets/add"></form>
<table>
  <tr>
    <th>Title</th>
    <th>Add</th>
  </tr>
  <tr>
    <td>
      <label>
        <input type="text" name="title" form="pac" required>
      </label>
    </td>
    <td>
      <input type="submit" name="add" form="pac">
    </td>
  </tr>
</table>
</body>
</html>
