package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JapangiControl {

	Scanner sc = new Scanner(System.in);
	List<Japangi> japangis = new ArrayList<Japangi>();
	JapangIExpel exjapangi = new JapangIExpel();
	Japangi my = new Japangi(); // 디폴트 생성자가 있어야 함
	// TODO Auto-generated method stub

	void init() { // 초기값
		japangis.add(new Japangi("후라이드", 18000, 5));
		japangis.add(new Japangi("간장", 19000, 5));
		japangis.add(new Japangi("양념", 20000, 5));
	}

	void studentPlay(int ja) {
		switch (ja) {
		case 1:
			customerView();
			break;
		case 2:
			break;
		case 99:
			break;

		default:
			break;
		}
	}

	void customerView() {
		System.out.println("1.전체 메뉴보기 2.구매하기(메뉴 찾기) 3. 삭제된 메뉴보기 4. 돈 추가하기");
		int sel = sc.nextInt();

		switch (sel) {
		case 1:
			for (Japangi j : japangis) {
				System.out.println(j);
			}
			break;

		case 2:
			System.out.println("메뉴를 입력해주세요.");
			String r = sc.next();
			int pirce = japangis.get(japanmenu(r, japangis)).getjPrice();
			int count = japangis.get(japanmenu(r, japangis)).getjCount();
			if (japanmenu(r, japangis) == -1) {
				System.out.println("없는 메뉴입니다.");
			} else {
				System.out.println(japangis.get(japanmenu(r, japangis)) + "선택하셨습니다.");
				System.out.println("1.구매하기 2. 돌아가기");
				int choice = ms("구매하시겠습니까?");
				if (choice == 1) {
					if (my.getjMoney() >= pirce && count != 0) {
						int money1 = my.getjMoney() - pirce; // 돈에서 가격만큼 뺀 것을 담아
						my.setjMoney(money1);
						japangis.get(japanmenu(r, japangis)).setjCount(count - 1); // 구매하면서 재고가 빠짐
						System.out.println("구매가 완료되었습니다.");
						System.out.println("잔돈이 반환됩니다. " + my.getjMoney());
					} else if (my.getjMoney() < pirce) {
						System.out.println("돈이 부족합니다.");
					} else if (count == 0) {
						System.out.println("재고가 없습니다.");
					}

				} else if (choice == 2) {
					System.out.println("돌아가기");
				}
			}
			break;

		case 3:
			System.out.println("더 이상 판매하지 않는 메뉴입니다.");
//			if() {
//				
//			}else {
//				System.out.println("없는 메뉴입니다.");
//			}
			break;

		case 4:
			System.out.println("현재 잔액은  : " + my.getjMoney() + "입니다.");
			System.out.println("돈을 충전하시겠습니까?");
			System.out.println("1.돈을 충전 2. 돌아가기");
			int choice = ms("돈을 충전하시겠습니까?");
			if (choice == 1) {
				System.out.println("충전할 금액을 입력해주세요.");
				int money99 = sc.nextInt();
				my.setjMoney(money99);
				System.out.println("금액을 충전완료했습니다.");

			} else if (choice == 2) {
				System.out.println("돌아가기");
			}

			break;

		default:
			break;
		}

	}

//	 메뉴 찾기 메소드	
	int japanmenu(String jName, List<Japangi> japangis) {
		int index = -1;

		for (int i = 0; i < japangis.size(); i++) {
			if (jName.equals(japangis.get(i).getjName())) {
				index = i;
				break;
			}
		}
		return index;

	}

	private String msg(String msg) {
		System.out.println(msg + " ");
		return sc.next();

	}

	private int ms(String ms) {
		System.out.println(ms + " ");
		return sc.nextInt();
	}
}
