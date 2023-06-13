package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest21 {
public static void main(String[] args) {
	
	int[] room = new int[12]; 	//	방 12개를 배열로 선언 * 기본 형태이니 숙지 해둘것 
	int menu = 0; // 메뉴 진입을 위해 선언
	Scanner sc = new Scanner(System.in);
	boolean power = false;
				
		while(!power) {
			
			System.out.println(" ┌──────────────────────────────────────────┬──────────┐");
			System.out.println(" │ ┬ ┬┌─┐┌─┐┌─┐┌┬┐┌┐┌┌─┐┬  ┌─┐┌─┐           │  야좀놀자  │");
			System.out.println(" │ └┬┘├─┤┌─┘│││││││││││││  ┌─┘├─┤     ♬♩    │  숙박예약  │");
			System.out.println(" │  ┴ ┴ ┴└─┘└─┘┴ ┴┘└┘└─┘┴─┘└─┘┴ ┴           │  sys.v1  │");
			System.out.println(" ├──────────────────────────────────────────┴──────────┤");
			System.out.println(" │  1.예약    2.예약취소    3.예약상태확인    99.예약콘솔종료   │");
			System.out.println(" └─────────────────────────────────────────────────────┘");
			System.out.println("  ■■■■ 입력 = ");
			menu = sc.nextInt();
			
			switch(menu){ // 큰 메뉴 
					
			case 1: // 1.예약하기
				
				
				System.out.println(" 현재 예약이 가능한 호실 목록입니다 몇 번방을 예약하시겠습니까? 객실 규모 : " + room.length +"실");
					
				for(int i =0; i<room.length; i++) { // 예약 여부 확인
					
					if(0 == room[i]){
						System.out.println("┌───────┐\n│ "+(char)(9312+i) + " 가능 │\n└───────┘");
						
					}else{
						System.out.println("┌───────┐\n│ "+(char)(9312+i) + " 불가 │\n└───────┘");
					}
					
					if(i==6) {
					
//				System.out.println();
					}
				}
//				System.out.println();
			
				
				int rv = 0; // 예약할 방 고르는 변수
				rv = sc.nextInt(); // 방 번호 선택
				rv--;
				
				switch(rv) { // 방을 예약하면 0 또는 null;에서 1로 치환 하는 수식을 써야함 
				
					case 0: case 1: case 2: case 3: case 4: case 5: case 6:
					case 7: case 8: case 9: case 10: case 11:
								
						if(0==room[rv]) {
						System.out.println(" "+(char)(9312) +" 예약하기 " +(char)(9313)+ " 돌아가기 ");
					
						int rvs = 0; // 선택한 방을 예약하는 변수
						rvs = sc.nextInt();
														
						switch(rvs){
							case 1:// 예약하기가 가능한 호실 예약하기
									
								room[rv] =1;
														
									System.out.println("예약 되었습니다.");
									break;
									
									
								case 2:// 돌아가기
									System.out.println("호실 선택 화면으로 돌아갑니다.");
									break;
									
								default:// 1,2 이외 입력 했을 때
									System.out.println("잘못 된 입력입니다.");
									break;
							}
						}
					
					}
					break;
					
			case 2: // 2.취소하기
				System.out.println(" 현재 취소가 가능한 호실 목록입니다 몇 번방을 예약하시겠습니까?");
					
				for(int i =0; i<room.length; i++) { // 취소 가능 여부 확인
					if(1 == room[i]){
						System.out.print(" "+(char)(9312+i) + " 취소가능 ");
					}else{
						System.out.print(" "+(char)(9312+i) + " 미 예약 ");
					}
				}
				
				rv = sc.nextInt(); // 방 번호 선택
				rv--;
				
				switch(rv) { // 방을 예약하면 0 또는 null;에서 1로 치환 하는 수식을 써야함 
				
				case 0: case 1: case 2: case 3: case 4: case 5: case 6:
				case 7: case 8: case 9: case 10: case 11:
							
					if(1==room[rv]) {
					System.out.println(" "+(char)(9312) +" 취소하기 " +(char)(9313)+ " 돌아가기 ");
				
					int rvs = 0; // 선택한 방을 예약하는 변수
					rvs = sc.nextInt();
													
					switch(rvs){
						case 1:// 예약하기가 가능한 호실 예약하기
								
							room[rv]=0;
												
								System.out.println("예약이 취소 되었습니다.");
								break;
								
								
							case 2:// 돌아가기
								System.out.println("호실 선택 화면으로 돌아갑니다.");
								break;
								
							default:// 1,2 이외 입력 했을 때
								System.out.println("잘못 된 입력입니다.");
								break;
						}
					}
				
				}
				break;
			case 3:
				System.out.println(" 예약 현황을 조회합니다.");
				
				for(int i =0; i<room.length; i++) { // 예약 여부 확인
					if(0 == room[i]){
						System.out.print(" "+(char)(9312+i) + " 공실 ");
					}else{
						System.out.print(" "+(char)(9312+i) + " 예약 ");
					}
				}
				System.out.println();
				
				
				break;
			case 99:
				power = true;
				System.out.println("기기 전원이 종료됩니다.");
				
				break;
				
			default:// 1,2 메뉴 이외 입력 했을 때
				System.out.println("잘못 된 입력입니다.");
				break;
			
				}
			
		
			
		
		
		
		
		}

}//main ed

}//class ed

/*


20230525 추가사항 객실규모는 시작과 동시에 보여줘야함 (입력) 
	호텔방 번호랑 호텔방명(스윗/킹/퀸/더블)/객실최대인원/가격
	예약시 예약자 명 /예약번호 등
	관리자모드라던가 야놀자 모드



입력구성에서 	// menu 변수: 1,2,3,99를 입력받음

1을 누른경우는 방의 예약,	 // room[방번호]의 값이 1이면 예약상태


1-> 호실번호 선택(1~12)-> 예약상태여부 확인

>예약가능상태-> 예약실시->호실확인=> 메뉴로 복귀 ->
예약불가상태-> 호실번호 선택(1~12) or 메뉴로 복귀

2를 누른 경우 예약취소(예약->공실), // room[방번호]의 값이 0이면 공실

2-> 호실번호선택(1~12)-> 취소가능여부

->취소가능: 해당호실의 값을 0으로=> 메뉴복귀
->취소불가: 예약되지않은 방이라고 표시.=> 메뉴복귀

*3를 누른 경우는 호실 확인, // 1인 경우는 "예약됨: ★ "0인경우는 "예약가능☆"

99를 누른 경우는 프로그램종료.

package kr.co.dong.checkPoint;
import java.util.Scanner; // Scanner클래스를 불러들인다.
rt.jar 파일에 있는 클래스들을 사용할수 있게 해준다.

*/