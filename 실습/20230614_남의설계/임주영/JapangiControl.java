package VendingMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JapangiControl {

	Scanner sc = new Scanner(System.in);
	List<Japangi> japangis = new ArrayList<Japangi>();
	JapangIExpel exjapangi = new JapangIExpel();
	Japangi my = new Japangi(); // ����Ʈ �����ڰ� �־�� ��
	// TODO Auto-generated method stub

	void init() { // �ʱⰪ
		japangis.add(new Japangi("�Ķ��̵�", 18000, 5));
		japangis.add(new Japangi("����", 19000, 5));
		japangis.add(new Japangi("���", 20000, 5));
	}

	void studentPlay(int ja) {
		switch (ja) {
		case 1:
			customerView();
			break;
		case 2:
			break;
		case 99:
			break;

		default:
			break;
		}
	}

	void customerView() {
		System.out.println("1.��ü �޴����� 2.�����ϱ�(�޴� ã��) 3. ������ �޴����� 4. �� �߰��ϱ�");
		int sel = sc.nextInt();

		switch (sel) {
		case 1:
			for (Japangi j : japangis) {
				System.out.println(j);
			}
			break;

		case 2:
			System.out.println("�޴��� �Է����ּ���.");
			String r = sc.next();
			int pirce = japangis.get(japanmenu(r, japangis)).getjPrice();
			int count = japangis.get(japanmenu(r, japangis)).getjCount();
			if (japanmenu(r, japangis) == -1) {
				System.out.println("���� �޴��Դϴ�.");
			} else {
				System.out.println(japangis.get(japanmenu(r, japangis)) + "�����ϼ̽��ϴ�.");
				System.out.println("1.�����ϱ� 2. ���ư���");
				int choice = ms("�����Ͻðڽ��ϱ�?");
				if (choice == 1) {
					if (my.getjMoney() >= pirce && count != 0) {
						int money1 = my.getjMoney() - pirce; // ������ ���ݸ�ŭ �� ���� ���
						my.setjMoney(money1);
						japangis.get(japanmenu(r, japangis)).setjCount(count - 1); // �����ϸ鼭 ��� ����
						System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
						System.out.println("�ܵ��� ��ȯ�˴ϴ�. " + my.getjMoney());
					} else if (my.getjMoney() < pirce) {
						System.out.println("���� �����մϴ�.");
					} else if (count == 0) {
						System.out.println("��� �����ϴ�.");
					}

				} else if (choice == 2) {
					System.out.println("���ư���");
				}
			}
			break;

		case 3:
			System.out.println("�� �̻� �Ǹ����� �ʴ� �޴��Դϴ�.");
//			if() {
//				
//			}else {
//				System.out.println("���� �޴��Դϴ�.");
//			}
			break;

		case 4:
			System.out.println("���� �ܾ���  : " + my.getjMoney() + "�Դϴ�.");
			System.out.println("���� �����Ͻðڽ��ϱ�?");
			System.out.println("1.���� ���� 2. ���ư���");
			int choice = ms("���� �����Ͻðڽ��ϱ�?");
			if (choice == 1) {
				System.out.println("������ �ݾ��� �Է����ּ���.");
				int money99 = sc.nextInt();
				my.setjMoney(money99);
				System.out.println("�ݾ��� �����Ϸ��߽��ϴ�.");

			} else if (choice == 2) {
				System.out.println("���ư���");
			}

			break;

		default:
			break;
		}

	}

//	 �޴� ã�� �޼ҵ�	
	int japanmenu(String jName, List<Japangi> japangis) {
		int index = -1;

		for (int i = 0; i < japangis.size(); i++) {
			if (jName.equals(japangis.get(i).getjName())) {
				index = i;
				break;
			}
		}
		return index;

	}

	private String msg(String msg) {
		System.out.println(msg + " ");
		return sc.next();

	}

	private int ms(String ms) {
		System.out.println(ms + " ");
		return sc.nextInt();
	}
}
