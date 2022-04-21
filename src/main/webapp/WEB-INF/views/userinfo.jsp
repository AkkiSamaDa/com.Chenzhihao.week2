<%@ page import="Chenzhihao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 12094
  Date: 2022/4/6
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>

<h1>User Info</h1>
<%
    Cookie [] allCookies = request.getCookies();
    for(Cookie c : allCookies){
        out.println("<br/>" + c.getName() + " --- " + c.getValue());
    }
%>
<%
    User user = (User)request.getAttribute("user");
%>
<table>
<%--    <tr><td>Username: </td><td><%=request.getAttribute("use")%></td></tr>--%>
<%--    <tr><td>Password: </td><td><%=request.getAttribute("pas")%></td></tr>--%>
<%--    <tr><td>id: </td><td><%=request.getAttribute("id")%></td></tr>--%>



    <tr><td>Username: </td><td><%=user.getUsername()%></td></tr>
    <tr><td>Password: </td><td><%=user.getPassword()%></td></tr>
    <tr><td>id: </td><td><%=user.getId()%></td></tr>

</table>
<%@include file="footer.jsp"%>