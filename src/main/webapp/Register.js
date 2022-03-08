var flag = true;
function add_class(areaid){
    document.getElementById('area1').classList.remove("selected");
    document.getElementById('area2').classList.remove("selected");
    document.getElementById('area3').classList.remove("selected");
    document.getElementById('area4').classList.remove("selected");
    document.getElementById('area5').classList.remove("selected");
    document.getElementById(areaid).classList.add("selected");
    var div = document.getElementById('choosed-area');
    var area = document.getElementById(areaid);
    div.innerHTML = area.innerHTML;
    click_v();
}
var flag_zhuce = false;
// 昵称错误识别
function name_errors(){
    let div = document.getElementById('names').value;
}
// 密码不合法识别
function password_errors(){
    let errorCase = document.getElementById('pass_error');
    let div = document.getElementById('passwords').value;
    console.log(div);
    // let x = div.length;
    // console.log(x);
    let re = /\w{8}$/;
    if(re.test(div)) errorCase.classList.remove("haserror");
    else errorCase.classList.add("haserror");
}
// 密码不统一识别
function password_errors2(){
    let errorCase = document.getElementById('pass_error2');
    let div = document.getElementById('passwords').value;
    let div2 = document.getElementById('passwords2').value;
    console.log(div);
    console.log(div2);
    // let x = div.length;
    // console.log(x);

    // 不显示错误
    if(div2 === div) errorCase.classList.remove("haserror");
    // 显示错误
    else errorCase.classList.add("haserror");
}
// 电话号码不合法识别
function phonenum_errors(){
    let errorCase = document.getElementById('phone_error');
    let div = document.getElementById('phonenum').value;
    console.log(div);
    let re = /^1\d{10}$/;
    if((re.test(div))) errorCase.classList.remove("haserror");
    else errorCase.classList.add("haserror");
}
// 邮箱不合法识别
function e_mail_errors(){
    let errorCase = document.getElementById('mail_error');
    let div = document.getElementById('eMail').value;
    console.log(div);
    let re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,5}$/;
    if((re.test(div))) errorCase.classList.remove("haserror");
    else errorCase.classList.add("haserror");
}
