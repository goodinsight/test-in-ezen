<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트</title>
<script>
	alert("확인창");
	document.write("<h1>내용</h1>");
	
	var msg = "Hello";
	msg += " next";
	msg += " next";
	msg += " next";
	msg += " next";
	
	document.write(msg);
	console.log(msg);
	function test01(name){
		alert("함수호출 : " + name);
		var age = prompt("당신의 나이는?");
		console.log(age);
		location.href="test01.jsp";
	}
	
	
</script>
</head>
<body>
	함수를 호출 : <input type="button" value="호출" onclick="test01('홍길동');"><br>

</body>
</html>