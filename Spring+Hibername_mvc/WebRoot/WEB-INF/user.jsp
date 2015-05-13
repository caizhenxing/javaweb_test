<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="dd"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>用户信息</title>
	</head>
	<body>

		<table border="1" align="center">
			<tr>
				<td>
					昵称
				</td>
				<td>
					用户名
				</td>
				<td>
					密码
				</td>
			</tr>
			<dd:forEach items="${user}" var="u">
				<tr>
					<td>
						${u.nickName }
					</td>
					<td>
						${u.userName}
					</td>
					<td>
						${u.password}
					</td>
				</tr>
			</dd:forEach>


		</table>

	</body>
</html>