package vendingMahchine;

import java.util.List;
import java.util.Scanner;

public class FruitView {
	Scanner scan = new Scanner(System.in);

	int mainMenu() {
		System.out.println("========���� ���Ǳ�========");
		System.out.println("1. �մԸ�� ");
		System.out.println("2. �����ڸ��");
		System.out.println("99. ����");
		System.out.println("========================");
		System.out.print("��带 ������ �ּ��� :");
		return scan.nextInt();
	}

	int customerMenu(Customer cus, List<Fruit> fList) {
		System.out.println("========================");
		System.out.println(cus.getcName() + "�� ȯ���մϴ� / �ܾ�(" + cus.getcMoney() + "��)");
		System.out.println("========================");
		System.out.println("======= ������ ���� =======");
		System.out.println("  [���� /  ����  / ��������]");
		System.out.println("------------------------");
		for (int i = 0; i < fList.size(); i++) {
			System.out.println("  " + fList.get(i));
		}
		System.out.println("========================");
		System.out.println("1. ���� ����");
		System.out.println("2. ���� ���� ���");
		System.out.println("3. ���� ���ų��� Ȯ��");
		System.out.println("4. �ݾ� �����ϱ�");
		System.out.println("88. ���ư���");
		System.out.println("========================");
		System.out.print("�޴��� ������ �ּ��� :");
		return scan.nextInt();
	}

	int customerMenu1(List<Fruit> fList) {
		System.out.println("========================");
		for (int i = 0; i < fList.size(); i++) {
			System.out.println(i + 1 + ". " + fList.get(i));
		}
		System.out.println("========================");
		System.out.print("�����Ͻ� ���� ��ȣ�� �����ϼ��� :");
		return scan.nextInt();
	}

	int customerMenu11(List<Fruit> fList, int sel) { // ���������
		System.out.println("========================");
		System.out.println(fList.get(sel - 1));
		System.out.println("========================");
		System.out.print("�����Ͻ� ���� ������ �Է��ϼ��� :");
		return scan.nextInt();
	}
	void customerMenu12(List<Fruit> fList, int sel) { // ��������
		System.out.println("========================");
		System.out.println("  �˼��մϴ� "+fList.get(sel - 1).getfName()+"�� ��� �����ϴ�.");
		System.out.println("========================");
	}

}
