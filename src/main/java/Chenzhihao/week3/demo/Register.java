package Chenzhihao.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Objects;

public class Register extends HttpServlet{
    Connection dbConn = null;
    static int id = 10015;




    @Override
    public void init() throws ServletException {
        super.init();
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String password = getServletContext().getInitParameter("password");
        String username = getServletContext().getInitParameter("username");

        try {
            Class.forName(driver);
            dbConn = DriverManager.getConnection(url,username,password);
            System.out.println("successfull!!!");
        }

        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            System.out.println("false!!!");
        }
    }






        @Override

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html");
            String username = req.getParameter("names");
            String password = req.getParameter("passwords");
            String Pname = req.getParameter("phonenum");
            String email = req.getParameter("eMail");


            try {

                PreparedStatement stmt = Objects.requireNonNull(dbConn.prepareStatement("insert into usertable values(?,?,?,?,?,?)"));

                stmt.setString(2,username);
                stmt.setString(3,password);
                stmt.setString(4,email);
                stmt.setString(1, String.valueOf(id++));
                stmt.setString(5,null);
                stmt.setString(6,null);
                stmt.executeUpdate();
                System.out.println("nsdawsdwasdwada");
                resp.sendRedirect("WEB-INF/views/login.jsp");

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


