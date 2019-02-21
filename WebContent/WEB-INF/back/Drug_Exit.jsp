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
			<h1>退还厂家</h1>
		</div>
		<div class="container-fluid">

			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-info-sign"></i>
							</span>
							<h5>退还厂家申请</h5>
						</div>
						<div class="widget-content nopadding">
							<!--    	private int library_detail_id; // 出入库明细id -->
							<!-- 	private int library_id; // 药库库存id -->
							<!-- 	private String library_detail_num; // 数量 -->
							<!-- 	private String library_detail_price;// 价格 -->
							<!-- 	private String library_detail_date; // 时间 -->
							<!-- 	private String library_detail_type; // 出库/入库/退厂 -->

							<!-- 	private int library_id; // 药库id -->
							<!-- 	private int drug_id; // 药品id -->
							<!-- 	private int purchase_id; // 采购统计id -->
							<!-- 	private String batch; // 批次 -->
							<!-- 	private String validity; // 有效期 -->
							<!-- 	private String library_num; // 数量 -->
							<!-- 	private String library_threshold; // 阈值 -->
							<!-- 	private int library_state; // 状态 -->

							<!-- 	private Drug drug; // 药品 -->
							<!-- 	private Purchase purchase; // 采购 -->




							<form action="<%=path%>exitDrug/exitDrugRequest.action"
								method="post">
								<div class="control-group">
									<label class="control-label">药品名</label>
									<div class="controls">
										<select name="library.drug_id" style="width: 100px;"
											id="firstId">
											<c:forEach items="${drugList}" var="type" varStatus="st">
												<option value="${type.drug_id}">${type.drug_name1}</option>
											</c:forEach>
										</select>
									</div>
								</div>

								<div class="control-group">
									<label class="control-label">批次</label>
									<div class="controls">
										<select name="library.batch" style="width: 100px;"
											id="secondId">
<!-- 											<option value="no" selected='selected'>请选择</option> -->
												<c:forEach items="${libraryListt}" var="type" varStatus="st">
														<option value="${type.batch}">${type.batch}</option>
												</c:forEach>
										</select>
									</div>
								</div>
								
								<div class="control-group">
									<label class="control-label">数量</label>
									<div class="controls">
											<input onkeyup="this.value=this.value.replace(/\D/g,'')" 
												onblur="if(this.value.replace(/^ +| +$/g,'')=='')alert('不能为空!')"
onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="library_detail_num" id="library_detail_num"
											id="library_detail_num">
									</div>
								</div>

								<!--                 <div class="control-group"> -->
								<%--                   <label class="control-label">操作人:${login_name}</label> --%>
								<!--                 </div> -->

								<%--                 <input type="hidden" name="user_id" value="${login_id}" /> --%>

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
function sumbit_sure(){
		
	var name = document.getElementById("library_detail_num").value
	if (name == null || name == "")
	{
		alert("请输入数量！");
		return false;
	}
	var gnl=confirm("确定要提交?");
	if (gnl==true){
		return true; 
 		}else{
		return false;}
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

