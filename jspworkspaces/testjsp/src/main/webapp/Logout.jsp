<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	session.invalidate();	//세션 전체제거
	response.sendRedirect("index02.jsp");
%>
<script>
	alert("로그아웃");
	location.href="index02.jsp";
</script>