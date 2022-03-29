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
//                System.out.println(username + password);
                stmt.setString(2,username);
                stmt.setString(3,password);
                stmt.setString(4,email);
                stmt.setString(1, String.valueOf(id++));
                stmt.setString(5,null);
                stmt.setString(6,null);
                stmt.executeUpdate();
                System.out.println("nsdawsdwasdwada");

                Statement stmt2 = dbConn.createStatement();
                ResultSet selected_table = stmt2.executeQuery("select * from usertable");
                PrintWriter writer = resp.getWriter();

                writer.println("<table border = "+"1"+">");
                writer.println("<tr>");
                writer.println("<td>username</td>"
                        + "<td>password</td>"
                        + "<td>email</td>"
                        + "<td>gender</td>"
                        + "<td>Birthdate</td>");
                writer.println("</tr>");
                while(selected_table.next()){
                    String use = selected_table.getString("username");
                    String pas = selected_table.getString("password");
                    String ema = selected_table.getString("email");
                    String gen = selected_table.getString("gender");
                    String bir = selected_table.getString("Birthdate");
                    writer.println("<tr>");
                    writer.println("<td>" + use + "</td>"
                            + "<td>" + pas + "</td>"
                            + "<td>" + ema + "</td>"
                            + "<td>" + gen + "</td>"
                            + "<td>" + bir + "</td>");
                    writer.println("</tr>");
                }
                writer.println("</table>");
                writer.close();
//                writer.println("<br> username: " + username);
//                writer.println("<br> passwords: " + password);
//                writer.println("<br> email: " + email);
//                writer.println("<br> Phonenum: " + Pname);
                writer.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }


        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}


