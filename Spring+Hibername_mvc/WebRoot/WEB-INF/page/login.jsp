<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>登陆</title>
	</head>
	<body background="../assets/img/008_36.jpg">
		<CENTER>
			登陆
			<br />
			<div align="center">
			<form action="action_login">
				<input name="user.userName" placeholder="用户名"/><br />
				<input name="user.password" type="password" placeholder="密码" /><br />
				<input type="submit" value="登陆" title="登陆"/>
			</form>
			</div>
		</CENTER>
	</body>
</html>