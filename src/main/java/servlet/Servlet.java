package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request")
public class Servlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/save-request.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (name == null || name.isEmpty() ||
            email == null || email.isEmpty() ||
            password == null || password.isEmpty()) {
            resp.sendRedirect("/request");
        } else {
            req.setAttribute("name", name);
            req.setAttribute("email",email);
            req.setAttribute("password",password);
            req.getRequestDispatcher("/WEB-INF/result-application.jsp").forward(req,resp);
        }
    }
}
