<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>添加用户</title>
	</head>
	<body background="../assets/img/009_47.jpg">
		<CENTER>
			添加用户
			<br />
			<div align="center">
			<form action="reg" method="post" >
				<input name="userName" placeholder="用户名"/><br />
				<input name="nickName" placeholder="昵称"/><br />
				<input type="password" name="password" placeholder="密码" /><br />
				<input type="text" name="email" placeholder="Email"/><br />
				<input type="submit" value="添加" title="添加用户"/>
			</form>
			</div>
		</CENTER>
	</body>
</html>