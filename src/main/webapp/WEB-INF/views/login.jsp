<%@ page import="java.util.SplittableRandom" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<%

    if  (request.getRequestDispatcher("massage") != null){
        out.println("<h3>" + request.getAttribute("message") + "</h3>");
    }

%>

<%
    Cookie[] allCookies = request.getCookies();
    String username = "", password = "", rememberMeVale = "";
    if(allCookies!=null){
        for (Cookie c : allCookies){
            if (c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")){
                password = c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                rememberMeVale = c.getValue();
            }
        }
    }
%>


    <form action="login">
        <!-- 昵称 -->
        <div class="login-text" id="name_error">
            <input id="names" name="names" type="text" placeholder="ID" value="<%=username%>">
        </div>
        <!-- 密码 -->
        <div class="login-text" id="pass_error">
            <input id="passwords"  name="passwords"  onchange="password_errors() ;" type="password" value="<%=password%>">
        </div>
        <div>
            <input type="submit" value="login"/>
        </div>

        <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1") ?"checked":""%>/>RememberMe<br/>

    </form>

<%@include file="footer.jsp"%>
//