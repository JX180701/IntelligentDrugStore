<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
#setType{width:60%;margin:100px auto;border:1px gray solid;padding:30px;}
h2{text-align:center}
#setType div{width:80%;margin-left:240px;}
#setType div input{margin-left:15px;}
#setType div select{margin-left:15px;width:170px;}
#setType input{margin-top:10px;}
#setType select{margin-top:10px;}
#sub{padding-left:100px;}
</style>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.cn.js"></script>
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
	$.ajax({
		url:"<%=path%>/type/findAllType.action",
		type:"post",
		contentType:"application/json;charset=utf-8",
		success:function(data){
			if(data!=""){
				$.each(data, function(commentIndex, comment){
					if(data[commentIndex].type_pid==0){
						$("#type_pid").append("<option value='"+data[commentIndex].type_id+"'>"+data[commentIndex].type_name+"</option>");
					}
               });
			}
		}
	});
});
</script>
<body>
	<div id="setType">
	<h2>药品分类设置</h2>
	<form action="<%=path%>/type/addType.action" method="post">
<!-- 		<div>分类&nbsp;&nbsp;&nbsp;ID:<input type="text" name="type_id"></div> -->
	    <div>所属分类:<select name="type_pid" id="type_pid"></select>
	    </div>
	    <div>分类名称:<input type="text" name="type_name"> </div>
	    <div id="sub"><input type="submit" value="提交">&nbsp;<input type="reset" value="重置"></div>
	</form>
	</div>
</body>

</html>
