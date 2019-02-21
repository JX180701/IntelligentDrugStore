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
<title>配伍禁忌</title>
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
							<h5>药库库存预警设置</h5>
						</div>
						<div class="widget-content nopadding">

							<!-- 查询条件 -->
							<div>
							<form action="<%=path%>taboo/searchConditionTaboo.action"
								method="post">
<!-- 								<input type="text" name="type_name" id="type_name"> -->
								<select name="drug_id1" id="drug_id1" style="width:100px;">
								<option value="0">无</option>
									<c:forEach items="${drugs }" varStatus="i" var="drug">
<%-- 										<c:forEach items="${taboos}" var="taboo" varStatus="st"> --%>
<%-- 											<c:if test="${(drug.drug_id == taboo.drug_id1) || (drug.drug_id == taboo.drug_id2)}"> --%>
												<option value="${drug.drug_id}">${drug.drug_name1}</option>
<%-- 											</c:if> --%>
<%-- 										</c:forEach> --%>
									</c:forEach>
								</select>
								<button type="submit" class="btn">
									<i class="icon-search">查询</i>
								</button>
								<a style="float:right;margin-right:20px;"><i class="icon-download-alt">导出数据到Excel</i></a>
							</form>
							</div>
							<table
								class="table table-bordered data-table table-striped with-check">
								<thead>
									<tr>
										<th>序号</th>
										<th>药品</th>
										<th>库存</th>
										<th>阈值</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${drugs}" var="drug" varStatus="st">
											<tr class="gradeA">
											<td>${st.count}</td>
											<td>
												${drug.drug_name1}
											</td>
											<td>
												${drug.drug_sum}
											</td>
											<td id="${drug.drug_id}" ondblclick="editText(${drug.drug_id})" onblur="updateTaboo(${drug.drug_id})">${drug.drug_threshold_library }
											</td>
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
<span style="display:none" id="tempValue"></span>
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
	function editText(id){
		var elem = "#"+id;
		$(elem).attr("contentEditable","true");
		//把值存入临时容器中
		var tempValue = $(elem).text();
		$("#tempValue").text(tempValue);
	}
	
	function updateTaboo(tbid){
		var elem = "#"+tbid;
		$(elem).attr("contentEditable","false");
		
		//如果修改后的值为空，则不提交，修改值为原来的值
		var changeValue = $(elem).text();
		var tempValue = $("#tempValue").text();
		if(changeValue==""){
			alert("输入不能为空");
			$(elem).text(tempValue);
			return;
		}
		//修改后的值和原来的值相同，则不做变化
		if(changeValue==tempValue){
			return;
		}
		
		//修改后的值为非数值
		if(isNaN(changeValue)){
			alert("请输入数值");
			$(elem).text(tempValue);
			return;
		}
		
		if(changeValue<0){
			alert("请输入正数");
			$(elem).text(tempValue);
			return;
		}
		
		if(changeValue==null){
			$(elem).text(tempValue);
			return;
		}
		
		if(changeValue==undefined){
			$(elem).text(tempValue);
			return;
		}
		
		if(changeValue%1!=0){
			alert("请输入整数");
			$(elem).text(tempValue);
			return;
		}
		
		//提交修改后的值
		$.ajax({
		url:"<%=path%>drug/updateLibraryThreshold.action",
		type:"post",
		data:{
			drug_id:tbid,
			drug_threshold_library:changeValue
		},
// 		dataType:"text",
		success:function(data){
			if(data=="yes"){
				alert("修改成功！");
			}
		}
	});
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
	a.download = "药品库存.xls";
</script>
</html>