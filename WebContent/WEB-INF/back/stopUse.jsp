<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

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
			<h1>药品停用</h1>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							
							
							<form action="<%=path%>/drugstore/condUseState.action">
								
								药品ID: <input type="text" name="drug" id="textfield1" value="0" >
								药品名称: <input type="text" name="drug_name" id="textfield2"
									  autocomplete=off>
								<div id="context1"
									style="background-color: white; border: 1px solid LightBLue; width: 220px; position: absolute; top: 30px; left: 322px; display: none">
								</div>
								批次：<input type="text" name="batch" id="textfield2" value="0" style="width:110px" >
								有效期：<input type="date" name="expiration" id="textfield4" >
								<input type="submit" value="查询" >
								</form>
						</div>
						
						<div class="widget-content nopadding">
							
								<table class="table table-bordered data-table">
									<thead>
										<tr>
											<th>药品ID</th>
											<th>批次</th>
											<th>有效期</th>
											<th>数量</th>
											<th>阈值</th>
											<th>状态</th>
											<th>药品名称</th>
											<th>操作</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${drugstorelist}" var="d">
											<tr class="gradeA" id="${d.drug_id }">

												<td><p>${d.drug_id }</p></td>
												<td><p >${d.batch }</p></td>
												<td><p >${d.validity }</p></td>
												<td><p >${d.drugstore_num }</p></td>
												<td><p >${d.drugstore_threshold}</p></td>
												<td><p >${d.drugstore_state}</p></td>
												<td><p>${d.drug.drug_name1}</p></td>
												<td><c:if test="${d.drugstore_state eq '停用'}">
														<a href="#" onclick="changeState(this)">启用</a>
													</c:if> <c:if test="${d.drugstore_state eq '启用'}">
														<a href="#" onclick="changeState(this)">停用</a>
													</c:if></td>
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
<script type="text/javascript">
		
		
		function changeState(node) {
			var batch=node.parentNode.parentNode.childNodes[3].childNodes[0].innerHTML
			var state=node.parentNode.parentNode.childNodes[11].childNodes[0].innerHTML
			
			
			if(state=='停用'){
				state='启用'
			}else{
				state='停用'
			}
			node.href = "<%=path%>/drugstore/changeUseState.action?state="+state+"&batch="+batch
		}

	$("#textfield2")
			.keyup(
					function() {
						var content = $(this).val();
						if (content == "") {
							$("#context1").css("display", "none");
							return;
						}
						;
						var time = new Date().getTime();
						$
								.ajax({
									type : "get",
									//新建一个名为findBooksAjaxServlet的servlet
									url : "${pageContext.request.contextPath}/requisition/findDrugAjax.action",
									data : {
										name : content,
										time : time
									},
									success : function(data) {
										//拼接html
										var res = data.split(",");
										var html = "";
										for (var i = 0; i < res.length; i++) {
											//每一个div还有鼠标移出、移入点击事件
											html += "<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"
													+ res[i] + "</div>";
										}
										$("#context1").html(html);
										//显示为块级元素
										$("#context1").css("display", "block");
									}
								});
					})

	function changeBackColor_over(div) {
		$(div).css("background-color", "#CCCCCC");
	}
	//鼠标离开内容
	function changeBackColor_out(div) {
		$(div).css("background-color", "");
	}
	//将点击的内容放到搜索框
	function setSearch_onclick(div) {
		$("#textfield2").val(div.innerText);
		$("#context1").css("display", "none");
	}
</script>
</html>