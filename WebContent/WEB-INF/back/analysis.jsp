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
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="<%=basePath%>js/highcharts.js"></script>
<script src="<%=basePath%>js/data.js"></script>
<script src="<%=basePath%>js/series-label.js"></script>
<script src="<%=basePath%>js/exporting.js"></script>
<script src="<%=basePath%>js/export-data.js"></script>
<script src="https://www.highcharts.com/media/com_demo/js/highslide-full.min.js"></script>
<script src="https://www.highcharts.com/media/com_demo/js/highslide.config.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="https://www.highcharts.com/media/com_demo/css/highslide.css" />
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
<!-- 	<h2>销量预测</h2> -->
	<form action="<%=path%>/drugstore/sendDrug.action" method="post" >
	<div >
										药品名：<select name="drug_id" style="width: 100px;"
											id="firstId" onchange="num(this)">
											<c:forEach items="${drugList}" var="type" varStatus="st">
												<option value="${type.drug_id}">${type.drug_name1}</option>
											</c:forEach>
										</select>
									</div>
<!-- 		<div>药品ID:&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="drug_id" id="textfield" onblur="num(this)"></div> -->
<!-- 		<div>下月预测销量：<label id="price"></label></div> -->
		
<!-- 	    <div id="sub"><input type="submit" value="提交">&nbsp;<input type="reset" value="重置"></div> -->
	</form>
	</div>
	<script type="text/javascript">
	 
	var timeArray = new Array();
	
	var chart;
	var series = [];
	var titleY = "";
	var temp
	 
	function num(node){
		
		var id=$("#firstId").val()
		temp=$("#firstId option:selected").text()
		
		if(id==""){
			alert("请输入药品ID")
		}
	
		
			 $.ajax({
		          url: "<%=path%>/drugstore/checkAnalysis.action",
		          type: "POST",
		          data: {
		            "drug":id
		          },    
		          success: function(data) {
		        	var countArray = new Array();
		        	var symbol=new Array();
					redata=JSON.parse(data);
					 for(var j=0;j<redata.length;j++){
						  if(j!=redata.length-1){
							  if(redata[j]!=null){
								  
						  	countArray.push(parseInt(redata[j]));
							  }else{
								  countArray.push(0)
							  }
						  }else{
							  array={
						            y: parseInt(redata[j]),
						            marker: {
						                symbol: 'url(https://www.highcharts.com/samples/graphics/sun.png)'
						            }
							  };
						            countArray.push(array);     
						  }
					  } 
					 
					 
					 series[0] = {
							 name:temp,
						     marker: {
						         symbol: 'circle'
						     },
						     data: countArray 
						  };


					
		            drawLine()
		          }
		        });
	
	}
	
	
	</script>
	
	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>



		<script type="text/javascript">
		
		$(document).ready(function(){
            
		    drawLine()
		}); 
		
		function drawLine(){
			Highcharts.chart('container', {
			    chart: {
			        type: 'line'
			    },
			    title: {
			        text: temp+'销量预测'
			    },
			    subtitle: {
			        text: 'Source: IntelligentDrugStore'
			    },
			    xAxis: {
			        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
			    },
			    yAxis: {
			        title: {
			            text: '单位'
			        }
			    },
			    plotOptions: {
			        line: {
			            dataLabels: {
			                enabled: true
			            },
			            enableMouseTracking: false
			        }
			    },
			    series: series
			});
		}
		
		</script>
</body>
</html>