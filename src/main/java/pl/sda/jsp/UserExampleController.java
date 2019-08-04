package pl.sda.jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserExampleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getSession().setAttribute("userLoginSessionName", "initialLogin");
        req.getSession().setAttribute("userPasswordSessionName", "initialPassword");

        getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || login.isEmpty()) {
            login = "initialName";
        }

        if (password == null || password.isEmpty()) {
            password = "initialPassword";
        }

        req.getSession().setAttribute("userLoginSessionName", login);
        req.getSession().setAttribute("userPasswordSessionName", password);

        getServletContext().getRequestDispatcher("/user.jsp").forward(req, resp);
    }
}
