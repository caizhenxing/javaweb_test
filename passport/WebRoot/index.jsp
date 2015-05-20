<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String host = request.getRemoteHost();
	int port = request.getLocalPort();
	String user = request.getRemoteUser();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>欢迎来到通行证管理中心</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="通行证管理中心">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<body>
		<center>
			Welcome !
			<br>
			This is passport management center.
			<br>
			your host is : <%=host%>. port : <%=port%>. user : <%=user%> 
		</center>
	</body>
</html>
