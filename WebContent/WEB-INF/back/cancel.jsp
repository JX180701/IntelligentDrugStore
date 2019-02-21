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
<style type="text/css">
#setDrug{width:60%;margin:5px auto;border:1px gray solid;padding:10px;}
h2{text-align:center}
#addInsurance div{width:80%;margin-left:450px;margin-top:50px;}
#addInsurance div input{margin-left:35px;}
#addInsurance div select{margin-left:35px;}
#addInsurance div textarea{margin-left:35px;}
</style>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.cn.js"></script>
</head>

<body>
<div id="addInsurance">
	<h2>药品申请</h2>
	<form action="<%=path%>/requisition/addRequisition.action" method="post" id="form" >
		<div>药品ID:&nbsp;&nbsp; <input type="text" name="drug_id" id="textfield " onblur="batch(this)"><label id="caution"></label></div>
		<div>申请批次:<input type="text" name="requisition_batch" id="textfield2"></div>
		<div>申请数量:<input type="text" name="requisition_num" id="textfield3"></div>
		<div>申请类型:<select name="requisition_type" id="select"><option>-选择类型-</option><option>药品退库</option><option>药品报损</option>  </select></div>
		<div>申请描述:<textarea name="requisition_discribe" id="textarea" cols="45" rows="5"></textarea></div>
	    <div id="sub"><input type="submit" value="提交">&nbsp;<input type="reset" value="重置"></div>
	</form>
	</div>
	<script type="text/javascript">
	 
	function batch(node){
		var id=node.value
		reg=/^[-+]?\d*$/;
		if(id==""){
			alert("请输入药品ID")
		}else if(!reg.test(id)){
			
			alert("id必须为数字")
		}else{
			 $.ajax({
		          url: "<%=path%>/drugstore/checkBatch.action",
		          type: "POST",

		          data: {
		            "drug":id
		          },
		         
		          success: function(data) {
		            
		            
		            $("#caution").html('该药品批次'+data)
		            
		          }
		          
		        });
		}
	}
	
	$("#form").validate({//表单id
		rules:{
			drug_id:{
				required:true,
				number:true
			},
			requisition_batch:{
				required:true,
			},
			requisition_num:{
				required:true,
				number:15
				
			},
		}
	});
	</script>
</body>
</html>