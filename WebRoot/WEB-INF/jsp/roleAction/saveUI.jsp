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

<title>岗位设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<s:form action="role_%{id == null ? 'add' : 'edit'}">
		<s:hidden name="id"></s:hidden>

		<table>
			<tr>
				<td>岗位名称</td>
				<td><s:textfield name="name" /></td>
			</tr>
			<tr>
				<td>岗位说明</td>
				<td><s:textfield name="description" /></td>
			</tr>
		</table>

		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>
