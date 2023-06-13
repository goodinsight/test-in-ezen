package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 객실 규모 받기 및 생성
		System.out.println("객실 규모를 입력하세요");
		int how = scan.nextInt();
		int tmp = 0, tmp2 = 0;
		String tmp3 = "";

		String tmp1 = "";
		int[][] room = new int[how][5]; // 0 이름 1 객실인원 2 가격 3 예약상황(예약시-1 미예약상태-0) 4 예약 번호
		String[][] roomTag = new String[how][2]; // 0 호텔특성 1 예약자명
		boolean power = true;
		boolean power2 = true;

		for (int i = 0; i < room.length; i++) {
			// 방 특성 적용, 가격 지정
			how = (int) (Math.random() * 2 + 1);
			if (how == 1) {
				roomTag[i][0] = "프리미엄";
				room[i][2] = 150000;
			} else {
				roomTag[i][0] = "일반";
				room[i][2] = 75000;
			}
			// 각각의 방 이름을 101 102 이런식으로
			room[i][0] = 100 + (i + 1);
			// 객실인원 랜덤
			how = (int) (Math.random() * 3 + 1);
			room[i][1] = how;
			// 모두 미예약으로
			room[i][3] = 0;
		}
		for (int i = 0; i < room.length; i++) {
			System.out.printf("이름: %d호 객실인원: %d 가격: %6d 특성: %s이며 ", room[i][0], room[i][1], room[i][2], roomTag[i][0]);
			if (room[i][3] == 1) {
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("예약되어있지않습니다");
			}
		}

		System.out.println();

		while (power) {
			power2 = true;
			System.out.println("1: 예약하기 /// 2: 예약취소 /// 3: 예약상황 /// 4: 종료");
			tmp = scan.nextInt();
			switch (tmp) {
			default:
				System.out.println("다시 입력해 주세요");
				break;
			case 4:
				power = false;
				System.out.println("종료합니다...");
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					System.out.printf("이름: %d호 객실인원: %d 가격: %6d 특성: %s이며 ", room[i][0], room[i][1], room[i][2],
							roomTag[i][0]);
					if (room[i][3] == 1) {
						System.out.println("예약되었습니다.");
					} else {
						System.out.println("예약되어있지않습니다");
					}
				}
				break;
			case 1:
				System.out.println("예약할 방의 번호를 입력해 주세요(101호 시작) (0입력시 종료)");
				while (true) {
					tmp = scan.nextInt();
					if (tmp == 0) {
						break;
					}else if (tmp > 100) { //tmp가 105호 이러면
						if (tmp - 101 > room.length) { //지정된 방크기보다 클때 다시 입력
							System.out.println("다시 입력해 주세요");
						} else {    //성공시 탈출
							break;
						}
					} else { //tmp가 5호 이러면
						if (tmp > room.length) {
							System.out.println("다시 입력해 주세요");
						}else {
							break;
						}
					}
				}
				if (tmp == 0) {
					break;
				}
				if (tmp < 100) {
					tmp += 100;
				}
				while (power2) {
					if (tmp == 0) {
						power2 = false;
					} else if (room[tmp - 101][3] == 1) {
						System.out.println("그 방은 이미 예약 되어 있습니다");
					} else {
						System.out.println("예약자명을 입력해 주세요");
						tmp1 = scan.next();
						roomTag[tmp - 101][1] = tmp1;
						System.out.println("예약번호 4자리(숫자)를 입력해 주세요");
						tmp2 = scan.nextInt();
						room[tmp - 101][4] = tmp2;
						System.out.println(roomTag[tmp - 101][1] + "님 예약되었습니다");
						room[tmp - 101][3] = 1;
						power2 = false;
					}
				}
				break;
			case 2:
				System.out.println("예약취소할 방의 번호를 입력해 주세요(101호 시작) (0입력시 종료)");
				while (true) {
					tmp = scan.nextInt();
					if (tmp == 0) {
						break;
					}else if (tmp > 100) { //tmp가 105호 이러면
						if (tmp - 101 > room.length) { //지정된 방크기보다 클때 다시 입력
							System.out.println("다시 입력해 주세요");
						} else {    //성공시 탈출
							break;
						}
					} else { //tmp가 5호 이러면
						if (tmp > room.length) {
							System.out.println("다시 입력해 주세요");
						}else {
							break;
						}
					}
				}
				if (tmp == 0) {
					break;
				}
				if (tmp < 100) {
					tmp += 100;
				}
				if (room[tmp - 101][3] == 0) {
					System.out.println(room[tmp - 101][0] + "은 예약되어 있지 않은 상태입니다");
				} else {
					while (power2) {
						System.out.println("예약번호(숫자)를 입력해 주세요 (0입력시 종료)");
						tmp2 = scan.nextInt();
						if (tmp2 == 0) {
							power2 = false;
							break;
						} else if (room[tmp - 101][4] == tmp2) {
							System.out.println("예약을 취소하였습니다");
							room[tmp - 101][3] = 0;
							power2 = false;
						} else {
							System.out.println("예약번호가 다릅니다");
						}
					}
				}
				break;
//	관리자 모드 호텔특성, 가격, \인원 수정기능
// room 0 이름 1 객실인원 2 가격 3 예약상황(예약시-1 미예약상태-0) 4 예약 번호
// roomTag 0 호텔특성 1 예약자명
			case 77:
				System.out.println("관리자 모드를 실행합니다");
				while (power2) {
					System.out.println("1: 호실특성변경 /// 2: 인원수정 /// 3: 가격변경 /// 0: 종료");
					tmp2 = scan.nextInt();
					switch (tmp2) {
					case 0:
						power2 = false;
						System.out.println("관리자 모드를 종료합니다");
						break;
					case 1:
						System.out.println("어느 호실의 특성을 변경하시나요?");
						while (true) {
							tmp = scan.nextInt();
							if (tmp == 0) {
								break;
							}else if (tmp > 100) { //tmp가 105호 이러면
								if (tmp - 101 > room.length) { //지정된 방크기보다 클때 다시 입력
									System.out.println("다시 입력해 주세요");
								} else {    //성공시 탈출
									break;
								}
							} else { //tmp가 5호 이러면
								if (tmp > room.length) {
									System.out.println("다시 입력해 주세요");
								}else {
									break;
								}
							}
						}
						if (tmp == 0) {
							break;
						}
						if (tmp < 100) {
							tmp += 100;
						}
						System.out.println("현재 " + tmp + "호의 특성은 " + roomTag[tmp - 101][0] + "입니다");
						System.out.println("무엇으로변경하나요? 프리미엄/일반");
						tmp3 = scan.next();
						System.out.println(tmp + "호의 특성을 " + tmp3 + "로 변경합니다");
						roomTag[tmp - 101][0] = tmp3;
						break;
					case 2:
						System.out.println("어느 호실의 최대인원을 변경하시나요?");
						tmp = scan.nextInt();
						while (true) {
							tmp = scan.nextInt();
							if (tmp > 100) { //tmp가 105호 이러면
								if (tmp - 101 > room.length) { //지정된 방크기보다 클때 다시 입력
									System.out.println("다시 입력해 주세요");
								} else {    //성공시 탈출
									break;
								}
							} else { //tmp가 5호 이러면
								if (tmp > room.length) {
									System.out.println("다시 입력해 주세요");
								}else {
									break;
								}
							}
						}
						if (tmp < 100) {
							tmp += 100;
						}
						System.out.println("현재 " + tmp + "호의 최대인원은 " + room[tmp - 101][1] + "입니다");
						System.out.println("무엇으로변경하나요?");
						tmp2 = scan.nextInt();
						System.out.println(tmp + "호의 최대인원을 " + tmp2 + "로 변경합니다");
						room[tmp - 101][1] = tmp2;
						break;
					case 3:
						System.out.println("어느 호실의 가격을 변경하시나요?");
						while (true) {
							tmp = scan.nextInt();
							if (tmp > 100) { //tmp가 105호 이러면
								if (tmp - 101 > room.length) { //지정된 방크기보다 클때 다시 입력
									System.out.println("다시 입력해 주세요");
								} else {    //성공시 탈출
									break;
								}
							} else { //tmp가 5호 이러면
								if (tmp > room.length) {
									System.out.println("다시 입력해 주세요");
								}else {
									break;
								}
							}
						}
						tmp = scan.nextInt();
						if (tmp < 100) {
							tmp += 100;
						}
						System.out.println("현재 " + tmp + "호의 가격은 " + room[tmp - 101][2] + "입니다");
						System.out.println("무엇으로변경하나요?");
						tmp2 = scan.nextInt();
						System.out.println(tmp + "호의 가격을 " + tmp2 + "로 변경합니다");
						room[tmp - 101][2] = tmp2;
						break;
					}
				}
				break;
			}
		}
	}
}
