<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#setType {
	width: 60%;
	margin: 100px auto;
	border: 1px gray solid;
	padding: 30px;
}

h2 {
	text-align: center
}

#setType div {
	width: 80%;
	margin-left: 240px;
}

#setType div input {
	margin-left: 15px;
}

#setType div select {
	margin-left: 15px;
	width: 170px;
}

#setType input {
	margin-top: 10px;
}

#setType select {
	margin-top: 10px;
}

#sub {
	padding-left: 100px;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.cn.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$("form").validate({
		rules:{
			type_name:{
				required:true
			}
		},
		messages:{
			type_name:{
				required:"请输入分类名称"
			}
		}
	});
});

function typeExist(){
	$("#type_name").val();
	var name = "${updateType.type_name}";
	var pid = "${updateType.type_pid}";
	var type_pid = $("#type_pid").val();
	var type_name = $("#type_name").val();
	var result = true;
	if(name == type_name && pid==type_pid){
		result = false;
		alert("修改成功！");
		location.href = "<%=basePath %>type/findTypes.action";
	}
	
		return result;
	}
</script>
<body>
	<div id="setType">
		<h2>药品分类修改</h2>
		<form action="<%=path%>/type/updateType.action?type_id=${updateType.type_id}" method="post"
			onSubmit="return typeExist();">
			<div>
				所属分类:<select name="type_pid" id="type_pid">

						<c:forEach items="${listType}" var="uptype" varStatus="i">
							<c:if test="${uptype.type_id == updateType.type_pid }">
								<option value="${updateType.type_pid}">${uptype.type_name}</option>
							</c:if>
						</c:forEach>
<%-- 					<c:if test="${updateType.type_pid == 0 }"> --%>
<!-- 						<option value="0">无</option> -->
<%-- 					</c:if> --%>
					<c:if test="${updateType.type_pid ne 0 }">
						<c:forEach items="${listType}" var="uptype" varStatus="i">
							<c:if test="${uptype.type_pid == 0 && (updateType.type_pid ne uptype.type_id) && uptype.type_id ne 0}">
								<option value="${uptype.type_id}">${uptype.type_name}</option>
							</c:if>
						</c:forEach>

					</c:if>
				</select>
			</div>
			<div>
				分类名称:<input type="text" name="type_name" id="type_name"
					value="${updateType.type_name}">
			</div>
			<div id="sub">
				<input type="submit" value="提交">&nbsp;
				<a href="JavaScript:history.go(-1)"><input type="button" value="返回"></a>
			</div>
		</form>
	</div>
</body>

</html>
