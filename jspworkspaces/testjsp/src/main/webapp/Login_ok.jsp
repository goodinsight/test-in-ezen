<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<%@ include file ="./include/header.jsp" %>

</head>

<body>

<img src="../images/layout.png"><br>

<div class="frame">
  <!-- header -->
  <jsp:include page="./include/top.jsp"></jsp:include>

  <!-- //header -->
  <!-- container -->
  <div class="container">

    <!-- nav -->
	<jsp:include page="./include/nav.jsp"></jsp:include>
    <!-- //nav -->

    <div class="content">

      <h1>로그인 결과처리</h1>
	  <div>
	    <%
	      request.setCharacterEncoding("utf-8");
	      out.println("처리하기");
	      String userId = request.getParameter("id");
	      String userPw = request.getParameter("pwd");
	      
	      // DB에 가서 아이디 패스워드를 조회
	      // rs != null  => 회원이 존재함
	      // id : admin, password : 12345 -> ok
	      
	      if(userId.equals("admin") && userPw.equals("12345")){
	    	  out.println("로그인 성공!");
	    	  //세션 부여하기
	    	  session.setAttribute("sid", userId);
	    	  session.setAttribute("sname", "관리자");
	    	  
	      }
	      else{
	    	  out.println("로그인 실패: 세션 설정 실패");
	      }
	      
	    %>
	  </div>
    
    </div>

  </div>

  <!-- //container -->
  
  <!-- footer -->
  <jsp:include page="./include/footer.jsp"></jsp:include>

  <!-- //footer -->

</div>

<!-- //frame -->

</body>

</html>