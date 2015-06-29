<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/resource/tld/c.tld" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>itel demo</title>
    <link rel="stylesheet" type="text/css" href="./xmlhttp/css/rime/rime.css" />
  </head>
  <body>
  	<c:if test="${list != null }">
  		<table>
  			<tr>
  				<th>ID</th>
  				<th>Name</th>
  				<th colspan="2">操作</th>
  			</tr>
			<c:forEach items="${list }" var="object">
				<tr id="tr${object.demoId}">
					<td>${object.demoId }</td>
					<td id="td${object.demoId}">${object.demoName }</td>
					<td>
						<a href="javascript:void(0)" onclick="deleteDemo('${object.demoId}')">删除</a>
					</td>
					<td>
						<a href="javascript:void(0)" onclick="updateDemo('${object.demoId}','${object.demoName }')">修改</a>
					</td>
				</tr>
			</c:forEach>
  		</table>
  	</c:if>
  	
  </body>
</html>
