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
			<h1>药品调价</h1>
		</div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<form action="<%=basePath%>/requisition/condPrice.action">

								药品ID: <input type="text" name="drug" id="textfield1" value="0" style="width:110px">
								药品名称: <input type="text" name="drug_name" id="textfield2"
									 autocomplete=off>
								<div id="context1"
									style="background-color: white; border: 1px solid LightBLue; width: 220px; position: absolute; top: 30px; left: 260px; display: none">
								</div>
								成本价：<input type="text" name="cost" id="textfield3" value="0" style="width:110px">
								零售价：<input type="text" name="retail" id="textfield4" value="0" style="width:110px">

								<input type="submit" value="查询">
								</form>
						</div>
						<div class="widget-content nopadding">
							
								<table class="table table-bordered data-table">
									<thead>
										<tr>
											<th>药品ID</th>
											<th>药品名称</th>
											<th>成本价</th>
											<th>零售价</th>
											<th>底价</th>
											<th>开票价</th>
											<th>实际结算价</th>
											<th>操作</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${pricelist}" var="p">
											<tr class="gradeA" id="${p.drug_id }">

												<td width="100"><p >${p.drug_id }</p></td>
												<td width="100"><p >${p.drug_name1 }</p></td>
												<td width="100"><p >${p.price.price_cost }</p></td>
												<td width="100"><p contenteditable="true">${p.price.price_retail }</p></td>
												<td width="100"><p >${p.price.price_floor }</p></td>
												<td width="100"><p >${p.price.price_invoice}</p></td>
												<td width="100"><p >${p.price.price_settle}</p></td>
												<td width="100"><input type="hidden"
													value="${p.price.price_retail }" /><a href="#" onclick="changePrice(this,${p.price.price_id})">修改</a></td>
												
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
$("#textfield2").keyup(function(){
	var content=$(this).val();
	if(content==""){
		   $("#context1").css("display","none");
		   return ;
		  };
	var time=new Date().getTime();
	$.ajax({
		   type:"get",
		   //新建一个名为findBooksAjaxServlet的servlet
		   url:"${pageContext.request.contextPath}/requisition/findDrugAjax.action",
		   data:{name:content,time:time},
		   success:function(data){
		    //拼接html
		    var res=data.split(",");
		    var html="";
		    for(var i=0;i<res.length;i++){
		     //每一个div还有鼠标移出、移入点击事件
		     html+="<div onclick='setSearch_onclick(this)' onmouseout='changeBackColor_out(this)' onmouseover='changeBackColor_over(this)'>"+res[i]+"</div>";
		    }
		    $("#context1").html(html);
		    //显示为块级元素
		    $("#context1").css("display","block");
		   }
		  });
})

function changeBackColor_over(div){
  $(div).css("background-color","#CCCCCC");
 }
 //鼠标离开内容
 function changeBackColor_out(div){
  $(div).css("background-color","");
 }
 //将点击的内容放到搜索框
 function setSearch_onclick(div){
  $("#textfield2").val(div.innerText);
  $("#context1").css("display","none");
 }

		
		function changePrice(node,price_id) {
			var drug_id=node.parentNode.parentNode.childNodes[1].childNodes[0].innerHTML
			var oldprice = node.parentNode.parentNode.childNodes[15].childNodes[0].value
			var newprice = node.parentNode.parentNode.childNodes[7].childNodes[0].innerHTML
			var cost = node.parentNode.parentNode.childNodes[5].childNodes[0].innerHTML
			costprice=parseInt(cost);
			retail=parseInt(newprice);
			if(oldprice==newprice){
				alert("请重新输入价格")
			}if(costprice>retail){
				alert("小于成本价")
			}else{
				node.href = "<%=path%>/requisition/changePrice.action?oldprice="+oldprice+"&newprice="+newprice+"&drug_id="+drug_id+"&price_id="+price_id
				
			}
			

	
		

		
		
		

	}
</script>
</html>