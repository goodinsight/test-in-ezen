<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>써치 페이지</title>
</head>
<body>
	<h3> 원하는 영화 검색을 원하시면 영화 제목을 입력하세요</h3>
	<form action="search/name" method="get">
		영화 제목 <input type="text" name="m_name"><br>
		영화 개봉일 
		<select name="m_opening">
			<option value="1900" selected> 전체</option>
			<option value="1990" > 1990년대이후</option>
			<option value="2000" > 2000년대이후</option>
			<option value="2010" > 2010년대이후</option>
			<option value="2020" > 2020년대이후</option>
		</select><br>
		<input type="hidden" value="" name="m_reopening">
		영화 상영시간 <input type="text" name="m_runtime"><br>
		영화 평점 <input type="text" name="m_grade"><br>
		영화 감독 <input type="text" name="m_director"><br>
		영화 배우 <input type="text" name="m_actor"><br>
		영화 관객수 <input type="text" name="m_attendance"><br>
		영화 수상 <input type="text" name="m_awards"><br>
		영화 장르
		<select name="m_genre">
			<option value="SF" selected> SF</option>
			<option value="가족" > 가족</option>
			<option value="공연" > 공연</option>
			<option value="공포" > 공포</option>
			<option value="다큐멘터리" > 다큐멘터리</option>
			<option value="드라마" > 드라마</option>
			<option value="로맨스" > 로맨스</option>
			<option value="멜로" > 멜로</option>
			<option value="뮤지컬" > 뮤지컬</option>
			<option value="무협" > 무협</option>
			<option value="미스터리" > 미스터리</option>
			<option value="범죄" > 범죄</option>
			<option value="서부" > 서부</option>
			<option value="성인" > 성인</option>
			<option value="스릴러" > 스릴러</option>
			<option value="시대극" > 시대극</option>
			<option value="애니메이션" > 애니메이션</option>
			<option value="액션" > 액션</option>
			<option value="어드벤처" > 어드벤처</option>
			<option value="전쟁" > 전쟁</option>
			<option value="코미디" > 코미디</option>
			<option value="판타지" > 판타지</option>
		</select>
		<br>
		
		영화 관람연령 
		<select name="m_age">
			<option value="-1" selected> 모든 ㄴ연령 관람가</option>
			<option value="0" > 전체연령 관람가</option>
			<option value="12" > 12세이상 관람가</option>
			<option value="15" > 15세이상 관람가</option>
			<option value="18" > 18세이상 관람가</option>
		</select>
		<br>
		영화 국가 
		<select name="m_nation">
			<option value="나이지리아" > 나이지리아</option>
			<option value="네덜란드" > 네덜란드</option>
			<option value="노르웨이" > 노르웨이</option>
			<option value="대만" > 대만</option>
			<option value="덴마크" > 덴마크</option>
			<option value="독일" > 독일</option>
			<option value="라트비아" > 러시아</option>
			<option value="루마니아" > 루마니아</option>
			<option value="멕시코" > 멕시코</option>
			<option value="미국" > 미국</option>
			<option value="벨기에" > 벨기에</option>
			<option value="브라질" > 브라질</option>
			<option value="스웨덴" > 스웨덴</option>
			<option value="아일랜드" > 아르헨티나</option>
			<option value="영국" > 영국</option>
			<option value="오스트레일리아" > 오스트레일리아</option>
			<option value="오스트리아" > 오스트리아</option>
			<option value="우크라이나" > 우크라이나</option>
			<option value="유고슬라비아" > 유고슬라비아</option>
			<option value="이탈리아" > 이탈리아</option>
			<option value="인도" > 인도</option>
			<option value="인도네시아" > 인도네시아</option>
			<option value="일본" > 일본</option>
			<option value="중국" > 중국</option>
			<option value="캐나다" > 캐나다</option>
			<option value="태국" > 태국</option>
			<option value="터키" > 터키</option>
			<option value="프랑스" > 프랑스</option>
			<option value="핀란드" > 핀란드</option>
			<option value="한국" selected>한국</option>
			<option value="홍콩" > 홍콩</option>
			
		</select>
		<br>
		<p></p>
		<input type="submit" value="제출">
	</form>

	<h3> 연령별 영화 목록 검색을 원하시면 한가지를 선택하세요</h3>
	<form action="search/age" method="get">
		<select name="m_age">
			<option value="0" selected> 전체연령 관람가</option>
			<option value="12" > 12세이상 관람가</option>
			<option value="15" > 15세이상 관람가</option>
			<option value="18" > 18세이상 관람가</option>
		</select>
		<p></p>
		<input type="submit" value="제출">
	</form>
	<h3> 장르별 영화 목록 검색을 원하시면 한가지를 선택하세요</h3>
	<form action="search/genre" method="get">
		<select name="m_genre">
			<option value="SF" selected> SF</option>
			<option value="가족" > 가족</option>
			<option value="공연" > 공연</option>
			<option value="공포" > 공포</option>
			<option value="다큐멘터리" > 다큐멘터리</option>
			<option value="드라마" > 드라마</option>
			<option value="로맨스" > 로맨스</option>
			<option value="멜로" > 멜로</option>
			<option value="뮤지컬" > 뮤지컬</option>
			<option value="무협" > 무협</option>
			<option value="미스터리" > 미스터리</option>
			<option value="범죄" > 범죄</option>
			<option value="서부" > 서부</option>
			<option value="성인" > 성인</option>
			<option value="스릴러" > 스릴러</option>
			<option value="시대극" > 시대극</option>
			<option value="애니메이션" > 애니메이션</option>
			<option value="액션" > 액션</option>
			<option value="어드벤처" > 어드벤처</option>
			<option value="전쟁" > 전쟁</option>
			<option value="코미디" > 코미디</option>
			<option value="판타지" > 판타지</option>
		</select>
		<p></p>
		<input type="submit" value="제출">
	</form>
	<h3> 국가별 영화 목록 검색을 원하시면 한가지를 선택하세요</h3>
	<form action="search/nation" method="get">
		<select name="m_nation">
			<option value="나이지리아" > 나이지리아</option>
			<option value="네덜란드" > 네덜란드</option>
			<option value="노르웨이" > 노르웨이</option>
			<option value="대만" > 대만</option>
			<option value="덴마크" > 덴마크</option>
			<option value="독일" > 독일</option>
			<option value="라트비아" > 러시아</option>
			<option value="루마니아" > 루마니아</option>
			<option value="멕시코" > 멕시코</option>
			<option value="미국" > 미국</option>
			<option value="벨기에" > 벨기에</option>
			<option value="브라질" > 브라질</option>
			<option value="스웨덴" > 스웨덴</option>
			<option value="아일랜드" > 아르헨티나</option>
			<option value="영국" > 영국</option>
			<option value="오스트레일리아" > 오스트레일리아</option>
			<option value="오스트리아" > 오스트리아</option>
			<option value="우크라이나" > 우크라이나</option>
			<option value="유고슬라비아" > 유고슬라비아</option>
			<option value="이탈리아" > 이탈리아</option>
			<option value="인도" > 인도</option>
			<option value="인도네시아" > 인도네시아</option>
			<option value="일본" > 일본</option>
			<option value="중국" > 중국</option>
			<option value="캐나다" > 캐나다</option>
			<option value="태국" > 태국</option>
			<option value="터키" > 터키</option>
			<option value="프랑스" > 프랑스</option>
			<option value="핀란드" > 핀란드</option>
			<option value="한국" selected>한국</option>
			<option value="홍콩" > 홍콩</option>
			
		</select>
		<p></p>
		<input type="submit" value="제출">
	</form>
	
</body>
</html>