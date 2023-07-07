<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body background="https://cdn.imweb.me/upload/S20200130a3018554a5004/a6f46584e7133.png">
	<br>
	<div align="center">
		<audio align="center" autoplay controls>
			<source src="\마침표.mp3">
		</audio>
	</div>
	<br><br>
	<form name="joinForm" action="mailto:hk7286@naver.com?subject=안녕하세요">
		<table text-align="center" align="center" border="1" width = "800" height="600" cellspacing="0">
			<tr>
				<td bgcolor=#48dbfb" align="center" colspan="2" heigth="50"> <b>회원 기본 정보</b> </td>
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center" width="150">아이디: </td>
				<td bgcolor="white"> <input type="text" size="20" name="uid" id="uid" minlength="4" maxlength="12"> 4~12자의 영문 대소문자의 숫자로만 입력 </td> 		
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">비밀번호: </td>
				<td bgcolor="white"> <input type="password" size="20" name="pw" id="pw" minlength="4" maxlength="12"> 4~12자의 영문 대소문자의 숫자로만 입력 </td> 		
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">비밀번호확인: </td>
				<td bgcolor="white"> <input type="password" size="20" name="cpw" id="cpw"></td> 		
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">메일주소: </td>
				<td bgcolor="white"> <input type="email" size="30" name="mail" id="mail"> 예) id@domain.com</td> 		
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">이름: </td>
				<td bgcolor="white"> <input type="text" size="30" name="uname" id="uname"></td>
			</tr>
			<tr>
				<td bgcolor=#48dbfb" align="center" colspan="2" heigth="50"> <b>개인 신상 정보</b> </td>
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">주민등록번호: </td>
				<td bgcolor="white"> <input maxlength="13" type="text" size="30" name="num"> 예) 1234561234567</td> 		
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">생일: </td>
				<td bgcolor="white">
					<input type="text" size="8" name="year" id="year"> 년
					<select name="month" id="month">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">4</option>
						<option value = "5">5</option>
						<option value = "6">6</option>
						<option value = "7">7</option>
						<option value = "8">8</option>
						<option value = "9">9</option>
						<option value = "10">10</option>
						<option value = "11">11</option>
						<option value = "12">12</option>					
					</select>월
					<select name="day" id="day">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">4</option>
						<option value = "5">5</option>
						<option value = "6">6</option>
						<option value = "7">7</option>
						<option value = "8">8</option>
						<option value = "9">9</option>
						<option value = "10">10</option>
						<option value = "11">11</option>
						<option value = "12">12</option>
						<option value = "13">13</option>
						<option value = "14">14</option>
						<option value = "15">15</option>
						<option value = "16">16</option>
						<option value = "17">17</option>
						<option value = "18">18</option>
						<option value = "19">19</option>
						<option value = "20">20</option>
						<option value = "21">21</option>
						<option value = "22">22</option>
						<option value = "23">23</option>
						<option value = "24">24</option>
						<option value = "25">25</option>
						<option value = "26">26</option>
						<option value = "27">27</option>
						<option value = "28">28</option>
						<option value = "29">29</option>
						<option value = "30">30</option>
						<option value = "31">31</option>
					</select>일			
				</td> 		
			</tr>
			<tr>
				<td bgcolor=#c8d6e5" align="center">관심분야: </td>
				<td bgcolor="white">
					<input type="checkbox" name="hobby" value="computer">컴퓨터&nbsp;&nbsp;
					<input type="checkbox" name="hobby" value="net">인터넷&nbsp;&nbsp;
					<input type="checkbox" name="hobby" value="trable">여행&nbsp;&nbsp;
					<input type="checkbox" name="hobby" value="movie">영화감상&nbsp;&nbsp;
					<input type="checkbox" name="hobby" value="music">음악감상&nbsp;&nbsp;
				</td>
			</tr>
			<tr height="100">		
				<td bgcolor=#c8d6e5" align="center" rowspan="2">자기소개: </td>
				<td bgcolor="white">
					<textarea rows="10" cols="75" name="me" id="me"> </textarea>
				</td>
			</tr>			
		</table>
		<br>
		<div align="center">
			<button type="button" width="30" onclick="Validation()">회원 가입</button>
			<input type="reset" onclick="alert('초기화 했습니다.')" value="다시 입력">
		</div>
	
	</form>
