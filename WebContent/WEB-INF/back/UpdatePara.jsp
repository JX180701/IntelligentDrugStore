<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>  
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/colorpicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/datepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/uniform.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-style2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-media.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-wysihtml5.css" />
<link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="<%=path %>Para/updatepara.action" method="get" class="form-horizontal">
            <div class="control-group">
              <label class="control-label">原参数ID :</label>
              <div class="controls">
                <input type="text" class="span11" name="para_id" id="para_id" value="${para.para_id }" />
             
                
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">原角父类ID :</label>
              <div class="controls">
                <input type="text" class="span11" name="parapid" id="parapid" value="${para.para_pid }"  />
                <label class="control-label">新父类ID :</label>
                <input type="text" class="span11" name="para_pid" id="para_pid" />
              </div>
            </div>
            
             <div class="control-group">
              <label class="control-label">原参数名 :</label>
              <div class="controls">
                <input type="text" class="span11" name="paraname" id="paraname" value="${para.para_name }"  />
              <label class="control-label">新参数名 :</label>
                <input type="text" class="span11" name="para_name" id="para_name" />
              </div>
            </div>
            
              <div class="control-group">
              <label class="control-label">原参数值 :</label>
              <div class="controls">
                <input type="text" class="span11" name="paravalue" id="paravalue" value="${para.para_value }"  />
              <label class="control-label">新参数值 :</label>
                <input type="text" class="span11" name="para_value" id="para_value" />
              </div>
            </div>
            
            
            
            
            
            
            
            
            
            
            
            
              <div >
              <button type="submit" class="btn btn-success">Save</button>
            </div>
            
</form>
</body>
</html>