<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Matrix Admin</title>
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
            <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
              <h5>用户编辑</h5>
            </div>
            <div class="widget-content nopadding">
            <br/><br/>
              <form class="form-horizontal" action="<%=path%>User/updateuser.action" method="post" >
                <div class="control-group">
                    <input name="user_id" id="user_id" type="hidden" style="margin-top:5px" value="${user.user_id}">
                  <label class="control-label">姓名:</label>
                  <div class="controls">
                    <input name="user_name" id="user_name" style="margin-top:5px" value="${user.user_name}">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">密码:</label>
                  <div class="controls">
                    <input name="user_pwd" id="user_pwd" style="margin-top:5px" value="${user.user_pwd}">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">账号:</label>
                  <div class="controls">
                    <input name="user_account" id="user_account" style="margin-top:5px" value="${user.user_account}">
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">角色:</label>
                  <div class="controls">
                    <select class="DataInput" name="role_id" id="role_id" style="margin-top:5px;width:210px">
		          			<option value=1 >管理员</option>
							<option value=2 >药房</option>
							<option value=3 >药库</option>
        			</select>
                  </div>
                </div>
<!--                 <div class="control-group"> -->
<!--                   <label class="control-label">状态:</label> -->
<!--                   <div class="controls" style="margin-top:5px"> -->
<!--                     <input name="user_state" type="radio" value="启用" />启用  -->
<!--                     <input name="user_state" type="radio" value="禁用" />禁用 -->
<!--                   </div> -->
<!--                 </div> -->
                <div class="form-actions" style="text-align: center; width:550px;">
              	<input type="submit"  value="保存" class="btn btn-success">
               &nbsp;&nbsp;&nbsp;&nbsp;  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" onclick="javascript:history.back(-1);" value="返回" class="btn btn-success">
                </div>
              </form>
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
<script>

</script>
</html>