<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Knowledge Package To Set</title>
</head>
<body>
<form method="post" id="set" action="${pageContext.request.contextPath}/sets/kpacs/add"></form>
<h1 class="table_dark">Add Knowledge Package To Set:</h1>
<table border="1" class="table_dark">
  <tr>
    <th>Set ID</th>
    <th>KPac ID</th>
    <th>Add</th>
  </tr>
  <tr>
    <td>
      <label>
        <input type="number" name="setId" form="set" required>
      </label>
    </td>
    <td>
      <label>
        <input type="number" name="kPacId" form="set" required>
      </label>
    </td>
    <td>
      <input type="submit" name="add" form="set">
    </td>
  </tr>
</table>
</body>
</html>