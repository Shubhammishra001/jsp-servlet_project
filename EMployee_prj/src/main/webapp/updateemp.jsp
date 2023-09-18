<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.Employee" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body><center>

<marquee direction="left" height="100" width="900" bgcolor="white">Innogent Technologies Private Limited</marquee>

    <% 
    response.setHeader("Cache-Control","no-cache,no-store,must-ravalidate");
    if(session.getAttribute("adminUsername")==null)
        response.sendRedirect("index.jsp");
     %>
   
    <h1>Edit Employee</h1>
    
    <%
        // Retrieve user attributes from the session
        HttpSession session1 = request.getSession();
        String username = (String) session1.getAttribute("normalUsername");
        Employee user = (Employee) session1.getAttribute("user"); // Assuming you have a user object in the session

        // Check if the user is logged in
        if (username != null && user != null) {
    %>
    <h3>Logged in as: <%= username %></h3>
    
    <!-- Display the edit form with pre-populated fields -->
    <form action="UpdateEmployeeServlet" method="post">
        <input type="hidden" name="employeeId" value="<%= request.getParameter("employeeId") %>">
        
        <label>ID : <input type="text" name="id" value="<%= user.getEmployeeId()%>"></label><br>
        
        <label>Name: <input type="text" name="name" value="<%= user.getName() %>"></label><br>
        <label>Password: <input type="password" name="password" value="<%= user.getPassword() %>"></label><br>
        <label>Salary: <input type="text" name="salary" value="<%= user.getSalary() %>"></label><br>
        <label>Admin: <input type="checkbox" name="isAdmin" <% if (user.isAdmin()) out.print("checked"); %>></label><br>
        <input type="submit" value="Update">
    </form>
    
    <!-- Add a cancel or back button to return to welcomeemp.jsp -->
    
    <% 
        } else {
            // If the user is not logged in, you can redirect them to the login page or handle it as needed.
            response.sendRedirect("login.jsp"); // Replace with your login page's URL
        }
    %>
</center></body>
</html>
