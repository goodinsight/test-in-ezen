package kr.co.dong.vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingFunc {
	Scanner scan = new Scanner(System.in);
	List<Menu> list = new ArrayList<Menu>();
	int money = 0;
	
	int menu() { // �޴�
		for(Menu data : list) {
			data.toString();
		}
		System.out.println("[1. ����] [2. ���� ����] [3. �Ž����� ��ȯ] [0. ����] | ���� �ܾ� : " + money );
		System.out.print("���� : ");
		return scan.nextInt();
	}
	
	void buy() { // ����
		for(Menu data : list) {
			data.toString();
		}
		System.out.println("��ǰ ��ȣ �Է� : ");
		Menu data = search(scan.nextInt());
		if(data.getNumber() != 0) {
			if(data.getAmount() > 0 && data.getPrice() >= money) {
				money -= data.getPrice();
				data.setAmount(data.getAmount()-1);
				System.out.println(data.getName() + "�� ���Խ��ϴ�.");
			}else if(data.getPrice() > money){
				System.out.println("�ܾ��� �����մϴ�.");
			}else {
				System.out.println("��� �����մϴ�.");
			}
		}
	}
	
	void inputMoney() {
		System.out.print("������ �ݾ� �Է� : ");
		money += scan.nextInt();
	}

	void change() {
		System.out.println(money + "���� ��ȯ�Ǿ����ϴ�.");
		money = 0;
	}
	
	Menu search(int num) { // ��ǰ ã��
		Menu result = null;
		for(Menu data : list) {
			if(data.getNumber() == num) {
				result = data;
				break;
			}else if (data == list.get(list.size() - 1)){
				System.out.println("�ش� ��ȣ�� ��ǰ�� �����ϴ�.");
				return new Menu(null, 0, 0, 0);
			}
		}
		return result;
	}
	
}
