<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.FirstMenu" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	ArrayList<FirstMenu> firstMenu = (ArrayList<FirstMenu>)session.getAttribute("firstMenu");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜单栏</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/Menu.css">
	
	<style type="text/css">
		.test ul{list-style:none;} 
		.test li{float:left;width:100px;background:#CCC;margin-left:3px;line-height:30px;} 
		.test a{display:block;text-align:center;height:30px;} 
		.test a:link{color:#666;background:url(arrow_off.gif) #CCC no-repeat 5px 12px;text-decoration:none;} 
		.test a:visited{color:#666;text-decoration:underline;} 
		.test a:hover{color:#FFF; font-weight:bold;text-decoration:none;background:url(arrow_on.gif) #F00 no-repeat 5px 12px;}  
	</style>

  </head>
  
  <body>
  	<div class="test">
	<ul>
		<%
			if(null == firstMenu)
			{
		 %>
		 	<script type="text/javascript">location="servlet/MenuServlet?op=firstMenuList";</script>
		<%
			}
			else
			{
				for(int i=0;i<firstMenu.size();i++)
				{
					FirstMenu fm = firstMenu.get(i);
		 %>
		 	<li><a href="#" ><%=fm.getName() %></a></li>
		 <%
		 		}
		 	}	
		  %>
	</ul>
	</div>
  </body>
</html>
