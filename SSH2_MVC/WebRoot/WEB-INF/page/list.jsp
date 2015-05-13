<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title>用户列表</title>
	</head>
	<body>
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
				<c:iterator value="users">
					<tr>
						<td>
							<c:property value="id" />
						</td>
						<td>
							<c:property value="userName" />
						</td>
						<td>
							<c:property value="password" />
						</td>
						<td>
							<c:property value="nickName" />
						</td>
						<td>
							<c:property value="email" />
						</td>
						<td>
							<a href="action_del.do?user.id=<c:property value="id"/>">删除</a>
						</td>
					</tr>
				</c:iterator>
			</table>

		</center>
	</body>
</html>