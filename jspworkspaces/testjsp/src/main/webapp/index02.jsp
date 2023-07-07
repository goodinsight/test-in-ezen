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

      <h1>Hello World</h1>

      <p>

        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit nam error ipsa commodi exercitationem fugiat praesentium tempore inventore voluptate dolore. Ipsa quisquam nemo enim explicabo aut accusantium ex ab perspiciatis.

      </p>

      <p>

        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Impedit nam error ipsa commodi exercitationem fugiat praesentium tempore inventore voluptate dolore. Ipsa quisquam nemo enim explicabo aut accusantium ex ab perspiciatis.

      </p>

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