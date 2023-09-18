package cont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditEmployeeServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int employeeId = Integer.parseInt(request.getParameter("employeeId"));
            EmployeeService employeeService = EmployeeService.getInstance();
            Employee employee = employeeService.getEmployeeById(employeeId);
              System.out.print("edit   page********");
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("updateemp.jsp").forward(request, response);
        } catch (Exception e) {
        }
    }
}
