<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>药品</title>
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
#DataTables_Table_0_filter {
	display: none;
}

.DataInput {
	margin-top: 8px;
	width: 120px;
}

#operationArea {
	float: right;
}
</style>
</head>
<body>

	<div id="content">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<h5>分类设置</h5>
						</div>
						<div class="widget-content nopadding">

							<!-- 查询条件 -->
							<div>
								<form action="<%=path%>type/searchConditionType.action"
									method="post">
									<!-- 								<input type="text" name="type_name" id="type_name"> -->
									<select name="type_pid" style="width: 100px;">
										<c:forEach items="${typelist}" var="type" varStatus="st">
											<c:if test="${type.type_pid == 0}">
												<option value="${type.type_id}">${type.type_name}</option>
											</c:if>
										</c:forEach>
									</select>

									<button type="submit" class="btn">
										<i class="icon-search">查询</i>
									</button>
										<a style="float:right;margin-right:20px;"><i class="icon-download-alt">导出数据到Excel</i></a>
								</form>
							</div>
							<div id="operationArea">
								<a href="<%=path%>type/toPage.action?page=type_addType"><button
										type="button" class="btn"><i class="icon-plus">添加分类</i></button></a>
							</div>
							<table
								class="table table-bordered data-table table-striped with-check">
								<thead>
									<tr>
										<th>序号</th>
										<th>上级分类</th>
										<th>分类名称</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${types}" var="type" varStatus="st">
										<c:if test="${type.type_id ne 0}">
											<tr class="gradeA" id="${type.type_id}">
												<td>${st.count}</td>
												<%-- 											<td>${type.type_pid}</td> --%>
												<c:forEach items="${types}" var="uptype" varStatus="i">
													<c:if test="${uptype.type_id == type.type_pid }">
														<td>${uptype.type_name}</td>
													</c:if>
												</c:forEach>
												<td>${type.type_name}</td>
												<td><a
													href="<%=path%>type/toUpdateType.action?page=type_updateType&type_id=${type.type_id}">修改</a>
													<a
													href="JavaScript:isDelete(${type.type_pid},${type.type_id})">删除</a>
												</td>
											</tr>
										</c:if>
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
	function changeEdit(drug_name1,drug_id){
		alert(drug_name1,drug_id);
	}
	function isDelete(type_pid,type_id){
		if(type_pid==0){
			var isConfirm = confirm("是否删除该分类？该分类的所有子分类也将一并删除。");
			if(isConfirm){
				location.href = "<%=path%>type/deleteSomeTypes.action?type_id="+type_id;
			}
		}else{
			var isConfirm = confirm("是否删除该分类？");
			if(isConfirm){
				location.href = "<%=path%>type/deleteType.action?type_id="
						+ type_id;
			}
		}
	}
</script>
<script type="text/javascript">
	var html = "<html><head><meta charset='utf-8' /></head><body>"
			+ document.getElementsByTagName("table")[0].outerHTML
			+ "</body></html>";
	var blob = new Blob([ html ], {
		type : "application/vnd.ms-excel"
	});
	var a = document.getElementsByTagName("a")[0];
	a.href = URL.createObjectURL(blob);
	a.download = "分类信息表.xls";
</script>
</html>