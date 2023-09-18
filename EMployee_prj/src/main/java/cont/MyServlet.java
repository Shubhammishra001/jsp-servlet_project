package cont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Employee;
import service.EmployeeService;
@WebServlet("/My")
public class MyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	  try {
              String inputName = request.getParameter("name");
              String inputPassword = request.getParameter("password");

              EmployeeService userService = EmployeeService.getInstance();

              boolean isUserValid = userService.isValidUser1(inputName, inputPassword);

              if (isUserValid) {
                  HttpSession session = request.getSession(true); // Get or create the session
                  session.setAttribute("adminUsername", inputName);

                  Employee user = userService.getUserByName(inputName);
                  session.setAttribute("user", user);
                  boolean isAdmin = userService.isAdmin(inputName);
                  session.setAttribute("isAdmin", isAdmin);

                  if (isAdmin) {
                                          response.sendRedirect("welcomeadmin.jsp");
                  } else {
                                       response.sendRedirect("welcomeemp.jsp");
                  }
              } else {
                  request.setAttribute("errorMessage", "Invalid credentials. Please try again.");
                  request.getRequestDispatcher("error.jsp").forward(request, response);
              }
          } catch (Exception e) {
              e.printStackTrace();
              response.sendRedirect("error.jsp");
          }
      }
  }