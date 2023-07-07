<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부트스트랩 이용하기</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<form>
		<div class="form-group">
			<h2>부트스트랩 버튼 적용하기</h2>
			<input type="button" id="b1" class="btn btn-warning" value="버튼1">
			<input type="button" id="b2" class="btn btn-warning" value="버튼2">
			<input type="button" id="b3" class="btn btn-warning" value="버튼3">
			<input type="button" id="b4" class="btn btn-info" value="버튼4">
			<input type="button" id="b5" class="btn btn-info" value="버튼5">
			<input type="button" id="b6" class="btn btn-info" value="버튼6"><hr>
			<button> 모바일용 </button>
		</div>
	</form>
	<hr>
	<ans>사용자정의태그</ans>
	<table class="table table-hover">
	<tr>
		<td colspan="2">1</td>
		<td>3</td>	
	</tr>	
	<tr>
		<td>4</td>
		<td rowspan="2">5</td>
		<td>6</td>	
	</tr>	
	<tr>
		<td>7</td>
		<td>9</td>	
	</tr>	
	<tr>
		<td>10</td>
		<td>11</td>
		<td>12</td>	
	</tr>	
	</table>


</body>
</html>