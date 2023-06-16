package drink;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuView {
	Scanner scan = new Scanner(System.in);
	List<Menu> list = new ArrayList<Menu>();
	Menu d = new Menu();

	void init() {
		list.add(new Menu(1, "콜라", 2000, 50));
		list.add(new Menu(2, "사이다", 3000, 60));
		list.add(new Menu(3, "환타", 4000, 70));
		list.add(new Menu(4, "우유", 5000, 80));
	}

	public int MainMenu() {
		System.out.println("=============자판기===============");
		System.out.println("현재잔액 : " + d.getMoney());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("1.구매 2. 잔액충전 3. 잔돈반환 4. 관리자모드 99.종료 ");
		return scan.nextInt();
	}

	void buy() {
		System.out.println("음료번호를 입력해주세요.");
		int sel = scan.nextInt();
		if(d.getMoney()<list.get(sel-1).getDPrice()) {
			System.out.println("금액이 부족합니다.");
		}else if(list.get(sel-1).getStock() == 0) {
			System.out.println("남은 재고가 없습니다.");
					
		}else {
			System.out.println("음료출력");
			d.setMoney(d.getMoney()-list.get(sel-1).getDPrice());
			list.get(sel-1).setStock(list.get(sel-1).getStock()-1); 
			
			//받은돈 - 제품가격...
		}

	}

	void charge() {
		System.out.println("돈을 넣어주세요.");
		int money = scan.nextInt();
		d.setMoney(d.getMoney() + money);
	}

	void change() {
		System.out.println("투입금액 : "+ d.getMoney()+ "을 반환합니다!");
		d.setMoney(0); // 0이 되게...
		
		
		

	}

	void manager() {
		System.out.println("1.메뉴추가 2. 메뉴삭제 3.메뉴 정보수정");
		int sel = scan.nextInt();
		switch(sel) {
		case 1:
			addMenu();
			break;
		case 2:
			deleteMenu();
			break;
		case 3:
			updateMenu();
			break;
			
		}

	}

	private void updateMenu() {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("수정하실 메뉴번호를 선택해주세요");
		int sel = scan.nextInt();
		
		System.out.println("1.음료이름 2. 음료가격 3. 음료재고");
		int sel1 =scan.nextInt();
		
		switch(sel1) {
		
		case 1:
			System.out.println("변경하실 음료 이름을 적어주세요.");
			String name =scan.next();
			list.get(sel-1).setDName(name);
			break;
		case 2:
			System.out.println("변경하실 음료 가격을 적어주세요.");
			int price = scan.nextInt();
			list.get(sel-1).setDPrice(price);
			break;
		case 3:
			System.out.println("변경하실 음료 재고를 적어주세요");
			int stock = scan.nextInt();
			list.get(sel-1).setStock(stock);
			break;
		}
	
		
	}

	private void deleteMenu() {
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("삭제하실 메뉴번호를 입력해주세요.");
		int sel = scan.nextInt();
		System.out.println(list.get(sel-1));
		System.out.println("1.삭제 2.삭제취소");
		int sel1 = scan.nextInt();
		if(sel1 ==1) {
			list.remove(sel-1);
		}else {
			System.out.println("삭제가 취소되었습니다.");
		}
		
		
		
		
	}

	private void addMenu() {
		System.out.println("추가하실 메뉴정보를 입력해주세요");
		
	System.out.println("음료번호을 입력해주세요");
	int num =scan.nextInt();
	System.out.println("음료이름을 입력해주세요");
	String name = scan.next();
	System.out.println("음료가격을 입력해주세요");
	int price = scan.nextInt();
	System.out.println("음료 재고를 입력해주세요");
	int stock = scan.nextInt();
	
	
	
		
	list.add(new Menu(num, name, price, stock));
	}

}
