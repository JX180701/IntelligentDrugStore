<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
#setDrug{width:70%;margin:5px auto;border:1px gray solid;padding:10px;}
h2{text-align:center}
#setDrug div{width:80%;margin-left:240px;}
#setDrug div input{margin-left:15px;}
#setDrug div select{margin-left:15px;width:170px;}
#setDrug input{margin-top:10px;}
#setDrug select{margin-top:10px;}
#sub{padding-left:100px;}
#direction div{margin-left:70px;width:350px;}
</style>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.cn.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$("form").validate({
		rules:{
			drug_name1:{
				required:true
			},
			drug_name2:{
				required:true
			},
			drug_unsalable:{
				required:true,
				digits:true
			},
			drug_standard:{
				required:true
			},
			drug_unit1:{
				required:true
			},
			drug_unit2:{
				required:true
			},
			drug_dosage:{
				required:true
			},
			drug_formula:{
				required:true,
				digits:true
			},
			price_cost:{
				required:true,
				number:true
			},
			direction_num:{
				required:true,
				digits:true
			},
			direction_time:{
				required:true,
				digits:true
			},
			direction_describe:{
				required:true
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
					if(data[commentIndex].type_pid!=0){
						$("#type_id").append("<option value='"+data[commentIndex].type_id+"'>"+data[commentIndex].type_name+"</option>");
					}
               });
			}
		}
	});
});
</script>
<body>
	<div id="setDrug">
	<h2>药品基本信息</h2>
	<form action="<%=path%>/drug/updateDrug.action" method="post">
		<div><input type="text" name="drug_id" value="${drug.drug_id }" style="display:none"></div>
		<div>药品名称:<input type="text" name="drug_name1" value="${drug.drug_name1 }"></div>
		<div>化学名称:<input type="text" name="drug_name2" value="${drug.drug_name2 }"></div>
		<div>滞销时长:<input type="text" name="drug_unsalable" value="${drug.drug_unsalable }">天</div>
		<div>药品规格:<input type="text" name="drug_standard" value="${drug.drug_standard }"></div>
		<div>药品剂型:<input type="text" name="drug_dosage" value="${drug.drug_dosage }"></div>
		<div><input type="text" name="price_id" value="${drug.price.price_id }" style="display:none"></div>
		<div>成本价格<input type="text" name="price_cost" value="${drug.price.price_cost }" >元</div>
		<div>药房单位:<input type="text" name="drug_unit1" value="${drug.drug_unit1 }"></div>
		<div>药库单位:<input type="text" name="drug_unit2" value="${drug.drug_unit2 }"></div>
		<div>换算公式:药房:药库=<input type="text" name="drug_formula" value="${drug.drug_formula }"></div>
		<div id="direction">用法用量:
			<div><input type="text" name="direction_id" value="${drug.direction.direction_id }" style="display:none"></div>
			<div>用量<input type="text" name="direction_num" value="${drug.direction.direction_num }"></div>
			<div>次数<input type="text" name="direction_time" value="${drug.direction.direction_time }">/日</div>
			<div>描述<input type="text" name="direction_describe" value="${drug.direction.direction_describe }"></div>
		</div>
		<div>特殊药品:<select name="drug_special">
			<c:if test="${drug.drug_special == 'no'}">
				<option value="no">否</option>
				<option value="yes">是</option>
			</c:if>
			<c:if test="${drug.drug_special == 'yes'}">
				<option value="yes">是</option>
				<option value="no">否</option>
			</c:if>
		</select></div>
		<div>抗生素&nbsp;&nbsp;&nbsp;:<select name="drug_antibiotic">
			<c:if test="${drug.drug_antibiotic == 'no'}">
				<option value="no">否</option>
				<option value="yes">是</option>
			</c:if>
			<c:if test="${drug.drug_antibiotic == 'yes'}">
				<option value="yes">是</option>
				<option value="no">否</option>
			</c:if>
		</select></div>
	    <div>所属分类:<select name="type_id" id="type_id">
	    	<option value="${drug.type.type_id }">${drug.type.type_name }</option>
	    </select>
	    </div>
	    <div id="sub"><input type="submit" value="提交">&nbsp;<a href="JavaScript:history.go(-1)"><input type="button" value="返回"></a></div>
	</form>
	</div>
</body>

</html>
