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
import java.sql.ResultSet;

@WebServlet("/get")
public class GetUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            getServletContext().getRequestDispatcher("/WEB-INF/getUser.jsp").forward(req, resp);
            return;
        }
        try (Connection connection = DriverDB.initializeDatabase()) {
            String query = "SELECT * FROM users WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                req.setAttribute("id", resultSet.getInt("id"));
                req.setAttribute("login", resultSet.getString("login"));
                req.setAttribute("password", resultSet.getString("password"));
                req.getRequestDispatcher("/WEB-INF/resultDB.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/operationError.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}