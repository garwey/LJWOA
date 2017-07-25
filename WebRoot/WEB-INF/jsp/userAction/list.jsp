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

<title>用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<div id="MainArea">
		<table>
			<thead>
				<tr>
					<td width="80">登录名</td>
					<td width="80">姓名</td>
					<td width="80">姓别</td>
					<td width="80">所属部门</td>
					<td width="80">岗位</td>
					<td width="100">备注</td>
					<td>相关操作</td>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="#userList">
					<tr>
						<td>${loginName}</td>
						<td>${name}</td>
						<td>${gender}</td>
						<td>${department.name}</td>
						<td><s:iterator value="roles">
						${name}
						</s:iterator></td>
						<td>${description}</td>
						<td><s:a action="user_delete?id=%{id}"
								onclick="return window.confirm('您确定要删除吗？')">删除</s:a> <s:a
								action="user_editUI?id=%{id}">修改</s:a> <s:a
								action="user_initPassword?id=%{id}"
								onclick="return window.confirm('您确定要初始化密码为1234吗？')">初始化密码</s:a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>

	<div>
		<s:a action="user_addUI">添加用户</s:a>
	</div>
</body>
</html>
