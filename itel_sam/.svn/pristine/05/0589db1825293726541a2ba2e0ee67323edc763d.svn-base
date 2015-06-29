<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.itel.service.*"%>
<%@ page import="com.itel.service.impl.*"%>
<%@ page import="com.itel.dao.*"%>
<%@ page import="com.itel.dao.impl.*"%>
<%@ page import="com.itel.domain.*"%>
<%@ page import="java.util.*"%>
<jsp:directive.page import="org.springframework.web.context.WebApplicationContext"/>

 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
		ServletContext sc = this.getServletConfig().getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
			//ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		System.out.println(context);
			ISamUpgradeDao isamUp = (ISamUpgradeDaoImpl) context
					.getBean("iSamUpgradeDao");
			SamUpgrade samUpgrade = new SamUpgrade();
			samUpgrade.setPlatform("Android");
			List<SamUpgrade> list = isamUp.getLastVersion(samUpgrade);
			SamUpgrade sp = null;
			if (list.size() > 0) {
				sp = list.get(0);
				String filename = sp.getUrl();
				out
						.println("<a href=\"localhost:8080/itel/fileController/download/"
								+ filename + "\" />");
			}
		%>


	</body>
</html>