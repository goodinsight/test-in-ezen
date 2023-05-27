package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report08 {
	public static void main(String[] args) {
//		- 3가지 종류 / 별도의 가격 / 재고
//		- 화면에 메뉴 출력
//		- 종류, 가격, 재고, 거스름돈, 입금액 등

		boolean power = true; // 전원
//		메뉴입력, 돈, 상품명1.2.3, 가격1.2.3, 거스름돈
		int pr1 = 1000, pr2 = 2000, pr3 = 3000,
			st1 = 999, st2 = 999, st3 = 999,
			wal = 99999, in = 0, ch = 0;
		String na1 = "water", na2 = "coffee", na3 = "coke";
		Scanner scan = new Scanner(System.in);

		while (power) {
			System.out.print("=====[MENU]=====\n1." + na1 + ": " + pr1 + "w	"
					+ "2." + na2 + ": " + pr2 + "w	" + "3." + na3 + ": " + pr3 + "w" 
					+ "\n(5 입력시 잔돈반환, 99 입력시 종료)\n\n");

			if (wal <= 0) {
				System.out.println("잔돈 부족");
				break;
			}
			if (st1 <= 0 || st2 <= 0 || st3 <= 0) {
				System.out.println("재고 부족");
				break;
			}

			System.out.print("현금 투입 : ");
			in += scan.nextInt();
			wal += in;

			System.out.print("상품 선택 : ");
			ch = scan.nextInt();

			switch (ch) {
			case 1:
				if (in >= pr1) {
					System.out.println("\n" + na1 + " out");
					System.out.println("거스름돈 : " + (in -= pr1) + "w");
					wal -= (in -= pr1);
					st1--;
					break;
				} else {
					System.out.println("금액부족");
					System.out.println("반환액 : " + in + "w");
					wal -= in;
					break;
				}
			case 2:
				if (in >= pr2) {
					System.out.println("\n" + na2 + " out");
					System.out.println("거스름돈 : " + (in -= pr2) + "w");
					wal -= (in -= pr2);
					st2--;
					break;
				} else {
					System.out.println("금액부족");
					System.out.println("반환액 : " + in + "w");
					wal -= in;
					break;
				}
			case 3:
				if (in >= pr3) {
					System.out.println("\n" + na3 + " out");
					System.out.println("거스름돈 : " + (in -= pr3) + "w");
					wal -= (in -= pr3);
					st3--;
					break;
				} else {
					System.out.println("금액부족");
					System.out.println("반환액 : " + in + "w");
					wal -= in;
					break;
				}
			case 5:
				System.out.println("반환액 : " + in + "w");
				in = 0;
				break;
			case 99:
				power = false;
				break;
			default:
				System.out.println("다른 제품을 선택하세요");
				break;
			}
		}
		System.out.println("\noff");
	}
}
