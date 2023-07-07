<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="nav">

      <ul class="nav-list">
	  <%
	  	String sid = (String)session.getAttribute("sid");
	  	if(sid == null){
	  %>
        <li class="nav-item"><a href="Login.jsp" class="nav-link">Login</a></li>
        <% }else{ %>
        <li class="nav-item"><a href="Logout.jsp" class="nav-link">Logout</a></li>
        <% } %>
        <li class="nav-item"><a href="menu1.jsp" class="nav-link">Menu-1</a></li>

        <li class="nav-item"><a href="menu2.jsp" class="nav-link">Menu-2</a></li>

        <li class="nav-item"><a href="menu3.jsp" class="nav-link">Menu-3</a></li>

      </ul>

    </div>