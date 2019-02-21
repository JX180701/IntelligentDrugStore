<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uniform.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-style2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-media.css" />
<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册页面</title>
</head>

<body>
	<div id="content">
		<div id="content-header">
			<h1>用户管理</h1>
		</div>
		<div class="container-fluid">

			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-info-sign"></i>
							</span>
							<h5>添加用户</h5>
						</div>
						<div class="widget-content nopadding">
							<fieldset>
								<legend>用户的注册区域</legend>
								<form action="<%=path%>User/insertuser.action" method="post">
									<table border="1" bordercolor="#0099ff" cellpadding="10px"
										cellspacing="0" name="reg">
										<tr>
											<th colspan="3">注册页面</th>
										</tr>
										<tr>
											<td>用户名：</td>
											<td><input type="text" id="user_name" name="user_name"
												value="" /></td>
											<td><font color="#FF0000">*不能以数字、下划线开头</font></td>
										</tr>
										<tr>
											<td>密码：</td>
											<td><input type="password" id="user_pwd" name="user_pwd" />

											</td>
											<td><font color="#FF0000">*数字和字母的组合</font></td>
										</tr>
										<tr>
											<td>确认密码：</td>
											<td><input type="password" id="u_rpwd" name="r_upwd" />
											</td>
											<td><font color="#FF0000">*重新输入上面的密码</font></td>
										</tr>
										<tr>
											<td>角色：</td>
											<td><input type="text" id="role_id" name="role_id" /></td>

										</tr>
										<tr>
											<td>账号</td>
											<td><input type="text" id="user_account"
												name="user_account" /></td>
										</tr>
										<tr>
											<th colspan="3"><input type="submit"
												onclick="checkData();" name="submit" value="提交" /> <input
												type="reset" name="reset" value="重置" /> <input
												type="submit" name="test" value="验证" on
												onclick="checkData();" /></th>
										</tr>
									</table>
										<input type="hidden" name="user_state" value="启用" />
								</form>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script> 
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script> 
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.form_validation.js"></script>
</html>