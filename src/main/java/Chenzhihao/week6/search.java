package Chenzhihao.week6;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String txt = req.getParameter("txt");
        String search = req.getParameter("search");
        if(txt.length() == 0){
            resp.sendRedirect("index.jsp");
            System.out.println("Sdawd");
        }else{
            if (Objects.equals(search, "baidu")){
                resp.sendRedirect("http://www.baidu.com/s?wd=" + txt );
            }else if (Objects.equals(search, "bing")){
                resp.sendRedirect("http://cn.bing.com/search?q=" + txt);
            }else if (Objects.equals(search, "google")){
                resp.sendRedirect("http://www.google.com/search?q=" + txt);
            }
        }

    }
}
