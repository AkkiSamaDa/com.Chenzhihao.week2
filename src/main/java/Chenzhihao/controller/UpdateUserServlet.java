package Chenzhihao.controller;

import Chenzhihao.dao.UserDao;
import Chenzhihao.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User usr = null;
        usr = new User();
        usr.setUsername(request.getParameter("username"));
        usr.setPassword(request.getParameter("password"));
        usr.setEmail(request.getParameter("email"));
        UserDao userDao = new UserDao();
        Connection con = (Connection) getServletContext().getAttribute("con");
        try {
            userDao.updateUser(con, usr);
            request.setAttribute("update","update");
            request.setAttribute("user", usr);
            request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
