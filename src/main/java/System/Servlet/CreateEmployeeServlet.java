package System.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import System.DAO.CreateEmployeeDAO;
import System.model.Employee;

@WebServlet("/CreateEmployeeServlet")
public class CreateEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CreateEmployeeDAO createEmployeeDAO;

    public CreateEmployeeServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        createEmployeeDAO = new CreateEmployeeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employee_id = request.getParameter("employee_id");
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");
        String dateOfJoining = request.getParameter("dateOfJoining");
        String managerAlloted = request.getParameter("managerAlloted");
        String password = request.getParameter("password");

        // Basic null checks
        if (employee_id == null || username == null || fullname == null || role == null ||
            email == null || phoneNumber == null || dob == null || address == null ||
            dateOfJoining == null || managerAlloted == null || password == null) {
            request.setAttribute("errorMessage", "All fields are required.");
            request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
            return;
        }

        Employee employee = new Employee();
        employee.setEmployeeId(employee_id);
        employee.setUsername(username);
        employee.setFullname(fullname);
        employee.setRole(role);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        employee.setDob(dob);
        employee.setAddress(address);
        employee.setDateOfJoining(dateOfJoining);
        employee.setManagerAlloted(managerAlloted);
        employee.setPassword(password);

        try {
            boolean result = createEmployeeDAO.insertEmployee(employee);
            if (result) {
                response.sendRedirect("registraion-success.jsp");
            } else {
                request.setAttribute("errorMessage", "Failed to create employee. Please try again.");
                request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database error. Please try again.");
            request.getRequestDispatcher("createEmployee.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("createEmployee.jsp");
    }
}