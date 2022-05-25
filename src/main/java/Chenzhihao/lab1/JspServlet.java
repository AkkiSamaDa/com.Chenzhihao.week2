package Chenzhihao.lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JspServlet", value = "/JspServlet")
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String name = request.getParameter("name");
        String cla = request.getParameter("class");
        String id = request.getParameter("ID");
        out.println("<html><body>");
        out.println("<h1>" + "name: " + name + "</h1>");
        out.println("<h1>" + "class: " + cla + "</h1>");
        out.println("<h1>" + "ID: " + id + "</h1>");
        out.println("<h1>" + "ChenZhiHao 2020211001001116" + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
