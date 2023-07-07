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

      <h1>로그인</h1>
	  <div>
	  	<form action = "Login_ok.jsp" method="post">
	  		아이디 : <input type="text" name="id"><br>
	  		패스워드 : <input type="text" name="pwd"><br>
	  		<input type="submit"><input type="reset">	  	
	  	</form>
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