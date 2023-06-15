package vendingMahchine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerAble {
	Scanner scan = new Scanner(System.in);
	Customer cus;
	List<Fruit> bList;
	String back;
	public CustomerAble() {
		cus = new Customer();
		bList = new ArrayList<Fruit>();
	}

	void addCustomer() { // ���
		System.out.println("========================");
		System.out.print("�̸��� �Է����ּ��� : ");
		String cName = scan.next();
		cus.setcName(cName);
	}

	// ����
	void addMoney() {
		System.out.println("========================");
		System.out.print("�����Ͻ� �ݾ��� �Է����ּ��� :");
		int money = scan.nextInt();
		cus.setcMoney(cus.getcMoney() + money);
	}

	// ����
	void buyFruit(List<Fruit> fList, Customer cus, int num, int count) {
		if (fList.get(num - 1).getfCount() < count) {
			System.out.println("========================");
			System.out.println("�Է��Ͻ� �������� ��� �����ϴ�.");
		} else if (fList.get(num - 1).getfPrice() * count > cus.getcMoney()) {
			System.out.println("�����Ͻ� �ݾ��� �����մϴ�.");
		} else {
			addBlist(fList.get(num - 1).getfName(), fList.get(num - 1).getfPrice() * count, count);
			fList.get(num-1).setfCount(fList.get(num-1).getfCount()-count);
			cus.setcMoney(cus.getcMoney()-fList.get(num - 1).getfPrice() * count);
		}
	}

	// ���ų��� �߰�
	void addBlist(String fName, int fPrice, int fCount) {
		bList.add(new Fruit(fName, fPrice, fCount));
	}

	// ���ų��� ����
	void delBlist() {
		
	}
	// ���ų��� Ȯ��
	void viewBlist() {
		int allPrice=0;
		if(bList.size() == 0) {
			System.out.println("======= ���� ���ų��� =======");
			System.out.println(" [���� /  �ֹ�����  / �ֹ�����]");
			System.out.println("------------------------");
			System.out.println("   �ֹ��Ͻ� ������ �����ϴ�.");
			System.out.println("========================");
			System.out.print("���ư��÷��� �ƹ�Ű�� �Է����ּ���.");
			back = scan.next();
		}else {		
			System.out.println("======= ���� ���ų��� =======");
			System.out.println("  [���� /  �ֹ�����  / �ֹ�����]");
			System.out.println("------------------------");
			for (int i = 0; i < bList.size(); i++) {
				System.out.println("  " + bList.get(i));
			}
			System.out.println("------------------------");
			for (int i = 0; i < bList.size(); i++) {
				allPrice += bList.get(i).getfPrice();
			}
			System.out.println("  [�� �ֹ����� : "+ allPrice+"��]");
			System.out.println("========================");
			System.out.print("���ư��÷��� �ƹ�Ű�� �Է����ּ���.");
			back = scan.next();
		}
	}
}
