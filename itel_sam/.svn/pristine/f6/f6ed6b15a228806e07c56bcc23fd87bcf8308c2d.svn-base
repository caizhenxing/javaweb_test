<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/resource/tld/c.tld" prefix="c"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>itel demo</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-2.1.1.js"></script>
    <script type="text/javascript">
    	function saveDemo () {
    		if ($("#demoName").val() == "") {
    			return;
    		}
    		var url = "${pageContext.request.contextPath }/demo/demo/saveDemo.jhtml";
    		$.ajax({
    			type: "POST",
    			url: "${pageContext.request.contextPath }/demo/demo/saveDemo.jhtml",
    			data: {name:$("#demoName").val(),id:$("#demoId").val()},
    			beforeSend: function(){
    			},
    			success:function(result){
    				$("#_list").html(result);
    				$("#demoId").val("");
		    		$("#demoName").val("");
    			},
    			error:function(){
    			},
    			complete:function(){
    			}
    		});
    	}
    	
    	function updateDemo (id, name) {
    		$("#demoId").val(id);
    		$("#demoName").val(name);
    	}
    	
    	function deleteDemo (id) {
    		var url = "${pageContext.request.contextPath }/demo/demo/deleteDemo.jhtml";
    		$.post(url,
    				{
    					id:id
    				},
    				function(data){
    					var trId = "tr"+id;
    		    		$("#"+trId).remove();
    				});
    		
    	}
    	function findDemo () {
    		
    		$.ajax({
    			type: "POST",
    			url: "${pageContext.request.contextPath }/demo/demo/demoList.jhtml",
    			data: {name:$("#demoName").val()},
    			beforeSend: function(){
    			},
    			success:function(result){
    				$("#_list").html(result);
    			},
    			error:function(){
    			},
    			complete:function(){
    			}
    		});
    		
    	}
    </script>
  </head>
  <body>
  	<h1>${hello }</h1>
  	<table>
  		<tr>
  			<th>ID：</th>
  			<td>
  				<input type="text" value="${demoId }" id="demoId" readonly="readonly">
  			</td>
  			<th>Name：</th>
  			<td><input type="text" value="${demoName }" id="demoName"></td>
  			<td>
				<input type="button" value="保存" onclick="saveDemo();">
  				<input type="button" value="查询" onclick="findDemo();">
  			</td>
  		</tr>
  	</table>
  	
  	<div id="_list"></div>
  </body>
</html>
