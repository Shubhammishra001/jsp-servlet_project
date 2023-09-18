<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.Employee" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
</head>
<body>
<marquee direction="left" height="100" width="900" bgcolor="white">Innogent Technologies Private Limited</marquee>
<center>
    <h1>Update Employee Record</h1>
    <form action="UpdateEmployeeServlet" method="post">
        <% 
            HttpSession session1 = request.getSession();
            Employee user = (Employee) session1.getAttribute("user");
        %>
        <input type="hidden" name="employeeId" value="<%= user.getEmployeeId() %>">
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="<%= user.getName() %>">
        <br>
        <label for="password">Password:</label>
        <input type="password" name="password" id="password" value="<%= user.getPassword() %>">
        <br>
        <label for="salary">Salary:</label>
        <input type="text" name="salary" id="salary" value="<%= user.getSalary() %>">
        <br>
        <button type="submit">Update</button>
    </form>
</center>
</body>
</html>
