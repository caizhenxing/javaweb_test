<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>添加用户</title>
	</head>
	<body background="../assets/img/008_36.jpg">
		<CENTER>
			添加用户
			<br />
			<div align="center">
			<c:form action="action_add" namespace="/user">
				<input name="user.userName" placeholder="用户名"/><br />
				<input name="user.nickName" placeholder="昵称"/><br />
				<input name="user.password" placeholder="密码" /><br />
				<input type="text" name="user.email" placeholder="Email"/><br />
				<input type="submit" value="添加" title="添加用户"/>
			</c:form>
			</div>
		</CENTER>
	</body>
</html>