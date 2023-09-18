<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entity.Employee" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Employee Page</title>
</head>
<body>
<marquee direction="left" height="100" width="900" bgcolor="white">Innogent Technologies Private Limited</marquee>
<center>
<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout">
</form>
    <% 
    response.setHeader("Cache-Control","no-cache,no-store,must-ravalidate");
    if(session.getAttribute("adminUsername")==null)
        response.sendRedirect("index.jsp");
     %>
   
    <h1>Welcome Employee Page</h1>
    <% 
        // Retrieve user attributes from the session
        HttpSession session1 = request.getSession();
        String name = (String) session1.getAttribute("normalUsername");
        Employee user = (Employee) session1.getAttribute("user"); // Assuming you have a user object in the session
          
        // Check if the user is logged in
       
    %>
    <h3> employee name  is  :<%= name  %></h3>
      
      
      <h3> Id is  :<%= user.getEmployeeId()  %></h3>
      <h3> name  is  :<%= user.getName()  %></h3>
      <h3> password is  :<%= user.getPassword()  %></h3>
      <h3> salery  is  :<%= user.getSalary()  %></h3>
       %>
        <tr>
       
            <td>
                <form action="UpdateEmployeeForm.jsp" method="post" style="display: inline;">
    <input type="hidden" name="employeeId" value="<%= user.getEmployeeId() %>">
                    <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
      </tbody>
</table>
        </center>
</body>
</html>
