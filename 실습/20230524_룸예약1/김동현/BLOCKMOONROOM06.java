package kr.co.dong.checkPoint;

import java.util.Scanner;

public class BLOCKMOONROOM06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// 방12개가 있다 변수?배열? 배열은 room[12]
		// 메뉴변수는 1,2,3,99를 압력받자
		// 1을 누르면 방을 예약함
		// 호실번호 선택(1~12) +>예약상태여부를 홗인하자
		// 예약가능상태 ->예약실시->호실 홗인 => 메뉴복귀
		// 예약불가면 호실번호를 선택 또는 메뉴로 복귀지
		// 2를 누른경우 예약취소(예약->공실) 룸번호가 0이면 공백
		// 3를 누른경우는 호실확인 , 1이면 예약된거임 0이면 예약가능하대
		// 99를 누르면 종료하자
		// 추가사항1. 객실규모크기는 시작과 동시에 입력하자2. 호텔방번호 호텔방명 객실인원수 가격등등 과
		// 3.예약시 예약자명과 예약번호(취소시 필요)등등 이고 4.기타 필요기능 은 관리자모드!?!?!?4?!?!
		Scanner scan = new Scanner(System.in);
		boolean power = false;
		//int price[] = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 };// 호텔방가격이당
		int[] room = null;// 1이면 예약된거고 0이면 가능이며 없는상태!??!
		int[] price = null;//가격이지
		int[] summerin=null; // 객실인원
		int[] hotelnumber=null;// 호텔방번호
		String saram[] = null;// 예약자명
		String roomname[] = null;// 호텔방명
		int menu;// 메뉴이지 해당메뉴부합하는 스위치문으로 가지 1,2,3,4,99
		int roomsize;// 객실규모
		int num1;// 방예약 여부랑 가능한지 여부를 확인하기 위해 필요한 변수이지
		int[] math;// 예약번호
		
		int abc=0;
		
		System.out.println("객실규모크기를 입력받읍시다");
		roomsize=scan.nextInt();
		room=new int[roomsize];
		price=new int[roomsize];
		summerin=new int[roomsize];
		hotelnumber=new int[roomsize];
		saram=new String[roomsize];
		roomname=new String[roomsize];
		math=new int[roomsize];
		
		for(int i=0;i<room.length;i++) {//입력과 구현
			System.out.println("방번호를 입력하세여");
			hotelnumber[i]=scan.nextInt();
			System.out.println("방이름을 입력하세요");
			roomname[i]=scan.next();
			System.out.println("객실인원을 입력합시다");
			summerin[i]=scan.nextInt();
			System.out.println("가격을 입력합시다");
			price[i]=scan.nextInt();
		}
		while(!power) {
			System.out.println("어서와호텔은첨이지??");
			System.out.println("1.예약부터합시다");
			System.out.println("2.취소인데");
			System.out.println("3.확인여부를체크하자");
			System.out.println("4.객실확인 방정보 확인 등등");
			System.out.println("77.관리자모드로 갈거에요");// 77로 우선 관리자모드를 하자
			System.out.println("99.END!!!");
			System.out.println("방번호,인원수,가격,예약자명과번호를 숙지하고 알려주세요");
			menu = scan.nextInt();
			switch (menu) {
			case 1://예약시스템이다
				System.out.println("안내시스템(예약할방 입력)");
				num1=scan.nextInt();
				
				if(room[num1-1]==0) {
					System.out.println("예약자이름입력");
					saram[num1-1]=scan.next();
					System.out.println("예약번호여부임니당");
					math[num1-1]=scan.nextInt();
//					 if(saram.equals(math)){
//						System.out.println();
//					if(math[num1-1]==1) {
//					}
					room[num1-1]=1;
					System.out.println("예약이됬어요");
				}else if(room[num1-1]==1){
					System.out.println("예약이되있는방이라 안되여");
				}
				break;
			case 2://취소하기 여부 등등이지
				System.out.println("예약취소여부등등");
				num1=scan.nextInt();
				if(room[num1-1]==1) {
					room[num1-1]=0;
					System.out.println("취소됐어여");
				}else{
					System.out.println("예약이 안되어 있어요");
					
				}
				break;
			case 3:
				System.out.println("객실인원");
				abc=scan.nextInt();
				System.out.println(hotelnumber[roomsize-1]);
				
				
				break;
			case 4:
				for(int i=0;i<room.length;i++) {
					System.out.print(i+1+". "+hotelnumber[i]+" "+roomname[i]+" "+price[i]+" "+summerin[i]+" : ");
					if(room[i]==1) {
						System.out.println("예약이 다 찼네요");
					}else if(room[i]==0){
						System.out.println("예약부터 빨리 합시다");
					}
				}
				
				break;
			case 77:
				
				
				break;
			case 99:
				
				
				break;
				
			default:
				break;
			}
		}
	}
}

