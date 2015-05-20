<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>用户列表</title>
	</head>
	<body background="../assets/img/009_47.jpg">
		<center>
			所有的用户:
			<br />
			<table border="1">

				<tr>
					<td>
						id
					</td>
					<td>
						用户名
					</td>
					<td>
						密码
					</td>
					<td>
						昵称
					</td>
					<td>
						邮箱
					</td>
					<td>
						操作
					</td>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>
							${user.id}
						</td>
						<td>
							${user.userName}
						</td>
						<td>
							${user.password}
						</td>
						<td>
							${user.nickName}
						</td>
						<td>
							${user.email}
						</td>
						<td>
							<a href="del.do?id=${user.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</center>
	</body>
</html>