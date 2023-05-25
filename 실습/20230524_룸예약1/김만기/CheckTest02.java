//=> 추가사할 : 1. 객실규모(크기)는 시작과 동시에 입력함
//			  2. 호텔방번호 / 호텔방명(예-로얄/참나무 등)/객실인원/가격
//			  3. 예약시 예약자명 / 예약번호(취소시 필요) 등
//			  4. 기타 필요한 기능(관리자모드)

package kr.co.checkpoint;

import java.util.Scanner;

public class CheckTest02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("호텔 규모 입력(1 ~ 20) : ");
		int roomScale = scan.nextInt(); // 호텔에 등록될 방의 개수 입력
		String input = null;

		int[] roomNumbers = new int[roomScale]; // 각 방의 호실을 저장할 배열
		int[] roomStatus = new int[roomScale];	// 방의 예약 상태를 정수로 저장
		String[] reservationStatus = { "○예약 가능○", "●예약불가능●" }; // roomStatus[]의 저장되어 있는 값에 따라 출력할 문자열 ex) 0 = 예약가능, 1 = 예약 불가능
		
		String[][] reservationNumber = new String[roomScale][2]; // 예약자의 이름과 예약번호를 저장 시킬 2차원 배열 [][0] = 이름, [][1] = 예약번호
		
		// 방의 이름과 가격 투숙가능한 인원수를 저장한 2차원배열
		String[][] roomClass = { 
								{ "Deluxe", "Sweet", "Special", "Guest", "Suit", "King" }, // [0][i] 방의 이름
								{ "100,000", "150,000", "200,000", "250,000", "130,000", "300,000" }, // [1][i] 방의 가격
								{ "3", "2", "4", "3", "2", "5" }  // [2][i] 투숙가능한 인원수
								};

		// roomNumvers[]의 0 ~ 입력한 배열의 길이까지 호실 번호를 저장 (각 층마다 방은 4개씩 저장하기 위해 호실은 X01 ~ X04 까지)
		for (int i = 0; i < roomNumbers.length; i++) {
			int k = i / 4 * 100 + 200;
			roomNumbers[i] = i % 4 + k + 1;
		}
		
		// 호텔 예약프로그램의 시작
		hotel: while (true) {
			System.out.println("=========================================================================================");
			System.out.println("                                           "+((roomScale-1)/4+2)+"층");
			
			// 메인메뉴
			// 각 방의 정보를 출력
			int i = roomNumbers.length-1; // i에 입력한 배열의 길이 -1을 저장
				do {
						// 호실을 위에서부터 내림차순으로 층마다 각 방을 4개씩 출력하기 위한 수식
						for(int j=i-i%4; j<=i; j++) { // 입력한 배열의 길이가 17 이라면  16-(16%4) = 16-0 = 16 = 초기값    j=i;  입력한 배열의 길이 - 1 16까지
							System.out.printf("[ %2d호 %s\t] \t", roomNumbers[j], roomClass[0][i/4+1]); // roomNumbers[16], roomClass[0=방의이름][입력한 배열의 길이-1(16)/4+1]
						}
						System.out.println();
						
						// 정해진 방의 이름에 맞는 가격을 출력
						for(int j=i-i%4; j<=i; j++) {
							System.out.printf("[   가격 %s \t]\t", roomClass[1][i/4+1]);
						}
						System.out.println();
						for(int j=i-i%4; j<=i; j++) {
							System.out.printf("[   인원 수 %s \t]\t", roomClass[2][i/4+1]);
						}
						System.out.println();
						for(int j=i-i%4; j<=i; j++) {
							System.out.printf("[   %s \t]\t", reservationStatus[roomStatus[j]]);
						}
						System.out.println();
						System.out.println("=========================================================================================");
						System.out.println("                                           "+(i/4+1)+"층");
						
						i = (i-i%4)-1; // 층수를 내림차순으로 출력하기 위해 i값을 변화하고 다시 처음부터
						
				}while(i>0); // i가 0이 되면 루프 종료
				
				//그냥 이쁘게 만들기 위한 출력
				System.out.println("[\t\t]\t[\t\t]\t[\t레\t]\t[\t\t]");
				System.out.println("[\t카\t]\t[\t카\t]\t[\t스\t]\t[\t편\t]");
				System.out.println("[\t\t]\t[\t운\t]\t[\t토\t]\t[\t의\t]");
				System.out.println("[\t페\t]\t[\t터\t]\t[\t랑\t]\t[\t점\t]");
				System.out.println("=========================================================================================");
				System.out.println("원하는 메뉴의 번호를 입력해주세요");
				System.out.println("1.예약하기 \t 2.예약취소하기 \t 3.예약확인하기 \t 4.객실확인하기 \t 99.종료");
				
				input = scan.next(); // input은 String타입
				
				mainManu:
				switch(input) {
				case "1": 
					System.out.print("호실을 선택해주세요. : ");
					input = scan.next();
					
					// 입력된 호실 문자열을 정수로 바꿔주기
					int num = Integer.parseInt(input);
					
					// 입력된 호실이 저장되어 있는 배열을 찾을때까지 반복
					for(int j=0; j<roomNumbers.length; j++) {
						if(roomNumbers[j] == num) {
							
							// roomClass[방의 이름][roomNumbers[찾은 호실이 저장되어 있는 인덱스]/100-1 = 찾은 호실의 방의 이름이 저장되어 있는 인덱스]
							System.out.println("선택하신 객실은 "+roomNumbers[j]+"호 "+roomClass[0][roomNumbers[j]/100-1]+"이며");
							System.out.println("[ "+reservationStatus[roomStatus[j]]+" ] 상태 입니다");
							
							// 0이라면 예약이 가능한 호실
							if(roomStatus[j] == 0) {
								System.out.println("예약 하시겠습니까?");
								System.out.println("네 / 아니오");
								input = scan.next();
								switch(input) {
								case "네": case "예": case "sp":
									System.out.println("");
									System.out.println("예약자분 성함을 입력해주세요.");
									reservationNumber[j][0] = scan.next();
									System.out.println(reservationNumber[j][0]+" 님");
									
									// 예약번호는 111111 ~ 999999까지의 랜덤한 수를 문자열로 변환하여 저장
									reservationNumber[j][1] = Integer.toString((int)(Math.random() * 888888) + 111111);
									System.out.println("예약번호는 "+reservationNumber[j][1]+"입니다.");
									roomStatus[j] = 1;
									System.out.println("예약이 완료되었습니다.");
									break mainManu;
								case "아니오": case "아니요": case "아뇨": case "dksldh": case "dksldy":
									System.out.println("취소하였습니다.");
									System.out.println("처음으로 되돌아갑니다.");
									break mainManu;
								default:
									System.out.println("잘못된 입력입니다.");
								}
							}
							else {
								System.out.println("다시 선택해주세요");
								break;
							}
							break;
						}
					}
					System.out.println("잘못된 입력입니다.");
					break;
				case "2":
					System.out.print("예약자분 성함을 입력해주세요. : ");
					input = scan.next();
					for(int j=0; j<reservationNumber.length; j++) {
						if(input.equals(reservationNumber[j][0])) {
							System.out.println(reservationNumber[j][0]+" 님");
							System.out.println("예약하신 객실은 "+roomNumbers[j]+"호 "+roomClass[0][roomNumbers[j]/100-1]+"입니다.");
							System.out.println("예약을 취소하시려면 예약번호를 입력해주세요");
							input = scan.next();
							if(input.equals(reservationNumber[j][1])) {
								roomStatus[j] = 0;
								System.out.println("예약이 취소되었습니다.");
								break mainManu;
							}
							else {
								System.out.println("예약번호가 틀렸습니다");
								break mainManu;
							}
						}
					}
					System.out.println("예약된 객실이 없습니다.");
					break;
				case "3":
					System.out.println("예약자분 성함을 입력해주세요. : ");
					input = scan.next();
					for(int j=0; j<roomNumbers.length; j++) {
						if(input.equals(reservationNumber[j][0])) {
							System.out.println(reservationNumber[j][0]+" 님");
							System.out.println("예약하신 객실은 "+roomNumbers[j]+"호 "+roomClass[0][roomNumbers[j]/100-1]+"입니다.");
							System.out.println("예약번호 : "+reservationNumber[j][1]);
							break mainManu;
						}
					}
					System.out.println("예약된 객실이 없습니다.");
					break;
				case "4":
					break;
				case "55":
					System.out.println("");
				case "99":
					break hotel;
					default:
						System.out.println("잘못된 입력입니다.");
				}
		}
	}
}
