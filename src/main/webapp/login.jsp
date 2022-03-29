<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
    <form action="login">
        <!-- 昵称 -->
        <div class="login-text" id="name_error">
            <input id="names" name="names" type="text" placeholder="ID">
        </div>
        <!-- 密码 -->
        <div class="login-text" id="pass_error">
            <input id="passwords"  name="passwords" onchange="password_errors();" type="password" >
        </div>
        <div>
            <input type="submit" value="login"/>
        </div>
    </form>

<%@include file="footer.jsp"%>