</body>
	<script>
		function Validation(){
			var uid = document.getElementById("uid")
			var pw = document.getElementById("pw")
			var cpw = document.getElementById("cpw")
			var mail = document.getElementById("mail")
			var name = document.getElementById("uname")
			var year = document.getElementById("year")
			var hobby = document.getElementById("hobby")
			var me = document.getElementById("me")
			
			if(uid.value.length < 4){
				alert("아이디를 4글자 이상 입력하세요.")
				uid.focus();
				return false;
			} else if(!checkEngNumber(uid.value)){
				alert("영문 대소문자, 숫자만 입력하세요.")
				uid.focus();
				return false;
			}
			
			if(pw.value.length < 4){
				alert("비밀번호를 4글자 이상 입력하세요.")
				pw.focus();
				return false;
			} else if(!checkEngNumber(pw.value)){
				alert("영문 대소문자, 숫자만 입력하세요.")
				pw.focus();
				return false;
			} else if(pw.value == uid.value){
				alert("아이디와 동일한 비밀번홀르 사용할 수 없습니다.")
				pw.focus();
				return false;
			}
			
			if(cpw.value != pw.value){
				alert("비밀번호와 동일하지 않습니다.")
				cpw.focus();
				return false;
			}
			
			if(mail.value.length < 4){
				alert("메일주소를 입력하세요.")
				mail.focus();
				return false;
			} else if(mail.value.indexOf("@") == -1 || mail.value.indexOf(".") == -1 || mail.value.length <= 5){
				alert("잘못된 이메일 형식입니다.")
				mail.focus();
				return false;
			}
			
			if(uname.value == ""){
				alert("이름을 입력하세요.")
				uname.focus();
				return false;
			} else if(!checkKorEng(uname.value)){
				alert("한글, 영어만 입력하세요.")
				uname.focus();
				return false;
			}
			
			if(year.value == ""){
				alert("년도를 입력하세요.")
				year.focus();
				return false;
			} else if(!(year.value >=1900 && year.value <= 2050)){
				alert("년도를 정확하게 입력하세요.")
				year.focus();
				return false;
			}
			
			if(!checkedHobby(hobby)){
				alert("관심분야를 체크하세요.")
				hobby.focus();
				return false;
			}
			
			if(me.value.length <= 10){
				alert("자기소개는 최소 10글자를 입력해주세요.")
				me.focus();
				return false;
			}
			
			document.joinForm.submit();
		}
		
		
		function checkEngNumber(value){
			var count = 0;
			
			for(var i = 0; i<value.length; i++){
				if((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122)  || (value.charCodeAt(i)>=48 && value.charCodeAt(i)<=57)){
					count += 1;
				}					
			}
			
			if(count == (value.length)){
				return true;
			} else {
				return false;
			}
		}
		
		function checkKorEng(value){
			var count = 0;
			
			for(var i = 0; i<value.length; i++){
				console.log(value.charCodeAt(i));
				if((value.charCodeAt(i)>=65 && value.charCodeAt(i)<=90) || (value.charCodeAt(i)>=97 && value.charCodeAt(i)<=122)  || (value.charCodeAt(i)>=44032 && value.charCodeAt(i)<=55203)){
					count += 1;
				}
			}
			
			if(count == (value.length)){
				return true;
			}else{
				return false;	
			}
		}
		
		function checkedHobby(arr){
			for(var i = 0; i < arr.length; i++){
				if(arr[i].checked == true){
					return true;
				}
			}
			return false;
		}
		
	</script>

</body>
</html>