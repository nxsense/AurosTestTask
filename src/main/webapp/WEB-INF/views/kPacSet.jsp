<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Knowledge Package Sets</title>
</head>
<body>
<h1 class="kpac_table">All Knowledge Package Sets</h1>
<table class="kpac_table">
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Delete</th>
  </tr>
  <c:forEach var="kPacSet" items="${sets}">
    <tr>
      <td>
        <c:out value="${kPacSet.id}"/>
      </td>
      <td>
        <c:out value="${kPacSet.title}"/>
      </td>
      <td>
        <a href="${pageContext.request.contextPath}/sets/delete/${kPacSet.id}">Delete</a>
    </tr>
  </c:forEach>
</table>

</body>
</html>
