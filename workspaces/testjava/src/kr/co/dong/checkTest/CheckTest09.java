package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest09 {
	public static void main(String[] args) {
//		추가사항 : 1.객실규모(크기)는 시작과 동시에 입력
//		 2.호텔방번호/호텔방명(예-로얄/참나무 등)/객실인원/가격 ->1901호~1919호 (1층 레스토랑 로비)2층 피트니스룸 3층 수영장 4층 세미나룸,결혼식장 5~18층 오피스텔 2층 라운지
//		 3.예약시 예약자명/예약번호(취소시 필요) 등
//		 4.기타 필요한 기능(관리자모드)


int[] room = {0,0,0,0,0,0,0,0,0,0,0,0};				//room[] 예약 번호
int menu = 0;							//menu switch문에서 입력받을 변수
int rooms = 0;							//전체화면 -> 2.ROOMS 메뉴 선택
int reservation=0;						//전체화면 -> 2.ROOMS -> 2.ROOM RESERVATION 메뉴 선택
int choiceRoom = 0;						//전체화면 -> 2.ROOMS -> 2.ROOM RESERVATION -> case 2(RESERVATION) 호실번호 선택
int roomType = 0;						//전체화면 -> 2.ROOMS -> 1.ROOM TYPE -> case 1 룸타입 선택
int count = 0;

//String name = null;				//예약자명
String[] name = new String[12];	//예약자명 배열

int reservationNum=0;			//예약번호
//int numOfPeople =0;				//숙박인원 (수용인원 초과시 추가금액) -> 전화문의/방문시 처리하기
String name2 = null;			//예약취소 입력용 예약자명
String name3 = null;			//예약확인 입력용 예약자명

Scanner scan = new Scanner(System.in);
boolean hotel = false;			//전체화면 while문
boolean booking = false;		
boolean menu2=false;			//전체화면 -> 2.ROOMS while문
boolean menu2_2=false;			//전체화면 -> 2.ROOMS -> 2.ROOM RESERVATION while문
boolean menu2_1=false;			//전체화면 -> 2.ROOMS -> 1.ROOM TYPE while문
boolean menu2_2_1=false;		//전체화면 -> 2.ROOMS -> 2.ROOM RESERVATION -> 2.RESERVATION while문


while(!hotel) {
	System.out.println();
	System.out.println("						 ★ GRAND SY HOTEL ★");
	System.out.println("★ GRAND SY HOTEL에 오신것을 환영합니다.");
	System.out.println("=======================================================================");
	System.out.println("[1] HOTEL [2] ROOMS [3] AREA ATTRACTION [4] DINING [5] SPECIAL EVENTS");
	System.out.println("[0] CLOSE");
	System.out.println("=======================================================================");
	System.out.print("√ 번호를 입력하세요. > ");
	menu = scan.nextInt();
	
	switch (menu) {
	case 1:
		System.out.println();
		System.out.println("★GRAND SY HOTEL★");
		System.out.println();
		System.out.println("★ 부산 최고급 럭셔리 호텔");
		System.out.println("★ 멋진 바다와 광안대교 전경을 자랑하는 부산의 랜드마크.");
		System.out.println("★ 럭셔리한 품격과 세련된 스타일로 소중한 순간을 더욱 특별하게 만들어 드립니다.");
		System.out.println("★ 부산의 MICE와 레저 중심지에 위치한 '그랜드 SY 호텔'에서 감각적이고 전문적인 고객 맞춤서비스를 경험해 보세요. ");
		System.out.println("★ 부산에서의 추억은 GRAND SY HOTEL과 함께하세요.");
		break;
		
	case 2:
		while(!menu2) {
		//호텔 방번호 규모 변수 rooms while문 ->menu2
		System.out.println();
		System.out.println("						 ★ GRAND SY HOTEL ★");
		System.out.println("< ROOMS >");
		System.out.println("=======================================================================");
		System.out.println("[1] ROOM TYPE [2] ROOM RESERVATION [0] CLOSE");
		System.out.println("=======================================================================");
		System.out.print("√ 번호를 입력하세요. > ");
		rooms = scan.nextInt();
			
			switch (rooms) {
			case 1:
				while(!menu2_1) {
					System.out.println();
					System.out.println("						 ★ GRAND SY HOTEL ★");
					System.out.println("< ROOM TYPE >");
					System.out.println("======================================================================");
					System.out.println("[ 1] Presidential Suite");
					System.out.println("[ 2] Diplomat Suite");
					System.out.println("[ 3] Royal Executive Family Suite");
					System.out.println("[ 4] Royal Executive Suite");
					System.out.println("[ 5] Premium Family Suite");
					System.out.println("[ 6] Premium Executive Suite");
					System.out.println("----------------------------------------------------------------------");
					System.out.println("[ 7] Premium Double");
					System.out.println("[ 8] Premium Twin");
					System.out.println("[ 9] Premium Double (Ocean View)");
					System.out.println("[10] Premium Twin (Ocean View)");
					System.out.println("[11] Deluxe Double");
					System.out.println("[12] Deluxe Twin");
					System.out.println("======================================================================");
					System.out.println("[0] CLOSE");
					System.out.println("======================================================================");
					System.out.println();
					System.out.print("√ ROOM TYPE을 선택하세요. > ");
					roomType = scan.nextInt();
//					1~6, 9,10: Ocean View

					
					switch (roomType) {
					case 1:
						System.out.println("[ 1] Presidential Suite");
						System.out.println("<넘버> 1912호");
						System.out.println("<크기> 198평방미터");
						System.out.println("<옵션> 오션뷰, 침실2(2 King Bed), 거실1, 다이닝룸1, 오션뷰 욕실2");
						System.out.println("<인원> 8인 (최대 12인, 인원 추가시 추가금액)");
						System.out.println("<가격> 주말 및 공휴일: $2,000 평일: $1,800");
						
						break;
						
					case 2:
						System.out.println("[ 2] Diplomat Suite");
						System.out.println("<넘버> 1911호");
						System.out.println("<크기> 155평방미터");
						System.out.println("<옵션> 오션뷰, 침실2(2 King Bed), 거실1, 다이닝룸1, 오션뷰 욕실1");
						System.out.println("<인원> 4인 (최대 8인, 인원 추가시 추가금액)");
						System.out.println("<가격> 주말 및 공휴일: $1,800 평일: $1,600");
						break;
						
					case 3:
						System.out.println("[ 3] Royal Executive Family Suite");
						System.out.println("<넘버> 1910호");
						System.out.println("<크기> 107평방미터");
						System.out.println("<옵션> 오션뷰, 침실2(2 Queen Bed, 2 Single Bed), 거실1, 욕실1");
						System.out.println("<인원> 4인 (최대 6인, 인원 추가시 추가금액)");
						System.out.println("<가격> 주말 및 공휴일: $1,400 평일: $1,200");
						break;

						
					case 4:
						System.out.println("[ 4] Royal Executive Suite");
						System.out.println("<넘버> 1909호");
						System.out.println("<크기> 107평방미터");
						System.out.println("<옵션> 오션뷰, 침실2(2 King Bed), 거실1, 욕실1");
						System.out.println("<인원> 4인 (최대 6인, 인원 추가시 추가금액)");
						System.out.println("<가격> 주말 및 공휴일: $1,200 평일: $1,000");
						break;

					case 5:
						System.out.println("[ 5] Premium Family Suite");
						System.out.println("<넘버> 1908호");
						System.out.println("<크기> 87평방미터");
						System.out.println("<옵션> 오션뷰, 침실1(1 Queen Bed, 1 Single Bed), 거실1, 욕실1");
						System.out.println("<인원> 3인 (최대 4인, 인원 추가시 추가금액)");
						System.out.println("<가격> 주말 및 공휴일: $1,000 평일: $800");
						break;

					case 6:
						System.out.println("[ 6] Premium Executive Suite");
						System.out.println("<넘버> 1907호");
						System.out.println("<크기> 87평방미터");
						System.out.println("<옵션> 오션뷰, 침실1(1 King Bed), 거실1, 욕실1");
						System.out.println("<인원> 2인 (최대 4인, 인원 추가시 추가금액)");
						System.out.println("<가격> 주말 및 공휴일: $1,000 평일: $800");
						break;

					case 7:
						System.out.println("[ 7] Premium Double");
						System.out.println("<넘버> 1906호");
						System.out.println("<크기> 59평방미터");
						System.out.println("<옵션> 침실1(1 King Bed), 욕실1");
						System.out.println("<인원> 2인 (인원추가 불가)");
						System.out.println("<가격> 주말 및 공휴일: $800 평일: $600");
						break;

					case 8:
						System.out.println("[ 8] Premium Twin");
						System.out.println("<넘버> 1905호");
						System.out.println("<크기> 59평방미터");
						System.out.println("<옵션> 침실1(2 Single Bed), 욕실1");
						System.out.println("<인원> 2인 (인원추가 불가)");
						System.out.println("<가격> 주말 및 공휴일: $800 평일: $600");
						break;

					case 9:
						System.out.println("[ 9] Premium Double (Ocean View)");
						System.out.println("<넘버> 1904호");
						System.out.println("<크기> 59평방미터");
						System.out.println("<옵션> 오션뷰, 침실1(1 King Bed), 욕실1");
						System.out.println("<인원> 2인 (인원추가 불가)");
						System.out.println("<가격> 주말 및 공휴일: $900 평일: $700");
						break;

						
					case 10:
						System.out.println("[10] Premium Twin (Ocean View)");
						System.out.println("<넘버> 1903호");
						System.out.println("<크기> 59평방미터");
						System.out.println("<옵션> 오션뷰, 침실1(2 Single Bed), 욕실1");
						System.out.println("<인원> 2인 (인원추가 불가)");
						System.out.println("<가격> 주말 및 공휴일: $900 평일: $700");
						break;

						
					case 11:
						System.out.println("[11] Deluxe Double");
						System.out.println("<넘버> 1902호");
						System.out.println("<크기> 41평방미터");
						System.out.println("<옵션> 침실1(1 King Bed), 욕실1");
						System.out.println("<인원> 2인 (인원추가 불가)");
						System.out.println("<가격> 주말 및 공휴일: $700 평일: $500");
						break;

						
					case 12:
						System.out.println("[12] Deluxe Twin");
						System.out.println("<넘버> 1901호");
						System.out.println("<크기> 41평방미터");
						System.out.println("<옵션> 침실1(2 Single Bed), 욕실1");
						System.out.println("<인원> 2인 (인원추가 불가)");
						System.out.println("<가격> 주말 및 공휴일: $700 평일: $500");
						break;

					case 0:
						menu2_1 = true;
						System.out.println("> 이전 화면으로 돌아갑니다.");
						break;

					default:
						System.out.println("√ 잘못된 번호입니다. 번호를 다시 입력하세요.");
						break;
					}
				}
				menu2_1=!menu2_1;
				break;
				
			case 2:
				while(!menu2_2) {
					System.out.println();
					System.out.println("						 ★ GRAND SY HOTEL ★");
					System.out.println("< ROOM RESERVATION >");
					System.out.println("=======================================================================");
					System.out.println("[1] RESERVATION [2] CANCEL RESERVATION [3] RESERVATION CONFIRMATION");
					System.out.println("[0] CLOSE");
					System.out.println("=======================================================================");
					System.out.print("√ 번호를 입력하세요. > ");
					reservation = scan.nextInt();		
				
					switch (reservation) {
					case 1:
						while(!menu2_2_1) {
							
						System.out.println("						 ★ GRAND SY HOTEL ★");
						System.out.println("< RESERVATION >");
						System.out.println("======================================================================");
						System.out.println("※ ROOM TYPE \t \t \t \t \t > ROOM NUMBER");
						System.out.println("[ 1] Presidential Suite \t \t \t > [1912호]");
						System.out.println("[ 2] Diplomat Suite \t \t \t \t > [1911호]");						
						System.out.println("[ 3] Royal Executive Family Suite \t \t > [1910호]");
						System.out.println("[ 4] Royal Executive Suite \t \t \t > [1909호]");
						System.out.println("[ 5] Premium Family Suite \t \t \t > [1908호]");
						System.out.println("[ 6] Premium Executive Suite \t \t \t > [1907호]");
						System.out.println("----------------------------------------------------------------------");
						System.out.println("[ 7] Premium Double \t \t \t \t > [1906호]");
						System.out.println("[ 8] Premium Twin \t \t \t \t > [1905호]");
						System.out.println("[ 9] Premium Double (Ocean View) \t \t > [1904호]");
						System.out.println("[10] Premium Twin (Ocean View) \t \t \t > [1903호]");
						System.out.println("[11] Deluxe Double \t \t \t \t > [1902호]");
						System.out.println("[12] Deluxe Twin \t \t \t \t > [1901호]");
						System.out.println("======================================================================");
						System.out.println("[0] CLOSE");
						System.out.println("======================================================================");
						
						System.out.print("√ 원하시는 ROOM TYPE 번호를 선택하세요. (1~12) >");
						choiceRoom = scan.nextInt();
							if(choiceRoom == 0){
								System.out.println("이전화면으로 돌아갑니다.");
								menu2_2_1 = !menu2_2_1;
							}else if(choiceRoom>room.length) {
								System.out.println("입력하신 객실은 없는 객실입니다.");
							}else if(room[choiceRoom-1]==1) {
								System.out.println("√ 예약이 불가능합니다. 다른 호실을 선택하세요.");
								
							}else{
							
								System.out.println("> 예약이 가능합니다.");
								System.out.println();
								System.out.print("√ 예약자명을 입력하세요. > ");		//예약취소,예약확인시 -> 예약자명 입력 (name.equals = -> 다음화면 넘어가기)
								name[choiceRoom-1] = scan.next();
								
								if(choiceRoom>0 && choiceRoom<10) {
									System.out.println("> [190"+(choiceRoom)+"호]로 예약되었습니다.");
									System.out.println("> 예약번호는 " + (choiceRoom) + "입니다.");
									room[choiceRoom-1] = 1;
									name[choiceRoom-1] = name[choiceRoom-1]+choiceRoom;	//배열만들어서 넣기
									break;
								}else{
									System.out.println("> [19"+(choiceRoom)+"호]로 예약되었습니다.");
									System.out.println("> 예약번호는 " + (choiceRoom) + "입니다.");
									room[choiceRoom-1] = 1;
									name[choiceRoom-1] = name[choiceRoom-1]+choiceRoom;
									break;
								}
							}	
						}
						break;
					case 2:
						boolean b = false;
						System.out.println();
						System.out.println("						 ★ GRAND SY HOTEL ★");
						System.out.println("< CANCEL RESERVATION >");
						System.out.println("======================================================================");

						System.out.print("√ 예약자 성함과 예약번호를 입력하세요. (ex. name1) > ");
						name2 = scan.next();
						for(int i=0; i<name.length; i++) {
							if(name2.equals(name[i])) {
								choiceRoom = i;
								b = true;
								break;
							}
						}
							if(choiceRoom+1<10 && b) {
								System.out.println("> [190"+ (choiceRoom+1) + "호실]의 예약을 취소합니다.");
								room[choiceRoom]=0;
							} else if(choiceRoom+1>=10 && b){
								System.out.println("> [19"+ (choiceRoom+1) + "호실]의 예약을 취소합니다.");
								room[choiceRoom]=0;
							}else{
							System.out.println("√ 예약내역이 조회되지 않습니다. 다시 입력하세요.");
							}
						break;
					case 3:
						System.out.println();
						System.out.println("						 ★ GRAND SY HOTEL ★");
						System.out.println("< RESERVATION CONFIRMATION >");
						System.out.println("======================================================================");
						System.out.println("※ ROOM TYPE \t \t \t \t \t > ROOM NUMBER");
						System.out.println("[ 1] Presidential Suite \t \t \t > [1912호]");
						System.out.println("[ 2] Diplomat Suite \t \t \t \t > [1911호]");						
						System.out.println("[ 3] Royal Executive Family Suite \t \t > [1910호]");
						System.out.println("[ 4] Royal Executive Suite \t \t \t > [1909호]");
						System.out.println("[ 5] Premium Family Suite \t \t \t > [1908호]");
						System.out.println("[ 6] Premium Executive Suite \t \t \t > [1907호]");
						System.out.println("----------------------------------------------------------------------");
						System.out.println("[ 7] Premium Double \t \t \t \t > [1906호]");
						System.out.println("[ 8] Premium Twin \t \t \t \t > [1905호]");
						System.out.println("[ 9] Premium Double (Ocean View) \t \t > [1904호]");
						System.out.println("[10] Premium Twin (Ocean View) \t \t \t > [1903호]");
						System.out.println("[11] Deluxe Double \t \t \t \t > [1902호]");
						System.out.println("[12] Deluxe Twin \t \t \t \t > [1901호]");
						System.out.println("======================================================================");
						System.out.println("[0] CLOSE");
						System.out.println("======================================================================");
						
						
						for(int i=0; i<room.length; i++) {
							if((i+1)<10) {
								System.out.print("["+"190"+(i+1)+"호] : ");
							} else {
								System.out.print("[" + "19" + (i+1)+"호] : ");
							}
							
							if(room[i]==1) {
								System.out.println("★ NO VACANCY ★");
							} else {
								System.out.println("☆ VACANCY ☆");
							}
						}
						
						break;
	
					case 0:
						menu2_2 = true;
						System.out.println("> 이전화면으로 돌아갑니다.");
						break;
	
					default:
						System.out.println("√ 잘못된 번호입니다. 번호를 다시 입력하세요.");
						break;
					}
				}
				menu2_2=!menu2_2;
				break;
				
			case 0:
				menu2 = true;	
				System.out.println("> 이전 화면으로 돌아갑니다.");
				break;
				
			default:
				System.out.println("√ 잘못된 번호입니다. 번호를 다시 입력하세요.");
				break;
			}
		}
		
		
		menu2 = !menu2;
		break;
	case 3:
		System.out.println("> 현재 준비중입니다.");
		break;
		
	case 4:
		System.out.println("> 현재 준비중입니다.");
		break;
		
	case 5:
		System.out.println("> 현재 준비중입니다.");
		break;
		
	case 0:
		hotel = true;
		System.out.println("★ GRAND SY HOTEL을 방문해주셔서 감사합니다.");
		System.out.println("END");
		break;

	default:
		System.out.println("잘못된 번호입니다. 번호를 다시 입력하세요.");
		break;
	}
	
}

}
}
