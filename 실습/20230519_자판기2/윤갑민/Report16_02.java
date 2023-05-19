package kr.co.dong.array;

import java.util.Scanner;

public class Report16_02 {

	public static void main(String[] args) {
		int money = 0;
		String[] dName = { "���̴�", "�ݶ�", "Ŀ��" };
		int[] dPrice = { 1000, 1500, 2000 };
		int[] dAmount = { 5, 5, 5 };
		boolean power = false;
		Scanner scan = new Scanner(System.in);
		int choice = 0;

		while (!power) {
			if (dAmount[0] + dAmount[1] + dAmount[2] == 0) {
				System.out.println("��� �������� �����մϴ�.");
				System.out.println("�Ž��� ���� ��ȯ�˴ϴ�." + money + "�� ��ȯ");
				money = 0; // ���Աݾ�
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			System.out.println("(1)" + dName[0] + "(" + dPrice[0] + "��), (2)" + dName[1] + "(" + dPrice[1] + "��), (3)"
					+ dName[2] + "(" + dPrice[2] + "��), (4)�� �Է�, (5)�Ž�����, (0)���Ǳ� ����");
			System.out.println("=================================================================================");
			System.out.println("���� �� " + dName[0] + " : " + dAmount[0] + "��, " + dName[1] + " : " + dAmount[1] + "��, "
					+ dName[2] + " : " + dAmount[2] + "�� ���ҽ��ϴ�");
			
			if (money < dAmount[0]) { 
				System.out.println("���� ������ ���ᰡ �����ϴ�. (4)�� �Է�, (5)�Ž����� �ޱ�");
			} else {
				System.out.print("���� ������ ���� : ");
				for (int i = 0; i < dPrice.length; i++) {
					if (money >= dPrice[i]) {
						System.out.print("(" + (i + 1) + ")" + dName[i] + "(" + dPrice[i] + ")");
						if ((money < dPrice[i]) || !(i == 2)) {
							System.out.print(", ");
						}
					}
				}
				System.out.println();
			} // end of else
			System.out.println("���� �ݾ��� : " + money + "�� �Դϴ�.");
			System.out.print("��ȣ�� �Է��ϼ��� : ");
			choice = scan.nextInt();

			switch (choice) {
			case 0:
				power = true;

			case 5:
				System.out.println(money + "���� ��ȯ�Ǿ����ϴ�.");
				money = 0;
				break;

			case 4:
				System.out.print("���� �ݾ��� �Է����ּ��� : ");
				money += scan.nextInt();
				break;

			case 1:
			case 2:
			case 3:
				choice--;  // ���⿡ �ִ� ������??
				if (money >= dPrice[choice] && dAmount[choice] > 0) {
					System.out.println(dName[choice] + "�� ���Խ��ϴ�.");
					money -= dPrice[choice];
					dAmount[choice]--;
				} else if (money < dPrice[choice]) {
					System.out.println("�ݾ��� �����մϴ�.");
				} else {
					System.out.println("��� �����մϴ�."); // �ٸ� ���� ���� ��� �߰�.
				}

			default:
				break;
			}
		}
		System.out.println("���Ǳ� ����.");
	}
}