//		while (!false) {
//			
//			switch (menu) {
//			case 1:
//				System.out.println("객실규모는 ??");
//				roomsize = scan.nextInt();
//				if (room[roomsize - 0] == 0) {
//					//System.out.println("부합하는객실규모입니다:" + roomsize);
//					room[roomsize-1]=1;
//				} else if(room[roomsize-1]==1){
//					System.out.println("해당 객실규모에 부합하지않으니 다시 숙지하고 오세여:" + roomsize);
//				}
//
////					num1 = scan.nextInt();
////					if (room[num1 - 1] == 0) {
////						room[num1 - 1] = 1;// 예약된거임
////					} else if (room[num1 - 1] == 0) {
////						System.out.println("해당방은 없으니 예약하실래여??");
////					}else {//그 어느것도 부합하지 못할경우
////						System.out.println("다시 처음부터 하세염");
////					}
////				}
//				break;
//			case 2:
//				System.out.println("가격is??");
//				System.out.println("호텔방번호랑 이름과 객실인원들 여부를 알려주자");
//				for (int i = 0; i < room.length; i++) {
//					for (int j = 0; j < price.length; j++) {
//						if (price[j] >= 100) {
//							System.out.println("호텔방가격은:" + price[j]);
//						} else if (price[j] < 100) {
//							System.out.println("해당조건에부합하지못해요");
//							hotelnumber = scan.nextInt();
//							if (hotelnumber > 0) {
//								System.out.println("호텔방번호는 :" + hotelnumber);
//							}else{
//								System.out.println("그어떤것도 아니군요 공백인데염");
//								roomname.equals(roomname);
//							}
//						}
////				System.out.println("방번호방이름과인원과가격으로예약되었습니다");
////				num1=scan.nextInt();
////				System.out.println("예약자명과 예약번호를숙지하고 다시입력하세여");
////				math=scan.nextInt();
//
//					}
//				}
//				break;
//			case 3:
//				for (int i = 0; i < room.length; i++) {
////					for(int j=0; j<price.length; j++) {						
////					}
//
//					if (room[i] == 1) {
//						System.out.println(i + 1 + " 방이 예약됏어요");
//					} else if (room[i] == 0) {
//						System.out.println(i + 1 + " 예약이 가능함");
//
//					}
//				}
//				System.out.println("방번호는:");
//				System.out.println("호실이 확인됐으니 입장해도되염");
//				hotelnumber = scan.nextInt();
//				if (hotelnumber > 0) {// 양의숫자면 방번호를 출력 아니면 다시확인하기
//					System.out.println("방번호는: " + hotelnumber);
//				} else if (hotelnumber < 0) {
//					System.out.println("해당사항이없으니 다시하세요");
//				}
//				break;
//			//case 4:
//				// for(int a=0;a<saram.toString();a++) {
//
//				// }
//////				if(saram[]>0&&roomname[]>0) {
//////					saram.equals(saram);
//////					roomname.equals(roomname);
////				}
//			case 4:// 우선 관리자모드는 4로 지정 호출 또는 관리자모드로 하면 되
//				System.out.println("관리자모드 호출 OR 관리자모드변경");
//				break;
//			case 99:// 프로그램 종료 한다 블리언 파워도 끄자
//				System.out.println("집에가자");
//				power = false;
//				break;
//			default:
//				break;
//			}
//		}
//	}
//
//}
