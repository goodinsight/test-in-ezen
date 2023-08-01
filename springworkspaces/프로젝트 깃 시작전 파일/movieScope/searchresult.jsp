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
	<table class="table">
		  <tr>
		  	<td>영화 제목</td>
		  	<td>영화 개봉일</td>
		  	<td>영화 재개봉일</td>
		  	<td>영화 상영시간</td>
		  	<td>영화 평점</td>
		  	<td>영화 감독</td>
		  	<td>영화 배우</td>
		  	<td>영화 관객수</td>
		  	<td>영화 수상</td>
		  	<td>영화 장르</td>
		  	<td>영화 관람연령</td>
		  	<td>영화 국가</td>

		  </tr>
		<c:forEach var="movieVO" items="${nameMovieList }">
		 	<tr>
		 	<td>${movieVO.m_name}</td>
		 	<td>${movieVO.m_opening}</td>
		 	<td>${movieVO.m_reopening}</td>
		 	<td>${movieVO.m_runtime}</td>
		 	<td>${movieVO.m_grade }</td>
		 	<td>${movieVO.m_director }</td>
		 	<td>${movieVO.m_actor }</td>
		 	<td>${movieVO.m_attendance }</td>
		 	<td>${movieVO.m_awards }</td>
		 	<td>${movieVO.m_genre }</td>
		 	<td>${movieVO.m_age }</td>
		 	<td>${movieVO.m_nation }</td>

		 	</tr>
		</c:forEach>
		  </table>
	
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