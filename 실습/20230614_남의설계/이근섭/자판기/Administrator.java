package kr.co.dong.vendingMachine;

import java.util.List;

public class Administrator {
	Menu menu = new Menu();
	void controlProduct(List<Product> list) {
		// ��ǰ����
		String sel = productView();
		productPlay(sel);
	}
	
	private void productPlay(String select) {
		// ��ǰ ����
				switch (select) {
				case "1":
					modifyName();
					break;
				case "2":
					modifyPrice();
					break;
				case "3":
					modifyNumber();
					break;
				case "4":
					System.out.println("���� �޴��� �̵��մϴ�.");
					break;
				default:
					System.out.println("�޴��� �ٽ� ����ּ���.");
					break;
				}
	}

	private void modifyNumber() {
		// ��ǰ ��� ����
		
	}

	private void modifyPrice() {
		// ��ǰ ���� ����
		
	}

	private void modifyName() {
		// ��ǰ �̸� ����
		
	}

	private String productView() {
		menu.showTitle("��ǰ ����");
		System.out.println("1.�̸� ���� 2.���� ���� 3.��� ���� 4. �����޴�");
		String select = menu.askChoice("�޴��� �����ϼ��� : ");
		return select;
	}

	void controlChange(MoneyChanger moneyChanger) {
		// �ܵ�����
		System.out.println("���� �غ���");
	}
	
	
	void controlIncome() {
		// �������
		System.out.println("���� �غ���");
		
	}
}
