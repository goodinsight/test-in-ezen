package kr.co.dong.vendingMachine;

import java.util.List;

public class Administrator {
	Menu menu = new Menu();
	FileControl fileControl = new FileControl();

	void controlProduct(List<Product> list) {
		// ��ǰ����
		List<Product> tmp = list;
		String sel = productView();
		productPlay(sel, tmp);
	}

	private void productPlay(String select, List<Product> list) {
		// ��ǰ ����
		switch (select) {
		case "1": // ��ǰ �߰�
			addProductPlay(list);
			break;
		case "2": // ��ǰ ����
			removeProductPlay(list);
			break;
		case "3": // ��ǰ ����
			String sel = modifyProductView();
			modifyProductPlay(sel, list);
			break;
		case "4":
			System.out.println("���� �޴��� �̵��մϴ�.");
			break;
		default:
			System.out.println("�޴��� �ٽ� ����ּ���.");
			break;
		}
	}

	private String modifyProductView() {
		menu.showTitle("��ǰ ����");
		System.out.println("1.�̸� ���� 2.���� ���� 3.��� ���� 4. �����޴�"); // ���� �޴��� �����ϰ� 3�� ������ ���������
		String select = menu.askChoice("�޴��� �����ϼ��� : ");
		return select;
	}

	private void addProductPlay(List<Product> list) {
		// ��ǰ �߰�
		try {
			menu.showTitle("��ǰ �߰�");
			System.out.println("<�ȳ�> ���ʴ�� ��ǰ ī�װ�, �̸�, ����, ��ǰ����, ��� �Է��ϼ���");
			String category = menu.askChoice("��ǰ ī�װ��� �Է��ϼ���: ");
			String name = menu.askChoice("��ǰ �̸��� �Է��ϼ���: ");
			String price = menu.askChoice("��ǰ ������ �Է��ϼ���: ");
			String content = menu.askChoice("��ǰ ������ �Է��ϼ���: ");
			String num = menu.askChoice("��� ������ �Է��ϼ���: ");
			Product p = new Product(category, name, Integer.parseInt(price), content, Integer.parseInt(num));
			list.add(p);
			fileControl.writeFile(p);

		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("��ǰ�߰��� �����Ͽ����ϴ�.");
		}
	}

	private void removeProductPlay(List<Product> list) {
		// ��ǰ ����
		menu.showTitle("��ǰ ����");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("� ��ǰ�� �����Ͻðڽ��ϱ�? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String choice = menu.askChoice("�ش� ��ǰ�� ���� ���� �Ͻðڽ��ϱ�?(������ ���Ͻø� y�� �Է�) ");
				if (choice.equals("y")) {
					fileControl.deleteFile(list.get(i));
					list.remove(i);
					System.out.println("��ǰ�� ���� �Ǿ����ϴ�.");
				} else {
					System.out.println("���� ������ ���߾����ϴ�.");
				}
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("�ش� ��ǰ�� ��ǰ��Ͽ� �����ϴ�.");
		}
	}

	private void modifyProductPlay(String select, List<Product> list) {
		// ��ǰ ����
		switch (select) {
		case "1":
			modifyName(list); // ��ǰ �̸� ����
			break;
		case "2":
			modifyPrice(list); // ��ǰ ���� ����
			break;
		case "3":
			modifyNumber(list); // ��ǰ ��� ����
			break;
		case "4":
			System.out.println("���� �޴��� �̵��մϴ�.");
			break;
		default:
			System.out.println("�޴��� �ٽ� ����ּ���.");
			break;
		}
	}

	private void modifyNumber(List<Product> list) {
		// ��ǰ ��� ����
		menu.showTitle("��� ����");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("� ��ǰ�� �����Ͻðڽ��ϱ�? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String num = menu.askChoice("�ٲٽ� ����� ������ �Է��ϼ���: ");
				list.get(i).setNumberOfProduct(Integer.parseInt(num));
				System.out.println("��ǰ�� ��� \"" + list.get(i).getNumberOfProduct() + "\" �� ����Ǿ����ϴ�.");
				fileControl.updateFile(list);
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("�ش� ��ǰ�� ��ǰ��Ͽ� �����ϴ�.");
		}
	}

