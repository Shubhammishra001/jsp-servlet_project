<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="entity.Employee" %>
<%@ page import="service.EmployeeService" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Admin Page</title>
</head>
<body>
<center>
    <form action="LogoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>
    <h1>Welcome Admin Page</h1>
    <% 
        response.setHeader("Cache-Control","no-cache,no-store,must-ravalidate");
        if(session.getAttribute("adminUsername")==null)
            response.sendRedirect("index.jsp");
    %>
    <% 
        String name = (String)session.getAttribute("adminUsername");
    %>
    <h3> USER is  :<%= name %></h3>

    <button id="showAddForm">Add Employee</button>
    <div id="AddEmp">
        <h2>Add New  Employee</h2>
        <form action="AddEmp" method="post">
            <label>Name: <input type="text" name="name"></label><br>
            <label>Password: <input type="password" name="password"></label><br>
            <label>Salary: <input type="text" name="salary"></label><br>
            <label>Admin: <input type="checkbox" name="isAdmin" value="true"></label><br>
            <input type="submit" value="Add Employee">
        </form>
    </div>
    <!-- Employee List -->
    <h2>Employee List</h2>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Salary</th>
                <th>Admin</th>
                <th>Actions</th> <!-- New column for buttons -->
            </tr>
        </thead>
        <tbody>
            <%
                // Get the user's role from the session
                HttpSession session1 = request.getSession();
                boolean isAdmin = (Boolean) session1.getAttribute("isAdmin");

                // Only display the employee list to admins
                if (isAdmin) {
                    EmployeeService employeeService = EmployeeService.getInstance();
                    List<Employee> employeeList = employeeService.getAllEmployees();
                    for (Employee employee : employeeList) {
            %>
            <tr>
                <td><%= employee.getEmployeeId() %></td>
                <td><%= employee.getName() %></td>
                <td><%= employee.getPassword() %></td>
                <td><%= employee.getSalary() %></td>
                <td><%= employee.isAdmin() %></td>
                <td>
                    <form action="DeleteEmployeeServlet" method="post" style="display: inline;">
                        <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                        <button type="submit">Delete</button>
                    </form>
                    <button type="button" onclick="toggleUpdateForm('<%= employee.getEmployeeId() %>')" <%= employee.isAdmin() ? "disabled" : "" %>>Update</button>
                </td>
            </tr>
            <div id="UpdateEmp_<%= employee.getEmployeeId() %>" style="display: none;">
                <h2>Update Employee</h2>
                <form action="UpdateEmployeeServlet1" method="post">
                    <input type="hidden" name="employeeId" value="<%= employee.getEmployeeId() %>">
                    <label>Name: <input type="text" name="name" value="<%= employee.getName() %>"></label><br>
                    <label>Password: <input type="password" name="password" value="<%= employee.getPassword() %>"></label><br>
                    <label>Salary: <input type="text" name="salary" value="<%= employee.getSalary() %>"></label><br>
                    <label>Admin: <input type="checkbox" name="isAdmin" <%= employee.isAdmin() ? "checked" : "" %> <%= employee.isAdmin() ? "readonly" : "" %>></label><br>
                    <input type="submit" value="Update Employee">
                </form>
            </div>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="6">You do not have permission to view this page.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</center>
<script>
    // JavaScript function to toggle the display of update forms
    function toggleUpdateForm(employeeId) {
        var formId = "UpdateEmp_" + employeeId;
        var formElement = document.getElementById(formId);
        if (formElement.style.display === "none") {
            formElement.style.display = "block";
        } else {
            formElement.style.display = "none";
        }
    }
</script>
</body>
</html>
