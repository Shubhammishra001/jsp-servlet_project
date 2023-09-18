package cont;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class FinalAdminUpdate
 */
@WebServlet("/FinalAdminUpdate")
public class FinalAdminUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalAdminUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	        String name = request.getParameter("name");
	        String password = request.getParameter("password");
	        double salary = Double.parseDouble(request.getParameter("salary"));
	        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));

	        EmployeeService employeeService = EmployeeService.getInstance();
	        boolean updated = employeeService.updateEmployee(employeeId, name, password, salary, isAdmin);

	        if (updated) {
	            response.sendRedirect("welcomeadmin.jsp");
	        } else {
	            response.sendRedirect("error.jsp");
	        }
	    }
	}