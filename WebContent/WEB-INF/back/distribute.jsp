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
	<h2>发药</h2>
	<form action="<%=path%>/drugstore/sendDrug.action" method="post" onSubmit="return confirm();" >
<!-- 	<div class="control-group"> -->
<!-- 									<label class="control-label">药品名</label> -->
									
<!-- 								</div> -->
<!-- 		<div>药品ID: <input type="text" name="drug_id" id="textfield" ></div> -->
		<div >
										药品名：&nbsp;&nbsp;&nbsp;<select name="drug_id" style="width: 100px;"
											id="textfield">
											<c:forEach items="${drugList}" var="type" varStatus="st">
												<option value="${type.drug_id}">${type.drug_name1}</option>
											</c:forEach>
										</select>
									</div>
		<div>发药数量：<input type="text" name="amount" id="textfield3" onblur="num(this)">
					<label id="caution"></label></div>
		<div>药品总价：<label id="price"></label><input type="hidden" name="price" id="hidden"></input></div>
	    <div id="sub"><input type="submit" value="提交">&nbsp;<input type="reset" value="重置"></div>
	</form>
	</div>
	<script type="text/javascript">
	var r="";
	function num(node){
		var num=node.value
		var id=$("#textfield").val()
		
		if(id==""){
			alert("请输入药品ID")
		}
	
		if(num!=""){
			 $.ajax({
		          url: "<%=path%>/drugstore/checkNum.action",
		          type: "POST",
		          dataType: 'json', 
		          data: {
		            "amount": num,
		            "drug":id    
		          },		         
		          success: function(data) {   	  
		        	r=data.sum
		            $("#caution").html('剩余'+data.sum+data.unit)
		            var num=$("#textfield3").val()
		            var unit=data.price
		            var result=parseInt(num)*parseInt(unit)
		            $("#price").html(result+"元")
		            $("#hidden").val(data.price)
		          }  
		        });
		}
	}
		
		function confirm(){
			var temp=$("#caution").html()
			
			var input=$("#textfield3").val()
			if(temp!=""&&input!=""){			
			    var oldnum=parseInt(input)
			    var newnum=parseInt(r)
			    if(oldnum>newnum){
			    	alert("超出最大发药数量")
			    	return false;
			    }else{
			    	return true;
			    }
			} 
			alert("请输入数量")　
			return false
		}
	
	
	
	
	</script>
</body>
</html>

