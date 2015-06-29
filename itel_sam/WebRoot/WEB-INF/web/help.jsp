<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itel.domain.*"%>
<%@ page import="java.util.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet"
			href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
		<link rel="stylesheet"
			href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap-theme.min.css">
		<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
		<script
			src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<title>帮助</title>
		<style>
body {
	background-color: #202028;
	padding-top: 10px
}

.conmain {
	background-color: #2c2c33;
	border: 1px solid #494949;
	-moz-border-radius: 10px; /* Gecko browsers */
	-webkit-border-radius: 10px; /* Webkit browsers */
	border-radius: 10px; /* W3C syntax */
}

.text-info {
	text-align: center;
}

.rowtitle {
	background-color: #2c2c33;
	border-bottom: 1px solid #18181a;
	border-top: 1px solid #38383b;
	color: #FFFFFF;
	padding: 10px;
}

.rowcontent {
	border-top: 1px solid #38383b;
	border-bottom: 1px solid #18181a;
	color: #a6a9af;
}
</style>
	</head>

	<body>
		<!---/主要区域/--->
		<div class="container conmain">
			<%
				List<SamHelpCenter> list = (List<SamHelpCenter>)request.getAttribute("list");
				if (list != null) {
					for (SamHelpCenter samHelpCenter : list) {
			%>
			<div class="row">
				<div class="col-xs-12 col-md-12">
					<div class="rowtitle">
						<%=samHelpCenter.getTitle()%>
					</div>
					<div class="rowcontent">
						 
						<p>
							<%=samHelpCenter.getContent()%>
						</p>
					</div>
				</div>
			</div>

			<%
				}
				}
			%>




		</div>

		<div class="container">
			<div class="text-info">
			
				<!-- Copyright &copy; 2014 艾泰尔科技. -->
			 	Copyright © 2014 艾泰尔科技. 
			</div>
		</div>
	</body>
</html>
