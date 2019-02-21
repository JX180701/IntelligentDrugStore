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
#setTaboo {
	width: 60%;
	margin: 100px auto;
	border: 1px gray solid;
	padding: 30px;
}

h2 {
	text-align: center
}

#setTaboo div {
	width: 80%;
	margin-left: 240px;
}

#setTaboo div input {
	margin-left: 15px;
}

#setTaboo div select {
	margin-left: 15px;
	width: 170px;
}

#setTaboo input {
	margin-top: 10px;
}

#setTaboo select {
	margin-top: 10px;
}

#sub {
	padding-left: 100px;
}

#direction div {
	margin-left: 70px;
	width: 350px;
}

textarea {
	margin-left: 80px;
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
							<h5>是否医保药品？</h5>
						</div>
						<div class="widget-content nopadding">
							<div id="setTaboo">
								<div>
									药品&nbsp;&nbsp;&nbsp;ID:<input type="text" name="type_id"
										value="${drug.drug_id }" disabled>
								</div>
								<div>
									药品名称:<input type="text" name="type_id"
										value="${drug.drug_name1 }" disabled>
								</div>
								<div>
									化学名称:<input type="text" name="type_id"
										value="${drug.drug_name2 }" disabled>
								</div>
								<hr />
								<c:if test="${isInsurance == 'yes'}">
				${drug.drug_name1 }是医保药品，医保信息如下：<br>
				药品名：${insurance.drug_name}<br>
				医保编号:${insurance.insurance_code}
			</c:if>
								<c:if test="${isInsurance == 'no'}">
				${drug.drug_name1 }不是医保药品。
				
			</c:if>
								<hr />
							</div>
							<div style="margin-top:-30px;">
								<h3>医保药品目录：</h3>
								<table
									class="table table-bordered data-table table-striped with-check">
									<thead>
										<tr>
											<th>序号</th>
											<th>药品名</th>
											<th>医保编号</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach items="${insuranceList}" var="item" varStatus="st">
											<tr class="gradeA" id="${item.insurance_id}">
												<td>${st.count}</td>
												<td>${item.drug_name}</td>
												<td>${item.insurance_code}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div>
								<a href="<%=path%>drug/searchDrug.action?page=drug_search" style="margin-left:300px;"><button
										type="button">完成</button></a>
							</div>
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

</html>