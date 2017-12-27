<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
   	<link rel="stylesheet" type="text/css" href="style/index.css" />
   	<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="script/dateFormate.js"></script>
	<script type="text/javascript">
		$(function(){
			//按下回车键时，发送聊天消息---获取发送键的ASCII码
			$("#sendMessage").keypress(function(event){
				//alert(event.keyCode);
				if(event.keyCode == 13){
					//获取聊天消息
					var message =$.trim(this.value);
					//alert(message);
					
					//将聊天内容发送到服务器端
					$.post("/chatRoom/servlet/servletSay",{"message":message});
				}
			});
		
		});
		
	</script>
	
  </head>
  
  <body>
  		<div id="chatBox">
  			<img src="img/chatRoom.png"/>
	   		<div id="showMessage"></div>
	   		<textarea id="sendMessage"></textarea>
  		</div>
   		
  </body>
</html>
