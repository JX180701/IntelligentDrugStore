<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Matrix Admin</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uniform.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-style2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-media.css" />
<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
</head>
<body>

<div id="content">
  <div id="content-header">
      <h1>参数管理</h1>
  </div>
  <div class="container-fluid">
    
      <div class="row-fluid">
        <div class="span12">
          <div class="widget-box">
            <div class="widget-title"> <span class="icon"> <i class="icon-info-sign"></i> </span>
              <h5>添加参数</h5>
            </div>
            <div class="widget-content nopadding">
            
              <form class="form-horizontal" action="<%=path %>Para/insertpara.action" method="get" class="form-horizontal">
            
			            <div class="control-group">
			              <label class="control-label">参数类型:</label>
			              <div class="controls">
			               <select class="DataInput" name="para_type" id="para_type" style="margin-top:5px;width:220px">
		                    	<c:forEach items="${xxxx}" var="p" varStatus="st">
				        			<option value="${p.xxxx}">${p.xxxx}</option>
		        				</c:forEach>
		        			</select>
			              </div>
			            </div>
			            <div class="control-group">
			              <label class="control-label">参数名:</label>
			              <div class="controls">
			                <input type="text" name="para_name" />
			              </div>
			            </div>
			            
			             <div class="control-group">
			              <label class="control-label">参数值 :</label>
			              <div class="controls">
			                <input type="text" name="para_value" />
			              </div>
			            </div>
                <div class="form-actions">
                  <input type="submit"  value="保存" class="btn btn-success">
                  <input type="button" onclick="javascript:history.back(-1);" value="返回" class="btn btn-success">
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/excanvas.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script> 
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script> 
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.form_validation.js"></script>
<script>

</script>
</html>