package vendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingMachineControl2 {
	Scanner scan = new Scanner(System.in);
	List<vendingMachine> drink = new ArrayList<>();
	LoginControl lc = new LoginControl();
	int money;

//		�ʱⰪ
	void init() {
		vendingMachine d1 = new vendingMachine("����ĥ�����̴�", 2200, 5, 0);
		vendingMachine d2 = new vendingMachine("��Ű������", 2500, 5, 0);
		vendingMachine d3 = new vendingMachine("�������", 2000, 5, 0);

		drink.add(d1);
		drink.add(d2);
		drink.add(d3);
	}

//		�޴�
	String menu() {
		System.out.println("=====���Ǳ� �޴�=====");
		System.out.println("1.����޴� 2.�����ݾ����� 3.�ܵ���ȯ 77.�����ڸ��");
		System.out.println("�����ݾ� : " + money);
		System.out.println("��ȣ �Է� : ");

		return scan.next();
	}

//		�˻� �޼ҵ�
	private int searchindex(String drinkname) {
		int index = -1;
		for (int i = 0; i < drink.size(); i++) {
			if (drinkname.equals(drink.get(i).getDrinkName())) {
				index = i;
				break;
			}
		}
		return index;
	}

//		�ܵ���ȯ
	void refund() {
		if (money == 0) {
			System.out.println("��ȯ�� �ܾ��� �����ϴ�.");
		} else {
			System.out.println("��ȯ�ݾ� : " + money);
			money = 0;
		}
	}

//		����
	void payMent() {
		int plusM = choice("������ �ݾ��� �Է��ϼ��� : ");
		money += plusM;
		System.out.println("������ �ݾ� : " + money);
	}

//		����޴�
	void drinkMenu() {

		boolean check = false;
		while (!check) {
			view();
			int cnt = 0;
			String name = strChoice("'�޴�'�� �Է½� �޴��� ���ư��ϴ�.\n���ϴ� �����̸��� �Է��ϼ��� : ");
			if (name.equals("�޴�")) {
				System.out.println("�޴��� ���ư��ϴ�.");
				check = true;
				break;
			}
			int per = searchindex(name);
			if (per == -1) {
				System.out.println("���� �����Դϴ�.");
			} else if (drink.get(per).getDrinkCount() == 0) {
				System.out.println("��� �����ϴ�.");
			} else {
				cnt = count(per);
				pay(cnt, per);
			}
		}
	}

//		����
	private void pay(int count, int per) {
		int price = drink.get(per).getDrinkPrice() * count;
		boolean check = false;
		while (!check) {
			if (money < price) {
				System.out.println("�����ݾ��� �����մϴ�.");
				System.out.println("������ �ݾ� : " + (drink.get(per).getDrinkPrice() * count - money));
				String str = strChoice("�߰������� �Ͻðڽ��ϱ�? y/n");
				if (str.equals("n") || str.equals("N")) {
					System.out.println("�޴��� ���ư��ϴ�.");
					check = false;
					break;
				} else if (str.equals("y") || str.equals("Y")) {
					payMent();
				}
			} else {
				System.out.println("**���� ���� : " + drink.get(per).getDrinkName() + " ���� :" + count + "�� **");
				money -= price;
				System.out.println("���� �ݾ� : " + money);
				drink.get(per).setDrinkCount(drink.get(per).getDrinkCount() - count);
				drink.get(per).setSellCount(drink.get(per).getSellCount() + count);
				break;
			}
		}

	}

	// ���ᰳ��
	int count(int per) {
		int count = 0;
		while (true) {
			count = choice("���ϴ� ���� ������ �Է��ϼ��� : ");
			if (count == 0) {
				System.out.println("1�� �̻��� �Է����ּ���");
			} else if (count > drink.get(per).getDrinkCount()) {
				System.out.println("���� ������ �������� ���� �Է��Ҽ������ϴ�.");
			} else {
				break;
			}
		}
		return count;
	}

//		����޴�����
	void view() {
		for (vendingMachine v : drink) {
			System.out.println(v);
		}
	}

//		msg�޾Ƽ� int�� ��ȯ
	int choice(String msg) {
		System.out.println(msg);
		return scan.nextInt();
	}

//		msg�޾Ƽ� string���� ��ȯ
	String strChoice(String msg) {
		System.out.println(msg);
		return scan.next();
	}

}