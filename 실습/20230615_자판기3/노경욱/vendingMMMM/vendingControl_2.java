package vendingMMMM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingControl_2 {
	public static Scanner scan = new Scanner(System.in);
	public static int money;
	public static int tmp;
	public static int select;
	public static void main(String[] args) {
		boolean power = true;
		boolean power2 = true;

//		vending 리스트 생성
		List<VendingMea> vending = new ArrayList<VendingMea>();

//		coke, pepsi, cake 생성
		VendingMea coke = new VendingMea("coke", 20, 1500);
		VendingMea pepsi = new VendingMea("pepsi", 20, 3000);
		VendingMea cake = new VendingMea("cake", 20, 5000);

//		vending 리스트에 제품추가
		vending.add(coke);
		vending.add(pepsi);
		vending.add(cake);

		String menu = "1 coke_1500_20개 2 pepsi_3000_20개 3 cake_5000_20개 0.종료";

		System.out.println("자판기 작동 시작");
		while (power) {
			moneyPrint();
			System.out.println("1. 돈입금 2. 구매 3.잔금 반환 0. 종료");
			int sel = scan.nextInt();
			switch (sel) {
			case 0:
				System.out.println("자판기를 종료합니다");
				power = false;
				break;
			case 1:
				moneyAdd();
				break;
			case 2:
				viewMenu(menu);
				int sell = scan.nextInt();
				switch (sell) {
				case 1:
				case 2:
				case 3:
					sell(sell, vending);
					break;
				}
				break;
			case 3:
				moneySubt();
				break;
			case 77:
				System.out.println("관리자 모드 실행");
				while (power2) {
					System.out.println("1. 메뉴수정 2. 가격수정 3. 이름수정 4. 제품개수추가 5. 제품개수제거 6. 제품 추가 7. 제품 제거 0. 종료");
					sel = scan.nextInt();
					switch (sel) {
					case 0:
						System.out.println("관리자 모드 종료");
						power2 = false;
						break;
					case 1:
						menu = changeMenu(menu);
						break;
					case 2:
						select = select(vending) ;
						changePrice(select,vending);
						break;
					case 3:
						select = select(vending);
						changeName(select,vending);
						break;
					case 4:
						select = select(vending);
						addVend(select,vending);
						break;
					case 5:
						select = select(vending);
						removeVend(select,vending);
						break;
					case 6:
						addItem(vending);
						break;
					case 7:
						select = select(vending);
						removeItem(select,vending);
					}
				}
			}
		}
	}

	private static void removeItem(int select2, List<VendingMea> vending) {
		String namee = vending.get(select2).getDrinkName();
		System.out.println("선택한 제품("+namee+")을 제거합니다");
		vending.remove(select2);
		System.out.println("메뉴를 수정해야 합니다");
	}

	private static void addItem(List<VendingMea> vending) {
		System.out.println("제품을 추가합니다");
		System.out.println("양식을 입력하세요 (예시: 제품이름,제품개수,가격");
		String get = scan.next();
		String[] gett = get.split(",");
		String namee = gett[0];
		int countt = Integer.parseInt(gett[1]);
		VendingMea r = new VendingMea(namee, countt, countt);
		vending.add(r);
		System.out.println("메뉴를 수정해야 합니다");
	}

	private static void removeVend(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"의 제품 개수는 "+r.getDrinkCount()+"개 입니다");
		System.out.println("제거할 개수를 입력해 주세요");
		int minuse = r.getDrinkCount()-scan.nextInt();
		r.setDrinkCount(minuse);
		System.out.println("추가완료");
		System.out.println(r.getDrinkName()+"의 제품 개수는 "+r.getDrinkCount()+"개 입니다");
	}

	private static void addVend(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"의 제품 개수는 "+r.getDrinkCount()+"개 입니다");
		System.out.println("추가할 개수를 입력해 주세요");
		int adddd = r.getDrinkCount()+scan.nextInt();
		r.setDrinkCount(adddd);
		System.out.println("추가완료");
		System.out.println(r.getDrinkName()+"의 제품 개수는 "+r.getDrinkCount()+"개 입니다");
	}

	private static void changeName(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"에서 바꿀 이름을 입력하세요");
		String changee = scan.next();
		r.setDrinkName(changee);
		System.out.println("수정하였습니다");
		System.out.println(r.getDrinkName());
		
	}

	private static void changePrice(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"의 가격은 "+r.getDrinkPrice()+"입니다");
		System.out.println("수정할 가격을 입력해 주세요");
		int changePP = scan.nextInt();
		r.setDrinkPrice(changePP);
		System.out.println("수정하였습니다");
		System.out.println(r.getDrinkName()+"의 가격은 "+r.getDrinkPrice()+"입니다");
	}
	
	private static int select( List<VendingMea> vending) {
		System.out.println("제품을 선택해 주세요");
		tmp = 1;
		for(VendingMea r : vending) {
			System.out.print(tmp+". "+r.getDrinkName()+ ", ");
			tmp++;
		}
		System.out.println();
		int choose = scan.nextInt() -1;
		return choose;
		
	}


	private static String changeMenu(String menu) {
		System.out.println("현재 설정된 menu는");
		System.out.println(menu + "<<< 입니다");
		System.out.println("수정할 menu를 입력해 주세요");
		menu = scan.next();
		return menu;
	}

	private static void viewMenu(String menu) {
		System.out.println(menu);

	}

	private static void sell(int sell, List<VendingMea> vending) {
		VendingMea tin = vending.get(sell - 1);
		if (money < tin.getDrinkPrice()) {
			System.out.println("잔액이 부족합니다");
		}else if(tin.getDrinkCount() < 1){
			System.out.println("재고가 부족합니다");
		}
		else {
			System.out.println(tin.getDrinkName() + "가 제공되었습니다");
			money -= tin.getDrinkPrice();
		}
	}

	private static void moneySubt() {
		System.out.println("금액을 반환합니다: " + money);
		money = 0;
	}

	private static void moneyAdd() {
		System.out.println("입금할 금액을 입력해주세요");
		money += scan.nextInt();
	}

	private static void moneyPrint() {
		System.out.println("현재 잔액은: " + money + " 입니다");
	}
}
