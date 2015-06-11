<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>所有的书</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="全部的书">
		<link rel="stylesheet" type="text/css" href="assets/css/table.css">

		<script src="assets/js/jquery-1.8.2.min.js">
</script>
		<script src="assets/js/book_list.js">
</script>
	</head>

	<body>
		<div>
			<form>
				<input id="len" type="hidden" name="len" value="${page.len}">
				<input id="off" type="hidden" name="off" value="${page.off}">
				<input id="basePath" type="hidden" value="<%=basePath%>" />
			</form>
		</div>
		<center>
			<div style="width:98%">
				<h1>
					所有的书
				</h1>
				<br>
				<table id="book_list_table" class="hovertable" width="100%">
					<th>
						ID
					</th>
					<th>
						书名
					</th>
					<th>
						操作
					</th>

				</table>

			</div>
			<input type="button" value="上一页" id="booklist_beforePage">
			<input type="button" value="下一页" id="booklist_nextPage">
	</body>
	</center>


</html>
