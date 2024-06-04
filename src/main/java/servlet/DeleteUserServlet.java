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

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/deleteUser.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        try (Connection connection = DriverDB.initializeDatabase()) {
            String query = "DELETE FROM users WHERE id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(id));
            int result = statement.executeUpdate();

            if (result > 0) {
                req.getRequestDispatcher("/WEB-INF/result.jsp").forward(req, resp);
            } else {
                resp.getWriter().println("<h4>Error deleting user</h4>");
                resp.setContentType("text/html");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
