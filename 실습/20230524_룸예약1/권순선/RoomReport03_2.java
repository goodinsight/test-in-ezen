package kss.co.kr.array;

import java.util.Scanner;

public class RoomReport03_2 {
	public static void main(String[] args) {

		boolean moon = false;

		Scanner sc = new Scanner(System.in);
		String[] roomName = { "�Ϲݷ�", "�Ϲݷ�", "�Ϲݷ�", "�Ϲݷ�", "PC��", "PC��", "��ȭ��", "��ȭ��", "vip����Ʈ��", "vip����Ʈ��", "vvip��",
				"vvip��" };
		int[] pay = { 20000, 20000, 20000, 20000, 40000, 40000, 60000, 60000, 80000, 80000, 100000, 100000 };
		int[] roomNum = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112 };
		int[] person = { 2, 2, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10 };
		int[] room = new int[12];
		int money = 0;
		String[] name2 = new String[12];
		String name = null;
		int num = 0;
		int[] num2 = new int[12];

		while (!moon) {

			System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
			System.out.println("�ڡ١ڡ١� ���� Ȯ�� �ʼ����� Ȯ�� ��Ź�帳�ϴ� �١ڡ١ڡ�");
			System.out.println("1) �� ����");
			System.out.println("2) ���� Ȯ��");
			System.out.println("3) ���� ���");
			System.out.println("4) �ݾ� �Ա�");
			System.out.println("99) ����");
			System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
			System.out.print("��ȣ ���� >> ");
			num = sc.nextInt();
			System.out.println();

			switch (num) {
			case 1:

				while (num != 55) {

					System.out.print("������ �̸� >> ");
					name = sc.next();
					System.out.print("ȣ�� ��ȣ ����(1 ~ 12) ����) : 55 >> ");
					num = sc.nextInt();

					if (num > 12 || num < 1) {
						System.out.println("�ٽ� �Է�");
						continue;
					} else if (room[num - 1] == 1) {
						System.out.println("�� ����Ǿ��ִ� �� ��");
						continue;
					}

					if (num >= 1 && num <= 12) {
						System.out.print(roomName[num - 1] + " " + roomNum[num - 1] + "ȣ�� �ݾ��� " + pay[num - 1]
								+ "�� �Դϴ� �Ա� �ϼ��� >> ");
						money = sc.nextInt();
						if (money == pay[num - 1]) {
							room[num - 1] = 1;
							name2[num - 1] = name;
							num2[num - 1] = (int) (Math.random() * 100) + 1;
							System.out.println(
									name2[num - 1] + "�� " + roomName[num - 1] + " " + roomNum[num - 1] + "ȣ �����");
							System.out.println("���� ��ȣ�� " + num2[num - 1] + "�� �Դϴ�");
						} else {
							System.out.println("�ݾ��� ���� �ʽ��ϴ� �ٽ� �Ա��ϼ���");
							continue;
						}
						System.out.println();
						break;
					}

				}

				break;

			case 2:

				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println("============== �̺�Ʈ ������ ==============");
						System.out.println();
						System.out.println(" " + roomNum[i] + "ȣ " + roomName[i] + " " + person[i] + "�� " + pay[i] + "��"
								+ " �� ���� ���� ��");
					}
					System.out.println();
				}

				break;

			case 3:

				while (num != 77) {

					System.out.println("������ Ȯ��");
					System.out.print("�̸��� �����ּ��� >> ");
					name = sc.next();
					for (int i = 0; i < name2.length; i++) {
						if (name.equals(name2[i]) && num2[i] == 0 && room[i] == 0) {
							System.out.println("������� ���� �̸��̰ų� �����ϴ�");
							System.out.println("�ٽ� �Է��ϼ���");
							break;
						}
						if (name.equals(name2[i]) && num2[i] != 0 && room[i] == 1) {
							System.out.println(name2[i] + "������ ����");
							System.out.println(roomNum[i] + "ȣ " + roomName[i] + " " + person[i] + "��");
							System.out.println("���� ��ȣ " + num2[i] + "��");
						}
					}

					System.out.print("1) ���� ����ϱ�, 77) �ڷΰ��� >> ");
					num = sc.nextInt();

					switch (num) {
					case 1:
						for (int i = 0; i < num2.length; i++) {
							System.out.println(room[i] + " < > " + num2[i] + " < > " + name2[i]);
						}

						System.out.print("���� ����� �̸� >> ");
						name = sc.next();
						System.out.print("���� ����� �����ȣ >> ");
						num = sc.nextInt();
						for (int i = 0; i < name2.length; i++) {
							if (name.equals(name2[i]) && num2[i] != num && room[i] == 0) {
								System.out.println("������� ���� �̸��̰ų� ���� ��ȣ�Դϴ�");
								System.out.println("�̸� �� ���� ��ȣ �ٽ� Ȯ���ϼ���");
								break;
							}
							if (name.equals(name2[i]) && num2[i] == num && room[i] == 1) {
								room[i] = 0;
								num2[i] = 0;
								name2[i] = null;
								System.out.println("���� ��ҵǾ����ϴ�");
								System.out.println(money + "�� ȯ�ҵ˴ϴ�");
							}

						}
						break;

					}

				}

				break;

			case 4:

				break;

			case 99:

				moon = true;
				System.out.println("���α׷� ����");

				break;

			}

		}

	}
}
