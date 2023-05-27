/*
 * _1 변경 사항
 * 관리자모드 추가
 * 
 */

package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean power = false; // 전원
		String[] dName = null; // 음료이름
		dName = new String[4];
		int[] dPrice = null; // 가격
		dPrice = new int[4];
		int[] dAmount = null; // 재고 양
		dAmount = new int[4];
		int money = 0; // 돈
		int choose = 0;
		int select = 0;

		dName[0] = "물";
		dName[1] = "콜라";
		dName[2] = "커피";

		dPrice[0] = 1000;
		dPrice[1] = 1500;
		dPrice[2] = 2000;

		dAmount[0] = 7;
		dAmount[1] = 7;
		dAmount[2] = 7;
		while (!power) {
//			0. 돈 입력
			System.out.print("돈 투입구에 돈을 넣어주세요 : ");
			money = money + scan.nextInt();

// 			1. 음료의 종류와 가격
			System.out.println("==========[MENU]==========");
			System.out.print("1. 음료의 종류, 음료의 가격, 음료의 재고 수 | 2. 음료 선택");
			System.out.println();
			System.out.println("5 . 돈 반환  |  90.관리자 모드  |  99. 자판기종료");
			System.out.println("돈 잔액 : " + money);
			while (!power) {
//			2. 메뉴 선택
				System.out.println("MENU를 선택해 주세요.");
				choose = scan.nextInt();

//			3. 메뉴 상세 및 수량 및 남은 잔액
				switch (choose) {
				case 1:
					for (int i = 0; i < 3; i++) {
						System.out.println(dName[i] + " 입니다.");
						System.out.println(dPrice[i] + "원 입니다.");
						System.out.println("남은 수량" + dAmount[i] + "개 입니다.");
					}
					continue;
				case 2:
					System.out.println(
							"1. 물 (" + dPrice[0] + ")" + "2.콜라 (" + dPrice[1] + ")" + "3.커피 (" + dPrice[2] + ")");
					select = scan.nextInt();
					if (select == 1) {
						System.out.println(dName[0] + "입니다." + "\n" + dPrice[0] + "원 입니다" + "\n남은 수량은"
								+ (dAmount[0] - 1) + "개 입니다.");
						money = money - dPrice[0];
						System.out.println("남은 잔액은 : " + money);
						if (dAmount[0]-- == 1) {
							System.out.println("매진되었습니다.");
							break;
						}
					} else if (select == 2) {
						System.out.println(dName[1] + "입니다." + "\n" + dPrice[1] + "원 입니다" + "\n남은 수량은"
								+ (dAmount[1] - 1) + "개 입니다.");
						money = money - dPrice[1];
						System.out.println("남은 잔액은 : " + money);
						if (dAmount[1]-- == 1) {
							System.out.println("매진되었습니다.");
							break;
						}
					} else if (select == 3) {
						System.out.println(dName[2] + "입니다." + "\n" + dPrice[2] + "원 입니다" + "\n남은 수량은"
								+ (dAmount[2] - 1) + "개 입니다.");
						money = money - dPrice[2];
						System.out.println("남은 잔액은 : " + money);
						if (dAmount[2]-- == 1) {
							System.out.println("매진되었습니다.");
							break;
						}
					} else if (select == 4) {
						System.out.println(dName[3] + "입니다." + "\n" + dPrice[3] + "원 입니다" + "\n남은 수량은"
								+ (dAmount[3] - 1) + "개 입니다.");
						money = money - dPrice[3];
						System.out.println("남은 잔액은 : " + money);
						if (dAmount[3]-- == 1) {
							System.out.println("매진되었습니다.");
							break;
						}
					}
					continue;
				case 5:
					System.out.println("거스름 돈 반환");
					System.out.println("거스름돈  : " + money + "을 반환합니다  ");
					money = 0;
					System.out.println(money);

					continue;
				case 90:
					System.out.println("1. 상품 확인  2. 재고 확인  3. 가격변동  4. 재고추가  5.상품추가 ");
					select = scan.nextInt();
					if (select == 1) {
						System.out.println("1. 상품 확인");
						System.out.println(dName[0] + " " + dName[1] + " " + dName[2]);
					} else if (select == 2) {
						System.out.println("2. 재고 확인");
						System.out.println(dAmount[0] + " " + dAmount[1] + " " + dAmount[2]);
					} else if (select == 3) {
						System.out.println("3. 가격변동");
						System.out.print("가격 변동 : ");
						dPrice[0] = scan.nextInt();
						System.out.print("가격 변동 : ");
						dPrice[1] = scan.nextInt();
						System.out.print("가격 변동 : ");
						dPrice[2] = scan.nextInt();
						System.out.print("가격 변동 : ");
						dPrice[3] = scan.nextInt();
					} else if (select == 4) {
						System.out.print("재고 추가 수량: ");
						dAmount[0] = scan.nextInt();
						System.out.println(dAmount[0]);
						System.out.print("재고 추가 수량: ");
						dAmount[1] = scan.nextInt();
						System.out.println(dAmount[1]);
						System.out.print("재고 추가 수량: ");
						dAmount[2] = scan.nextInt();
						System.out.println(dAmount[2]);
						System.out.print("재고 추가 수량: ");
						dAmount[3] = scan.nextInt();
						System.out.println(dAmount[3]);
					} else if (select == 5) {
						System.out.print("상품추가 : ");
						dName[3] = scan.next();
						System.out.println(dName[3]);
					}
					continue;

				case 99:
					power = true;
					System.out.println("자판기 종료!!");
					break;
				default:
					System.out.println("메뉴를 다시 선택해 주세요");
					break;
				}
			}
		}
	}
}
