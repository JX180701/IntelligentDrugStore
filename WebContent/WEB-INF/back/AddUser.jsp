<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<script type="text/javascript" >


</script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>用户注册页面</title>
	
</head>

<body>

    <legend>用户的注册区域</legend>
 <form action="<%=path %>User/insertuser.action" method="post">
    <table border="1" bordercolor="#0099ff" cellpadding="10px" cellspacing="0" name="reg">
        <tr>
            <th colspan="3">注册页面</th>
        </tr>
        <tr>
            <td>用户名：</td>
            <td>
                <input  type="text"id="user_name" name="user_name" value="" />
            </td>
            <td><font color="#FF0000">*不能以数字、下划线开头</font></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" id="user_pwd" name="user_pwd" />
                
            </td>
            <td><font color="#FF0000">*数字和字母的组合</font></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <input type="password" id="u_rpwd"name="r_upwd" />
            </td>
            <td><font color="#FF0000">*重新输入上面的密码</font></td>
        </tr>
        <tr>
          <td>角色：</td>
           <td>
            <input type="text"id="role_id"name="role_id"/>
          </td>
        
        </tr>
        
        <tr>
          <td>状态：</td>
            <td>
                <input type="radio" name=user_state value=启用 checked="checked"/>启用
                <input type="radio" name=user_state value=禁用 />禁用
            </td>
        
        </tr>
        
         <tr>
          <td>日期</td>
           <td>
            <input type="text"id="user_date"name="user_date"/>
          </td>
        
        </tr>
        
         <tr>
          <td>账号</td>
           <td>
            <input type="text"id="user_account"name="user_account"/>
          </td>
        
        </tr>
       
      
        
        
        
        
        
        
        
        <tr>
            <th colspan="3">
                 <input type="submit" onclick="checkData();" name="submit" value="提交"/>
                 
                <input type="reset" name="reset" value="重置" />
               <input type="submit"button name="test" value="验证"on onclick="checkData();" />
            </th>
        </tr>
    </table>
</form>
</fieldset>

</body>
</html>