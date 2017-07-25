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

<title>用户设置</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<s:form action="user_%{id == null ? 'add' : 'edit'}">
		<s:hidden name="id"></s:hidden>
		<div>用户信息</div>
		<table>
			<tr>
				<td>所属部门</td>
				<td><s:select name="departmentId" list="#departmentList"
						listKey="id" listValue="name" headerKey="" headerValue="==请选择部门==" /></td>
			</tr>
			<tr>
				<td>登录名</td>
				<td><s:textfield name="loginName" /></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><s:textfield name="name" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><s:radio name="gender" list="{'男', '女'}"></s:radio></td>
			</tr>
			<tr>
				<td>联系电话</td>
				<td><s:textfield name="phoneNumber" /></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><s:textfield name="email" /></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><s:textarea name="description"></s:textarea></td>
			</tr>
		</table>
		<div>岗位设置</div>
		<table cellpadding="0" cellspacing="0" class="mainForm">
			<tr>
				<td width="100">岗位</td>
				<td><s:select name="roleIds" multiple="true" size="10"
						list="#roleList" listKey="id" listValue="name" />
			</tr>
			<tr>
				<td> </td>
				<td>按住Ctrl键可以多选或取消选择</td>
			</tr>
		</table>
		<s:submit value="提交"></s:submit>
	</s:form>
</body>
</html>
