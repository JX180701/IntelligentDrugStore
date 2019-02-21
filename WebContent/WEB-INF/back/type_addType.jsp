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

function typeExist(){
	var name = $("#type_name").val();
	var result = true;
	$.ajax({
		url:"<%=path%>/type/typeExist.action",
		data:{"type_name":name},
		type:"post",
		async:false,
		dataType:"text",
		success:function(data){
			if(data=="yes"){
				result = false;
				alert("该分类已存在!");
				doTTS();
			}
		}
	});
	return result;
}

function doTTS() {
	var ttsDiv = document.getElementById('bdtts_div_id');
	var ttsAudio = document.getElementById('tts_autio_id');
	var ttsText = "该分类已存在";

	ttsDiv.removeChild(ttsAudio);
	var au1 = '<audio id="tts_autio_id" autoplay="autoplay">';
	var sss = '<source id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=9&text='
			+ ttsText + '" type="audio/mpeg">';
	var eee = '<embed id="tts_embed_id" height="0" width="0" src="">';
	var au2 = '</audio>';
	ttsDiv.innerHTML = au1 + sss + eee + au2;

	ttsAudio = document.getElementById('tts_autio_id');
	ttsAudio.play();
}
</script>
<body>
	<div id="setType">
	<h2>药品分类设置</h2>
	<form action="<%=path%>/type/addType.action" method="post" onSubmit="return typeExist();">
<!-- 		<div>分类&nbsp;&nbsp;&nbsp;ID:<input type="text" name="type_id"></div> -->
	    <div>所属分类:<select name="type_pid" id="type_pid"></select>
	    </div>
	    <div>分类名称:<input type="text" name="type_name" id="type_name"> </div>
	    <div id="sub"><input type="submit" value="提交">&nbsp;
	    <a href="JavaScript:history.go(-1)"><input type="button" value="返回"></a>
	    </div>
	</form>
	</div>
	
	<div id="bdtts_div_id">
		<audio id="tts_autio_id" autoplay="autoplay">
		<source	id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=9" type="audio/mpeg">
		<embed id="tts_embed_id" height="0" width="0" src=""></audio>
	</div>
</body>

</html>
