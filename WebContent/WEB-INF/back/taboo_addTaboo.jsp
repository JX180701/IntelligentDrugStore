<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
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

textarea {
	margin-left: 80px;
}
</style>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.validate.cn.js"></script>
<script type="text/javascript">
function tabooExist(){
	var drug_id1 = $("#drug_id1").val();
	var drug_id2 = $("#drug_id2").val();
	var taboo_discribe = $("#taboo_discribe").val();
	var result = true;
	if(drug_id1==drug_id2){
		alert("请选择两种不同的药品！");
		return false;
	}
	$.ajax({
		url:"<%=path%>/taboo/tabooExist.action",
			data : {
				"drug_id1" : drug_id1,
				"drug_id2" : drug_id2
			},
			type : "post",
			async : false,
			dataType : "text",
			success : function(data) {
				if (data == "yes") {
					result = false;
					alert("该禁忌已存在!");
					doTTS();
				}
			}
		});
		if (result == true) {
			if (taboo_discribe == "") {
				alert("请输入描述！");
				return false;
			}
		}

		return result;
	}

	function doTTS() {
		var ttsDiv = document.getElementById('bdtts_div_id');
		var ttsAudio = document.getElementById('tts_autio_id');
		var ttsText = "该禁忌已存在";

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
</head>
<body>
	<div id="setTaboo">
		<h2>配伍禁忌</h2>
		<form action="<%=path%>/taboo/appendTaboo.action" method="post"
			onSubmit="return tabooExist();">
			<div>
				药品一: <select name="drug_id1" id="drug_id1">
					<c:forEach items="${drugs }" varStatus="i" var="item">
						<option value="${item.drug_id}">${item.drug_name1}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				药品二: <select name="drug_id2" id="drug_id2">
					<c:forEach items="${drugs }" varStatus="i" var="item">
						<option value="${item.drug_id}">${item.drug_name1}</option>
					</c:forEach>
				</select>
			</div>
			<div>
				说明：<br>
				<textarea name="taboo_discribe" id="taboo_discribe"></textarea>
			</div>
			<div id="sub">
				<input type="submit" value="提交" id="subTaboo"> <a
					href="<%=path%>/taboo/findAllTaboo.action?page=taboo_search"><button
						type="button">返回</button></a>
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
