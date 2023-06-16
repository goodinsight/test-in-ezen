package vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingMachineControl2 {
	Scanner scan = new Scanner(System.in);
	List<vendingMachine> drink = new ArrayList<>();
	LoginControl lc = new LoginControl();
	int money;

//		초기값
	void init() {
		vendingMachine d1 = new vendingMachine("제로칠성사이다", 2200, 5, 0);
		vendingMachine d2 = new vendingMachine("밀키스제로", 2500, 5, 0);
		vendingMachine d3 = new vendingMachine("제로펩시", 2000, 5, 0);

		drink.add(d1);
		drink.add(d2);
		drink.add(d3);
	}

//		메뉴
	String menu() {
		System.out.println("=====자판기 메뉴=====");
		System.out.println("1.음료메뉴 2.결제금액충전 3.잔돈반환 77.관리자모드");
		System.out.println("남은금액 : " + money);
		System.out.println("번호 입력 : ");

		return scan.next();
	}

//		검색 메소드
	private int searchindex(String drinkname) {
		int index = -1;
		for (int i = 0; i < drink.size(); i++) {
			if (drinkname.equals(drink.get(i).getDrinkName())) {
				index = i;
				break;
			}
		}
		return index;
	}

//		잔돈반환
	void refund() {
		if (money == 0) {
			System.out.println("반환할 잔액이 없습니다.");
		} else {
			System.out.println("반환금액 : " + money);
			money = 0;
		}
	}

//		결제
	void payMent() {
		int plusM = choice("넣으실 금액을 입력하세요 : ");
		money += plusM;
		System.out.println("넣으신 금액 : " + money);
	}

//		음료메뉴
	void drinkMenu() {

		boolean check = false;
		while (!check) {
			view();
			int cnt = 0;
			String name = strChoice("'메뉴'를 입력시 메뉴로 돌아갑니다.\n원하는 음료이름을 입력하세요 : ");
			if (name.equals("메뉴")) {
				System.out.println("메뉴로 돌아갑니다.");
				check = true;
				break;
			}
			int per = searchindex(name);
			if (per == -1) {
				System.out.println("없는 음료입니다.");
			} else if (drink.get(per).getDrinkCount() == 0) {
				System.out.println("재고가 없습니다.");
			} else {
				cnt = count(per);
				pay(cnt, per);
			}
		}
	}

//		결제
	private void pay(int count, int per) {
		int price = drink.get(per).getDrinkPrice() * count;
		boolean check = false;
		while (!check) {
			if (money < price) {
				System.out.println("결제금액이 부족합니다.");
				System.out.println("부족한 금액 : " + (drink.get(per).getDrinkPrice() * count - money));
				String str = strChoice("추가결제를 하시겠습니까? y/n");
				if (str.equals("n") || str.equals("N")) {
					System.out.println("메뉴로 돌아갑니다.");
					check = false;
					break;
				} else if (str.equals("y") || str.equals("Y")) {
					payMent();
				}
			} else {
				System.out.println("**나온 음료 : " + drink.get(per).getDrinkName() + " 개수 :" + count + "개 **");
				money -= price;
				System.out.println("남은 금액 : " + money);
				drink.get(per).setDrinkCount(drink.get(per).getDrinkCount() - count);
				drink.get(per).setSellCount(drink.get(per).getSellCount() + count);
				break;
			}
		}

	}

	// 음료개수
	int count(int per) {
		int count = 0;
		while (true) {
			count = choice("원하는 음료 개수를 입력하세요 : ");
			if (count == 0) {
				System.out.println("1개 이상은 입력해주세요");
			} else if (count > drink.get(per).getDrinkCount()) {
				System.out.println("현재 음료의 재고수보다 많이 입력할수없습니다.");
			} else {
				break;
			}
		}
		return count;
	}

//		음료메뉴보기
	void view() {
		for (vendingMachine v : drink) {
			System.out.println(v);
		}
	}

//		msg받아서 int로 반환
	int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}

//		msg받아서 string으로 반환
	String strChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

}