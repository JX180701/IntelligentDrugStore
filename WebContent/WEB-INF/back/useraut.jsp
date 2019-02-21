<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.ArrayList,org.great.entity.User"
    pageEncoding="utf-8"%>
  <%
  	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
    	+ request.getContextPath() + "/";
  %>  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>

<body>
 <form action="<%=path%>/User/specificfind.action" method="post">
  <p>&nbsp;</p>
  <p>查询条件：</p>
  <p>人员姓名：
    <input type="text"style="width:140px; height:30px;" name="user_name" id="user_name" /> 

 
  <p>角色：
    <select name="role_name" style="width:140px; height:40px;id="role">
     <option value=""></option>
      <option value="">管理员</option>
      
      <option value = "">药房</option>
     
       <option value = "">药库</option>
      
    </select>
    
    状态：
    <select name="user_state" style="width:140px; height:40px; " id="rolestate">
     
      <option value="启用">启用</option>
      <option value="禁用">禁用</option>
    </select>
  </p>
  <p>&nbsp;</p>
 
  <p align="left">
 <!--  <input type="hidden" name="action" value="query"/> -->
     <input type="submit" value="提交">
  </p>
</form>
    <a href="<%=path %>jsp/AddUser.jsp">
    <submit>增加</submit>
  <table width="800" border="1">
    <tr>
      <td>ID</td>
      <td>人员姓名</td>
      <td>密码</td>
      <td>角色</td>
      <td>状态</td>
      <td>日期</td>
      <td>账号</td>
    </tr>
     <c:forEach var="c" items = "${useraut}">
     <tr>
      <td align="center" >${c.user_id }</td>	
      <td align="center" >${c.user_name }</td>
      <td align="center" >${c.user_pwd }</td>
      <td align="center" >${c.role.role_name }</td>
        <td align="center" >${c.user_state }</td>
      <td align="center" >${c.user_date }</td>
       <td align="center" >${c.user_account }</td>
        
     
        <td align="center" ><a href="<%=path%>/User/deleteuser.action?uid=${c.user_id }"  target="tab">删除</a>|
     
         
          
             
      
          
    </tr>
    </c:forEach>
   
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
  <p align="left">&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
</body>
</html>