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
	<form action="<%=path%>/requisition/addRequisition.action" method="post" id="form" onSubmit="return confirm();" >
<!-- 	<div class="control-group"> -->
<!-- 									<label class="control-label">药品名</label> -->
									
<!-- 								</div> -->
								<div >
										药品名：<select name="drug_id" style="width: 100px;"
											id="firstId" onchange="batch(this)">
											<c:forEach items="${drugList}" var="type" varStatus="st">
												<option value="${type.drug_id}">${type.drug_name1}</option>
											</c:forEach>
										</select>
									</div>
<!-- 		<div>药品ID:&nbsp;&nbsp; <input type="text" name="drug_id" id="textfield " onblur="batch(this)"><label id="caution"></label></div> -->
		<div>申请批次:<select name="requisition_batch" style="width: 100px;" id="textfield2"></select></div>
		<div>申请数量:<input type="text" name="requisition_num" id="textfield3" onblur="num(this)"><label id="caution"></label></div>
		<div>申请类型:<select name="requisition_type" id="select"><option>-选择类型-</option><option>药品退库</option><option>药品报损</option>  </select></div>
		<div>申请描述:<textarea name="requisition_discribe" id="textarea" cols="45" rows="5"></textarea></div>
	    <div id="sub"><input type="submit" value="提交">&nbsp;<input type="reset" value="重置"></div>
	</form>
	</div>
	<script type="text/javascript">
	 var r="";
	function batch(node){
		var id=node.value
		$.ajax({
		  url: "<%=path%>/drugstore/checkBatch.action",
		  type: "POST",

		  data: {
		     "drug":id
          },
		         
		  success: function(data) {
			 
			  var arr=data.split(',');
			  
			  var html = "";
			for (var i = 0; i < arr.length; i++) {
											//每一个div还有鼠标移出、移入点击事件
				html += "<option value='"+arr[i]+"'>" + arr[i] + "</option>";
				}
				$("#textfield2").html(html);
			  
			  
		  }
		          
	});
		
	}
	
	function  num(node){
		var batch=$("#textfield2").val();
		
		
		
		$.ajax({
		  url: "<%=path%>/drugstore/checkDrugStore.action?op=batch",
		  type: "POST",

		  data: {
		     "drug":batch
          },
		         
		  success: function(data) {
			 r=data;
			alert(data)
			$("#caution").html("当前批次药库剩余"+data);
		  }
		          
	});
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
	
	
	function confirm(){
		var temp=$("#caution").html()
		if(temp!=""){
			var input=$("#textfield3").val()
		    var oldnum=parseInt(input)
		    
		    var newnum=parseInt(r)
		    
		    if(oldnum>newnum){
		    	alert("超出最大申请数量")
		    	return false;
		    }
		}
		return true;
	}
	</script>
</body>
</html>