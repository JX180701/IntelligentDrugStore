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
	 
	function num(node){
		
		var id=$("#textfield").val()
		alert(id)
		if(id==""){
			alert("请输入药品ID")
		}
	
		if(num!=""){
			 $.ajax({
		          url: "<%=path%>/drugstore/checkAnalysis.action",
		          type: "POST",
		          data: {
		            "drug":id
		          },    
		          success: function(data) {
		            $("#price").html(data)
		          }
		        });
		}
	}
	
	
	</script>
	
	<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>



		<script type="text/javascript">

Highcharts.chart('container', {

    chart: {
        scrollablePlotArea: {
            minWidth: 700
        }
    },

    data: {
        csvURL: 'https://cdn.jsdelivr.net/gh/highcharts/highcharts@v7.0.0/samples/data/analytics.csv',
        beforeParse: function (csv) {
            return csv.replace(/\n\n/g, '\n');
        }
    },

    title: {
        text: '销量预测'
    },

    subtitle: {
        text: 'Source: Google Analytics'
    },

    xAxis: {
        tickInterval: 7 * 24 * 3600 * 1000, // one week
        tickWidth: 0,
        gridLineWidth: 1,
        labels: {
            align: 'left',
            x: 3,
            y: -3
        }
    },

    yAxis: [{ // left y axis
        title: {
            text: null
        },
        labels: {
            align: 'left',
            x: 3,
            y: 16,
            format: '{value:.,0f}'
        },
        showFirstLabel: false
    }, { // right y axis
        linkedTo: 0,
        gridLineWidth: 0,
        opposite: true,
        title: {
            text: null
        },
        labels: {
            align: 'right',
            x: -3,
            y: 16,
            format: '{value:.,0f}'
        },
        showFirstLabel: false
    }],

    legend: {
        align: 'left',
        verticalAlign: 'top',
        borderWidth: 0
    },

    tooltip: {
        shared: true,
        crosshairs: true
    },

    plotOptions: {
        series: {
            cursor: 'pointer',
            point: {
                events: {
                    click: function (e) {
                        hs.htmlExpand(null, {
                            pageOrigin: {
                                x: e.pageX || e.clientX,
                                y: e.pageY || e.clientY
                            },
                            headingText: this.series.name,
                            maincontentText: Highcharts.dateFormat('%A, %b %e, %Y', this.x) + ':<br/> ' +
                                this.y + ' sessions',
                            width: 200
                        });
                    }
                }
            },
            marker: {
                lineWidth: 1
            }
        }
    },

    series: [{
        name: 'All sessions',
        lineWidth: 4,
        marker: {
            radius: 4
        }
    }, {
        name: 'New users'
    }]
});

		</script>
</body>
</html>