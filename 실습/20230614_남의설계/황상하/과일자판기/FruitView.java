package vendingMahchine;

import java.util.List;
import java.util.Scanner;

public class FruitView {
	Scanner scan = new Scanner(System.in);

	int mainMenu() {
		System.out.println("========과일 자판기========");
		System.out.println("1. 손님모드 ");
		System.out.println("2. 관리자모드");
		System.out.println("99. 종료");
		System.out.println("========================");
		System.out.print("모드를 선택해 주세요 :");
		return scan.nextInt();
	}

	int customerMenu(Customer cus, List<Fruit> fList) {
		System.out.println("========================");
		System.out.println(cus.getcName() + "님 환영합니다 / 잔액(" + cus.getcMoney() + "원)");
		System.out.println("========================");
		System.out.println("======= 오늘의 과일 =======");
		System.out.println("  [종류 /  가격  / 남은개수]");
		System.out.println("------------------------");
		for (int i = 0; i < fList.size(); i++) {
			System.out.println("  " + fList.get(i));
		}
		System.out.println("========================");
		System.out.println("1. 과일 구매");
		System.out.println("2. 과일 구매 취소");
		System.out.println("3. 과일 구매내역 확인");
		System.out.println("4. 금액 충전하기");
		System.out.println("88. 돌아가기");
		System.out.println("========================");
		System.out.print("메뉴를 선택해 주세요 :");
		return scan.nextInt();
	}

	int customerMenu1(List<Fruit> fList) {
		System.out.println("========================");
		for (int i = 0; i < fList.size(); i++) {
			System.out.println(i + 1 + ". " + fList.get(i));
		}
		System.out.println("========================");
		System.out.print("구매하실 과일 번호를 선택하세요 :");
		return scan.nextInt();
	}

	int customerMenu11(List<Fruit> fList, int sel) { // 재고있을시
		System.out.println("========================");
		System.out.println(fList.get(sel - 1));
		System.out.println("========================");
		System.out.print("구매하실 과일 갯수를 입력하세요 :");
		return scan.nextInt();
	}
	void customerMenu12(List<Fruit> fList, int sel) { // 재고없을시
		System.out.println("========================");
		System.out.println("  죄송합니다 "+fList.get(sel - 1).getfName()+"는 재고가 없습니다.");
		System.out.println("========================");
	}

}
