<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="<%=basePath%>js/jquery.min.js" type="text/javascript"></script>

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
</head>
<body>
	<div id="content">
		<div id="content-header">
			<h1>申请管理</h1>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<form action="<%=basePath%>/requisition/condRequisition.action">

								药品ID: <input type="text" name="drug" id="textfield1" value="0" style="width:110px">
								申请状态：<select name="requisition_state" id="select" style="width:110px"><option>-选择状态-</option>
									<option>待审核</option>
									<option>审核通过</option>
									<option>未通过</option></select> 申请类型：<select name="requisition_type"
									id="select" style="width:110px"><option>-选择类型-</option>
									<option>药品请领</option>
									<option>药品退库</option>
									<option>药品报损</option></select> 申请时间：<input type="date"
									name="requisition_date1" id="textfield4"> <input
									type="submit" value="查询">
									</form>
						</div>
						<div class="widget-content nopadding">
							
								<table class="table table-bordered data-table">
									<thead>
										<tr>
											<th>药品ID</th>
											<th>药品批次</th>
											<th>数量</th>
											<th>申请状态</th>
											<th>申请时间</th>
											<th>申请类型</th>
											<th>原因描述</th>
											<th>操作</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach items="${requestList}" var="r">
											<tr class="gradeA" id="${r.drug_id }">

												<td><p contenteditable="true">${r.drug_id }</p></td>
												<td><p contenteditable="true">${r.requisition_batch}</p></td>
												<td><p contenteditable="true">${r.requisition_num}</p></td>
												<td><p contenteditable="false">${r.requisition_state }</p></td>
												<td><p contenteditable="false">${r.requisition_date1 }</p></td>
												<td><p contenteditable="true">${r.requisition_type }</p></td>
												<td><p contenteditable="true">${r.requisition_discribe}</p></td>
												<td><input type="hidden" value="${r.requisition_id}"><a href="" style="margin-left: 0px"
													onclick="del(this)">删除</a><a href="#"
													style="margin-left: 10px" onclick="mod(this)">修改</a></td>

											</tr>
										</c:forEach>
									</tbody>
								</table>
							
						</div>
					</div>
					<div class="form-actions">
						<input type="button" onclick="javascript:history.back(-1);"
							value="返回" class="btn btn-success">
					</div>
				</div>
			</div>
		</div>
	</div>




	<script type="text/javascript">
		function del(node) {
			var requisition_id=node.parentNode.parentNode.childNodes[15].childNodes[0].value
			node.href = "<%=path%>/requisition/deleteRequisition.action?requisition_id=" + requisition_id

		}	
		function mod(node){
			
			var drug_id=node.parentNode.parentNode.childNodes[1].childNodes[0].innerHTML
			var requisition_batch=node.parentNode.parentNode.childNodes[3].childNodes[0].innerHTML
			var requisition_num=node.parentNode.parentNode.childNodes[5].childNodes[0].innerHTML
			var requisition_state=node.parentNode.parentNode.childNodes[7].childNodes[0].innerHTML
			var requisition_date1=node.parentNode.parentNode.childNodes[9].childNodes[0].innerHTML
			var requisition_type=node.parentNode.parentNode.childNodes[11].childNodes[0].innerHTML
			var requisition_discribe=node.parentNode.parentNode.childNodes[13].childNodes[0].innerHTML
			var requisition_id=node.parentNode.parentNode.childNodes[15].childNodes[0].value
			var user_id =${user.user_id}
			var array=new Array(requisition_id,user_id,drug_id,requisition_num,requisition_state,requisition_date1,requisition_type,requisition_discribe,requisition_batch)
			
			
			node.href = "<%=path%>/requisition/changeRequisition.action?array="+array					
		}
	</script>

</body>
<script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/matrix.js"></script>
<script src="${pageContext.request.contextPath}/js/matrix.tables.js"></script>
</html>