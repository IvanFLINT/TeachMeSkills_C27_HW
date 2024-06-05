package servlet;

import connectDB.DriverDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/change-login")
public class ChangeLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/changeLoginUser.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String newLogin = req.getParameter("login");

        try (Connection connection = DriverDB.initializeDatabase()) {
            String query = "UPDATE users SET login=? WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newLogin);
            statement.setInt(2, Integer.parseInt(id));
            int result = statement.executeUpdate();

            if (result > 0) {
                req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/operationError.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
