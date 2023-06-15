package vendingMahchine;

public class FruitMain {

	public static void main(String[] args) {
		boolean power = false;

		FruitView fView = new FruitView();
		CustomerAble cAble = new CustomerAble();
		ManagerAble mAble = new ManagerAble();
		int sel;
		int num;
		int count;

		mAble.init();

		while (!power) {
			sel = fView.mainMenu();
			switch (sel) {
			case 1: // 손님모드
				cAble.addCustomer();
				do {
					sel = fView.customerMenu(cAble.cus, mAble.fList);
					switch (sel) {
					case 1: // 구매
						num = fView.customerMenu1(mAble.fList);
						if (mAble.fList.size() < num) {
							System.out.println("========================");
							System.out.println("없는 번호입니다.");
						} else {
							if (mAble.fList.get(num - 1).getfCount() == 0) {
								fView.customerMenu12(mAble.fList, num);
							} else {
								count = fView.customerMenu11(mAble.fList, num);
								cAble.buyFruit(mAble.fList, cAble.cus, num, count);
							}
						}
						break;
					case 2: // 구매취소
						break;
					case 3: // 구매내역 확인
						cAble.viewBlist();
						break;
					case 4: // 금액 충전
						cAble.addMoney();
						break;
					case 88:
						break;
					default:
						System.out.println("========================");
						System.out.println("잘못된 입력입니다.");
					}
				} while (sel != 88);
				break;
			case 2: // 관리자모드
				break;
			case 99: // 종료
				System.out.println("========================");
				System.out.println("이용해 주셔서 감사합니다.");
				power = true;
				break;
			default: // 그 외 선택
				System.out.println("========================");
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}
