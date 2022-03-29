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

        System.out.println("66666666666666666666666");
        try {

            Statement stmt = dbConn.createStatement();

            ResultSet selected_table = stmt.executeQuery("select id,username,password from usertable");
            boolean flag = false;
            PrintWriter writer = resp.getWriter();
            while(selected_table.next()){
                String id = selected_table.getString("id");
                String use = selected_table.getString("username");
                String pas = selected_table.getString("password");

                if(Objects.equals(username, use) && Objects.equals(pas, password)){

                    writer.println("Login Successful! <br>");
                    writer.println("Welcome!   " + username );
                    flag = true;
                    break;
                }
            }
            if(!flag){
                writer.println("Login fail!");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }




}
