<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
#setTaboo {
	width: 60%;
	margin: 5px auto;
	border: 1px gray solid;
	padding: 5px;
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
textarea{margin-left:80px;}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.cn.js"></script>
<script type="text/javascript">
$(function(){
	$("#subTaboo").on("click",function(){
		var drug_id1 = "${drug.drug_id }";
		var drug_id2 = $("#drug_id2").val();
		var taboo_discribe = $("#taboo_discribe").val();
		
		//删除选中的action选项
		var index = "#drug_id2 option[value='"+drug_id2+"']";
		$(index).remove();
		
		$.ajax({
			url:"<%=path%>/taboo/addTaboo.action?",
			data:{
				drug_id1:drug_id1,
				drug_id2:drug_id2,
				taboo_discribe:taboo_discribe
				},
			type:"post",
			dataType:"text",
			success:function(data){
				alert(data);
				if(data!=""){
					$("#taboo_discribe").val("");
				}
			}
		});
	});
});
</script>
</head>
<body>
	<div id="setTaboo">
		<h2>配伍禁忌</h2>
			<div>
				药品&nbsp;&nbsp;&nbsp;ID:<input type="text" name="drug_id"
					value="${drug.drug_id }" disabled>
			</div>
			<div>
				药品名称:<input type="text" name="drug_name1" value="${drug.drug_name1 }"
					disabled>
			</div>
			<div>
				化学名称:<input type="text" name="drug_name2" value="${drug.drug_name2 }"
					disabled>
			</div>
			<div>
				药品规格:<br>
				<textarea name="drug_standard" disabled>${drug.drug_standard }</textarea>
			</div>
			<hr />
			添加配伍禁忌药品：
			<div>
			<select name="drug_id2" id="drug_id2">
				<c:forEach items="${drugList }" varStatus="i" var="item">
					<c:if test="${item.drug_id ne drug.drug_id }">
						<option value="${item.drug_id}">${item.drug_name1}</option>
				</c:if>
				</c:forEach>
				</select>
			说明：<br>
			<textarea name="taboo_discribe" id="taboo_discribe"></textarea>
			</div>
			<div id="sub">
				<input type="button" value="提交" id="subTaboo">&nbsp;<input type="reset" value="重填">
			</div>
			<form action="<%=path%>/drug/redirDrug.action?drug_id=${drug.drug_id }&drug_name1=${drug.drug_name1 }" method="post">
			<div><input type="submit" value="下一项"></div>
			</form>
	</div>
</body>

</html>
