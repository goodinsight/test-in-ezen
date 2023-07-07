<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String str = "hello";
	String msg = "더버";
%>
<div class="header">

    <div class="logo">LOGO - new
    <%=session.getAttribute("sname") %> : <b><%=str %></b> : <i> <%=msg %></i>
    </div>
	
  </div>