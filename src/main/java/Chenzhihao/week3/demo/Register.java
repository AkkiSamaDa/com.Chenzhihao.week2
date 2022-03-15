package Chenzhihao.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Register extends HttpServlet{
        @Override

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("names");
        String password = req.getParameter("passwords");
        String Pname = req.getParameter("phonenum");
        String email = req.getParameter("eMail");
        PrintWriter writer = resp.getWriter();
        writer.println("<br> username: " + username);
        writer.println("<br> passwords: " + password);
        writer.println("<br> email: " + email);
        writer.println("<br> Phonenum: " + Pname);
        writer.close();
    }




        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
