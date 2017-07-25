<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>岗位列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div>
		<table>
			<thead>
				<tr>
					<td width="150px">岗位名称</td>
					<td width="200px">岗位说明</td>
					<td>相关操作</td>
				</tr>
			</thead>

			<tbody>
				<s:iterator value="#roleList">
					<tr>
						<td>${name}&nbsp;</td>
						<td>${description}&nbsp;</td>
						<td><s:a action="role_delete?id=%{id}"
								onclick="return window.confirm('确定要删除吗？')">删除</s:a> <s:a
								action="role_editUI?id=%{id}">修改</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
			<tr></tr>
		</table>
	</div>
	<div>
		<s:a action="role_addUI">添加岗位</s:a>
	</div>
</body>
</html>
