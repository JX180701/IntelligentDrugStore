<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>智慧药房</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/matrix-media.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" />
		<script src="<%=basePath %>js/d-toast.min.js" type="text/javascript" charset="UTF-8"></script>
    <script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.validate.cn.js"></script>
    <script type="text/javascript">
    $(function(){
        var num = '<%= session.getAttribute("newreqnum")%>';
        var roleid = '<%= session.getAttribute("role_id")%>';
        if(roleid == 3){
			var config={
				title:"新消息",//通知标题部分  默认 新消息   可选
				body:"你有"+num+"个新申请",//通知内容部分
				inner:true, // 是浏览器仿桌面通知 否首选桌面通知 默认否 可选
				onclick:function(data){ //监听点击通知   data:可传递参数 可选
// 					new dToast("仿桌面通知被点击了 传递参数："+data);
				},
// 				data:"我是仿桌面通知的参数",//可传递参数 可选
				timeout:10000 // 自动关闭 单位毫秒 默认 6500毫秒   timeout<=0 不自动关闭  可选
			}
			
// 			if(isShowIcon==true){
// 				config.icon="img/thumb-"+i+".jpg";//通知的图片 可选
// 			}
			
			//仿桌面通知
			new dToast(config);
        }
    	});
</script>
</head>
<body>
    <div id="header">
      <h1>智慧药房</h1>
      
    </div>
    <div id="user-nav" class="navbar navbar-inverse">
        <ul class="nav">
            <li class="dropdown" id="profile-messages" >
                <a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle">
                    <i class="icon icon-user"></i>&nbsp;
                    <span class="text">欢迎，${sessionScope.user.user_name}</span>&nbsp;
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="admin_code.jsp" target="view"><i class="icon-user"></i>修改密码</a></li>
                </ul>
            </li>
            <li class="">
            	<a title="" href="${pageContext.request.contextPath}/login.jsp" onclick="if(confirm('确认注销?')==false)return false;">
            		<i class="icon icon-share-alt"></i> 
            		<span class="text">&nbsp;注销</span>
            	</a>
            </li>
        </ul>
    </div>
    <div id="sidebar" style="OVERFLOW-Y: auto; OVERFLOW-X:hidden;">
        <ul>
            <li class="submenu active">
                <a class="menu_a" link=" ${pageContext.request.contextPath}/home.jsp">
                <i class="icon icon-home"></i> 
                <span>主页</span></a> 
            </li>
         	
         	<c:forEach items="${menuList}" var="menu" varStatus="vs">
        	<c:if test="${menu.menu_pid==0}">
            <li class="submenu">
				<a href="#">
                    <i class="icon icon-th"></i> 
                    <span>${menu.menu_name}</span>
                </a>
                <c:forEach items="${menuList}" var="menu1" >
                <c:if test="${menu1.menu_pid==menu.menu_id}">
					<ul>
                    <li><a class="menu_a" href="<%=path%>/${menu1.menu_url}" target="view"><i class="icon icon-caret-right"></i>${menu1.menu_name}</a></li>
                 	</ul>                   
                </c:if>
                </c:forEach>
            </li>
            </c:if>
            </c:forEach>
                       
        </ul>
    </div>
    <!--sidebar-menu-->

    <!--main-container-part-->
    <div id="content">
        <!--breadcrumbs-->
        <!--End-breadcrumbs-->
        <iframe src="${pageContext.request.contextPath}/home.jsp" name="view" id="iframe-main" frameborder='0' style="width:100%;"></iframe>
    </div>
    <!--end-main-container-part-->

 
</body>
    <script src="${pageContext.request.contextPath}/js/excanvas.min.js"></script> 
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script> 
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> 
    <script src="${pageContext.request.contextPath}/js/nicescroll/jquery.nicescroll.min.js"></script> 
    <script src="${pageContext.request.contextPath}/js/matrix.js"></script> 
    <script type="text/javascript">
    
    //初始化相关元素高度
    function init(){
        $("body").height($(window).height()-80);
        $("#iframe-main").height($(window).height()-90);
        $("#sidebar").height($(window).height()-50);
    }

    $(function(){
        init();
        $(window).resize(function(){
            init();
        });
    });

    // This function is called from the pop-up menus to transfer to
    // a different page. Ignore if the value returned is a null string:
    function goPage (newURL) {
        // if url is empty, skip the menu dividers and reset the menu selection to default
        if (newURL != "") {
            // if url is "-", it is this page -- reset the menu:
            if (newURL == "-" ) {
                resetMenu();            
            } 
            // else, send page to designated URL            
            else {  
                document.location.href = newURL;
            }
        }
    }

    // resets the menu selection upon entry to this page:
    function resetMenu() {
        document.gomenu.selector.selectedIndex = 2;
    }

    // uniform使用示例：
    // $.uniform.update($(this).attr("checked", true));
    </script>
</html>
