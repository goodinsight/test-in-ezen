<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼태그-입력양식태그</title>
	<script>
		function check(){
			var exp = "^[0-9A-Za-z]"; //id, pw 테스트 함수를 이용해서 유효성 검사를 함
			
			
			//처리방식1
			var t = document.f;
			console.log(t.name.value);
			console.log(t.nick.value);
			
			//처리방식2
			var name = document.getElementById("name");
			var nick = document.getElementById("nick");
			console.log(name.value);
			console.log(nick.value);
			
			if(name.value == ""){
				alert("이름을 입력하세요");
				name.focus();
				return false;
			}
			
			if(nick.value==""){
				alert("별명을 입력하세요");
				nick.focus();
				return false;
			}
			f.submit();
			return true;
						
		}
	
	</script>


</head>
<body>
	<h1>이름과 별명 전송하기</h1>
	<div>
		<form name="f" action="formOk.jsp" method="post">
			이름 : <input type="text" id="name" name="name"><br>
			별명 : <input type="text" id="nick" name="nick"><br>
			내용 : <input type="text" required><br>
			<input type="button" value="전송" onclick="check();">
			<input type="reset" value="재작성">
		</form>
	
	</div>
	
</body>
</html>