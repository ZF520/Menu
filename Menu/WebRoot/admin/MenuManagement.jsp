<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.FirstMenu,entity.SecondMenu" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	ArrayList<FirstMenu> firstMenu = (ArrayList<FirstMenu>)session.getAttribute("firstMenu");
	ArrayList<SecondMenu> secondMenu = (ArrayList<SecondMenu>)session.getAttribute("secondMenu");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>菜单管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
		function addFirstMenu()
		{
			var value=document.getElementById('addFM').value;
			location="servlet/MenuServlet?op=addFirstMenu&addFirstMenu="+value;
		}
		function modFirstMenu(id)
		{
			var name=prompt("请输入新的一级菜单名称","");
			location="servlet/MenuServlet?op=modFirstMenu&id="+id+"&name="+name;
		}
		function delFirstMenu(id)
		{
			if(confirm("确定要删除吗？"))
			{
				location="servlet/MenuServlet?op=delFirstMenu&id="+id;
			}
		}
		function addSecondMenu()
		{
			var value=document.getElementById('addSM').value;
			location="servlet/MenuServlet?op=addSecondMenu&addSecondMenu="+value;
		}
		function modSecondMenu(id)
		{
			var name=prompt("请输入新的二级菜单名称","");
			location="servlet/MenuServlet?op=modSecondMenu&id="+id+"&name="+name;
		}
		function delSecondMenu(id)
		{
			if(confirm("确定要删除吗？"))
			{
				location="servlet/MenuServlet?op=delSecondMenu&id="+id;
			}
		}
		function sortID()
		{
			location="servlet/MenuServlet?op=sortID";
		}
	</script>
  </head>
  
  <body>
	<h1>菜单管理</h1>
	<h2>一级菜单</h2>
	
	<div>
	<form>
		<span>添加一级菜单</span><input type="text" name="addFM" id="addFM" />&nbsp;
		<input type="button" value="添加" onClick="addFirstMenu()">
	</form>
	</div>
	
	<div>
		<span>ID排序(还没弄好)</span><input type="button" value="排序" onClick="sortID()">
	</div>
	
	<div>
	<table border="1">
		<tr>
			<td></td>
			<td>ID</td>
			<td>名称</td>
			<td>操作</td>
		</tr>
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
		 <tr>
		 	<td><input type="checkbox" name="first" /></td>
		 	<td><%=fm.getId() %></td>
		 	<td><%=fm.getName() %></td>
		 	<td>
		 		<a href="javascript:modFirstMenu(<%=fm.getId()%>)">修改</a>
		 		<a href="javascript:delFirstMenu(<%=fm.getId() %>)">删除</a>
		 	</td>
		 </tr>
		 <%
		 		}
		 	}	
		  %>
	</table>
	</div>
	
	<h2>二级菜单</h2>
	
	<div>
	<form>
		<span>添加二级菜单</span><input type="text" name="addSM" id="addSM" />&nbsp;
		<input type="button" value="添加" onClick="addSecondMenu()">
	</form>
	</div>
	
	<table border="1">
		<tr>
			<td></td>
			<td>ID</td>
			<td>名称</td>
			<td>主菜单</td>
			<td>操作</td>
		</tr>
		<%
			if(null == secondMenu)
			{
		 %>
		 <script type="text/javascript">location="servlet/MenuServlet?op=secondMenuList";</script>
		 <%
		 	}
		 	else
		 	{
		 		for(int j=0; j<secondMenu.size(); j++)
		 		{
		 			SecondMenu sm = secondMenu.get(j);
		  %>
		  <tr>
		 	<td><input type="checkbox" name="second" /></td>
		 	<td><%=sm.getId() %></td>
		 	<td><%=sm.getName() %></td>
		 	<td><%=sm.getMaster() %></td>
		 	<td>
		 		<a href="javascript:modSecondMenu(<%=sm.getId()%>)">修改</a>
		 		<a href="javascript:delSecondMenu(<%=sm.getId() %>)">删除</a>
		 	</td>
		 </tr>
		  <%
		  		}
		  	}
		   %>
	</table>
	
	
  </body>
</html>
