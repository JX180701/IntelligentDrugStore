<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>登录</title>
<meta name="author" content="DeathGhost" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style1.css"/>


<style>
body{height:100%;background:#16a085;overflow:hidden;}
canvas{z-index:-1;position:absolute;}
</style>
</head>
<body>
<dl class="admin_login">
 <dt>
  <strong>智慧药房管理系统</strong>
  <em>Management System</em>
 </dt>
 <dd class="user_icon">
  <input id="username" name="username" type="text" placeholder="账号" class="login_txtbx" value="1"/>
 </dd>
 <dd class="pwd_icon">
  <input id="userpwd" name="userpwd" type="password" placeholder="密码" class="login_txtbx" value="1"/>
 </dd>
 <dd class="val_icon">
  <div class="checkcode">
    <input type="text" id="J_codetext" placeholder="验证码" maxlength="4" class="login_txtbx">
    <canvas class="J_codeimg" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
  </div>
  <input type="button" value="验证码核验" class="ver_btn" onClick="validate();">
 </dd>
 <dd>
  <input type="button" value="立即登陆" class="submit_btn"/>

 </dd>
 <dd>
 </dd>
</dl>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/verificationNumbers.js"></script>
<script src="${pageContext.request.contextPath}/js/Particleground.js"></script>
<script>
$(document).ready(function() {
  //粒子背景特效
  $('body').particleground({
    dotColor: '#5cbdaa',
    lineColor: '#5cbdaa'
  });
  //验证码
  createCode();
  //验证
  $(".submit_btn").click(function(){
	  if(validate()){
			loginForm();
		  }
	  });
});
function loginForm(){
	location.href="${pageContext.request.contextPath}/Login/Login.action?user_account="
		  +$("#username").val()+"&user_pwd="+$("#userpwd").val();
}
</script>


</html>


