/*
 *  작성자 : 양진율		날짜 : 2023.05.19		
 *  
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report15_2_1 {

	public static void main(String[] args) {

		final int DRINK_MAX = 3;

		boolean power = false; // 전원

		Scanner scan = new Scanner(System.in);

		int input = 0;
		int balance = 0;
		int mode = 0;
		/*
		 * mode 
		 * 0 : 초기 화면 
		 * 1 : 투입 금액 입력 
		 * 2 : 구입처리(실패시, 실패 원인 출력. 금액 부족/재고 부족) 
		 * 3 : 잔액 반환 
		 * 4 : 관리자 모드 -> 음료/가격/재고 변경 
		 * 		40 : 관리자 모드 - 초기화면 
		 * 		41 : 관리자 모드 - 항목 선택 단계 
		 * 		42 : 관리자 모드 - 수정 단계 
		 * 10 : 종료
		 */
		boolean tmpflag = false;
		int tmpValue = 0;
		String tmpStr = "";

		String[] dName = null;
		int[] dPrice = null;
		int[] dAmount = null;

		int[] changes = { 1000, 500, 100, 50, 10 };

		int targetIdx = 0;

		
//		품목 입력
		dName = new String[] { "커피", "몬스터", "레드불" };
		dPrice = new int[] { 1200, 2900, 2500 };
		dAmount = new int[] { 3, 5, 7 };
		
		
		
		while (!power) {

			switch (mode) {
			case 0:// 초기 화면
				System.out.println("\n\n--자판기-----------------------");// 화면 출력
				System.out.print("번호\t이름\t가격\t재고\n");
				for (int i = 0; i < DRINK_MAX; i++) {
					System.out.println((i + 1) + "\t" + dName[i] + "\t" + dPrice[i] + "\t" + dAmount[i]);
				}
				System.out.println("잔액 : " + balance);
				System.out.println("-----------------------------");

				System.out.println("입력 안내" 
						+ "\n 0\t: 금액 투입" 
						+ "\n 1~3\t: 해당 음료 구입" 
						+ "\n 77\t: 잔액 회수"
						+ "\n 88\t: 관리자 모드" 
						+ "\n 99\t: 종료\n");// 명령어 설명

				System.out.print("실행하시고 싶은 행동을 입력해주세요.\n>>");

				try {
					input = scan.nextInt();
					
					if(input >= 1 && input <= DRINK_MAX) {//타겟 설정 및 case 통일
						targetIdx = input - 1;
						input = 1;
					}
					
				} catch (Exception e) {
					input = 100;
					scan.nextLine();// 무한 반복 방지용 버퍼제거
				}

				switch (input) {
				case 0:
					mode = 1;// 금액 투입
					break;
				case 1: //case 2: case 3:
					mode = 2;// 구입 실행
					break;
				case 77:
					mode = 3;// 잔액 반환
					break;
				case 88:
					mode = 40;// 관리자 모드
					break;
				case 99:
					mode = 10;// 종료
					break;
				default:
					System.out.println("잘못된 입력입니다.");
				}

				break;// 초기 화면 end

			case 1:// 금액 투입

				tmpflag = false;

				while (!tmpflag) {
					try {
						System.out.print("투입 금액을 입력해주세요. \n>>");
						input = scan.nextInt();
						
					} catch (Exception e) {
						input = -1;
						scan.nextLine();// 무한 반복 방지용 버퍼제거
					}

					if (input >= 0) {
						balance += input;
						tmpflag = true;
					} else {
						System.out.println("잘못된 입력입니다.");
					}

				}

				mode = 0;// 초기화면으로
				break;// 금액투입 end

			case 2:// 구매 진행

				// 예외 및 계산
				if (balance < dPrice[targetIdx]) {
					System.out.println("잔액이 부족합니다.");
					mode = 0;
					break;
				} else if (dAmount[targetIdx] == 0) {
					System.out.println("재고가 부족합니다.");
					mode = 0;
					break;
				} else {
					balance -= dPrice[targetIdx];
					dAmount[targetIdx]--;

					System.out.printf("%s을(를) 구입합니다.\n", dName[targetIdx]);
					System.out.printf("잔액 : %d -> %d\n", balance + dPrice[targetIdx], balance);
				}

				mode = 0;// 초기화면으로
				break;//구매진행 end

			case 3:// 잔액 회수

				System.out.printf("잔액 %d원을 회수합니다.\n", balance);

				for (int i = 0; i < changes.length; i++) {
					if (balance / changes[i] > 0) {
						System.out.println(changes[i] + "원 " + balance / changes[i] + "개(장)");
						balance %= changes[i];
					}
				}

				mode = 0;// 초기화면으로
				break;// 잔액 회수 end

			case 40:// 관리자 모드 - 초기 화면

				tmpflag = false;

				while (!tmpflag) {
					System.out.println("\n\n--현재 품목---------------------");// 대충 화면 출력문
					System.out.printf("번호\t이름\t가격\t재고\n");
					for (int i = 0; i < DRINK_MAX; i++) {
						System.out.println((i + 1) + "\t" + dName[i] + "\t" + dPrice[i] + "\t" + dAmount[i]);
					}
					System.out.println("-----------------------------");
					System.out.println("99\t취소");
					System.out.println("-----------------------------");

					System.out.print("수정하시고 싶은 품목의 번호를 입력해주세요.\n>>");
					try {
						input = scan.nextInt();
					} catch (Exception e) {
						input = -1;
						scan.nextLine();// 무한 반복 방지용 버퍼제거
					}

					if (input >= 1 && input <= DRINK_MAX) {// 품목 선택시
						targetIdx = input - 1;
						mode = 41;// 관리자 모드 - 항목 선택으로
						tmpflag = true;
					} else if (input == 99) {// 취소 선택시
						mode = 0;// 초기 화면으로
						tmpflag = true;
					} else {
						System.out.println("잘못된 입력입니다.");
					}

				}
				break;//관리자 모드 - 초기 화면 end

			case 41:// 관리자 모드 - 항목 선택

				tmpflag = false;

				while (!tmpflag) {

					System.out.print("\n\n1) 제품 이름 : " + dName[targetIdx] 
							+ "\n2) 제품 가격 : " + dPrice[targetIdx]
							+ "\n3) 제품 재고 : " + dAmount[targetIdx] 
							+ "\n99) 취소" 
							+ "\n수정하시고 싶은 항목의 번호를 입력해주세요.\n>>");

					try {
						input = scan.nextInt();
					} catch (Exception e) {
						input = -1;
						scan.nextLine();// 무한 반복 방지용 버퍼제거
					}

					if (input >= 1 && input <= 3) {// 항목 선택시
						mode = 42;// 관리자 모드 - 수정 단계로
						tmpflag = true;
					} else if (input == 99) {// 취소 선택시
						mode = 0;// 초기 화면으로
						tmpflag = true;
					} else {
						System.out.println("잘못된 입력입니다.");
					}

				}
				break;// 관리자 모드 - 항목 선택 end

			case 42:// 관리자 모드 - 수정 단계

				tmpflag = false;

				switch (input) {
				case 1:// 이름 변경
					while (!tmpflag) {
						System.out.printf("\n\n현재 이름 : %s\n", dName[targetIdx]);
						System.out.print("새로운 이름을 입력해주세요. (5글자 이하)\n>>");
						tmpStr = scan.next();

						if (tmpStr.length() > 5) {
							System.out.println("이름이 너무 깁니다.");
						} else if (tmpStr.length() == 0) {
							System.out.println("한 글자 이상 입력해주세요.");
						} else {
							dName[targetIdx] = tmpStr;
							tmpflag = true;
						}
					}

					break;// 관리자 모드 - 수정 단계 end

				case 2:// 가격 변경
					while (!tmpflag) {
						System.out.printf("\n\n현재 가격 : %d\n", dPrice[targetIdx]);
						System.out.print("새로운 가격을 입력해주세요. (50000원 이하)\n>>");

						try {
							tmpValue = scan.nextInt();

							if (tmpValue > 50000) {
								System.out.println("수정하고자하는 가격이 너무 높습니다.");
							} else if (tmpValue < 0) {
								System.out.println("0 이상의 가격을 입력해주세요.");
							} else {
								dPrice[targetIdx] = tmpValue;
								tmpflag = true;
							}

						} catch (Exception e) {
							System.out.println("잘못된 입력입니다.");
							scan.nextLine();// 무한 반복 방지용 버퍼제거
						}

					}

					break;// 가격 변경 end
					
				case 3:// 재고 변경
					while (!tmpflag) {
						System.out.printf("\n\n현재 재고 : %d\n", dAmount[targetIdx]);
						System.out.print("증감치를 입력해주세요. (재고는 최대 50)\n>>");

						try {

							tmpValue = scan.nextInt();

							if (tmpValue + dAmount[targetIdx] > 50) {
								System.out.println("추가하고자 하는 값이 너무 큽니다.");
							} else if (tmpValue + dAmount[targetIdx] < 0) {
								System.out.println("재고 수가 부족합니다.");
							} else {
								dAmount[targetIdx] += tmpValue;
								tmpflag = true;
							}

						} catch (Exception e) {
							System.out.println("잘못된 입력입니다.");
							scan.nextLine();// 무한 반복 방지용 버퍼제거
						}

					}

				}

				mode = 40;// 관리자 모드 - 초기 화면으로
				break;// 재고 변경 end

			case 10:// 종료
				System.out.println("거래를 종료합니다.");
				power = true;
			}

		}

	}

}
