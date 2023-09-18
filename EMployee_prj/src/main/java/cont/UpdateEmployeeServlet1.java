package cont;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;
import service.EmployeeService;

/**
 * Servlet implementation class UpdateEmployeeServlet1
 */
@WebServlet("/UpdateEmployeeServlet1")
public class UpdateEmployeeServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		doGet(request, response);
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