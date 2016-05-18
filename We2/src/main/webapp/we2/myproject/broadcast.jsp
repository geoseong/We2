<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

<div class="chat_content">
     
    
        <textarea id="messageWindow" rows="10" cols="50" readonly="true" style= "background-color:#fff;" /></textarea>
        <br/>
        <input id="inputMessage" type="text"/>
        <input id="inputId" type="hidden" value="${authInfo.userId }"/>
        
     
        <div class = "submit">
        <input type="submit" class="add_btn_input" value="입력" onclick="send()" style= "width:53px; height:44px; background-color:#1591BE;"  />
        
        </div>
        </div>

</body>

    <script type="text/javascript">
        var textarea = document.getElementById("messageWindow");
        var webSocket = new WebSocket('ws://192.168.0.165:8080/We2/broadcasting');
        var inputMessage = document.getElementById('inputMessage');
        var inputId = document.getElementById('inputId');
    webSocket.onerror = function(event) {
      onError(event)
    };
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
    	onMessage(event)
    };
    function onMessage(event) {
        //textarea.value += event.data + ": " + event.data + "\n";
    	  textarea.value += event.data;
    }
    function onOpen(event) {
        textarea.value += "Geoseongtalk ver.1\n";
    }
    function onError(event) {
      alert(event.data);
    }
    function send() {
        webSocket.send(inputId.value + " : ");
        webSocket.send(inputMessage.value+ "\n");
        textarea.value += inputId.value + ": " + inputMessage.value + "\n";
        /*inputId.value = "";*/
         inputMessage.value = "";
    }
  </script>
  

</html>