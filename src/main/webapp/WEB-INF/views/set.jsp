<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Knowledge Packages in Set</title>
</head>
<body>
  <h1>Knowledge Packages in Set</h1>
<table>
  <tr>
    <th>Title:</th>
    <th>${kPacSet.title}</th>
  </tr>
  <tr>
    <th>Id:</th>
    <th>${kPacSet.id}</th>
  </tr>
  <tr>
    <th>Knowledge packages</th>
  </tr>
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Description</th>
    <th>Creation Date</th>
  </tr>
  <tbody>
  <c:forEach var="kPac" items="${kPacSet.knowledgePackages}">
    <tr>
      <th>${kPac.id}</th>
      <th>${kPac.title}</th>
      <th>${kPac.description}</th>
      <th>${kPac.creationDate}</th>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
