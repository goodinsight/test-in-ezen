<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<div>
	<ul>
		<li><a href="intro">회사소개</a></li>
		<li><a href="intro2">대표소개</a></li>
		<li><a href="intro3">조직도</a></li>
		<li><a href="main">메인으로 이동</a></li>
		<li><a href="m">회원가입</a></li>
		<li><a href="empcount">사원수 : ${cnt } </a></li>
	</ul>
</div>


</body>
</html>
