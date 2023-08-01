<%@page import="kr.co.dong.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체사원조회결과</title>
</head>
<body>
	전체사원 리스트<hr>
	<%
		List<EmpDTO> l = (List)request.getAttribute("l");
		for(int i = 0; i<l.size(); i++){
			out.print(l.get(i).getEmpno());
			out.println(l.get(i).getEname());
			}	
	
	%>
	
</body>
</html>