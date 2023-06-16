package kr.co.dong.vendingMachine;

import java.util.Scanner;

public class vendingAdmin {
	vendingFunc vf = new vendingFunc();
	Scanner scan = new Scanner(System.in);
	
	int admin_Menu() {
		System.out.println("[1. 제품 추가] [2. 제품 수정] [3. 제품 삭제]");
		return scan.nextInt();
	}
	
	
	void addMenu() {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("가격 : ");
		int price = scan.nextInt();
		System.out.print("제품 번호 : ");
		int number = scan.nextInt();
		System.out.print("재고 : ");
		int amount = scan.nextInt();
		vf.list.add(new Menu(name, price, number, amount));
		System.out.println(vf.list.get(vf.list.size()-1).toString() + "추가되었습니다.");
	}
	
	void setMenu() {
		System.out.print("수정할 메뉴 번호 : ");
		Menu data = vf.search(scan.nextInt());
		if(data.getNumber() != 0) {
			System.out.println("[1. 이름] [2. 가격] [3. 제품번호] [4. 재고]");
			switch (scan.nextInt()) {	
			case 1:
				System.out.print("변경할 이름 : ");
				String name = scan.next();
				System.out.println(data.getName() + "에서" + name +"으로 이름이 변경되었습니다.");
				data.setName(name);
				break;
				
			case 2:
				System.out.print("변경할 가격 : ");
				int price = scan.nextInt();
				System.out.println(data.getPrice() + "에서" + price +"으로 가격이 변경되었습니다.");
				data.setPrice(price);
				break;
				
			case 3:
				System.out.print("변경할 제품 번호 : ");
				int number = scan.nextInt();
				System.out.println(data.getNumber() + "에서" + number +"으로 제품 번호가 변경되었습니다.");
				data.setNumber(number);
				break;
				
			case 4:
				System.out.print("변경할 재고 수 : ");
				int amount = scan.nextInt();
				System.out.println(data.getAmount() + "에서" + amount +"으로 재고 수가 변경되었습니다.");
				data.setAmount(amount);
				break;
				
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
	
	void delMenu() {
		System.out.println("삭제할 메뉴 번호 : ");
		Menu data = vf.search(scan.nextInt());
		if(data.getNumber() != 0) {
			for(Menu menu : vf.list) {
				if(menu.getNumber() == data.getNumber()) {
					System.out.println(menu.getName() + "가 삭제되었습니다.");
					vf.list.remove(data);
				}
			}
		}
	}
	
}
