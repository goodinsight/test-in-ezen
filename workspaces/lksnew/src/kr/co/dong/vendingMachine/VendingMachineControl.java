package kr.co.dong.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachineControl {
	List<Product> list = null; // ���Ǳ⿡ ���� ���Ḧ ��� ����Ʈ
	MoneyChanger moneyChanger = null; // �Ž����� ��ȯ�� (�ܵ� ���� ������ �����)
	Customer customer = null; // ���Ǳ⿡ ���� ������ �մ� �ν��Ͻ��� ����
	Menu menu = new Menu(); // �޴� �ҷ��ö� ���
	Administrator admin = new Administrator();
	FileControl fileControl = null;

	public void init() {
		// ���Ͽ��� ���� ���� �ҷ��ͼ� ����
		fileControl = new FileControl();
		moneyChanger = new MoneyChanger();
		customer = new Customer();
		list = fileControl.init();
		if (list == null)
			list = new ArrayList<Product>();
	}

	public String menuView() {
		menu.showTitle("< ���� ���Ǳ� >");
		System.out.println("1. ���� �ִ´�  2. ���Ḧ �̴´� 3.�ܵ��� ��ȯ�Ѵ� 4. ������ �޴��� ���� 5. ����");
		String select = menu.askChoice("�޴��� �����ϼ��� : ");
		return select;
	}

	public void vendingMachinePlay(String select) {
		// ���Ǳ� ���� �޴�
		switch (select) {
		case "1":
			insertMoney();
			break;
		case "2":
			getBevarage();
			break;
		case "3":
			returnMoney();
			break;
		case "4":
			String sel = "";
			while (!sel.equals("4")) {
				sel = adminView();
				adminPlay(sel);
			}
			break;
		case "5":
			System.out.println("���Ǳ� ���α׷��� �����մϴ�.");
			System.exit(0);
			break;
		default:
			System.out.println("�޴��� �ٽ� ����ּ���.");
			break;
		}

	}

	private void adminPlay(String sel) {
		// ������ �޴� ����
		switch (sel) {
		case "1":
			admin.controlProduct(list);
			break;
		case "2":
			admin.controlChange(moneyChanger);
			break;
		case "3":
			admin.controlIncome();
			break;
		case "4":
			System.out.println("������ ��带 �����մϴ�.");
			break;
		default:
			System.out.println("�޴��� �ٽ� ����ּ���.");
			break;
		}
	}

	private String adminView() {
		// ������ �޴�
		menu.showTitle("<������ �޴�>");
		System.out.println("1. ��ǰ���� 2. �ܵ����� 3. ������� 4. ����");
		String select = menu.askChoice("�޴��� �����ϼ���: ");
		return select;
	}

	private void returnMoney() {
		// �ܵ� ��ȯ
		moneyChanger.returnOfChange(customer.getMoney());
		customer.setMoney(0);
	}

	private void getBevarage() {
		// ���� ����
		menu.showTitle("<���Ḧ ������>");
		customer.showMoney();
		fileControl.readFile();
		String select = menu.askChoice("� ���Ḧ ���ðڽ��ϱ�? ");
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSerialNo() == (Integer.parseInt(select))) {
				System.out.println(list.get(i).getName() + "�� ��������");
				int tmp = list.get(i).getNumberOfProduct();
				list.get(i).setNumberOfProduct(tmp - 1); // ��� 1�� ���ҽ�Ŵ
				fileControl.updateFile(list); // ��� ���������� ���Ͽ� �ݿ�
				fileControl.readFile();
				tmp = customer.getMoney();
				customer.setMoney(tmp - list.get(i).getPrice()); // �� �� ���ᰡ�ݸ�ŭ ����
			}
		}
	}

	private void insertMoney() {
		// �� ����
		menu.showTitle("<ȭ�� ����>");
		String insert = menu.askChoice("�󸶸� �����ðڽ��ϱ�? ");
		if (insert.equals("50000") || insert.equals("10000") || insert.equals("5000") || insert.equals("1000")
				|| insert.equals("500") || insert.equals("100")) {
			int tmp = customer.getMoney();
			customer.setMoney(Integer.parseInt(insert) + tmp); // ���� ����
			moneyChanger.insertMoney(Integer.parseInt(insert));
			System.out.println("�ܾ��� " + insert);
		} else {
			System.out.println("�������� �ʴ� ȭ���Դϴ�.");
		}
	}
}
