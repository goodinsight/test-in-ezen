package kr.co.dong.CheckPoint;

import java.util.Scanner;

public class CheckTest01_3 {

	public static void main(String[] args) {
//		* 설계 -> 소스작성 -> 디버그
//		* 키보드에 의한 입력작성
//		* 방12개가 있고 ==> 변수?배열? ==> 배열 room[12] (reserve 예약여부가 데이터에 들어있음)
		
//		* 입력구성에서                                //menu변수 : 1,2,3,99를 입력받음
//		* 1을 누른경우는 방의 예약,                     // room[방번호]의 값이 1이면 예약상태
//		*     1 -> 호실번호 선택(1~12) -> 예약 상태여부 확인
//		*       -> 예약가능상태 -> 예약실시 -> 호실확인 -> 메뉴로 복귀
		
//		* 2를 누른 경우 예약취소(예약->공실),             // room[방번호]의 값이 0이면 공실
//		*        2  -> 호실번호 선택(1~12) -> 취소가능 여부
//		*     -> 취소가능 : 해당호실의 값을 0으로 -> 메뉴복귀
//		*   -> 취소불가 : 예약되지 않은 방이라고 표시 -> 메뉴복귀
		
//		* 3을 누른경우는 호실확인, //1인 경우는 "예약됨☆" 0인경우는 "예약가능☆"
//		* 99를 누른 경우는 프로그램 종료.
		
//		=> 추가사항 : 1. 객실규모(크기)는 시작과 동시에 입력함
//				   2. 호텔방번호/호텔방명(예-로얄/참나무 등) / 객실인원 / 가격
//				   3. 예약시 예약자명 / 예약번호(취소시 필요) 등
//				   4. 기타 필요한 기능(관리자모드)
		
		
		boolean power = false;
		int [] room = {0,0,0,0,0,0,0,0,0,0,0,0};  // 방 호실 인덱스
		int menu = 0;     // 메뉴 번호 고르기 
		int select = 0;   // 호실 고르기
		int cancel = 0;   // 취소 할 호실 고르기
		int manage = 0;   // 관리자 모드 입력 받기
		
		String [] name = new String [12];  // 호실 이름설정
		int [] num = new int [12];     // 호실 인원설정
		int [] price = {60000, 60000, 80000, 80000, 80000, 80000, 80000, 80000, 80000, 120000, 240000, 240000};
		   // 호실 가격설정
		
		int nameChange1 = 0;  //호수 이름 변경 선택
		String nameChange2 = " ";  //호수 이름 적는 칸 
		
		int numChange1 = 0;    //호수 인원 변경 선택
		int numChange2 = 0;    //호수 인원 적는 칸
		
		int priceChange1 = 0;  // 가격 변경 호수 선택
		int priceChange2 = 0;  //호수 가격 적는 칸
		
		String [] reserveName = new String [12];   // 예약자 성함
		String [] reserveNum = new String [12];    // 예약시 예약번호
		String [] cancelName = new String [12];
		String [] cancelNum = new String [12];

		name[0] = "싱글룸1";
		name[1] = "싱글룸2";
		name[2] = "더블룸1";
		name[3] = "더블룸2";
		name[4] = "더블룸3";
		name[5] = "트윈룸1";
		name[6] = "트윈룸2";
		name[7] = "트윈룸3";
		name[8] = "디럭스룸";
		name[9] = "패밀리룸";
		name[10] = "스위트룸1";
		name[11] = "스위트룸2";
		
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;
		num[3] = 2;
		num[4] = 2;
		num[5] = 2;
		num[6] = 2;
		num[7] = 2;
		num[8] = 2;
		num[9] = 8;
		num[10] = 10;
		num[11] = 10;

		
		reserveName [0] = " ";
		reserveName [1] = " ";
		reserveName [2] = " ";
		reserveName [3] = " ";
		reserveName [4] = " ";
		reserveName [5] = " ";
		reserveName [6] = " ";
		reserveName [7] = " ";
		reserveName [8] = " ";
		reserveName [9] = " ";
		reserveName [10] = " ";
		reserveName [11] = " ";
		
		reserveNum [0] = " ";
		reserveNum [1] = " ";
		reserveNum [2] = " ";
		reserveNum [3] = " ";
		reserveNum [4] = " ";
		reserveNum [5] = " ";
		reserveNum [6] = " ";
		reserveNum [7] = " ";
		reserveNum [8] = " ";
		reserveNum [9] = " ";
		reserveNum [10] = " ";
		reserveNum [11] = " ";
		
		cancelName [0] = " ";
		cancelName [1] = " ";
		cancelName [2] = " ";
		cancelName [3] = " ";
		cancelName [4] = " ";
		cancelName [5] = " ";
		cancelName [6] = " ";
		cancelName [7] = " ";
		cancelName [8] = " ";
		cancelName [9] = " ";
		cancelName [10] = " ";
		cancelName [11] = " ";
		
		cancelNum [0] = " ";
		cancelNum [1] = " ";
		cancelNum [2] = " ";
		cancelNum [3] = " ";
		cancelNum [4] = " ";
		cancelNum [5] = " ";
		cancelNum [6] = " ";
		cancelNum [7] = " ";
		cancelNum [8] = " ";
		cancelNum [9] = " ";
		cancelNum [10] = " ";
		cancelNum [11] = " ";
		
		
		Scanner scan = new Scanner(System.in);
		
		while (!power) { 
			System.out.println("                                                             ");
			System.out.println("                                    ※예약※                    ");
			System.out.println("                              이용하실 메뉴를 눌러주세요.            ");
			System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
			System.out.println("                                ⑴. 방 예약 하기");
			System.out.println("                                ⑵. 방 예약 취소");
			System.out.println("                                ⑶. 호실 예약 현황 ");
			System.out.println("                                ⑷.  호실 정보 ");
//			System.out.println("                                ⑺⑺. 관리자 모드 ");
			System.out.println("                                ⑼⑼.  종료   ");
			System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("┌──────────────────────────INFORMATION──────────────────────────────┐");
				System.out.println("│   ▶ 호실 이름              ▶ 최대 객실 인원                  ▶ 가격      │");
				System.out.println("└───────────────────────────────────────────────────────────────────┘");
				for (int i=0; i<room.length; i++) {
					System.out.println("│"+(i+1)+"호실 - '"+name[i]+"'               "+num[i]+"명 가능                "+"￦ "+price[i]+"원       │");
				}
				System.out.println("────────────────────────────────────────────────────────────────────");
			
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				System.out.println("                          > 방 예약 하기 입니다.");
				System.out.println("                         > 예약하실 호수를 눌러주세요.");
				select = scan.nextInt();
				System.out.println(select+"호실을 선택 하였습니다.");
				if (room[select-1]==1) {
					System.out.println(select+"호실은 이미 예약이 되어 있어 예약이 불가능합니다");
					System.out.println("> 메뉴로 돌아갑니다. 메뉴를 다시 선택해주세요");
					System.out.println();
					break;
				}
				System.out.println(select+"호실이 예약이 가능합니다.");
				System.out.println("> 예약하시려면 예약자 성함을 적어주세요.");
				reserveName[select-1] = scan.next();
				System.out.println(reserveName[select-1]+"님 "+select+"호실이 예약 되었습니다.");
				reserveName[select-1] = reserveName[select-1];
				room[select-1] = 1; 
				System.out.println("예약번호는 : "+230525+select+select+"번 입니다. 감사합니다.");
				reserveNum[select-1] = "230525"+select+select;
			    System.out.println();
				 
				break;
			case 2:
				System.out.println("> 방 예약 취소 입니다.");
				System.out.println("> 예약 취소하실 호수를 눌러주세요.");
				cancel = scan.nextInt();
				System.out.println(cancel+"호실을 선택 하였습니다.");
				if (room[cancel-1]==1) {
					System.out.println(cancel+"호실의 취소가 가능합니다.");
					System.out.println("> 취소하시려면 예약자 성함을 적어주세요.");
					cancelName[cancel-1] = scan.next();
					if (reserveName[cancel-1].equals(cancelName[cancel-1])) {
						System.out.println(cancelName[cancel-1]+"님 "+cancel+"호실 예약이 확인되었습니다.");
						cancelName[cancel-1] = " ";
						System.out.println("> 예약번호를 입력해주세요.");
						cancelNum[cancel-1] = scan.next();
						if (reserveNum[cancel-1].equals(cancelNum[cancel-1])) {
							System.out.println("> 예약번호가 확인 되었습니다.");
							System.out.println(cancel+"호실의 예약이 취소되었습니다. 감사합니다.");
							cancelNum[cancel-1] = " ";
							room[cancel-1] = 0;
							break;
						}else {
							System.out.println("> 예약번호가 일치하지 않습니다.");
							System.out.println("> 확인 후 다시 입력해주세요.");
							System.out.println("> 메뉴로 돌아갑니다.");
							System.out.println();
							break;
						}
					}else {
						System.out.println("> 예약자가 목록에 없습니다.");
						System.out.println("> 확인 후 다시 입력해주세요.");
						System.out.println("> 메뉴로 돌아갑니다.");
						System.out.println();
						break;
					}
					
				}else {
					System.out.println(cancel+"호실은 예약이 되어있지 않습니다.");
					System.out.println("> 확인 후 다시 입력해주세요.");
					System.out.println("> 메뉴로 돌아갑니다.");
				}
				break;
			case 3:
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				System.out.println("∞∞∞∞∞∞∞∞∞∞[ 현재 호실 예약현황입니다. ]∞∞∞∞∞∞∞∞∞∞");
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				for (int i=0; i<room.length; i++) {
					System.out.print((i+1)+"호실 / "+ name[i]+") : "+ room[i]);
					if (room[i]==0) {
						System.out.println("  ▶ 예약가능 O");
					}else if(room[i]==1) {
						System.out.println("  ▷ 예약불가능 X");
					}
				}
				break;
			
			case 4:
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				System.out.println("∞∞∞∞∞∞∞∞∞∞  [  호실 정보 입니다. ]  ∞∞∞∞∞∞∞∞∞∞");
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				System.out.println("     호실 이름 및 최대객실인원 정보를 알 수 있습니다.  ");
				System.out.println("∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞∞");
				for (int i=0; i<room.length; i++) {
					System.out.println((i+1)+"호실 이름 : '"+name[i]+"' ▶ 객실인원 : (최대)"+num[i]+"명 가능"+" ▶ 가격 : "+"￦ "+price[i]+"원");
				}
				
				break;
				
			case 77:
				System.out.println("●●●●●●●●●●●● [ 관리자 모드입니다.] ●●●●●●●●●●●●");
				System.out.println("●●●●●●●●● 원하는 메뉴의 버튼을 눌러주세요. ●●●●●●●");
				System.out.println();
				System.out.println("1. 호실 이름 변경   2. 객실 인원 설정  3. 호실 가격 설정");
				manage = scan.nextInt();
				
				if (manage==1) {
					System.out.println("> 호실 이름 변경입니다.");
					System.out.println("> 이름 변경을 원하는 호실을 눌러주세요.");
					nameChange1 = scan.nextInt();
			
					System.out.println("> 현재 이름은 "+name[nameChange1-1]+"입니다.");
					System.out.println("> 변경할 이름을 입력해주세요.");
					nameChange2 = scan.next();
					System.out.println(name[nameChange1-1]+"에서 "+nameChange2+"로 변경 되었습니다.");
					name[nameChange1-1] = nameChange2;	
					break;
				}else if (manage==2) {
					System.out.println("> 객실 인원 설정입니다.");
					System.out.println("> 객실 인원 변경을 원하는 호실을 눌러주세요.");
					numChange1 = scan.nextInt();
					
					System.out.println("> 현재 인원은 "+num[numChange1-1]+"입니다.");
					System.out.println("> 변경할 인원을 입력해주세요.");
					numChange2 = scan.nextInt();
					System.out.println(num[numChange1-1]+"명 에서 "+numChange2+"명으로 변경 되었습니다.");
					num[numChange1-1] = numChange2;
					break;
				}
				 else if (manage==3) {
				    System.out.println("> 호실 가격 설정입니다.");
				    System.out.println("> 호실 가격 변경을 원하는 호실을 눌러주세요.");
				    priceChange1 = scan.nextInt();
				
				    System.out.println("> 현재 가격은 "+price[priceChange1-1]+"입니다.");
				    System.out.println("> 변경할 가격을 입력해주세요.");
				    priceChange2 = scan.nextInt();
				    System.out.println("￦"+price[priceChange1-1]+"원 에서 "+"￦"+priceChange2+"원으로 변경 되었습니다.");
			    	price[priceChange1-1] = priceChange2;
				    break;
			    }
		
			case 99:
				power = true;
				System.out.println(">>> 시스템을 종료합니다.");
				break;
			}

		}

	}

}
