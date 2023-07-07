<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "ko">
<head>

<meta charset="UTF-8">
<meta name="viewport" content=width=device-width, =1.0">
<title>html 기본태그</title>
<style>
	*{
		margin : 0px;
	}
	h1{
		color : red;
	}
	h2{
		color : blue;
	}
	p{
		color : red;
		border : 1px dashed red;
	}
	.gr{
		color : green;
	}
	
	#ora{
		color : orange;
		background-color: black;
	}
</style>
</head>
<body>
<!--  주석처리  -->
<%	// 주석처리
	/**
	
	*/
%>
	<div>
		<p>여기는 문단1</p>
		<p style="color : green">여기는 문단2</p>
		<p class="gr">여기는 문단3</p>
		<p class="gr">여기는 문단4</p>
		<p>여기는 문단5</p>
		<p id = "ora">여기는 문단6</p>
	</div>
	<hr>
	
	<h1>제목 태그</h1>
	<h2>제목 태그</h2>
	<h6>제목 태그</h6>
	<hr>
	<p>단락 태그</p>
	<div>단락 태그 - 주로 사용</div>
	<hr>
	줄<br>바꿈<br>
	<a href = "http://www.naver.com">네이버로 이동</a><br>
	<a href = "test02.jsp" target="_blank">문서 test02.jsp로 이동</a>
	<hr>
	<h2>목록 태그</h2>
	<ul>
		<li>커피1</li>		
		<li>커피2</li>		
		<li>커피3
			<ul>
				<li>콜라1</li>
				<li>콜라2</li>
				<li>콜라3</li>
			</ul>
		</li>		
	</ul>
	<ol>
		<li>커피1</li>		
		<li>커피2</li>		
		<li>커피3</li>		
	</ol>
	<hr>
	<h2>테이블 태그</h2>
	<table width="400" height="300" border="1" align="center">
	<tr align="center">
		<td>1</td>
		<td>2</td>
		<td>3</td>	
	</tr>	
	<tr align="center">
		<td>4</td>
		<td>5</td>
		<td>6</td>	
	</tr>	
	</table>
	<hr>
	<ans>사용자정의태그</ans>
	<table width="400" height="300" border="1" align="center">
	<tr align="center">
		<td colspan="2">1</td>
		<td>3</td>	
	</tr>	
	<tr align="center">
		<td>4</td>
		<td rowspan="2">5</td>
		<td>6</td>	
	</tr>	
	<tr align="center">
		<td>7</td>
		<td>9</td>	
	</tr>	
	<tr align="center">
		<td>10</td>
		<td>11</td>
		<td>12</td>	
	</tr>	
	</table>

	<hr>
	<table bgcolor = yellow width="400" height="300" border="1" align="center">
	<tr align="center">
		<td>1</td>
		<td colspan="2">2</td>
		<td rowspan="3">3</td>	
	</tr>	
	<tr align="center">
		<td rowspan="2">4</td>
		<td>5</td>
		<td>6</td>	
	</tr>
	<tr align="center">
		<td colspan="2">7</td>

	</tr>		
	<tr align="center">
		<td bgcolor="orange">8</td>
		<td bgcolor="orange">9</td>
		<td rowspan="2" colspan="2">10</td>	
	</tr>	
	<tr align="center">
		<td colspan="2">11</td>	
	</tr>
	<tr align="center">
		<td>12</td>
		<td>13</td>
		<td>14</td>	
		<td>15</td>	
	</tr>
	</table>
	<hr>
	<h2>이미지</h2>
	<img width = 500 src="../images/disney.jpg"><br>
	<img width = 500 src="/images/mickey.png"><br>
	<img width = 500 src="/testjsp/images/mickey.png"><br>




</body>
<footer>
	<div id="bottomMenu">
		<ul>
			<li><a href="#">회사 소개</a>
			<li><a href="#">개인정보처리방침</a>
			<li><a href="#">여행약관</a>
			<li><a href="#">사이트맵</a>	
		</ul>
	</div>
</footer>
</html>