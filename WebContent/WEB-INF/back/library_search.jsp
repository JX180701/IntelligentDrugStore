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
<title>医保药品</title>
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
							<h5>医保药品</h5>
						</div>
						<div class="widget-content nopadding">

							<!-- 查询条件 -->
							<div>
								<form
									action="<%=path%>insurance/searchConditionInsurance.action"
									method="post">
									<button type="submit" class="btn">
										<i class="icon-search">查询</i>
									</button>
									<a style="float: right; margin-right: 20px;"><i
										class="icon-download-alt">导出数据到Excel</i></a>
								</form>
							</div>
							<div id="operationArea">
								<a
									href="<%=path%>insurance/toPage.action?page=Insurance_addInsurance"><button
										type="button" class="btn">
										<i class="icon-plus">添加医保药品</i>
									</button></a>
							</div>
							<h3>医保药品目录：</h3>
							<table
								class="table table-bordered data-table table-striped with-check">
								<thead>
									<tr>
										<th>序号</th>
										<th>药品名</th>
										<th>批次</th>
										<th>采购人员</th>
										<th>供应商</th>
										<th>有效期</th>
										<th>数量</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${libraryList}" var="library" varStatus="st">
										<tr class="gradeA" id="${library.library_id}">
											<td>${st.count}</td>
											<td>${library.drug.drug_name1}</td>
											<td>${library.batch}</td>
											<td>${library.purchase.user.user_name}</td>
											<td>${library.purchase.purchase_supplier}</td>
											<td>${library.validity}</td>
											<td>${library.library_num}</td>
											<td>${library.library_state}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<form action="<%=path%>excel/importInsurance.action" enctype="multipart/form-data" method="post">
							上传Excel文件导入数据：<input type="file" name="file"><br />
							<input type="submit" value="上传">*上传的Excel文件格式为xlsx，需按照一定格式填写内容
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<span style="display: none" id="tempValue"></span>
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
	function deleteInsurance(insurance_id){
		var isConfirm = confirm("是否删除该医保药品？");
		if(isConfirm){
			location.href = "<%=path%>/insurance/deleteInsurance.action?insurance_id="+insurance_id;
		}
	}
	function editText(id){
		var elem = "#"+id;
		$(elem).attr("contentEditable","true");
		//把值存入临时容器中
		var tempValue = $(elem).text();
		$("#tempValue").text(tempValue);
	}
	
	function updateInsuranceName(tbid,insurance_id){
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
		//提交修改后的值
		$.ajax({
		url:"<%=path%>insurance/updateInsuranceName.action",
		data:{
			"insurance_id":insurance_id,
			"drug_name":tempValue,
			"changeValue":changeValue
		},
		type:"post",
		dataType:"text",
		success:function(data){
			if(data=="yes"){
				alert("修改成功！");
			}
		}
	});
	}
	
	function updateInsuranceCode(tbid,insurance_id){
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
		//提交修改后的值
		$.ajax({
		url:"<%=path%>insurance/updateInsuranceCode.action",
		data:{
			"insurance_id":insurance_id,
			"insurance_code":tempValue,
			"changeValue":changeValue
		},
		type:"post",
		dataType:"text",
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
	a.download = "医保信息表.xls";
</script>
</html>