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
#setDrug{width:60%;margin:5px auto;border:1px gray solid;padding:10px;}
h2{text-align:center}
#addInsurance div{width:80%;margin-left:450px;margin-top:50px;}
#addInsurance div input{margin-left:15px;}
</style>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.cn.js"></script>
</head>
<script type="text/javascript">
$(function(){
	$("form").validate({
		rules:{
			drug_name:{
				required:true
			},
			insurance_code:{
				required:true
			}
		}
	});
	
});
// 查询医保是否存在
function insuranceExist(){
	var name = $("#drug_name").val();
	var result = true;
	$.ajax({
		url:"<%=path%>/insurance/insuranceExist.action",
		data:{"drug_name":name},
		type:"post",
		async:false,
		dataType:"text",
		success:function(data){
			if(data=="yes"){
				result = false;
				alert("该药品已经是医保药品!");
				doTTS();
			}
		}
	});
	return result;
}

function doTTS() {
	var ttsDiv = document.getElementById('bdtts_div_id');
	var ttsAudio = document.getElementById('tts_autio_id');
	var ttsText = "该药品已经是医保药品";

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
	<div id="addInsurance">
	<h2>药品基本信息</h2>
	<form action="<%=path%>/insurance/addInsurance.action" method="post" onSubmit="return insuranceExist();">
		<div>药品名称:<input type="text" name="drug_name" id="drug_name"></div>
		<div>医保编号:<input type="text" name="insurance_code"></div>
		
	    <div id="sub"><input type="submit" value="提交">&nbsp;<a href="JavaScript:history.go(-1)"><input type="button" value="返回"></a></div>
	</form>
	</div>
	
	<div id="bdtts_div_id">
		<audio id="tts_autio_id" autoplay="autoplay">
		<source	id="tts_source_id" src="http://tts.baidu.com/text2audio?lan=zh&ie=UTF-8&spd=9" type="audio/mpeg">
		<embed id="tts_embed_id" height="0" width="0" src=""></audio>
	</div>
</body>

</html>
