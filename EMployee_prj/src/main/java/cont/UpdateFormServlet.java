package cont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Employee;
import service.EmployeeService;

@WebServlet("/UpdateFormServlet")
public class UpdateFormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateFormServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	int employeeId = Integer.parseInt(request.getParameter("employeeId"));
         System.out.println(" test = "+employeeId);
    	EmployeeService employeeService = EmployeeService.getInstance();
    	Employee employee = employeeService.getEmployeeById(employeeId);
System.out.println(" emplyee=  "+employee.isAdmin());
    	request.setAttribute("employee", employee);
    	request.getRequestDispatcher("updateformpage.jsp").forward(request, response);    
    
    
    
    }
}
