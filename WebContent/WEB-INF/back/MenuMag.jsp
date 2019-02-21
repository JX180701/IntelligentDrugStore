<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>菜单管理</title>

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
      <h1>菜单管理</h1>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="span12">
       
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>菜单列表</h5>
          </div>
          <div class="widget-content nopadding">
          
            <table class="table table-bordered data-table">
              <thead>
               	<tr>
					<th>菜单ID</th>
					<th>菜单父类ID</th>
					<th>菜单名</th>
					<th>菜单路径</th>
					<th>操作</th>
				</tr>
              </thead>
              <tbody>
                <c:forEach var="c" items="${menulist}">
						<tr class="gradeX">
							<td>${c.menu_id }</td>
							<td>${c.menu_pid }</td>
							<td>${c.menu_name }</td>
							<td>${c.menu_url }</td>
							<td style="vertical-align: middle; text-align: center;">
								
								<button id="deleterole"  onclick="javascript:window.location.href='<%=path %>/Menu/deletemenu.action?mid=${c.menu_id}'"  class="btn btn-info">删除菜单</button>
								<button id="updaterole"  onclick="javascript:window.location.href='<%=path %>/Menu/findmenuinfo.action?mid=${c.menu_id}'"class="btn btn-success">修改菜单</button>

							</td>
						</tr>


					</c:forEach>
              </tbody>
            </table>
	            <div class="form-actions">
	            	<button id="addrole" onclick="addmenu()" class="btn btn-success" style="margin-top:4px;margin-right:5px"><i class="icon-plus-sign">&nbsp;增加菜单</i></button>
                </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>

<script src="http://www.jq22.com/jquery/jquery-1.7.1.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script> 
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script> 
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.js"></script> 
<script src="${pageContext.request.contextPath}/js/matrix.tables.js"></script>
<script type="text/javascript">
		function addmenu() {
			window.location.href ="<%=path %>/jsp/AddMenu.jsp" 
		}
	</script>
</html>