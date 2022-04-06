package Chenzhihao.week5.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Objects;

public class login extends HttpServlet {
    Connection dbConn = null;
//

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
            System.out.println("successful!!!");

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




        System.out.println("66666666666666");
        try {

            Statement stmt = dbConn.createStatement();
            String sql = "select id,username,password from usertable where username = '" + username +"'" + "and password = '" + password +"'" ;
            ResultSet selected_table = stmt.executeQuery(sql);
            if (selected_table.next()){

                req.setAttribute("id", selected_table.getString("id"));
                req.setAttribute("use", selected_table.getString("username"));
                req.setAttribute("pas", selected_table.getString("password"));

                req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
                } else{
                req.setAttribute("message","Username or Password  Error!!!");
                req.getRequestDispatcher("login.jsp").forward(req,resp);

            }
            } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }




}
