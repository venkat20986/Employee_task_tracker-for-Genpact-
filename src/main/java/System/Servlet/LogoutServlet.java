package System.Servlet;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Fetch the existing session (if any)
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        
        // Redirect to the login page or any other appropriate page after logout
        response.sendRedirect("Login.jsp"); // Replace "login.jsp" with your actual login page
        
        // Alternatively, you can also forward to a logout confirmation page
        // request.getRequestDispatcher("logoutConfirmation.jsp").forward(request, response);
    }
}
