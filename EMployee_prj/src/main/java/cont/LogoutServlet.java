package cont;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            if (session.getAttribute("adminUsername") != null) {
                session.removeAttribute("adminUsername");
            } else if (session.getAttribute("normalUsername") != null) {
                session.removeAttribute("normalUsername");
            }
            session.invalidate();
        
           
        }
        
        
        

        // Redirect to the login page or any other appropriate page
        response.sendRedirect("index.jsp"); // Change this to your login page's URL
    }
}