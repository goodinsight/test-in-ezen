// ���� ���Ǳ� �����ϱ�
// 1. ���� ����, ����, ���
// 2. �����ϱ�, �Ǹ��ϱ�, �ݾ������ϱ�, �ܵ��ֱ�, ���&����&���� �����ϱ�, ��ȲȮ���ϱ�
package jpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.co.dong.room.Room;

public class DrinkControl {
	Scanner scan = new Scanner(System.in);
	List<Drink> drinks = new ArrayList<Drink>();
	Drink m = new Drink();

	void init() {
		drinks.add(new Drink("������������", 1800, 5));
		drinks.add(new Drink("���ڿ���", 1500, 10));
		drinks.add(new Drink("����", 700, 7));
		drinks.add(new Drink("Ŀ�ǿ���", 800, 0));
	}

	String manu() {

		System.out.println("���� �ܾ� : " + m.getMoniy());
		System.out.println("              �� ���ϴ� �޴��� �Է��ϼ��� ��              ");
		System.out.println("=================================================");
		System.out.println("1. �ݾ����� 2. ���ἱ�� 3. �ܵ���ȯ 4. ���� 5. ���� 99. ����");

		return scan.next();

	}

	void drinkPlay(String sel) {
		// TODO Auto-generated method stub
		switch (sel) {
		case "1": // �ݾ�����
			deposit(); // �Ա�
			break;

		case "2": // ���ἱ��
			choice(); // ����
			break;

		case "3":// �ܵ���ȯ
			returnP(); // ��ȯ
			break;

		case "4": // ����
			crystal();
			break;

		case "5": // ����
			drinkView();
			break;

		case "99":// ����

			break;

		default:
			System.out.println("���α׷��� �����մϴ�. �����մϴ� :)");
		}
	}

	private void deposit() { // �ݾ� ����
		// TODO Auto-generated method stub
		System.out.println("�ݾ��� �������ּ���. ");
		int money = scan.nextInt();

		m.setMoniy(m.getMoniy() + money);

	}

	private void choice() { // �޴�����
		// TODO Auto-generated method stub
		for (int i = 0; i < drinks.size(); i++) {
			System.out.println(drinks.get(i));
		}
		System.out.println("��� ���Ḧ �������ּ���.");
		String name = scan.next();
		searchDriknk(name);
		int index = searchDriknk(name);
		if (index == -1) {
			System.out.println("�ٽ� �������ּ���.");
		} else {
			if (drinks.get(index).getStock() == 0) {
				System.out.println("��� �����ϴ�.");
			} else if (m.getMoniy() < drinks.get(index).getPrice()) {
				System.out.println("�ܾ��� �����մϴ�.");
			} else {
				System.out.println("�����Ͻ� ���ᰡ ���ɴϴ�.");
				drinks.get(index).setStock(drinks.get(index).getStock() - 1);
				m.setMoniy(m.getMoniy() - drinks.get(index).getPrice());
			}
		}

	}

	private void returnP() { // �ܵ���ȯ
		System.out.println("�ܵ��� ��ȯ�˴ϴ� : " + m.getMoniy());
		m.setMoniy(0);
	}

	// ���� ���� �޼ҵ�
	private void crystal() { // ����(����, �ݾ�, ���)
		
		for (int i = 0; i < drinks.size(); i++) {
			System.out.println(drinks.get(i));
		}
		System.out.println("��� ���Ḧ �������ּ���.");
		String name = scan.next();
		searchDriknk(name);
		int index = searchDriknk(name);
		if (index == -1) {
			System.out.println("�ٽ� �������ּ���.");
		} else {
			System.out.println("             �� Ȯ���Ͻ� ��ȣ�� �Է��ϼ��� ��            ");
			System.out.println("===============================================");
			System.out.println("1. �������� 2. �ݾ׼��� 3. ������ 88.���ư���");
			int sel = scan.nextInt();

			switch (sel) {
			case 1: // ��������
				System.out.println("������ ���Ḧ �Է����ּ��� : ");
				String cName = scan.next();
				drinks.get(index).setName(cName);
				break;
			case 2: // �ݾ׼���
				System.out.println("������ �ݾ��� �Է����ּ��� : ");
				int cP = scan.nextInt();
				drinks.get(index).setPrice(cP);
				break;
			case 3: // ������
				System.out.println("������ ��� �Է����ּ��� : ");
				drinks.get(index).setStock(scan.nextInt());
				break;

			case 88: // ���ư���
				break;

			default:
				break;
			}

		}
	}

	private void drinkView() { // ����(��üȮ�� / ���к� Ȯ��)
		// TODO Auto-generated method stub
		System.out.println("             �� Ȯ���Ͻ� ��ȣ�� �Է��ϼ��� ��            ");
		System.out.println("===============================================");
		System.out.println("1. ��üȮ�� 2. ����Ȯ�� 3. ����Ȯ�� 4. ���Ȯ�� 88. ���ư���");
		int sel = scan.nextInt();

		switch (sel) {
		case 1: // ��üȮ��
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i));
			}
			break;
		case 2: // ����Ȯ��
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getName());
			}
			break;
		case 3: // ����Ȯ��
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getPrice());
			}
			break;
		case 4: // ���Ȯ��
			for (int i = 0; i < drinks.size(); i++) {
				System.out.println(drinks.get(i).getStock());
			}
			break;

		case 88: // ���ư���
			break;

		default:
			break;
		}

	}

	// �ε��� �޼ҵ�
	int searchDriknk(String name) {
		int index = -1;
		for (int i = 0; i < drinks.size(); i++) {
			if (drinks.get(i).getName().equals(name)) {
				index = i;
			}
		}

		return index; // �˻��� �л������� �ε���, ���ٸ� -1�� ����
	}

}
