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

		<title>${book.name}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="${book.name} ">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script src="assets/js/jquery-1.8.2.min.js">
</script>
		<script src="assets/js/jquery.base64.js">
</script>
		<script src="assets/js/book_content.js">
</script>

	</head>

	<body>
		<CENTER>
			<div>
				<form>
					<input id="len" type="hidden" name="len" value="${page.len}">
					<input id="off" type="hidden" name="off" value="${page.off}">
					<input id="bookid" type="hidden" name="bookid"
						value="${book.bookid}">
					<input id="basePath" type="hidden" value="<%=basePath%>" />
				</form>
			</div>
			<div style="width: 100%">
				<br />
				<div id="part">
					<!--<h1>文章第<c:out value="${page.off}"/>部分,长度<c:out value="${page.len}"/></h1>-->
					<c:out value="${part}"></c:out>
				</div>
				<br />
				<div>
					<!--<a href="book/books.do">-->
					<input id="mainpage" type="button" value="书列表">
					<!--</a>|-->
					<input id="beforepage" type="button" value="上一页">
					<input id="nextpage" type="button" value="下一页">
					<input id="pagenum" type="text" value="0" width="10%">
					<input id="gotopage" type="button" value="跳转">
				</div>
			</div>
		</CENTER>
	</body>

</html>
