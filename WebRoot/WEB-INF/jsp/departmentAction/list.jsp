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

<title>部门列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div id="MainArea">
		<table class="TableStyle">
			<!-- 表头-->
			<thead>
				<tr id="TableTitle">
					<td width="150px">部门名称</td>
					<td width="150px">上级部门名称</td>
					<td width="200px">职能说明</td>
					<td>相关操作</td>
				</tr>
			</thead>
			<!--显示数据列表-->
			<tbody id="TableData" class="dataContainer" datakey="departmentList">
				<s:iterator value="#departmentList">
					<tr class="TableDetail template">
						<td><s:a action="department_list?parentId=%{id}">${name}</s:a>&nbsp;</td>
						<td>${parent.name}&nbsp;</td>
						<td>${description}&nbsp;</td>
						<td><s:a action="department_delete?id=%{id}"
								onclick="return window.confirm('这将删除所有的下级部门，您确定要删除吗？')">删除</s:a>
							<s:a action="department_editUI?id=%{id}">修改</s:a></td>
					</tr>
				</s:iterator>
			</tbody>
			<tr></tr>
			<tr></tr>
			<tr></tr>
		</table>
	</div>
	<div>
		<s:a action="department_addUI">添加部门
			</s:a>
	</div>
</body>
</html>
