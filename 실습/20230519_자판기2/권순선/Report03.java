package kss.co.kr.array;

import java.util.Scanner;

public class Report03 {
	public static void main(String[] args) {

		boolean power = false;

		String[] dName = { "사이다", "콜라", "맥주" };
		int[] dPrice = { 2000, 3000, 5000 };
		int[] dAmount = { 10, 5, 7 };
		int money = 0;
		int num = 0;
		String xy = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("자판기를 실행하시겠습니까 ( y, x )");
		System.out.print("선택 >> ");
		xy = sc.next();

		switch (xy) {
		case "y":

			while (!power) {

				System.out.println("=======================음료 선택=======================");
				System.out.println("1) " + dName[0] + " " + dPrice[0] + "원 재고 수 " + dAmount[0]);
				System.out.println("2) " + dName[1] + " " + dPrice[1] + "원 재고 수 " + dAmount[1]);
				System.out.println("3) " + dName[2] + " " + dPrice[2] + "원 재고 수 " + dAmount[2]);
				System.out.println("4) 종료");
				System.out.print("돈을 입력 >> ");
				money += sc.nextInt();
				System.out.println("현재 투입 금액 " + money + "원");
				System.out.print("뽑을 음료 번호를 선택 or 종료 >>");
				num = sc.nextInt();

				switch (num) {
				case 1:

					if (money >= dPrice[0] && dAmount[0] > 0) {
						System.out.println(dName[0] + "를 선택");
						dAmount[0] -= 1;
						money -= dPrice[0];
						System.out.println(dPrice[0] + "원 결제");
						System.out.println(dAmount[0] + "개 남음");
						System.out.println(money + "원 남았습니다");
					} else if (money < dPrice[0]) {
						System.out.println("====돈이 부족====");
					} else if (dAmount[0] == 0) {
						System.out.println("====재고가 없음====");
					}

					break;

				case 2:

					if (money >= dPrice[1] && dAmount[1] > 0) {
						System.out.println(dName[1] + "를 선택");
						dAmount[1] -= 1;
						money -= dPrice[1];
						System.out.println(dPrice[1] + "원 결제");
						System.out.println(dAmount[1] + "개 남음");
						System.out.println(money + "원 남았습니다");
					} else if (money < dPrice[1]) {
						System.out.println("====돈이 부족====");
					} else if (dAmount[1] == 0) {
						System.out.println("====재고가 없음====");
					}

					break;

				case 3:

					if (money >= dPrice[2] && dAmount[2] > 0) {
						System.out.println(dName[2] + "를 선택");
						dAmount[2] -= 1;
						money -= dPrice[2];
						System.out.println(dPrice[2] + "원 결제");
						System.out.println(dAmount[2] + "개 남음");
						System.out.println(money + "원 남았습니다");
					} else if (money < dPrice[2]) {
						System.out.println("====돈이 부족====");
					} else if (dAmount[2] == 0) {
						System.out.println("====재고가 없음====");
					}

					break;

				case 4:

					power = true;
					System.out.println("종료");
					System.out.println(money + "원 잔돈입니다");
					break;

				default:

					break;

				}
			}

			break;

		case "x":

			power = true;

			System.out.println("종료");

			break;

		}
	}
}
