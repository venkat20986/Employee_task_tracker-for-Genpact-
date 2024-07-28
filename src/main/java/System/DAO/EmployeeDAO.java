package System.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/EmployeeTimeTracker";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    public String getEmployeeIdByUsername(String username) {
        String employeeId = null;
        String query = "SELECT employee_id FROM Employees WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employeeId = rs.getString("employee_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeeId;
    }
}