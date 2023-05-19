package kr.co.dong.array;

import java.util.Scanner;

public class Report16_02 {

	public static void main(String[] args) {
		int money = 0;
		String[] dName = { "사이다", "콜라", "커피" };
		int[] dPrice = { 1000, 1500, 2000 };
		int[] dAmount = { 5, 5, 5 };
		boolean power = false;
		Scanner scan = new Scanner(System.in);
		int choice = 0;

		while (!power) {
			if (dAmount[0] + dAmount[1] + dAmount[2] == 0) {
				System.out.println("재고 소진으로 종료합니다.");
				System.out.println("거스름 돈이 반환됩니다." + money + "원 반환");
				money = 0; // 투입금액
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			System.out.println("(1)" + dName[0] + "(" + dPrice[0] + "원), (2)" + dName[1] + "(" + dPrice[1] + "원), (3)"
					+ dName[2] + "(" + dPrice[2] + "원), (4)돈 입력, (5)거스름돈, (0)자판기 종료");
			System.out.println("=================================================================================");
			System.out.println("재고는 각 " + dName[0] + " : " + dAmount[0] + "개, " + dName[1] + " : " + dAmount[1] + "개, "
					+ dName[2] + " : " + dAmount[2] + "개 남았습니다");
			
			if (money < dAmount[0]) { 
				System.out.println("구매 가능한 음료가 없습니다. (4)돈 입력, (5)거스름돈 받기");
			} else {
				System.out.print("구매 가능한 음료 : ");
				for (int i = 0; i < dPrice.length; i++) {
					if (money >= dPrice[i]) {
						System.out.print("(" + (i + 1) + ")" + dName[i] + "(" + dPrice[i] + ")");
						if ((money < dPrice[i]) || !(i == 2)) {
							System.out.print(", ");
						}
					}
				}
				System.out.println();
			} // end of else
			System.out.println("남은 금액은 : " + money + "원 입니다.");
			System.out.print("번호를 입력하세요 : ");
			choice = scan.nextInt();

			switch (choice) {
			case 0:
				power = true;

			case 5:
				System.out.println(money + "원이 반환되었습니다.");
				money = 0;
				break;

			case 4:
				System.out.print("넣을 금액을 입력해주세요 : ");
				money += scan.nextInt();
				break;

			case 1:
			case 2:
			case 3:
				choice--;  // 여기에 있는 이유는??
				if (money >= dPrice[choice] && dAmount[choice] > 0) {
					System.out.println(dName[choice] + "가 나왔습니다.");
					money -= dPrice[choice];
					dAmount[choice]--;
				} else if (money < dPrice[choice]) {
					System.out.println("금액이 부족합니다.");
				} else {
					System.out.println("재고가 부족합니다."); // 다른 음료 선택 기능 추가.
				}

			default:
				break;
			}
		}
		System.out.println("자판기 종료.");
	}
}
