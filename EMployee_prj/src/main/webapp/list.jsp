<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.List" %>
    <%@ page import="entity.Employee" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> hello </h1>
   <h1>Employee List</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Salary</th>
            <th>Is Admin</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.salary}</td>
                <td>${employee.isAdmin ? 'Yes' : 'No'}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>