<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>药品信息统计</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsapi.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/corechart.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.ba-resize.min.js"></script>
<style>
#insurance {
	display: none
}
#antibiotic {
	display: none
}
#special {
	display: none
}
#selectType{margin-left:50px;margin-top:50px;}
</style>
<script type="text/javascript">
	$("#insurance").hide();
	function showOther() {
		$("#insurance").hide();
		$("#prescription").hide();
		$("#antibiotic").hide();
		$("#special").hide();
		var type = $("select").val();
		$("#" + type).show();
	}

	gvChartInit();
	$(document).ready(function() {
		$('#prescriptionTable').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 600,
				height : 350
			}
		});
		
		$('#insuranceTalbe').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 600,
				height : 350
			}
		});
		
		$('#specialTalbe').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 600,
				height : 350
			}
		});
		
		$('#antibioticTalbe').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 600,
				height : 350
			}
		});
	});
</script>
</head>
<body>
	<select name="type" onchange="javascript:showOther();" id="selectType">
		<option value="prescription">处方药品</option>
		<option value="insurance">医保药品</option>
		<option value="special">特殊药品</option>
		<option value="antibiotic">抗生素</option>
	</select>
	<div style="width: 600px; margin: 0 auto;">
		<div id='prescription'>
			<table id='prescriptionTable'>
				<caption>处方药品/非处方药品</caption>
				<thead>
					<tr>
						<th></th>
						<th>处方药品</th>
						<th>非处方药品</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>${prescription+unprescription}</th>
						<td>${prescription}</td>
						<td>${unprescription}</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div id='insurance'>
			<table id='insuranceTalbe'>
				<caption>医保药/非医保药</caption>
				<thead>
					<tr>
						<th></th>
						<th>医保药</th>
						<th>非医保药</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>${insurance+uninsurance}</th>
						<td>${insurance}</td>
						<td>${uninsurance}</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div id='special'>
			<table id='specialTalbe'>
				<caption>特殊药品/普通药品</caption>
				<thead>
					<tr>
						<th></th>
						<th>特殊药品</th>
						<th>普通药品</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>${special+unantibiotic}</th>
						<td>${special}</td>
						<td>${unantibiotic}</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div id='antibiotic'>
			<table id='antibioticTalbe'>
				<caption>抗生素/非抗生素</caption>
				<thead>
					<tr>
						<th></th>
						<th>抗生素</th>
						<th>非抗生素</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>${antibiotic+unantibiotic}</th>
						<td>${antibiotic}</td>
						<td>${unantibiotic}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>