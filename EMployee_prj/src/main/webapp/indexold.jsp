<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
    <%@ page import="entity.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> welcome admin page </h1>


<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Value</th>
        </tr>
    </thead>
    <tbody>
    
    <%
    List<Employee> itemList = (List<Employee>) request.getAttribute("employeeList");
      if (itemList != null) {
            for (Employee item : itemList) {
    %>
    <li><%= item %></li>
    <% }}
    %>
    
    
    
    
    
    
       </tbody>
</table>


 <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>passwaord</th>
                
                <th>Salary</th>
                <th>user type is admin</th>
                <!-- Add more table headers as needed -->
            </tr>
        </thead>
        <tbody>
            <%
            List<Employee> itemList1 = (List<Employee>) request.getAttribute("employeeList");   
            if (itemList1 != null) {
                    for (Employee item : itemList) {
            %>
            <tr>
                <td><%= item.getEmployeeId() %></td>
                <td><%= item.getName() %></td>
                <td><%= item.getPassword() %></td>
                <td><%= item.getSalary() %></td>
                <td><%= item.isAdmin() %></td>
                
                <!-- Add more table cells as needed -->
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>




</body>
</html>