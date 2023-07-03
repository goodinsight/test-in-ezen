<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		String str = "hello";
	
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01</title>
</head>
<body>
여기는 test01.jsp입니다.<br>
<%

	out.println(str);
%><br>
</body>
</html>