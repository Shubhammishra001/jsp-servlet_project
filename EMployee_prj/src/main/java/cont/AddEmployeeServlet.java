package cont;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;
import service.EmployeeService;

@WebServlet("/AddEmp")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddEmployeeServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    int id = 5;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int t=5;
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        double salary = Double.parseDouble(request.getParameter("salary"));
        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));
          System.out.print("\n admin->"+isAdmin);
        HttpSession hs = request.getSession();
        List<Employee> employeeList = (List<Employee>) hs.getAttribute("employeeList");

        // Check if employeeList is null and initialize it
        if (employeeList == null) {
            employeeList = new ArrayList<>();
            hs.setAttribute("employeeList", employeeList);
        }

        Employee employee = new Employee(id++, name, password, salary, isAdmin);

        hs.setAttribute("employeeId", employee.getEmployeeId());
        hs.setAttribute("employeeName", employee.getName());
        hs.setAttribute("employeeSalary", employee.getSalary());
        hs.setAttribute("employeeIsAdmin", employee.isAdmin());

        employeeList.add(employee);

        EmployeeService employeeService = EmployeeService.getInstance();
        employeeService.addEmployee(employee);

        response.sendRedirect("welcomeadmin.jsp");
    }
}
