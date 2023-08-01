<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search 결과 보여주는 화면</title>
</head>
<body>
	<c:if test="${nameMovieList ne null}">
	카타고리별 검색 영화목록 화면<br>
	<hr>
	${nameMovieList}
	</c:if>

	<c:if test="${ageMovieList ne null}">
	연령별 영화목록 화면<br>
	<hr>
	${ageMovieList}
	</c:if>
	<c:if test="${genreMovieList ne null}">
	장르별 영화목록 화면<br>
	<hr>
	${genreMovieList}
	</c:if>
	<c:if test="${nationMovieList ne null}">
	국가별 영화목록 화면<br>
	<hr>
	${nationMovieList}
	</c:if>
	
</body>
</html>