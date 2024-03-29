<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String date = new Date().toString();
%>

<!DOCTYPE html>
<html lang="en" class="no-js">

	<head>
		<meta charset="utf-8">
		<title>登陆</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- CSS -->
		<link rel="stylesheet" href="../assets/css/reset.css">
		<link rel="stylesheet" href="../assets/css/supersized.css">
		<link rel="stylesheet" href="../assets/css/style.css">

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

	</head>

	<body>

		<div class="page-container">
			<h1>
				登陆
			</h1>
			<form action="login.do" method="post">
				<input type="text" name="userName" class="username"
					placeholder="用户名" required>
				<input type="password" name="password" class="password"
					placeholder="密码" required>
				<button type="submit">
					登陆
				</button>
				<div class="error">
					<span>+</span>
				</div>
			</form>
			<!--class="connect"-->
			<div>
				<br />
				<p>
					<a href="regView.do">注册用户</a>|
					<!--<a href="#">忘记密码</a>-->
				</p>
			</div>
		</div>
		<div align="center">
			<br />
			<%=date%>
		</div>
		<br />
		<%=basePath%>
		<!-- Javascript -->
		<script src="../assets/js/jquery-1.8.2.min.js">
</script>
		<script src="../assets/js/supersized.3.2.7.min.js">
</script>
		<script src="../assets/js/supersized-init.js">
</script>
		<script src="../assets/js/scripts.js">
</script>

	</body>

</html>

