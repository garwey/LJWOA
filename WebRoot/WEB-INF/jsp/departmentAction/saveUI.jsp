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

<title>部门设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<div id="MainArea">
		<s:form action="department_%{id == null ? 'add' : 'edit'}">
			<s:hidden name="id"></s:hidden>
			<table cellpadding="0" cellspacing="0" class="mainForm">
				<tr>
					<td width="100">上级部门</td>
					<td><s:select name="parentId" list="#departmentList"
							listKey="id" listValue="name" headerKey=""
							headerValue="==请选择部门=="></s:select></td>
				</tr>
				<tr>
					<td>部门名称</td>
					<td><s:textfield name="name"></s:textfield></td>
				</tr>
				<tr>
					<td>职能说明</td>
					<td><s:textarea name="description"></s:textarea></td>
				</tr>
			</table>

			<div>
				<s:submit value="提交"></s:submit>
			</div>
		</s:form>
	</div>


</body>
</html>
