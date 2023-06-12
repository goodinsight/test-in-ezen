package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest5_2 {

	public static void main(String[] args) {
		
//		키보드에 의한 입력작성
//		방12개가 있고 => 변수?배열? => 배열 room[12]
//		입력구성에서			// menu변수 : 1,2,3,99를 입력받음
//		1을 누른경우 는 방의 예약	//room[방번호]의 값이 1이면 예약상태
//		1-> 호실번호 선택(1~12) -> 예약상태여부 확인
//		-> 예약가능상태 -> 예약실시 -> 호실확인 => 메뉴로 복귀
//		-> 예약불가상태 -> 호실번호 선택(1~12) or 메뉴로 복귀
//		2를 누른 경우 예약취소(예약->공실),	//room[방번호]의 값이 0이면 공실
//		2-> 호실번호선택(1~12) -> 취소가능여부
//		-> 취소가능 : 해당호실의 값을 0으로 => 메뉴복귀
//		-> 취소불가 : 예약되지않은 방이라고 표시. => 메뉴복귀
//		3를 누른 경우는 호실 확인,	// 1인 경우는 예약됨:★ "0인경우는 "예약가능☆"
//		99를 누른 경우는 프로그램종료
		
//		=> 추가사항 : 1. 객실규모(크기)는 시작과 동시에 입력함
//					2. 호텔방번호/호텔방명(예-로얄/참나무등)/객실인원/가격
//					3. 예약시 예약자명/예약번호(취소시 필요) 등
//					4. 기타 필요한 기능(관리자모드)
		Scanner sc = new Scanner(System.in);
		
//		예약인, 예약번호, 예약한 방 번호, 마일리지 결제 여부, id, 예약 취소여부
		String[][] userdate = new String[99][6];
		for (int i = 0; i < userdate.length; i++) {
			userdate[i][0] = "";
			userdate[i][1] = "";
			userdate[i][2] = "";
			userdate[i][3] = "";
			userdate[i][4] = "";
		}
//		객실번호, 예약여부
		int[][] room = new int[3][];
//		호텔룸명, 객실인원, 가격
		String[][] roomdate = new String[3][3];
//		유저 아이디, 유저 비밀번호, 마일리지, 잔액, 핸드폰 번호
		String[][] userdate2 = new String[99][5];
//		매뉴얼 선택
		int userchoice = 0;
//		유저 아이디
		String id = "";
//		유저 아이디 인댁스
		int userid = 0;
//		유저 비밀번호
		String pw = "";
//		유저 아이디 조회여부
		boolean idCheck = false;
//		유저 비밀번호 조회여부
		boolean pwCheck = false;
//		맨 처음 페이지 여부
		boolean userpower = false;
//		룸 이름
		String roomname = "";
//		인댁스 저장하는 변수
		int index = 0;
//		예약 여부확인하는 변수
		String reservation = "";
//		case1 무한 루프 여부
		boolean bReservation = false;
//		예약할때 인원수
		int people = 0;
//		호텔 예약시 해당 룸의 해당하는 금액 저장하는 변수
		int roomMoney = 0;
//		고객의 마일리지를 담는 변수
		int mileage = 0;
//		고객의 계정안의 잔액을 담는 변수
		int userMoney = 0;
//		예약시 index 안겹치게 해주는 변수
		int count = 0;
//		예약 번호 랜덤으로 생성하는 변수
		String randomNum = "";
//		예약자 성함 담는 변수
		String name = "";
//		마일리지 사용여부 변수
		char milcheck = ' ';
//		예약 취소시 80%금액 담는 변수
		int cancelMoney = 0;
		
		userdate2[0][0] = "신대한";
		userdate2[0][1] = "user01";
		userdate2[0][2] = "500";
		userdate2[0][3] = "500";
		userdate2[0][4] = "010-8991-7494";
		
		userdate2[1][0] = "신민국";
		userdate2[1][1] = "user02";
		userdate2[1][2] = "500";
		userdate2[1][3] = "500";
		userdate2[1][4] = "010-9047-7494";
		boolean power = false;
		for (int i = 0; i < room.length; i++) {
			System.out.println(i+1+"층의 호텔룸의 이름을 설정해주세요 : ");
			roomdate[i][0] = sc.nextLine();
			System.out.println(roomdate[i][0]+"의 정원을 설정해주세요 : ");
			roomdate[i][1] = sc.next();
			System.out.println(roomdate[i][0]+"의 가격을 설정해주세요 : ");
			roomdate[i][2] = sc.next();
			System.out.println(roomdate[i][0]+"의 방의 개수를 설정해주세요 : ");
			room[i] = new int[sc.nextInt()];
			sc.nextLine();
		}
		
		
		while (!power) {
//			아이디를 입력받음
			System.out.println("==============================================");
			System.out.println("1. 로그인    2. 아이디 찾기    3. 비밀번호 재설정");
			userchoice = sc.nextInt();
			switch (userchoice) {
			case 1:
				while (!idCheck) {
					System.out.println("아이디를 입력해주세요.");
					id = sc.next();
					for(int i = 0; i<userdate2.length;i++) {
						if(id.equals(userdate2[i][0])) {
							userid = i;
							idCheck = !idCheck;
						}
					}
					if(!idCheck) {
						System.out.println("입력하신 아이디는 조회되지 않습니다 다시입력해주세요.");
					}
				}
//				비밀번호를 입력받음
				while (!pwCheck) {
					System.out.println("비밀번호를 입력해주세요.");
					pw = sc.next();
					if(pw.equals(userdate2[userid][1])) {
						System.out.println(userdate2[userid][0]+"고객님 환영합니다. ");
						pwCheck = !pwCheck;
					}else if(pw.equals("0")){
						System.out.println("처음 페이지로 돌아갑니다.");
					}else {
						System.out.println("비밀번호를 잘못 입력하셨습니다 뒤로가기는 0번입니다.");
					}
				}
				break;

			default:
				System.out.println("1~3번만 눌러주세요.");
				break;
			}// 로그인, 아이디찾기, 비밀번호 찾기 끝
			idCheck = !idCheck; pwCheck = !pwCheck;
			while (!userpower) {
				System.out.println("1. 예약하기     2. 예약취소     3. 예약현황     4. 마일리지조회     5. 충전     99. 로그아웃");
				userchoice = sc.nextInt();
				switch (userchoice) {
				case 1:
					while (!bReservation) {
						System.out.print("예약하실 룸의 번호를 선택해주세요.");
						for (int i = 0; i < roomdate.length; i++) {
							System.out.print(i+1+". "+roomdate[i][0]+"    ");
						}
						userchoice = sc.nextInt();
						for (int i = 0; i < room[userchoice-1].length; i++) {
							if(i%5==0) {
								System.out.println();
							}
							
							if(room[userchoice-1][i] == 0) {
								reservation = "예약 가능☆";
							}else {
								reservation = "예약 불가능(T_T)";
							}
							System.out.print((userchoice*100+i+1)+"호 ("+reservation+")   ");
						}
						System.out.println();
						for (int i = 1; i <= 6; i++) {
							randomNum += (int)(Math.random()*9);
						}
						userchoice = sc.nextInt();
						index = userchoice%10;
						mileage = Integer.parseInt(userdate2[userid][2]);		//유저 마일리지 잔액
						userMoney = Integer.parseInt(userdate2[userid][3]);		//유저 아이디 잔액
						if(room[(userchoice/100)-1][index-1] == 1) {
							System.out.println("선택해주신 룸은 이미 예약되어있습니다 다시선택해주세요.");
						}else {
							roomMoney = Integer.parseInt(roomdate[userchoice/100-1][2]);
							System.out.println("투숙하는 인원의 수를 입력해주세요.");
							people = sc.nextInt();
							if(people > Integer.parseInt(roomdate[userchoice/100-1][1])) {
								System.out.println("선택하신 룸의 정원은 "+roomdate[userchoice/100-1][1]+"명입니다. 다른룸을 선택해주세요.");
								break;
							}else if(userMoney < roomMoney){
								System.out.println("금액이 부족합니다. 마일리지를 사용하시겠습니까? Y/N");
								System.out.println("부족한금액 : "+(roomMoney-userMoney)+" 마일리지 : "+mileage);
								milcheck = sc.next().charAt(0);
								if(milcheck == 'Y') {
									if(mileage + userMoney < roomMoney) {
										System.out.println("금액이 부족합니다 부족한 금액을 충전후 다시 예약해주세요.\n"
												+ "부족한 금액 : "+(roomMoney - (mileage+ userMoney)));
												bReservation = !bReservation;
												break;
									}else {
										if(roomMoney < mileage) {
											mileage -= roomMoney;
											roomMoney = 0;
										}else if(roomMoney >mileage) {
											int tmp = 0;
											tmp = mileage;
											mileage -= roomMoney;
											roomMoney -= tmp;
											userMoney -= roomMoney;
										}
										System.out.println("예약자님의 성함을 입력해주세요 : ");
										name = sc.next();
										userdate[count][0] = name;
										userdate[count][1] = randomNum;
										userdate[count][2] = userchoice+"";
										userdate[count][3] = "Y";
										userdate[count][4] = id;
										userdate2[userid][2] = mileage+"";
										userdate2[userid][3] = userMoney+"";
										System.out.println(name+"님 앞으로 예약이 완료되었습니다.");
										room[userchoice/100-1][index-1] = 1;
										bReservation = !bReservation;
										count++;
										randomNum = "";
										System.out.println("남은 돈 : "+userMoney);
										System.out.println("남은 마일리지 : "+mileage);
										break;
									}
								}else if(milcheck == 'N') {
									System.out.println("부족한 금액을 충전후 다시 예약해주세요.\n"
											+"부족한 금액 : "+(roomMoney-userMoney));
									bReservation = !bReservation;
									break;
								}// 마일리지 사용 여부 종료
							}else {
								System.out.println("예약자님의 성함을 입력해주세요 : ");
								name = sc.next();
								userMoney -= roomMoney;
								mileage += 0.10*roomMoney;
								userdate[count][0] = name;
								userdate[count][1] = randomNum;
								userdate[count][2] = userchoice+"";
								userdate[count][3] = "N";
								userdate[count][4] = id;
								userdate2[userid][2] = mileage+"";
								userdate2[userid][3] = userMoney+"";
								room[userchoice/100-1][index-1] = 1;
								bReservation = !bReservation;
								System.out.println(name+"님 앞으로 예약이 완료되었습니다.");
								count++;
								randomNum = "";
								System.out.println("남은 돈 : "+userMoney);
								System.out.println("남은 마일리지 : "+mileage);
								break;
							}
							
						}
					}// 예약 while문 끝
					bReservation = !bReservation;
					break;
//					case1끝
				case 2:
					System.out.println("예약을 취소하실 방을 선택해주세요. 마일리지로 결제한 룸은 금액환불이 안됩니다.");
					userchoice = sc.nextInt();
					for (int i = 0; i < userdate.length; i++) {
						if(userdate[i][2].equals(userchoice+"")&& userdate[i][3].equals("N") && userdate[i][4].equals(id)) {
							System.out.println("비밀번호를 입력해주세요.");
							if(sc.next().equals(pw)) {
								room[userchoice/100-1][userchoice%10-1] = 0;
								cancelMoney = Integer.parseInt(roomdate[userchoice/100-1][2]);
								cancelMoney = (int)(cancelMoney*0.80);
								userdate2[userid][3] = cancelMoney+"";
								System.out.println("예약이 취소되었습니다. 해당 룸 가격에 80%를 환불해드렸습니다 : "+ cancelMoney+"원");
							}else {
								System.out.println("비밀번호를 다시 입력해주세요.");
							}
						}else if(userdate[i][2].equals(userchoice+"")&& userdate[i][3].equals("Y") && userdate[i][4].equals(id)) {
							System.out.println("비밀번호를 입력해주세요.");
							if(sc.next().equals(pw)) {
								room[userchoice/100-1][userchoice%10-1] = 0;
								System.out.println("예약이 취소되었습니다. 마일리지로 결제하신 룸이어서 금액환불은 안됩니다.");
							}else {
								System.out.println("비밀번호를 다시 입력해주세요.");
							}
							
						}else {
							System.out.println("입력하신 객실은 회원님이 예약하시지 않으셨습니다. 예약조회로 가서 확인해주세요. -->6");
						}
					}
					break;
//					예약 취소 끝
				case 3:
					System.out.print("조회하실 룸을 선택해해주세요.");
					for (int i = 0; i < roomdate.length; i++) {
						System.out.print(i+1+". "+roomdate[i][0]+"    ");
					}
					userchoice = sc.nextInt();
					for (int i = 0; i < room[userchoice-1].length; i++) {
						if(room[userchoice-1][i] == 0) {
							reservation = "예약 가능☆";
						}else {
							reservation = "예약 불가능(T_T)";
						}
						System.out.print((userchoice*100+i+1)+"호 ("+reservation+")   ");
					}
					System.out.println();
					break;
//					객실 조회 끝
				case 4:
					System.out.println(userdate2[userid][0]+"님의 마일리지는 "+userdate2[userid][2]+"원 남았습니다.");
					break;
				case 5:
					
					System.out.println("충전하실 금액을 입력해주세요 : ");
					userMoney = sc.nextInt();
					userdate2[userid][3] = (userMoney+Integer.parseInt(userdate2[userid][3]))+"";
					System.out.println("충전이 완료되었습니다. ");
					System.out.println("잔액 : "+userdate2[userid][3]);
					break;
				case 99: 
					userpower = !userpower;
					System.out.println("로그아웃 되셨습니다.");
					id = "";
					pw = "";
//					로그아웃 끝
				default:
					break;
				}
			}
			userpower = !userpower;
			
			
			
		}
	}
}
