<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>

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
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>用户列表</h5>
          </div>
          <div class="widget-content nopadding">
          
            <table class="table table-bordered data-table">
              <thead>
               	<tr>
					<th>用户名</th>
					<th>账号</th>
					<th>密码</th>
					<th>角色</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
              </thead>
              <tbody>
                <c:forEach var="c" items="${userlist}">
						<tr class="gradeX">
							<td align="center">${c.user_name }</td>
							<td align="center">${c.user_account }</td>
							<td align="center">${c.user_pwd }</td>
							<td align="center">${c.role.role_name }</td>
							<td align="center">${c.user_state }</td>
							<td style="vertical-align: middle; text-align: center; width:400px;">
								
								<button id="deleterole"
									onclick="javascript:window.location.href='<%=path %>/User/deleteuser.action?uid=${c.user_id}'"
									class="btn btn-info">删除用户</button>
								<button id="updaterole"
									onclick="javascript:window.location.href='<%=path %>/User/finduserinfo.action?uid=${c.user_id}'"
									class="btn btn-success">修改用户信息</button>
							</td>
						</tr>
					</c:forEach>
              </tbody>
            </table>
	            <div class="form-actions">
	            	<button id="addrole" onclick="adduser()" class="btn btn-success" style="margin-top:4px;margin-right:5px"><i class="icon-plus-sign">&nbsp;增加用户</i></button>
                </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>

<script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script> 
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script> 
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.tables.js"></script>
<script type="text/javascript">
		function adduser() {
			window.location.href ="<%=path%>/jsp/AddUser.jsp"
		}
	</script>
</html>