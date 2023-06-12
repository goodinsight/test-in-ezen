package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Hotel04_3 {

	public static void main(String[] args) {
//		방 12개가 있고 배열 room[12]
//		입력구성에서 menu변수 : 1,2,3,99를 입력받음
//		1.방 예약
//		1을 누른 경우는 방의 예약 => room[방번호]의 값이 1이면 예약상태
//		1-> 호실번호 선택(1~12) -> 예약상태여부 확인
//		->예약가능상태 -> 예약실시 -> 호실확인 => 메뉴로 복귀

//		2.예약 취소
//		2를 누를 경우 예약 취소(예약-> 공실) -> room[방번호]의 값이 0이면 공실
//		2-> 호실번호 선택(1~12) -> 취소가능여부
//		-> 최소가능 : 해당호실의 값을 0으로 => 메뉴 복귀
//		-> 취소불가 : 예약되지않은 방이라고 표시 => 메뉴복귀

//		3. 호실확인
//		1번-> "예약됨:★" 0번-> "예약가능☆"
//		99 누르면 프로그램 종료

//		=> 추가사항 : 1. 객실규모(크기)는 시작과 동시에 입력(이 호텔에 객실이 몇개 있는지)
//		            2. 호텔방번호/호텔방명(ex-로얄/참나무 등)/객실인원/가격
//		            3. 예약 시 예약자명/예약번호(취소시 필요)/전화번호 등
//		            4. 기타 필요한 기능(관리자모드)

		boolean power = false;
		int[] room = null; // 0,1 예약 상태 확인
		int[] n = null; // 방번호
		String[] name = null; // 방 이름
		int[] hu = null; // 인원
		int[] price = null; // 방가격
		String[] s = null; // 예약자 이름
		int[] nb = null; // 예약번호
		String sCheck = null; // 예약자명 확인
		int nbCheck = 0; // 예약번호 확인
		int password = 1202; // 비밀번호
		int pass = 0; //비밀번호 확인
		int pass1 = 0; // 새로 저장할 비빌번호
		int ran = 0; //랜덤 예약번호
//		int[] ran = null; //랜덤 예약번호
    
//		int[] room = {101 ,102 ,103, 104, 105, 106 }; // 방 번호
		int roomN = -1; // 객실크기
		String[] menu = { "룸 예약", "예약 취소", "호실 확인", "종료" }; // 메뉴번호
		int menu1 = 0; // 메뉴선택
		int button = 0; // 관리자, 사용자 구분 번호

		Scanner scan = new Scanner(System.in);

		System.out.println("객실 크기를 입력해주세요: "); // 입력한게 방 개수  >6개
		roomN = scan.nextInt();
		room = new int[roomN];
		n = new int[roomN]; // 방번호
		name = new String[roomN];// 방 이름
		hu = new int[roomN];// 인원
		price = new int[roomN];// 방가격
		s = new String[roomN];// 예약자 이름
		nb = new int[roomN];// 예약번호
//		ran = new int[9]; //랜덤 예약번호

		for (int i = 0; i < roomN; i++) { //방 호수
			n[i] = 101 + i;
		}
		for (int i = 0; i < roomN; i++) { // 방 이름, 가격
			hu[i] = 4;
			if (n[i] <= 102) {
				name[i] = "일반";
				price[i] = 30000;
			} else if (n[i] <= 104) {
				name[i] = "스텐다드";
				price[i] = 50000;
			} else if (n[i] <= 106) {
				name[i] = "VIP";
				price[i] = 80000;
			}
			System.out.printf("○ %d호 %s %d원\n", n[i], name[i], price[i]);
		}

		while (!power) {
			System.out.println();
			System.out.println("====================================================");
			System.out.println("★☆★☆★☆★☆★☆★☆★☆★☆★☆  Menu  ★☆★☆★☆★☆★☆★☆★☆★☆★☆");
			System.out.println("▶ 1. 룸 예약 2. 예약 취소 3. 호실 확인 66. 관리자모드 99. 종료");
			System.out.println("====================================================");
			System.out.println("▶ 원하는 메뉴를 선택해주세요.");
			menu1 = scan.nextInt();
//		room 이 0일때 = 예약 가능, room 이 1일때 = 예약 불가능
			switch (menu1) {
			case 1: // 예약
				System.out.println("※" + menu[menu1 - 1] + "※을 선택하셨습니다.");
				System.out.println();
				System.out.println("▶원하시는 Room을 선택해주세요(1~"+roomN+"): ");
				button = scan.nextInt();
				if (button > 0 && button <= room.length && room[button - 1] == 0) {
					System.out.println("☞ 선택하신 " + button + "번 방은 예약 가능합니다.");
					System.out.println("☞ 예약자명을 입력해주세요: ");
					s[button - 1] = scan.next();
					for(int i=0; i<1; i++) {
						ran = (int)(Math.random() * 9999) + 1000; // 랜덤 예약번호 1000~9999
						for(int j=0; j<nb.length; j++) {
							if(ran == nb[j]) {
								i--;
							}
						}
					}
					nb[button-1] = ran;
					System.out.println("☞ 예약번호: " + ran );
//					nb[button - 1] = scan.nextInt();
					room[button - 1] = 1;
				} else if (button > 0 && button <= room.length && room[button - 1] == 1) {
					System.out.println("☞ 선택하신 " + button + "번 방은 이미 예약된 방입니다.");
				} else {
					System.out.println("☞ 확인되지 않는 방입니다. 다시 선택해주세요.");
				}
				break;
			case 2: // 예약취소 //여기서 button은 룸 번호
				System.out.println("※" + menu[menu1 - 1] + "※을 선택하셨습니다.");
				System.out.println("▶취소하실 Room 번호를 입력하세요(1~"+roomN+"): ");
				button = scan.nextInt();
				if (button > 0 && button <= room.length && room[button - 1] == 1) {
					System.out.println("☞ 예약자명을 입력해주세요: ");
					sCheck = scan.next();
					if(s[button-1].equals(sCheck)) {//s=문자
						System.out.println("☞ 예약번호를 입력해주세요: ");
						nbCheck = scan.nextInt();
						if(nb[button-1]==nbCheck) {
							room[button - 1] = 0;
							s[button-1] = null;
							nb[button-1] = 0;
							System.out.println("☞ 선택하신 " + button + "번 방이 정상적으로 취소되었습니다.");
						} else {
							System.out.println("☞ 정확하지 않은 예약번호입니다.");
						}
					} else {
						System.out.println("☞ 정확하지 않은 예약자입니다.");
					}
					
				} else if (button > 0 && button <= room.length && room[button - 1] == 0) {
					System.out.println("☞ 선택하신 " + button + "번 방은 예약 되지 않은 방입니다.");
				} else {
					System.out.println("☞ 번호를 다시 입력해주세요.");
				}
				break;
			case 3: // 호실확인
				for (int j = 0; j < roomN; j++) {
					System.out.print(n[j] + "호방");
					if (room[j] == 1) {
						System.out.println("★★이미 예약된 방입니다★★");
					} else if (room[j] == 0) {
						System.out.println(" ☆예약이 가능합니다☆");
					}
				}
				break;
			case 66: //관리자
				System.out.println("▶ 비밀번호를 입력하세요 : ");
				pass = scan.nextInt();
				if(pass == password) {
					System.out.println("================================================");
					System.out.println("                    Menu                        ");
					System.out.println("▶ 1. 예약확인 2. 가격변경 3. 비밀번호 변경 99. 종료");
					System.out.println("================================================");
					System.out.println("▶ 원하는 메뉴를 선택해주세요.");
					menu1 = scan.nextInt();
					switch(menu1) {
					case 1:
						System.out.println("=====================");
						System.out.println("  방호수  예약자  예약번호");
						System.out.println("=====================");
						for(int i=0; i<roomN; i++) {
							if(s[i] != sCheck); {
								if(s[i]==null) {
									s[i] = "     ";
								
								}
							System.out.printf("%5s호 %5s %6s \n",n[i],s[i],nb[i]);
							} //%5 => 글자별 공간(칸 수?)
						}
						System.out.println("=====================");
						break;
					case 2: //가격변경
						for(int i=0; i<roomN; i++) {
							System.out.println(i+1 +"번"+ " "+ n[i]+" "+ name[i]+ " "+price[i]+" "+hu[i]);
						}
						System.out.println("☞ 번호를 입력해주세요.");
						menu1 = scan.nextInt(); //입력한 번호 저장
						System.out.println("☞ 변경할 가격을 입력해주세요.");
						price[menu1-1] = scan.nextInt(); // 바꾼 가격 저장
						break;
					case 3: //비밀번호 변경
						System.out.println("☞ 새로운 비밀번호를 입력하세요.");
						pass1 = scan.nextInt();
						if(password == pass1) { // 기존 비밀번호와 같을때
							System.out.println("☞ 기존 비밀번호와 같습니다. 다른걸로 변경해주세요.");
						}else { // 기존 비밀번호와 다를때
							System.out.println("☞ 변경한 비밀번호가 " + pass1 + "이 맞는지 확인하세요.");
							password = pass1;
						}
						break;
					case 99: //종료(돌아가기)
						power = true;
						System.out.println("====== 관리자모드를 종료합니다 ======");
						break;
					default:
						System.out.println("!!! 잘못 누르셨습니다. 다시 선택해주세요 !!!");
					}
				} else if(password != pass) {
					System.out.println("!!! 비밀번호를 다시 입력하세요 !!!");
				}
				break;
			case 99: // 종료
				power = true;
				System.out.println("====== 예약창이 종료됩니다:) ======");
				break;

			default:
				System.out.println("!!! 잘못 누르셨습니다. 다시 선택해주세요 !!!");
			}
		}
	}
}

