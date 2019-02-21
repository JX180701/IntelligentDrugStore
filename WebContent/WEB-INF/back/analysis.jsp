<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<script src="<%=basePath%>js/jquery.min.js" type="text/javascript"></script>
<style type="text/css">
#setDrug{width:60%;margin:5px auto;border:1px gray solid;padding:10px;}
h2{text-align:center}
#addInsurance div{width:80%;margin-left:450px;margin-top:50px;}
#addInsurance div input{margin-left:35px;}
#addInsurance div select{margin-left:35px;}

</style>
</head>

<body>
<div id="addInsurance">
	<h2>销量预测</h2>
	<form action="<%=path%>/drugstore/sendDrug.action" method="post" >
		<div>药品ID:&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="drug_id" id="textfield" onblur="num(this)"></div>
		<div>下月预测销量：<label id="price"></label></div>
		
	    <div id="sub"><input type="submit" value="提交">&nbsp;<input type="reset" value="重置"></div>
	</form>
	</div>
	<script type="text/javascript">
	 
	function num(node){
		
		var id=$("#textfield").val()
		
		if(id==""){
			alert("请输入药品ID")
		}
	
		if(num!=""){
			 $.ajax({
		          url: "<%=path%>/drugstore/checkAnalysis.action",
		          type: "POST",
		          data: {
		            "drug":id
		          },    
		          success: function(data) {
		            $("#price").html(data)
		          }
		        });
		}
	}
	
	
	</script>
</body>
</html>