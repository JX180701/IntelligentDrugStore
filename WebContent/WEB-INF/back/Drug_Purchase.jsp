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
<title>药品采购查询</title>
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
							<h5>药品采购查询</h5>
						</div>
						<div class="widget-content nopadding">

						<form action="<%=path%>purchase/findPurchase.action" method="post">
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
										<th>数量</th>
										<th>出厂价</th>
										<th>入库时间（批次）</th>
										<th>采购人</th>
										<th>供应商</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach items="${purchaseList}" var="applly" varStatus="st">
										<tr class="gradeA" id="${applly.purchase_id}">
											<td>${st.count}</td>
											<td><a data-toggle="modal" data-target="#${applly.drug_id}">${applly.drug.drug_name1}</a></td>
											<td>${applly.purchase_num}</td>
											<td>${applly.purchase_price}</td>
											<td>${applly.purchase_date}</td>
											<td><a data-toggle="modal" data-target="#${applly.user.user_name}">${applly.user.user_name}</a></td>
											<td>${applly.purchase_supplier}</td>
											
<div class="modal fade" id="${applly.drug_id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					${applly.drug.drug_name1}
				</h4>
			</div>
			<div class="modal-body">
			<div>化学名:${applly.drug.drug_name2}滞销时长:${applly.drug.drug_unsalable}</div>
			<div>规格:${applly.drug.drug_standard}剂型:${applly.drug.drug_dosage}</div>
			<div>药房单位:${applly.drug.drug_unit1}药库单位:${applly.drug.drug_unit2}</div>
			<div>换算公式:${applly.drug.drug_formula}是否特殊药品:${applly.drug.drug_special}</div>
			<div>是否抗生素:${applly.drug.drug_antibiotic}是否医保药品:${applly.drug.drug_insurance}</div>
			<div>药品状态:${applly.drug.drug_state}用量:${applly.drug.direction.direction_num}</div>
			<div>每日次数:${applly.drug.direction.direction_time}用法描述:${applly.drug.direction.direction_describe}</div>
			<div>分类父id:${applly.drug.type.type_pid}分类名:${applly.drug.type.type_name}</div>
			<div>成本:${applly.drug.price.price_cost}零售价:${applly.drug.price.price_retail}</div>
			<div>加成率:${applly.drug.price.price_ratio}底价:${applly.drug.price.price_floor}</div>
			<div>开票价:${applly.drug.price.price_invoice}实际结算价:${applly.drug.price.price_settle}</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<div class="modal fade" id="${applly.user.user_name}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					${applly.user.user_name}
				</h4>
			</div>
			<div class="modal-body">
				<div>身份：${applly.user.role.role_name}</div>
				<div>状态：${applly.user.user_state}</div>
				<div>账号：${applly.user.user_account}</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
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