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
			case 1: // �մԸ��
				cAble.addCustomer();
				do {
					sel = fView.customerMenu(cAble.cus, mAble.fList);
					switch (sel) {
					case 1: // ����
						num = fView.customerMenu1(mAble.fList);
						if (mAble.fList.size() < num) {
							System.out.println("========================");
							System.out.println("���� ��ȣ�Դϴ�.");
						} else {
							if (mAble.fList.get(num - 1).getfCount() == 0) {
								fView.customerMenu12(mAble.fList, num);
							} else {
								count = fView.customerMenu11(mAble.fList, num);
								cAble.buyFruit(mAble.fList, cAble.cus, num, count);
							}
						}
						break;
					case 2: // �������
						break;
					case 3: // ���ų��� Ȯ��
						cAble.viewBlist();
						break;
					case 4: // �ݾ� ����
						cAble.addMoney();
						break;
					case 88:
						break;
					default:
						System.out.println("========================");
						System.out.println("�߸��� �Է��Դϴ�.");
					}
				} while (sel != 88);
				break;
			case 2: // �����ڸ��
				break;
			case 99: // ����
				System.out.println("========================");
				System.out.println("�̿��� �ּż� �����մϴ�.");
				power = true;
				break;
			default: // �� �� ����
				System.out.println("========================");
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}
