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
<title>出入库明细</title>
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
/* #DataTables_Table_0_filter { */
/* 	display: none; */
/* } */

.DataInput {
	margin-top: 8px;
	width: 120px;
}
</style>
<%-- 	location.href="<%=path%>purchase/findPurchase.action"; --%>
</head>
<body>

	<div id="content">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<h5>出入库明细</h5>
						</div>
						<div class="widget-content nopadding">

						<form action="<%=path%>libraryDetail/findLibraryDetail.action" method="post">
							<div>
								<span>入库时间</span> 
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
										<th>药品名</th>
										<th>批次</th>
										<th>数量</th>
										<th>成本价</th>
										<th>时间</th>
										<th>类型</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${libraryDetailList}" var="applly" varStatus="st">
										<tr class="gradeA" id="${applly.library_detail_id}">
											<td>${st.count}</td>
											<td>${applly.library.drug.drug_name1}</td>
											<td>${applly.library.batch}</td>
											<td>${applly.library_detail_num}</td>
											<td>${applly.library_detail_price}</td>
											<td>${applly.library_detail_date}</td>
											<td>${applly.library_detail_type}</td>
											
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
		$(function(){
			  var date1 = $("#date1").val();
			  var date2 = $("#date2").val();
			  
			  $.ajax({
			          url:"checkUsername.action",
			          data:{"date1":date1,"date2":date2},
			          type:"post",
			          dataType:"json",
			          success:function(data)
			          {
			              var jsons = data;
			              div.html("");
			              for(var i = 0; i < jsons.length; i++) 
			              {
			                  div.append("<div>"+jsons[i].username+"</div>");
			              }    
			          }
			      });
		});
</script>
</html>