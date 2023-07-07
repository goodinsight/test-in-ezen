<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제이쿼리</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	
  	$(document).ready(function(){
		$("button").click(function() {
			if($("p").is(':visible') != false)
				$("p").hide();
			else
				$("p").show();
		});
 	});

</script>
</head>
<body>
	<p>메시지 : 제이쿼리를 공부하고 있습니다. </p>
	<button> 메세지 삭제</button>
</body>
</html>