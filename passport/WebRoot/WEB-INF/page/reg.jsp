<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String date = new Date().toString();
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript">
addEventListener("load", function() {
	setTimeout(hideURLbar, 0);
}, false);
function hideURLbar() {
	window.scrollTo(0, 1);
}</script>
		<!--webfonts-->
		<!--//webfonts-->
	</head>
	<body>
		<center>
			<div class="header">
				<h1>
					添加用户
				</h1>
			</div>
			<form action="" method="post">
				<input type="text" name="userName" placeholder="用户名" required />

				<input type="password" name="nickName" placeholder="昵称" required />

				<input type="text" name="email" placeholder="邮件" required />

				<input type="password" name="password" placeholder="密码" required />

				<!--<label class="checkbox">-->
				<!--<input type="checkbox" name="checkbox" checked="">-->
				<!--<i> </i>-->
				<!--</label>-->
				<br />
				<input type="submit" value="添加">
				</div>

			</form>

			<!-----start-copyright---->
			<div class="copy-right">
				<p>
					com.passport.y0 2015
					<a href="#" target="_blank" title="/index.jsp">é¦é¡µ</a>
				</p>
				<!-----//end-copyright---->
		</center>
	</body>
</html>