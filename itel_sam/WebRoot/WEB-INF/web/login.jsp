<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp" %>
<%@ include file="/common/includes.jsp" %>
<%@ include file="/common/jqueryJavaScript.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css"  href="${cts}/css/login.css">
<style type="text/css">
table.content {
	width: 780px;
	height: 520px;
	background-image: url("${cts}/images/login/background.jpg");
}
</style>
<title>监控后台控制台</title>
<script language="javascript" type="text/javascript">
	function login() {
		
		
		var user = document.forms[0].username.value;
		var password = document.forms[0].password.value;
		var validateCode =  document.forms[0].validateCode.value;
		if (user == null || user == "") {
			alert("用户标识不能为空");
			document.forms[0].username.focus();
			return false;
		}

		if (password == null || password == "") {
			alert("密码不能为空");
			document.forms[0].password.focus();
			return false;
		}
		
		if (validateCode == null || validateCode == "") {
			alert("验证码不能为空");
			document.forms[0].validateCode.focus();
			return false;
		}

		return true;
	}

	function reset() {
		document.forms[0].username.value = "";
		document.forms[0].password.value = "";
		document.forms[0].validateCode.value = "";

	}

	function onLoad() {
		window.moveTo(0, 0);
		window.resizeTo(screen.availWidth, screen.availHeight);
		document.forms[0].userAccount.focus();
		  
	}
</script>
</head>
<body onload="onLoad();">
<form:form modelAttribute="loginAccount" action="${cts}/login/submit">
	<table class="main" cellpadding="0" cellspacing="0">
        <tr><td align="center" valign="middle" style="height: 582px">
            <table class="content" cellpadding="0" cellspacing="0">
                <thead>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-top:40px;">
                                <tr>
                                    <td style="width:165px;" valign="top"><!--<img src="${cts}/images/login/logo.gif" width="165" height="64" style="margin-left:50px;" alt="中国移动"/>-->Itel</td>
                                    <td align="right">
                                        <table border="0" cellpadding="0" cellspacing="0" style="margin-right: 50px;">
                                            <tr><td class="header" colspan="2">监控后台控制台</td></tr>
                                            <tr><td align="right">
                                                <table border="0" cellpadding="0" cellspacing="0">
                                                    <tr><td class="header2">Monitor Management PlatForm</td></tr>
                                                    <tr><td><hr/></td></tr>
                                                </table>
                                            </td></tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </thead>
                    
                <tbody>
                    <tr>
                        <td>
                            <table width="100%" border="0" cellpadding="0" cellspacing="0" style="margin-bottom:30px;">
                                <tr>
                                    <td align="center" valign="top" rowspan="2"><!--<img src="${cts}/images/login/center.jpg" width="371" height="280" alt="Center"/>-->Cehnter Jpg</td>
                                    <td align="left" valign="bottom" style="width:260px;">
                                        <table cellpadding="0" cellspacing="0">
                                            <tr><td class="message">
                                            		<form:errors path="username" cssClass="warning"></form:errors>
													<form:errors path="password" cssClass="warning"></form:errors>
													<form:errors path="validateCode" cssClass="warning"></form:errors>
											</td></tr>
                                            <tr><td>
                                                <table cellpadding="0" cellspacing="0" style="margin-bottom:20px;">
                                                    <tr style="height:30px;">
                                                        <td width="55px;">账&nbsp;&nbsp;号：</td>
                                                        <td><form:input id="username" path="username" size="25" maxlength="50" cssClass="input"/></td>
                                                    </tr>
                                                    <tr style="height:30px;">
                                                        <td>密&nbsp;&nbsp;码：</td>
                                                        <td><form:password path="password" size="25" maxlength="50" cssClass="input"/></td>
                                                    </tr>
                                                    <tr style="height:30px;">
                                                        <td>验证码：</td>
                                                         <td style="text-align:center;">
	                                                    <form action="submit.action"> 
	                                                    	<table cellpadding="0" cellspacing="0"><tr>
	                                                    		<td><input type="text" name="validateCode" value="" class="input" style="width:40px;margin-right:2px"/></td>
	                                                    		<td><img src="validate.code" id="kaptchaImage" width="90px"/></td>
	                                                    	</tr></table>
															<script type="text/javascript">  
															    $(function(){  
															        $('#kaptchaImage').click(function () {   
															            $(this).attr('src', 'validate.code?' + Math.floor(Math.random()*100) ); }); 
															    });  
															</script>
													    </form> 
                                                    </tr>
                                                  
                                                    <tr>
                                                        <td colspan="2" align="center" style="padding-top:10px;">
                                                            <input type="submit" class="button" value="登录" accesskey="enter" title="登录"  onclick="return login();" />
                                                            <input type="reset" class="button" value="重置" style="margin-left:10px;" onclick="javascript:reset();"/>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td></tr>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
        </td></tr>
    </table>
</form:form>

<div class="bottom">&copy;艾泰尔智能生活馆</div>
</body>
</html>