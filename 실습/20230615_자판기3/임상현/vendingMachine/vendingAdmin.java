package kr.co.dong.vendingMachine;

import java.util.Scanner;

public class vendingAdmin {
	vendingFunc vf = new vendingFunc();
	Scanner scan = new Scanner(System.in);
	
	int admin_Menu() {
		System.out.println("[1. ��ǰ �߰�] [2. ��ǰ ����] [3. ��ǰ ����]");
		return scan.nextInt();
	}
	
	
	void addMenu() {
		System.out.print("�̸� : ");
		String name = scan.next();
		System.out.print("���� : ");
		int price = scan.nextInt();
		System.out.print("��ǰ ��ȣ : ");
		int number = scan.nextInt();
		System.out.print("��� : ");
		int amount = scan.nextInt();
		vf.list.add(new Menu(name, price, number, amount));
		System.out.println(vf.list.get(vf.list.size()-1).toString() + "�߰��Ǿ����ϴ�.");
	}
	
	void setMenu() {
		System.out.print("������ �޴� ��ȣ : ");
		Menu data = vf.search(scan.nextInt());
		if(data.getNumber() != 0) {
			System.out.println("[1. �̸�] [2. ����] [3. ��ǰ��ȣ] [4. ���]");
			switch (scan.nextInt()) {	
			case 1:
				System.out.print("������ �̸� : ");
				String name = scan.next();
				System.out.println(data.getName() + "����" + name +"���� �̸��� ����Ǿ����ϴ�.");
				data.setName(name);
				break;
				
			case 2:
				System.out.print("������ ���� : ");
				int price = scan.nextInt();
				System.out.println(data.getPrice() + "����" + price +"���� ������ ����Ǿ����ϴ�.");
				data.setPrice(price);
				break;
				
			case 3:
				System.out.print("������ ��ǰ ��ȣ : ");
				int number = scan.nextInt();
				System.out.println(data.getNumber() + "����" + number +"���� ��ǰ ��ȣ�� ����Ǿ����ϴ�.");
				data.setNumber(number);
				break;
				
			case 4:
				System.out.print("������ ��� �� : ");
				int amount = scan.nextInt();
				System.out.println(data.getAmount() + "����" + amount +"���� ��� ���� ����Ǿ����ϴ�.");
				data.setAmount(amount);
				break;
				
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
	
	void delMenu() {
		System.out.println("������ �޴� ��ȣ : ");
		Menu data = vf.search(scan.nextInt());
		if(data.getNumber() != 0) {
			for(Menu menu : vf.list) {
				if(menu.getNumber() == data.getNumber()) {
					System.out.println(menu.getName() + "�� �����Ǿ����ϴ�.");
					vf.list.remove(data);
				}
			}
		}
	}
	
}
