/*설계 -> 소스작성 - >디버그
 * 키보드에 의한 입력작성
 * 방12개가있고 =>변수? 배열? =>배열room[12]
 * 입력구성에서					//menu변수 : 1,2,3,99를 입력받음
 * 1을 누른경우 는 방의 예약,     //room[방번호]의 값이 1 이면 예약상태
 *    1->호실번호 선택(1~12) -> 예약상태여부 확인
 *    ->예약가능상태 -> 예약실시 ->호실확인 => 메뉴로 복귀
 *    ->예약불가상태 -> 호실번호 선택(1~12)or 메뉴로 복귀
 * 2를 누른 경우 예약취소(예약->공실), //room[방번호]의 값이 0이면 공실
 * 					2->호실번허선택(1~12) -> 취소가능여부
 * 				->취소가능 : 해당호실의 값을 0으로 =>메뉴복귀
 * 				->취소불가 : 예약되지않은 방이라고 표시 =>메뉴복귀
 * 3을 누른 경우는 호실확인, // 1인 경우는 "예약됨:★"0인 경우는"예약가능☆"    
 * 99를 누른경우는 프로그램종료
 * 
 * =>추가사항 :	1.객실규모(개수)는 시작과 동시에 입력함 
 * 			 	2.호텔방번호/홀텔방명(예-로얄/참나무 등)/객실인원/가격
 *  		 	3.예약시 예약자명/예약번호(취소시 필요)등
 *				4.기타 피요한 기능(관리자모드)
 */

package kr.co.dong.checkTest;

import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class CheckTest10 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean power = false; // 전원
		String[] room = new String[12];
		int menu = 0;
		int select = 0;
		int roomNumber = 0;

		room[0] = "101호실(일반 객실) (0)";
		room[1] = "102호실(일반 객실) (1)";
		room[2] = "103호실(일반 객실) (2)";
		room[3] = "104호실(일반 객실) (3)";
		room[4] = "105호실(일반 객실) (4)";
		room[5] = "206호실(로얄 객실) (5)";
		room[6] = "207호실(로얄 객실) (6)";
		room[7] = "208호실(로얄 객실) (7)";
		room[8] = "209호실(로얄 객실) (8)";
		room[9] = "310호실(스위트 룸) (9)";
		room[10] = "311호실(스위트 룸) (10)";
		room[11] = "312호실(스위트 룸) (11)";

		System.out.println("=================[MENU]====================");
		System.out.println("|1.방의 예약 		| 2.예약 취소 	| 3.호실확인");
		System.out.println("|		|		|");
		System.out.println("|50. 관리자모드 	| 99.프로그램 종료  |");
		System.out.println("===========================================");

//		메뉴 선택
		while (!power) {
			System.out.println("MENU를 선택해 주세요");
			menu = scan.nextInt(); // 메뉴 입력

			switch (menu) {
//			방 예약
			case 1:
				for (int i = 0; i < room.length; i++) {
					System.out.println(room[i]);
				}
				System.out.println("예약할 객실을 선택해 주세요(0~11)");
				roomNumber = scan.nextInt();
				if (roomNumber == 0) {
					System.out.println(room[0]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 1) {
					System.out.println(room[1]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 2) {
					System.out.println(room[2]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 3) {
					System.out.println(room[3]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 4) {
					System.out.println(room[4]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 5) {
					System.out.println(room[5]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 6) {
					System.out.println(room[6]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 7) {
					System.out.println(room[7]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 8) {
					System.out.println(room[8]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 9) {
					System.out.println(room[9]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 10) {
					System.out.println(room[10]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				} else if (roomNumber == 11) {
					System.out.println(room[11]);
					System.out.println("예약 확인 : ");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예약가능☆☆☆☆☆!!");

					} else if (select == 1)
						System.out.println("예약됨★★★★★!!");

				}
				continue;
//				예약취소
			case 2:
				System.out.println("예약을 취소할 객실 (0~11)");
				roomNumber = scan.nextInt();
				if (roomNumber == 0) {
					System.out.println(room[0]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 1) {
					System.out.println(room[1]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 2) {
					System.out.println(room[2]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 3) {
					System.out.println(room[3]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 4) {
					System.out.println(room[4]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 5) {
					System.out.println(room[5]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 6) {
					System.out.println(room[6]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 7) {
					System.out.println(room[7]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 8) {
					System.out.println(room[8]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 9) {
					System.out.println(room[9]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 10) {
					System.out.println(room[10]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}

					System.out.println("예약을 취소할 객실 (0~11)");
					roomNumber = scan.nextInt();
				} else if (roomNumber == 11) {
					System.out.println(room[11]);
					System.out.println("예약 확인 : " + select);
					System.out.println("예약을 취소는 0번 입니다.");
					select = scan.nextInt();
					if (select == 0) {
						System.out.println("예☆약☆취☆소 ☆☆!!");
						System.out.println("예약을 취소 합니다.");
						break;
					}
				}

				break;
//				 호실확인
			case 3:
				System.out.println("호실(0~11)");
				System.out.println("0은 예약 가능 | 1은 예약 불가 ");
				roomNumber = scan.nextInt();
				if (roomNumber == 0) {
					System.out.println(room[0]);
					System.out.println("예약 확인 : " + select);
				} else if (roomNumber == 1) {
					System.out.println(room[1]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 2) {
					System.out.println(room[2]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 3) {
					System.out.println(room[3]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 4) {
					System.out.println(room[4]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 5) {
					System.out.println(room[5]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 6) {
					System.out.println(room[6]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 7) {
					System.out.println(room[7]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 8) {
					System.out.println(room[8]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 9) {
					System.out.println(room[9]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 10) {
					System.out.println(room[10]);
					System.out.println("예약 확인 : " + select);

				} else if (roomNumber == 11) {
					System.out.println(room[11]);
					System.out.println("예약 확인 : " + select);

				}

				break;

			case 50:

				break;
//				프로그램 종료
			case 99:
				power = true;
				System.out.println("프로그램 종료!! ");
				break;

			default:
				System.out.println("warning!!!!!");
				break;
			}
		}
	}
}
