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

form label {
	display: inline-block
}

#operationArea {
	float: right
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
							<h5>药品统计</h5>
						</div>
						<div class="widget-content nopadding">

							<!-- 查询条件 -->
							<form action="<%=path%>drug/searchConditionDrug.action"
								method="post">
								<input type="text" name="drug_name" id="drug_name"> <input
									type="checkbox" name="drug_special1" value="yes"
									id="drug_special1"> <label for="drug_special1">特殊药品</label>
								<input type="checkbox" name="drug_antibiotic" value="yes"
									id="drug_antibiotic"> <label for="drug_antibiotic">抗生素</label>
								<input type="checkbox" name="drug_insurance" value="yes"
									id="drug_insurance"> <label for="drug_insurance">医保药品</label>

								<button type="submit" class="btn">
									<i class="icon-search">查询</i>
								</button>
								<a style="float:right;margin-right:20px;"><i class="icon-download-alt">导出数据到Excel</i></a>
							</form>
							<div id="operationArea">
								<a href="<%=path%>drug/toPage.action?page=drug_setDrug"><button
										type="button" class="btn"><i class="icon-plus">添加药品</i></button></a>
							</div>
							<table
								class="table table-bordered data-table table-striped with-check">
								<thead>
									<tr>
										<th>序号</th>
										<th>药品名</th>
										<th>化学名</th>
										<th>滞销时长</th>
										<th>规格</th>
										<th>剂型</th>
										<th>用法用量</th>
										<th>价格</th>
										<th>药房单位</th>
										<th>药库单位</th>
										<th>换算公式</th>
										<th>特殊药品</th>
										<th>抗生素</th>
										<th>医保药</th>
										<th>分类</th>
										<th>状态</th>
										<th>修改</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${drugs}" var="drug" varStatus="st">
										<tr class="gradeA" id="${drug.drug_id}">
											<td>${st.count}</td>
											<td>${drug.drug_name1}</td>
											<td>${drug.drug_name2}</td>
											<td>${drug.drug_unsalable}</td>
											<td>${drug.drug_standard}</td>
											<td>${drug.drug_dosage}</td>
											<td>${drug.direction.direction_describe}</td>
											<td>${drug.price.price_cost}</td>
											<td>${drug.drug_unit1}</td>
											<td>${drug.drug_unit2}</td>
											<td>${drug.drug_formula}</td>
											<td>${drug.drug_special}</td>
											<td>${drug.drug_antibiotic}</td>
											<td>${drug.drug_insurance}</td>
											<td>${drug.type.type_name}</td>
											<td>${drug.drug_state}</td>
											<td><a href="<%=path %>drug/toUpdateDrug.action?page=drug_updateDrug&drug_id=${drug.drug_id}">修改</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
					</div>
					<form action="<%=path%>excel/importDrug.action" enctype="multipart/form-data" method="post">
							上传Excel文件导入数据：<input type="file" name="file"><br />
							<input type="submit" value="上传">*上传的Excel文件格式为xlsx，需按照一定格式填写内容
						</form>
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
	a.download = "药品信息表.xls";
</script>
</html>