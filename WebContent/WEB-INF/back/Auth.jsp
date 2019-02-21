<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/uniform.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/select2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/matrix-style2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/matrix-media.css" />
<link
	href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800'
	rel='stylesheet' type='text/css'>



<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=path%>/Role/specificfind.action" method="post">
  <p>&nbsp;</p>
  <p>查询条件：</p>
  <p>角色姓名：
    <input type="text"style="width:140px; height:30px;" name="role_name" id="role_name" /> 

 
 
  <p>角色ID：
    <input type="text"style="width:140px; height:30px;" name="role_id" id="role_id" />
     <input type="submit" value="搜索">
  </p>
</form>







	<div class="widget-box">
		<div class="widget-title">
			<span class="icon"><i class="icon-th"></i></span>
			<h5>Data table</h5>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered data-table">
				<thead>
					<tr>
						<th>权限ID</th>
						<th>权限名</th>
						<th>操作</th>
						

						<!-- <th>Platform(s)</th>
                  <th>Engine version</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${rolelist}">
						<tr class="gradeX">
							<td>${c.role_id }</td>
							<td>${c.role_name }</td>
							<td style="vertical-align: middle; text-align: center;">
							
								
								<button id="deleterole"  onclick="javascript:window.location.href='<%=path %>/Auth/findroleauth.action?rid=${c.role_id}'"  class="btn btn-info">给角色授权</button>
								
							</td>
						</tr>


					</c:forEach>
			</table>
		</div>
	</div>
	<script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery.ui.custom.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.uniform.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/select2.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/matrix.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/matrix.tables.js"></script>


	<script type="text/javascript">
		function addrole() {
			window.location.href ="<%=path %>/jsp/AddRole.jsp" 
		}
	</script>
	
 




</body>
</html>