<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트</title>
	<script>
		//브라우저가 로드될때 이벤트를 발생가능
		window.onload = function(){
			printTime();
		}
		
		function printTime(){
			alert("로드됨!");
			
			const test = document.getElementById("testspan");
			var msg = "<b>테스트라구요</b>";
			msg += "<b>테스트라구요2</b>";
			test.innerHTML = msg;
			test.style.color = "red";
		}
	
	</script>
</head>
<body>
	<span>여기는 그대로 </span><br>
	<span id="testspan"></span><br>
	<hr>
	<span id ="t">오늘은 점심은</span><br>
	<button id = "btn">클릭하면 윗줄 사라짐</button>
	<button id = "btn2">클릭하면 윗줄 나타남</button>
	<script>
		const btn = document.getElementById("btn");
		btn.onclick = ()=>{
			var testObj = document.getElementById("t");
			testObj.style.visibility = 'hidden';
		}
		
		const btn2 = document.getElementById("btn2");
		// $("#btn2").click(); ->jQuery 함수 방식
		btn2.onclick = function(){
			var testObj = document.getElementById("t");
			testObj.style.visibility = 'visible';
		}
	</script>

</body>
</html>