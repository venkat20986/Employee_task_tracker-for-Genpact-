package System.Servlet;

import System.DAO.AssignProjectDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/AssignProjectServlet")
public class AssignProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AssignProjectServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Extract parameters from the request
        int projectId = Integer.parseInt(request.getParameter("projectId"));
        String projectName = request.getParameter("projectName");
        String employeeId = request.getParameter("employeeId");
        String description = request.getParameter("description");
        Date deadline = Date.valueOf(request.getParameter("deadline")); // Ensure the format is yyyy-mm-dd

        // Create DAO object and assign project
        AssignProjectDAO dao = new AssignProjectDAO();
        boolean success = dao.assignProject(projectId, projectName, employeeId, description, deadline);

        // Redirect based on success or failure
        if (success) {
            response.sendRedirect("assignProjectSuccess.jsp");
        } else {
            response.sendRedirect("assignProjectFailure.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to the form page
        response.sendRedirect("assignProject.jsp");
    }
}