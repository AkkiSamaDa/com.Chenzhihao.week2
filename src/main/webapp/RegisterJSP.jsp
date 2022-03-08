<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <title>Register -- by ChenZhihao</title>
    <style>
        .login-text .error{
            display: none;
        }
        .login-text.haserror .error{
            display: block;
        }
    </style>
</head>
<body>
    <form action="" class="login-box">
        <!-- 注册界面内容块 -->
        <div class="login-content">
            <!-- 昵称 -->
            <div class="login-text" id="name_error">
                <input id="names" type="text" placeholder="昵称">
                <!-- 错误消息 -->
                <div class="error">该昵称已被使用</div>
            </div>
            <!-- 密码 -->
            <div class="login-text" id="pass_error">
                <input id="passwords"  onchange="password_errors();" type="password" placeholder="密码（至少8位，可填字母、数字、下划线）">
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
                        <input id="phonenum"  onchange="phonenum_errors();"type="text" placeholder="填写常用手机号码">
                    </div>
                </div>
                <div class="error">请填写正确的手机号码</div>
            </div>
            <!-- 邮箱地址及验证 -->
            <div class="login-text" id="mail_error">
                <div class="mail-catch ">
                    <div class="mail">
                        <input id="eMail" onchange="e_mail_errors();" type="text" placeholder="邮箱">
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
            <!-- 注册按钮 -->
            <div>
                <button  class="login-buttom" id="register" type = "button" onclick="window.location.href = ''">
                    注册
                </button>
            </div>
        </div>
    </form>
</body>
<script type="text/javascript" src="Register.js"></script>
</html>
