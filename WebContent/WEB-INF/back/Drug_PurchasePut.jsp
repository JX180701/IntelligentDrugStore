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
<title>密码修改</title>
<meta charset="UTF-8" />
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
</head>
<body>

	<div id="content">
		<div id="content-header">
			<h1>药品采购</h1>
		</div>
		<div class="container-fluid">

			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-info-sign"></i>
							</span>
							<h5>药品采购</h5>
						</div>
						<div class="widget-content nopadding">
							<form action="<%=path%>purchase/adddPurchase.action" method="post">
								<div class="control-group">
									<label class="control-label">药品名</label>
									<div class="controls">
										<select name="drug_id" style="width: 100px;"
											id="firstId">
											<c:forEach items="${drugList}" var="type" varStatus="st">
												<option value="${type.drug_id}">${type.drug_name1}</option>
											</c:forEach>
										</select>
									</div>
								</div>

									<div class="control-group">
									<label class="control-label">数量</label>
									<div class="controls">
											<input onkeyup="this.value=this.value.replace(/\D/g,'')" 
											onafterpaste="this.value=this.value.replace(/\D/g,'')" 
											type="text" 
											name="purchase_num" id="purchase_num"
											>
									</div>
								</div>
								

								<div class="control-group">
									<label class="control-label">成本单价</label>
									<div class="controls">
										<input 
										type="text" name="purchase_price"  
										onkeyup="this.value=this.value.replace(/\D/g,'')" 
										onafterpaste="this.value=this.value.replace(/\D/g,'')"  id="purchase_price"/>
									</div>
								</div>
								
									<div class="control-group">
									<label class="control-label">有效期</label>
									<div class="controls">
										<input type="date" name="validity" />
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">供应商</label>
									<div class="controls">
										<input type="text" name="purchase_supplier" id="purchase_supplier"  
												onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('供应商不能为空!')" />
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">采购人:${login_name}</label>
									<input type="hidden" name="user_id" value="${login_id}" />
								</div>

								<div class="form-actions">
									<input type="submit" value="提交" class="btn btn-success" onclick="return sumbit_sure()">
									<!--                   <input type="button" onclick="javascript:history.back(-1);" value="返回" class="btn btn-success"> -->
								</div>

							</form>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.validate.cn.js"></script>
<script src="${pageContext.request.contextPath}/js/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/matrix.js"></script>
<script src="${pageContext.request.contextPath}/js/matrix.form_validation.js"></script>
<script type="text/javascript">
function sumbit_sure()
{
	var name = document.getElementById("purchase_num").value
	var purchase_price = document.getElementById("purchase_price").value
	var purchase_supplier = document.getElementById("purchase_supplier").value
	if (name == null || name == "")
	{
		alert("请输入数量！");
		return false;
	}
	if (purchase_price == null || purchase_price == "")
	{
		alert("请输入成本单价！");
		return false;
	}
	if (purchase_supplier == null || purchase_supplier == "")
	{
		alert("请输入供应商！");
		return false;
	}

	var gnl=confirm("确定要提交?");
	if (gnl==true)
	{
		return true; 
 	}else
 	{
		return false;
	}
}
</script>

<script type="text/javascript">
$(function(){
	$("#pwdform").validate({//表单id
		rules:{
			pwd:{
				required:true,
				maxlength:15
			},
			pwd1:{
				required:true,
				maxlength:15
			},
			pwd2:{
				required:true,
				equalTo:pwd1
			}
		}
	});
});
</script>

<script type="text/javascript">
	$("#firstId").change(function(){
		loadTypeKey($(this).val());
	});
	function loadTypeKey(id){
		$.ajax({
			async: false,
			type:"post",
			url:"<%=path%>exitDrug/second.action",
			data:{"drugId":id},
			success : function(result) {
				$("#secondId").empty();
				$("#secondId").append("<option value=''>请选择</option>");
				$.each(result,
						function(commentIndex, comment) {
							$("#secondId").append(
									"<option value='"+result[commentIndex].batch+"'>" + result[commentIndex].batch + "</option>");
						});
			}

		});
	}
</script>
</html>

