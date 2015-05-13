<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>用户详情</title>
	</head>
	<body>
		<center>
			<br />
			id =
			<c:property value="user.id" />
			userName =
			<c:property value="user.userName" />
			password =
			<c:property value="user.password" />
			nickname =
			<c:property value="user.nickName" />
			<br />
		</center>
	</body>
</html>