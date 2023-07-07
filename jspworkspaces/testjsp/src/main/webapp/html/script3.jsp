<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퀴즈</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script> 
	$(function(){
		$("#a2").hide();
		$("#a1").click(function () {
			$("#a2").show();
		})
	 
		$("#b2").hide(); 
		$("#b1").click(function () {
			$("#b2").show();
		})
	})
	
	</script>
</head>
<body>
	<h2>질문1: 대한민국의 수도는 어디입니까?</h2>
	<button id = "a1">[정답 보기]</button>
	<div id = "a2">대한민국 수도는 <b>서울</b>입니다.</div>
	
	<h2>질문2: 대한민국의 국보1호는 무엇입니까?</h2>
	<button id = "b1">[정답 보기]</button>
	<div id = "b2">대한민국 국보1호는 <b>숭례문</b>입니다.</div>
	
	
</body>
</html>