	private void modifyPrice(List<Product> list) {
		// ��ǰ ���� ����
		menu.showTitle("���� ����");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("� ��ǰ�� �����Ͻðڽ��ϱ�? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String num = menu.askChoice("�ٲٽ� ������ �Է��ϼ���: ");
				list.get(i).setPrice(Integer.parseInt(num));
				System.out.println("��ǰ�� ������ \"" + list.get(i).getPrice() + "��\" �� ����Ǿ����ϴ�.");
				fileControl.updateFile(list);
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("�ش� ��ǰ�� ��ǰ��Ͽ� �����ϴ�.");
		}
	}

	private void modifyName(List<Product> list) {
		// ��ǰ �̸� ����
		menu.showTitle("�̸� ����");
		for (Product p : list)
			System.out.println(p.toString());
		String select = menu.askChoice("� ��ǰ�� �����Ͻðڽ��ϱ�? : ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == Integer.parseInt(select)) {
				String newName = menu.askChoice("�ٲٽ� �̸��� �Է��ϼ���: ");
				list.get(i).setName(newName);
				System.out.println("��ǰ�̸��� \"" + list.get(i).getName() + "\" �� ����Ǿ����ϴ�.");
				fileControl.updateFile(list);
				break;
			}
			if (i == list.size() - 1 && list.get(i).getSerialNo() != Integer.parseInt(select))
				System.out.println("�ش� ��ǰ�� ��ǰ��Ͽ� �����ϴ�.");
		}
	}

	private String productView() {
		menu.showTitle("��ǰ ����");
		System.out.println("1.��ǰ �߰� 2.��ǰ ���� 3.��ǰ ���� 4. �����޴�");
		String select = menu.askChoice("�޴��� �����ϼ��� : ");
		return select;
	}

	void controlChange(MoneyChanger moneyChanger) {
		// �ܵ�����
		menu.showTitle("�ܵ� ����");
		System.out.println(moneyChanger.toString());
		System.out.println("1."+MoneyChanger.moneyName[0]+ " 2."+MoneyChanger.moneyName[1] +" 3." +MoneyChanger.moneyName[2] +" 4." + MoneyChanger.moneyName[3]+ " 5." + MoneyChanger.moneyName[4] + " 6." + MoneyChanger.moneyName[5]);
		String select = menu.askChoice("� �ܵ��� ������ �����Ͻðڽ��ϱ�: ");
		try {
			if(Integer.parseInt(select) >= 1 && Integer.parseInt(select) <= 6) {
				String num = menu.askChoice("�ٲٽ� ������ �Է��ϼ���: ");
				moneyChanger.moneyCount[Integer.parseInt(select)-1] = Integer.parseInt(num);
				System.out.println(MoneyChanger.moneyName[Integer.parseInt(select)-1] +"�� ������ \"" + moneyChanger.moneyCount[Integer.parseInt(select)-1] + "��\" �� ����Ǿ����ϴ�.");
			}else
				System.out.println("�޴��� �ٽ� �������ּ���.");			
		} catch (Exception e) {
			System.out.println("���ڸ� �Է��ϼ���.");
		}
	}

	void controlIncome(LogFileControl logFileControl) {
		// �������
		menu.showTitle("���� ����");
		System.out.println("������� �� ���� : " + logFileControl.sum);
		System.out.println("1. ���Ằ �Ǹ���Ȳ 2. ���Ằ ������Ȳ 3. ���Ằ �������� �׷��� (��Ÿ).�����޴�");
		String select = menu.askChoice("�޴��� �����ϼ��� : ");
		switch (select) {
		case "1":
			menu.showTitle("���Ằ �Ǹ���Ȳ");
			logFileControl.showBeverageSaleNum();
			break;
		case "2":
			menu.showTitle("���Ằ ������Ȳ");
			logFileControl.showBeverageSaleMoney();
			break;
		case "3":
			menu.showTitle("�ð��� ��ü ���� ���");
			logFileControl.readFile();
			break;
		
		default:
			break;
		}
		

	}
}
