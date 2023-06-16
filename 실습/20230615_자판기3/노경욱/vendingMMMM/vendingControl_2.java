package vendingMMMM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class vendingControl_2 {
	public static Scanner scan = new Scanner(System.in);
	public static int money;
	public static int tmp;
	public static int select;
	public static void main(String[] args) {
		boolean power = true;
		boolean power2 = true;

//		vending ����Ʈ ����
		List<VendingMea> vending = new ArrayList<VendingMea>();

//		coke, pepsi, cake ����
		VendingMea coke = new VendingMea("coke", 20, 1500);
		VendingMea pepsi = new VendingMea("pepsi", 20, 3000);
		VendingMea cake = new VendingMea("cake", 20, 5000);

//		vending ����Ʈ�� ��ǰ�߰�
		vending.add(coke);
		vending.add(pepsi);
		vending.add(cake);

		String menu = "1 coke_1500_20�� 2 pepsi_3000_20�� 3 cake_5000_20�� 0.����";

		System.out.println("���Ǳ� �۵� ����");
		while (power) {
			moneyPrint();
			System.out.println("1. ���Ա� 2. ���� 3.�ܱ� ��ȯ 0. ����");
			int sel = scan.nextInt();
			switch (sel) {
			case 0:
				System.out.println("���Ǳ⸦ �����մϴ�");
				power = false;
				break;
			case 1:
				moneyAdd();
				break;
			case 2:
				viewMenu(menu);
				int sell = scan.nextInt();
				switch (sell) {
				case 1:
				case 2:
				case 3:
					sell(sell, vending);
					break;
				}
				break;
			case 3:
				moneySubt();
				break;
			case 77:
				System.out.println("������ ��� ����");
				while (power2) {
					System.out.println("1. �޴����� 2. ���ݼ��� 3. �̸����� 4. ��ǰ�����߰� 5. ��ǰ�������� 6. ��ǰ �߰� 7. ��ǰ ���� 0. ����");
					sel = scan.nextInt();
					switch (sel) {
					case 0:
						System.out.println("������ ��� ����");
						power2 = false;
						break;
					case 1:
						menu = changeMenu(menu);
						break;
					case 2:
						select = select(vending) ;
						changePrice(select,vending);
						break;
					case 3:
						select = select(vending);
						changeName(select,vending);
						break;
					case 4:
						select = select(vending);
						addVend(select,vending);
						break;
					case 5:
						select = select(vending);
						removeVend(select,vending);
						break;
					case 6:
						addItem(vending);
						break;
					case 7:
						select = select(vending);
						removeItem(select,vending);
					}
				}
			}
		}
	}

	private static void removeItem(int select2, List<VendingMea> vending) {
		String namee = vending.get(select2).getDrinkName();
		System.out.println("������ ��ǰ("+namee+")�� �����մϴ�");
		vending.remove(select2);
		System.out.println("�޴��� �����ؾ� �մϴ�");
	}

	private static void addItem(List<VendingMea> vending) {
		System.out.println("��ǰ�� �߰��մϴ�");
		System.out.println("����� �Է��ϼ��� (����: ��ǰ�̸�,��ǰ����,����");
		String get = scan.next();
		String[] gett = get.split(",");
		String namee = gett[0];
		int countt = Integer.parseInt(gett[1]);
		VendingMea r = new VendingMea(namee, countt, countt);
		vending.add(r);
		System.out.println("�޴��� �����ؾ� �մϴ�");
	}

	private static void removeVend(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"�� ��ǰ ������ "+r.getDrinkCount()+"�� �Դϴ�");
		System.out.println("������ ������ �Է��� �ּ���");
		int minuse = r.getDrinkCount()-scan.nextInt();
		r.setDrinkCount(minuse);
		System.out.println("�߰��Ϸ�");
		System.out.println(r.getDrinkName()+"�� ��ǰ ������ "+r.getDrinkCount()+"�� �Դϴ�");
	}

	private static void addVend(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"�� ��ǰ ������ "+r.getDrinkCount()+"�� �Դϴ�");
		System.out.println("�߰��� ������ �Է��� �ּ���");
		int adddd = r.getDrinkCount()+scan.nextInt();
		r.setDrinkCount(adddd);
		System.out.println("�߰��Ϸ�");
		System.out.println(r.getDrinkName()+"�� ��ǰ ������ "+r.getDrinkCount()+"�� �Դϴ�");
	}

	private static void changeName(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"���� �ٲ� �̸��� �Է��ϼ���");
		String changee = scan.next();
		r.setDrinkName(changee);
		System.out.println("�����Ͽ����ϴ�");
		System.out.println(r.getDrinkName());
		
	}

	private static void changePrice(int select, List<VendingMea> vending) {
		VendingMea r = vending.get(select);
		System.out.println(r.getDrinkName()+"�� ������ "+r.getDrinkPrice()+"�Դϴ�");
		System.out.println("������ ������ �Է��� �ּ���");
		int changePP = scan.nextInt();
		r.setDrinkPrice(changePP);
		System.out.println("�����Ͽ����ϴ�");
		System.out.println(r.getDrinkName()+"�� ������ "+r.getDrinkPrice()+"�Դϴ�");
	}
	
	private static int select( List<VendingMea> vending) {
		System.out.println("��ǰ�� ������ �ּ���");
		tmp = 1;
		for(VendingMea r : vending) {
			System.out.print(tmp+". "+r.getDrinkName()+ ", ");
			tmp++;
		}
		System.out.println();
		int choose = scan.nextInt() -1;
		return choose;
		
	}


	private static String changeMenu(String menu) {
		System.out.println("���� ������ menu��");
		System.out.println(menu + "<<< �Դϴ�");
		System.out.println("������ menu�� �Է��� �ּ���");
		menu = scan.next();
		return menu;
	}

	private static void viewMenu(String menu) {
		System.out.println(menu);

	}

	private static void sell(int sell, List<VendingMea> vending) {
		VendingMea tin = vending.get(sell - 1);
		if (money < tin.getDrinkPrice()) {
			System.out.println("�ܾ��� �����մϴ�");
		}else if(tin.getDrinkCount() < 1){
			System.out.println("��� �����մϴ�");
		}
		else {
			System.out.println(tin.getDrinkName() + "�� �����Ǿ����ϴ�");
			money -= tin.getDrinkPrice();
		}
	}

	private static void moneySubt() {
		System.out.println("�ݾ��� ��ȯ�մϴ�: " + money);
		money = 0;
	}

	private static void moneyAdd() {
		System.out.println("�Ա��� �ݾ��� �Է����ּ���");
		money += scan.nextInt();
	}

	private static void moneyPrint() {
		System.out.println("���� �ܾ���: " + money + " �Դϴ�");
	}
}
