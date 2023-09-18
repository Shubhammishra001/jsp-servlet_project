package cont;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;
//update for emp
@WebServlet("/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateEmployeeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	System.out.print(" /UpdateEmployeeServlet update ");
    	   int employeeId = Integer.parseInt(request.getParameter("employeeId"));
           String name = request.getParameter("name");
           String password = request.getParameter("password");
           double salary = 0.0; // Default value or an appropriate value if salary is not provided

           String salaryParam = request.getParameter("salary");
           if (salaryParam != null && !salaryParam.trim().isEmpty()) {
               try {
                   salary = Double.parseDouble(salaryParam);
               } catch (NumberFormatException e) {
               }
           }

           EmployeeService employeeService = EmployeeService.getInstance();
           Employee employee = employeeService.getEmployeeById(employeeId);

           if (employee != null) {
               employee.setName(name);
               employee.setPassword(password);
               employee.setSalary(salary);
               employeeService.updateEmployee(employee);
               response.sendRedirect("welcomeemp.jsp");
           } else {
               response.getWriter().println("Employee not found.");
           }
       }
   }
