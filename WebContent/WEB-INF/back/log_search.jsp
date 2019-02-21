<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path=request.getScheme()+"://"+request.getServerName()+":"
	+request.getServerPort()+request.getContextPath()+"/";
%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>日志查看</title>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" />


<style>

.DataInput {
	margin-top: 8px;
	width: 120px;
}
</style>
<%-- 	location.href="<%=path%>purchase/findPurchase.action"; --%>
</head>
<body>

	<div id="content">
	<div id="content-header">
      <h1>日志管理</h1>
  </div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<h5>日志查看</h5>
						</div>
						<div class="widget-content nopadding">

						<form action="<%=path%>log/findByDate.action" method="post">
							<div>
								<span>时间</span> 
								<input class="DataInput" type="date" id="date1" name="date1" style="width: 150px;"> 
								<span>至</span>
								<input class="DataInput" type="date" id="date2" name="date2" style="width: 150px;">
								<button type="submit" class="btn" id="search">
								<i class="icon-search">查询</i>
								</button>
							</div>
						</form>
							<table
								class="table table-bordered data-table table-striped with-check">
								<thead>
									<tr>
										<th>序号</th>
										<th>操作人</th>
										<th>操作事项</th>
										<th>操作时间</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${logList}" var="log" varStatus="st">
										<tr class="gradeA" id="${log.log_id}">
											<td>${st.count}</td>
											<td>${log.user.user_name}</td>
											<td>${log.log_thing}</td>
											<td>${log.log_date}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/matrix.js"></script>
<script src="${pageContext.request.contextPath}/js/matrix.tables.js"></script>

<script type="text/javascript">
</script>
</html>