package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report18 {
	/*
	 * 남은과제 1. 재고관리 만들기 
	 * 2. 돈 10,50,100,500,1000에만 인식하게 하기
	 * 3.
	 */

	public static void main(String[] args) {
		boolean power = false; // 전원
//		메뉴입력, 돈, 음료이름 가격1,2,3, 거스름돈
		int icetea = 1000, cider = 1700, coke = 1800;
		int iceteainv = 2, ciderinv = 0, cokeinv = 0;
		int money = 0;
//		int invselect = 0;

		Scanner scan = new Scanner(System.in);
		while (!power) {

			int select = 0;
			System.out.printf("현재 잔액: %d\n", money);
			System.out.println("선택: 1)아이스티 2)사이다 3)콜라 90)돈 넣기 99)자판기 종료");
			select = scan.nextInt();

			switch (select) { // 음료선택 후 음료 나옴 or 오류
			case 1:
				if (icetea > money) {
					System.out.println("잔액이 부족합니다!");
					continue;
				} else if (iceteainv == 0) {
					System.out.println("재고가 부족합니다!");
					continue;
				} else {
					System.out.println("아이스티가 나왔습니다.");
					money -= 1000;
					iceteainv--;
					break;
				}
			case 2:
				if (cider > money) {
					System.out.println("잔액이 부족합니다!");
					continue;
				} else if (ciderinv == 0) {
					System.out.println("재고가 부족합니다!");
					continue;
				} else {
					System.out.println("사이다가 나왔습니다.");
					money -= 1700;
					ciderinv--;
					break;
				}
			case 3:
				if (coke > money) {
					System.out.println("잔액이 부족합니다!");
					continue;
				} else if (cokeinv == 0) {
					System.out.println("재고가 부족합니다!");
					continue;
				} else {
					System.out.println("콜라가 나왔습니다.");
					money -= 1800;
					cokeinv--;
					break;
				}
			case 90:
				System.out.print("돈을 넣어주세요."); // 임시: 나중에는 10,50,100,500,1000의 숫자만 가능하게 제작.
				money += scan.nextInt();
				continue;

			case 99:
				if (money != 0) {
					System.out.println("거스름돈 " + money + "원 입니다.");
					money = 0;
				}
				power = true;
			}

		}

		System.out.println("자판기 종료!!");
		scan.close();
	}

}