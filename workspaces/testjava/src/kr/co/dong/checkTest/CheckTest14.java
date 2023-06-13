package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest14 {
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
		int people = 0;
		int num = 0;
		String reservation = "";
		String reservationnum = "";
		String cancel = "";
		int sum = 0;
		int floor = 0;
		int rooms = 0;
		int choice = 0;
		String roomname = "";
		int guest = 0;
//		결제
		int price =0;
//		[층][방]
		int[][] room;
//		[0방이름]	[1가격]	[2정원]
		String[][] detail;
		boolean user = false;
		boolean admin = false;
		boolean power = false;
		int userchoice = 0;
		String judgment = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("호텔의 층수를 입력하세요.");
		floor = sc.nextInt();
		room = new int[floor][];
		detail = new String[floor][3];
		for (int i = 1; i <= floor; i++) {
			System.out.println(i+"번째 층의 객실의 개수를 입력해주세요.");
			rooms = sc.nextInt();
			room[i-1] = new int[rooms];
			System.out.println(i+"층 객실의 개수가 설정되셨습니다.");
			sum += rooms;
			System.out.println(i+"층의 객실이름을 설정해주세요.");
			sc.nextLine();
			roomname = sc.nextLine();
			detail[i-1][0] = roomname;
			System.out.println(i+"층의 객실이름이 설정되셨습니다.");
			System.out.println(detail[i-1][0]+"의 가격을 설정해주세요.");
			price = sc.nextInt();
			detail[i-1][1] = price + "".trim();
			System.out.println(detail[i-1][0]+" 객실의 가격이 설정되셨습니다.");
			System.out.println("객실의 정원을 설정해주세요.");
			guest = sc.nextInt();
			detail[i-1][2] = guest+"".trim();
			System.out.println(detail[i-1][0]+" 객실의 정원이 설정되셨습니다.");
			
		}
//		[예약인][예약번호][객실번호]
		String[][] guestdate = new String[sum][3];
		int money = 0;
		while (true) {
			System.out.println("1. 사용자모드 2. 관리자모드");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				while (!user) {
					System.out.println("메뉴를 선택해주세요\n1. 호실예약    2. 예약취소    3. 호실확인    4. 결제금액 충전    99. 종료");
					userchoice = sc.nextInt();
					switch (userchoice) {
					case 1:
						System.out.println("예약하실 객실을 선택해주세요.");
						for (int i = 0; i < room.length; i++) {
							System.out.print((i+1)+". "+detail[i][0]+"   ");
						}
						userchoice = sc.nextInt();
						floor = userchoice;
						if(userchoice > room.length) {
							System.out.println("잘못 입력하셨습니다 다시 입력해주세요.");
						}
						
						for (int i = 0; i < room[userchoice-1].length; i++) {
							if(i%5 == 0) {
								System.out.println();
							}
							if(room[userchoice-1][i]== 0) {
								judgment = "예약가능☆";
							}else {
								judgment = "불예약가능";
							}
							System.out.print(floor+"0"+(i+1)+"호실("+judgment+")   ");
							
						}
						
						System.out.println("\n예약하실 호실을 선택해주세요.");
						userchoice = sc.nextInt();
						System.out.println("투숙하는 인원을 적어주세요.");
						people = sc.nextInt();
						if(room[floor-1][userchoice-1] == 1) {
							System.out.println("해당 객실은 이미 예약되있습니다. 다른 호실을 선택해주세요.");
						}else if(people > Integer.parseInt(detail[floor-1][2])) {
							System.out.println("해당 객실의 정원은 "+detail[floor-1][2]+"명 까지 가능합니다.");
						}else if(money < Integer.parseInt(detail[floor-1][1])) {
							System.out.println("금액이 부족합니다 결제금액을 충전해주세요. --> 4");
							System.out.println("부족하신 금액 : " +(Integer.parseInt(detail[floor-1][1])-money));
						}else{
							System.out.println("예약자님의 성함을 입력해주세요.");
							reservation = sc.next();
							guestdate[num][0] = reservation;
							System.out.println("예약이 완료되셨습니다.");
							for (int i = 1; i <= 6; i++) {
								reservationnum += (int)(Math.random()*10);
							}
							money -= Integer.parseInt(detail[floor-1][1]);
							guestdate[num][1] = reservationnum;
							guestdate[num][2] = floor + "0" + userchoice;
							
							reservationnum = "";
							System.out.println("예약인 : "+guestdate[num][0]+" 예약번호 : "+guestdate[num][1]+"남은 금액 : "+money);
							room[floor-1][userchoice-1] = 1;
							num++;
						}
						break;
						
					case 2: 
						System.out.println("취소하시려하는 호실을 입력해주세요.");
						cancel = sc.next();
						floor = Integer.parseInt(cancel.substring(0, 1));
						rooms = Integer.parseInt(cancel.substring(2));
						if(room[floor-1][rooms-1] == 0) {
							System.out.println("해당 호실은 예약되어있지 않습니다.");
							break;
						}
						System.out.println("취소하시는분의 성함이나 예약번호를 입력해주세요.");
						reservation = sc.next();
						System.out.println();
						boolean b = false;
						for (int i = 0; i < guestdate.length; i++) {
							if((reservation.equals(guestdate[i][0]) || reservation.equals(guestdate[i][1])) && cancel.equals(guestdate[i][2])) {
								room[floor-1][rooms-1] = 0;
								guestdate[i][0] = "";
								guestdate[0][i] = "";
								b = true;
								break;
							}
						}
						if(b) {
							System.out.println("예약이 취소되셨습니다.");
							
						}else {
							System.out.println("해당 객실에 입력하신 이름 혹은 예약번호가 조회되지않습니다.");
						}
						break;
					case 3:
						System.out.println("조회하실 객실을 선택해주세요.");
						for (int i = 0; i < detail.length; i++) {
							System.out.print((i+1)+". "+detail[i][0]+"   ");
						}
						userchoice = sc.nextInt();
						for (int i = 0; i < room[userchoice-1].length; i++) {
							if(i%5 == 0) {
								System.out.println();
							}
							if(room[userchoice-1][i]== 0) {
								judgment = "예약가능☆";
							}else {
								judgment = "불예약가능";
							}
							System.out.print(userchoice+"0"+(i+1)+"호실("+judgment+")   ");
							
						}
						System.out.println();
					case 4:
						System.out.println("보유하신 금액 : "+money+
								 "원   충전하실 금액을 입력해주세요.");
						money += sc.nextInt();
						System.out.println("금액이 충전되셨습니다. " + money);
						break;
					case 99:
						user = !user;
						break;
					default:
						break;
					}
				}user = !user;
				break;
			case 2:
				while (!admin) {
					System.out.println("1. 예약 조회   99. 관리자 종료");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						if(num == 0) {
							System.out.println("예약하신 손님이 없습니다.");
						}else {
							for (int i = 0; i < num; i++) {
								if(guestdate[i][0] != null) {
									System.out.print("객실번호 : " +guestdate[i][2]+ "호 성함 : "+guestdate[i][0]+" 예약번호 : "+guestdate[i][1]);
								}
							}
							System.out.println();
						}
						break;
					case 99:
						System.out.println("관리자 모드를 종료합니다.");
						admin = !admin;
						break;
					default:
						break;
					}
					break;
				}
					admin = !admin;
				default:
					break;
			}
			
		}
		
		
	}
}
