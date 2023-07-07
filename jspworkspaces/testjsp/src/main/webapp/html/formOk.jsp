<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");	//request("name") 
	String nick = request.getParameter("nick");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전송결과</title>
</head>
<body>
	<h1>전송받은 데이터 출력</h1>
	이름 : <%= name %><br>
	별명 : <%= nick %><br>
</body>
</html>