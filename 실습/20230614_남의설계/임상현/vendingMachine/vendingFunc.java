package kr.co.dong.vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingFunc {
	Scanner scan = new Scanner(System.in);
	List<Menu> list = new ArrayList<Menu>();
	int money = 0;
	
	int menu() { // 메뉴
		for(Menu data : list) {
			data.toString();
		}
		System.out.println("[1. 구매] [2. 동전 투입] [3. 거스름돈 반환] [0. 종료] | 남은 잔액 : " + money );
		System.out.print("선택 : ");
		return scan.nextInt();
	}
	
	void buy() { // 구매
		for(Menu data : list) {
			data.toString();
		}
		System.out.println("제품 번호 입력 : ");
		Menu data = search(scan.nextInt());
		if(data.getNumber() != 0) {
			if(data.getAmount() > 0 && data.getPrice() >= money) {
				money -= data.getPrice();
				data.setAmount(data.getAmount()-1);
				System.out.println(data.getName() + "가 나왔습니다.");
			}else if(data.getPrice() > money){
				System.out.println("잔액이 부족합니다.");
			}else {
				System.out.println("재고가 부족합니다.");
			}
		}
	}
	
	void inputMoney() {
		System.out.print("투입할 금액 입력 : ");
		money += scan.nextInt();
	}

	void change() {
		System.out.println(money + "원이 반환되었습니다.");
		money = 0;
	}
	
	Menu search(int num) { // 제품 찾기
		Menu result = null;
		for(Menu data : list) {
			if(data.getNumber() == num) {
				result = data;
				break;
			}else if (data == list.get(list.size() - 1)){
				System.out.println("해당 번호의 제품이 없습니다.");
				return new Menu(null, 0, 0, 0);
			}
		}
		return result;
	}
	
}
