<%@ page import="Chenzhihao.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 12094
  Date: 2022/4/6
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp"%>
<h1> User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form action="updateUser" class="login-box" method="post">
    <!-- 注册界面内容块 -->
    <div class="login-content">

        <input type="hidden" name="id" value="<%=u.getId()%>">
        <!-- 昵称 -->
        <div class="login-text" id="name_error">
            <input id="names" name="names" type="text" placeholder="昵称" value="<%=u.getUsername()%>">
            <!-- 错误消息 -->
            <div class="error">该昵称已被使用</div>
        </div>
        <!-- 密码 -->
        <div class="login-text" id="pass_error">
            <input id="passwords"  name="passwords" onchange="password_errors();" type="password" placeholder="密码（至少8位，可填字母、数字、下划线）" value="<%=u.getPassword()%>">
            <div class="error" >密码格式不规范</div>
        </div>

        <!-- 重复密码 -->
        <div class="login-text" id="pass_error2">
            <input id="passwords2"  onchange="password_errors2();" type="password" placeholder="请确认密码">
            <div class="error" >两次密码不一致</div>
        </div>
        <!-- 地区及电话 -->
        <div class="login-text" id="phone_error">
            <div class="phone-areas clearfix">
                <div class="phonenum">
                    <input id="phonenum"  name="phonenum" onchange="phonenum_errors();" type="text" placeholder="填写常用手机号码" >
                </div>
            </div>
            <div class="error">请填写正确的手机号码</div>
        </div>
        <!-- 邮箱地址及验证 -->
        <div class="login-text" id="mail_error">
            <div class="mail-catch ">
                <div class="mail">
                    <input id="eMail" name="eMail" onchange="e_mail_errors();" type="text" placeholder="邮箱" value="<%=u.getEmail()%>">
                </div>
                <div class="pass">
                    <button>验证邮箱</button>
                </div>
            </div>
            <div class="error" >邮箱格式不正确</div>
        </div>
        <!-- 是否同意用户协议 -->
        <div class="xieyi">
            <label class="xycontent">
                <input class="kuang" type="checkbox">
                <span class="checkbox"></span>
                <!-- </input> -->
                我已同意
                <a href="" class="link">《xxxx用户使用协议》</a>
            </label>
        </div>
        <input type="submit" value="Register"/>
    </div>
    <div>
        <a href="config">
            点击跳转
        </a>
    </div>
</form>
<%@include file="footer.jsp"%>