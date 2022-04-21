package Chenzhihao.week5.demo;

import Chenzhihao.dao.UserDao;
import Chenzhihao.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
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

        dbConn = (Connection)getServletContext().getAttribute("com");
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
        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String username = req.getParameter("names");
        String password = req.getParameter("passwords");
//        System.out.println("66666666666666");
//        try {
//
//            Statement stmt = dbConn.createStatement();
//            String sql = "select id,username,password from usertable where username = '" + username +"'" + "and password = '" + password +"'" ;
//            ResultSet selected_table = stmt.executeQuery(sql);
//            if (selected_table.next()){
//
//                req.setAttribute("id", selected_table.getString("id"));
//                req.setAttribute("use", selected_table.getString("username"));
//                req.setAttribute("pas", selected_table.getString("password"));
//
//                req.getRequestDispatcher("userinfo.jsp").forward(req,resp);
//            } else{
//                req.setAttribute("message","Username or Password  Error!!!");
//                req.getRequestDispatcher("login.jsp").forward(req,resp);
//
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(dbConn,username,password);
            if (user != null){

                String rememberMe = req.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCookie = new Cookie("cPassword", user.getPassword());
                    Cookie rememberMeCookie = new Cookie("cRememberMe", user.getPassword());


                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    resp.addCookie(usernameCookie);
                    resp.addCookie(passwordCookie);
                    resp.addCookie(rememberMeCookie);
                }
//                Cookie c = new Cookie("sessionid",""+ user.getId());
//                c.setMaxAge(10*60);
//                resp.addCookie(c);
                HttpSession session = req.getSession();
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user",user);
                req.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(req,resp);
            }else{
                req.setAttribute("message","Username or Password  Error!!!");
                req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }




}
