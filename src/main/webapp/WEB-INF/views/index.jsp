<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%@include file="header.jsp"%>
<div>Name:ChenZhihao</div>
<div>ID:2020211001001116</div>
<div>Date and Time: Sun Mar 5 16:54:24 CST 2022</div>


<h2>Welcome to My Online Shop Home Page</h2><br>
<form method="get" target="_blank" action="search">
    <input  type="text" name = "txt" size=30/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>

<%@include file="footer.jsp"%>