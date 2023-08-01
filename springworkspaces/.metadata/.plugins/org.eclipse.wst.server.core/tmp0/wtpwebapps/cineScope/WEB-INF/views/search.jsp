<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<head>
<%@include file="include/head.jsp" %>

<title>영화조회 </title>

</head>
   <%@include file="include/top.jsp"%>
      <div id="wrapper">
         <!-- Sidebar -->
         <%@include file="include/sidebar.jsp" %>

         <div id="content-wrapper">
            <div class="container-fluid upload-details">
            <!-- 여기서 부터 본문 작성 -->
            	<div class="row">
                  <div class="col-lg-12">
                     <div class="main-title">
                        <h6>원하시는 영화 검색</h6>
                     </div>
                  </div>
                  <div class="col-lg-2">
                     <div class="imgplace"></div>
                  </div>
                  <div class="col-lg-10">
                     <div class="osahan-title">Contrary to popular belief, Lorem Ipsum (2019) is not.</div>
                     <div class="osahan-size">102.6 MB . 2:13 MIN Remaining</div>
                     <div class="osahan-progress">
                        <div class="progress">
                           <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="75"   aria-valuemin="0" aria-valuemax="100" style="width: 75%"></div>
                        </div>
                        <div class="osahan-close">
                           <a href="#"><i class="fas fa-times-circle"></i></a>
                        </div>
                     </div>
                     <div class="osahan-desc">Your Video is still uploading, please keep this page open until it's done.</div>
                  </div>
               </div>
               <hr>
				<form action="${contextPath }/search/name" method="get">
					<div class="row">
					<div class="col-lg-12">
          			  <div class="form-group">
			            <label for="m_name">영화제목</label>
			            <input type="text" name="m_name" placeholder="타이타닉" id="m_name" class="form-control">
		              </div>
                    </div>
                    </div>
                    <div class="row">
	       			<div class="col-lg-3">
	          		  <div class="form-group">
			             <label for="m_opening">영화 개봉일</label>
			             <select id="m_opening" class="custom-select" name="m_opening">
			                <option value="1900" selected>전체</option>
			                <option value="1990">1990년대이후</option>
			                <option value="2000">2000년대이후</option>
			                <option value="2010">2010년대이후</option>
			                <option value="2020">2020년대이후</option>
			             </select>
			          </div>
	       			</div>
					<input type="hidden" value="" name="m_reopening">
					<div class="col-lg-3">
			           <div class="form-group">
			              <label for="m_runtime">영화 상영시간</label>
			              <input type="text" name="m_runtime" placeholder="90" id="m_runtime" class="form-control">
			           </div>
			        </div>
					<div class="col-lg-3">
			           <div class="form-group">
			              <label for="m_grade">영화 평점</label>
			              <input type="text" name="m_grade" placeholder="5.0" id="m_grade" class="form-control">
			           </div>
			        </div>
					<div class="col-lg-3">
			           <div class="form-group">
			              <label for="m_director">영화 감독</label>
			              <input type="text" name="m_director" placeholder="제임스 카메론" id="m_director" class="form-control">
			           </div>
			        </div>
			        </div>
			        <div class="row">
					<div class="col-lg-4">
			           <div class="form-group">
			              <label for="m_actor">영화 배우</label>
			              <input type="text" name="m_actor" placeholder="톰 크루즈" id="m_actor" class="form-control">
			           </div>
			        </div>
					<div class="col-lg-4">
			           <div class="form-group">
			              <label for="m_attendance">영화 관객수</label>
			              <input type="text" name="m_attendance" placeholder="10,000,000명" id="m_attendance" class="form-control">
			           </div>
			        </div>
					<div class="col-lg-4">
			           <div class="form-group">
			              <label for="m_awards">영화 수상</label>
			              <input type="text" name="m_awards" placeholder="아카데미" id="m_awards" class="form-control">
			           </div>
			        </div>
			        </div>
			        <div class="row">
			        <div class="col-lg-4">
	          		  <div class="form-group">
			             <label for="m_genre">영화 장르</label>
			             <select id="m_genre" class="custom-select" name="m_genre">
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
			          </div>
	       			</div>
	       			<div class="col-lg-4">
	          		  <div class="form-group">
			             <label for="m_age">영화 관람연령</label>
			             <select id="m_age" class="custom-select" name="m_age">
			                <option value="-1" selected> 연령제한없음</option>
							<option value="0" > 전체연령 관람가</option>
							<option value="12" > 12세이상 관람가</option>
							<option value="15" > 15세이상 관람가</option>
							<option value="18" > 18세이상 관람가</option>
			             </select>
			          </div>
	       			</div>
					<div class="col-lg-4">
	          		  <div class="form-group">
			             <label for="m_nation">영화 국가</label>
			             <select id="m_nation" class="custom-select" name="m_nation">
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
			          </div>
	       			</div>
	       			</div>
	       			<div class="osahan-area text-center mt-3">
                        <input type="submit" class="btn btn-outline-primary" value="제출">
                     </div>
                     <hr>
					
				</form>
				<div class="row ">
                     <div class="col-lg-12">
                        <div class="main-title">
                           <h6>연령별 영화 목록 검색을 원하시면 한가지만 선택하세요</h6>
                        </div>
                     </div>
                </div>
             <form action="${contextPath }/search/age" method="get">
                <div class="row category-checkbox">
                   <!-- checkbox 1col -->
                   <div class="col-lg-3 col-xs-6 col-4">
                      <div class="custom-control custom-checkbox">
                         <input type="checkbox" name="m_age" value="0" class="custom-control-input" id="customCheckAge1"  onclick='checkOnlyOneAge(this)'>
                         <label class="custom-control-label" for="customCheckAge1">전체연령 관람가</label>
                      </div>
                   </div>
                   <!-- checkbox 2col -->
                   <div class="col-lg-3 col-xs-6 col-4">
                      <div class="custom-control custom-checkbox">
                         <input type="checkbox" name="m_age" value="12" class="custom-control-input" id="zcustomCheckAge1"  onclick='checkOnlyOneAge(this)'>
                         <label class="custom-control-label" for="zcustomCheckAge1">12세이상 관람가</label>
                      </div>
                   </div>
                   <!-- checkbox 3col -->
                   <div class="col-lg-3 col-xs-6 col-4">
                      <div class="custom-control custom-checkbox">
                         <input type="checkbox" name="m_age" value="15" class="custom-control-input" id="czcustomCheckAge1"  onclick='checkOnlyOneAge(this)'>
                         <label class="custom-control-label" for="czcustomCheckAge1">15세이상 관람가</label>
                      </div>
                   </div>                  
                   <!-- checkbox 4col -->
                   <div class="col-lg-3 col-xs-6 col-4">
                      <div class="custom-control custom-checkbox">
                         <input type="checkbox" name="m_age" value="18" class="custom-control-input" id="customCheckAge2"  onclick='checkOnlyOneAge(this)'>
                         <label class="custom-control-label" for="customCheckAge2">18세이상 관람가</label>
                      </div>
                   </div>                  
                </div>
                <div class="osahan-area text-center mt-3">
                	<input type="submit" class="btn btn-outline-primary" value="제출">
             	</div>
             	<hr>
           		</form>

	<script>
		function checkOnlyOneAge(element) {
			  
			  const checkboxes 
			      = document.getElementsByName("m_age");
			  
			  checkboxes.forEach((cb) => {
			    cb.checked = false;
			  })
			  
			  element.checked = true;
			}
	</script>
	
	<div class="row ">
                           <div class="col-lg-12">
                              <div class="main-title">
                                 <h6>장르별 영화 목록 검색을 원하시면 한가지만 선택하세요</h6>
                              </div>
                           </div>
                        </div>
                      <form action="${contextPath }/search/genre" method="get">
                        <div class="row category-checkbox">
                           <!-- checkbox 1col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre"  value="SF" class="custom-control-input" id="customCheck1" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck1">SF</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="가족" class="custom-control-input" id="customCheck2" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck2">가족</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="공연"  class="custom-control-input" id="customCheck3" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck3">공연</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="공포" class="custom-control-input" id="customCheck4" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck4">공포</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="다큐멘터리" class="custom-control-input" id="customCheck5" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck5">다큐멘터리</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="시대극" class="custom-control-input" id="customCheck6" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck6">시대극</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="어드벤처" class="custom-control-input" id="customCheck7" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck7">어드벤처</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="판타지" class="custom-control-input" id="customCheck8" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="customCheck8">판타지</label>
                              </div>
                           </div>
                           <!-- checkbox 2col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="드라마" class="custom-control-input" id="zcustomCheck1" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck1">드라마</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="로맨스" class="custom-control-input" id="zcustomCheck2" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck2">로맨스</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="멜로" class="custom-control-input" id="zcustomCheck3" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck3">멜로</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="뮤지컬" class="custom-control-input" id="zcustomCheck4" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck4">뮤지컬</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="무협" class="custom-control-input" id="zcustomCheck5" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck5">무협</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="애니메이션" class="custom-control-input" id="zcustomCheck6" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck6">애니메이션</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="전쟁" class="custom-control-input" id="zcustomCheck7" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="zcustomCheck7">전쟁</label>
                              </div>
                           </div>
                           <!-- checkbox 3col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="미스터리" class="custom-control-input" id="czcustomCheck1" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck1">미스터리</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="범죄" class="custom-control-input" id="czcustomCheck2" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck2">범죄</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="서부" class="custom-control-input" id="czcustomCheck3" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck3">서부</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="성인" class="custom-control-input" id="czcustomCheck4" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck4">성인</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="스릴러" class="custom-control-input" id="czcustomCheck5" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck5">스릴러</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="액션" class="custom-control-input" id="czcustomCheck6" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck6">액션</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_genre" value="코미디" class="custom-control-input" id="czcustomCheck7" onclick='checkOnlyOneGenre(this)'>
                                 <label class="custom-control-label" for="czcustomCheck7">코미디</label>
                              </div>
                           </div>
                           </div>
                           <div class="osahan-area text-center mt-3">
			                <input type="submit" class="btn btn-outline-primary" value="제출">
			             	</div>
			             	<hr>
                          </form>
    <script>
		function checkOnlyOneGenre(element) {
			  
			  const checkboxes 
			      = document.getElementsByName("m_genre");
			  
			  checkboxes.forEach((cb) => {
			    cb.checked = false;
			  })
			  
			  element.checked = true;
			}
	</script>	
	
	
	<div class="row ">
                           <div class="col-lg-12">
                              <div class="main-title">
                                 <h6>국가별 영화 목록 검색을 원하시면 한가지만 선택하세요</h6>
                              </div>
                           </div>
                        </div>
                        <form action="${contextPath }/search/nation" method="get">
                        <div class="row category-checkbox">
                           <!-- checkbox 1col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="네덜란드" class="custom-control-input" id="customCheckNation1" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="customCheckNation1">네덜란드</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="노르웨이" class="custom-control-input" id="customCheckNation2" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="customCheckNation2">노르웨이</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="대만" class="custom-control-input" id="customCheckNation3" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="customCheckNation3">대만</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="덴마크" class="custom-control-input" id="customCheckNation4" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="customCheckNation4">덴마크</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="독일" class="custom-control-input" id="customCheckNation5" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="customCheckNation5">독일</label>
                              </div>
                           </div>
                           <!-- checkbox 2col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="라트비아" class="custom-control-input" id="zcustomCheckNation1" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="zcustomCheckNation1">라트비아</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="루마니아" class="custom-control-input" id="zcustomCheckNation2" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="zcustomCheckNation2">루마니아</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="멕시코" class="custom-control-input" id="zcustomCheckNation3" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="zcustomCheckNation3">멕시코</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="미국" class="custom-control-input" id="zcustomCheckNation4" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="zcustomCheckNation4">미국</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="벨기에" class="custom-control-input" id="zcustomCheckNation5" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="zcustomCheckNation5">벨기에</label>
                              </div>
                           </div>
                           <!-- checkbox 3col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="브라질" class="custom-control-input" id="czcustomCheckNation1" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="czcustomCheckNation1">브라질</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="스웨덴" class="custom-control-input" id="czcustomCheckNation2" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="czcustomCheckNation2">스웨덴</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="아일랜드" class="custom-control-input" id="czcustomCheckNation3" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="czcustomCheckNation3">아일랜드</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="영국"  class="custom-control-input" id="czcustomCheckNation4" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="czcustomCheckNation4">영국</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="오스트레일리아" class="custom-control-input" id="czcustomCheckNation5" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="czcustomCheckNation5">오스트레일리아</label>
                              </div>
                           </div>
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="오스트리아" class="custom-control-input" id="azcustomCheckNation1" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="azcustomCheckNation1">오스트리아</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="우크라이나" class="custom-control-input" id="azcustomCheckNation2" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="azcustomCheckNation2">우크라이나</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="유고슬라비아" class="custom-control-input" id="azcustomCheckNation3" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="azcustomCheckNation3">유고슬라비아</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="이탈리아" class="custom-control-input" id="azcustomCheckNation4" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="azcustomCheckNation4">이탈리아</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="인도" class="custom-control-input" id="azcustomCheckNation5" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="azcustomCheckNation5">인도</label>
                              </div>
                           </div>
                           <!-- checkbox 2col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="인도네시아" class="custom-control-input" id="bzcustomCheckNation1" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bzcustomCheckNation1">인도네시아</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="일본" class="custom-control-input" id="bzcustomCheckNation2" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bzcustomCheckNation2">일본</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="중국" class="custom-control-input" id="bzcustomCheckNation3" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bzcustomCheckNation3">중국</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="캐나다" class="custom-control-input" id="bzcustomCheckNation4" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bzcustomCheckNation4">캐나다</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="태국" class="custom-control-input" id="bzcustomCheckNation5" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bzcustomCheckNation5">태국</label>
                              </div>
                           </div>
                           <!-- checkbox 3col -->
                           <div class="col-lg-2 col-xs-6 col-4">
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="터키" class="custom-control-input" id="bczcustomCheckNation1" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bczcustomCheckNation1">터키</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="프랑스" class="custom-control-input" id="bczcustomCheckNation2" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bczcustomCheckNation2">프랑스</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="핀란드" class="custom-control-input" id="bczcustomCheckNation3" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bczcustomCheckNation3">핀란드</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="한국"  class="custom-control-input" id="bczcustomCheckNation4" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bczcustomCheckNation4">한국</label>
                              </div>
                              <div class="custom-control custom-checkbox">
                                 <input type="checkbox" name="m_nation" value="홍콩" class="custom-control-input" id="bczcustomCheckNation5" onclick='checkOnlyOneNation(this)'>
                                 <label class="custom-control-label" for="bczcustomCheckNation5">홍콩</label>
                              </div>
                           </div>
                           </div>
                           <div class="osahan-area text-center mt-3">
			                <input type="submit" class="btn btn-outline-primary" value="제출">
			             	</div>
			             	<hr>
							</form>
             <script>
		function checkOnlyOneNation(element) {
			  
			  const checkboxes 
			      = document.getElementsByName("m_nation");
			  
			  checkboxes.forEach((cb) => {
			    cb.checked = false;
			  })
			  
			  element.checked = true;
			}
	</script>
            
            </div>
            </div>
            <!-- /.container-fluid -->
            <!-- Sticky Footer -->
            <%@include file="include/footer.jsp" %>
         </div>
         <!-- /.content-wrapper -->
      </div>
      <!-- /#wrapper -->
      <!-- Scroll to Top Button-->
      <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
      </a>
      <!-- Logout Modal-->
      <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
         <div class="modal-dialog modal-sm modal-dialog-centered" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                  <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">×</span>
                  </button>
               </div>
               <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
               <div class="modal-footer">
                  <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                  <a class="btn btn-primary" href="login.html">Logout</a>
               </div>
            </div>
         </div>
      </div>
      <!-- Bootstrap core JavaScript-->
      <%@include file="include/js.jsp" %>
   </body>

</html>
