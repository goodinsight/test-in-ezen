package kss.co.kr.array;

import java.util.Scanner;

public class RoomReport03_2 {
	public static void main(String[] args) {

		boolean moon = false;

		Scanner sc = new Scanner(System.in);
		String[] roomName = { "�Ϲݷ�", "�Ϲݷ�", "�Ϲݷ�", "�Ϲݷ�", "PC��", "PC��", "��ȭ��", "��ȭ��", "vip����Ʈ��", "vip����Ʈ��", "vvip��",
				"vvip��" };
		String[] name2 = new String[12];
		String name = null;
		String roomName2 = null;
		String id = "root";
		String pw = "1234";
		String id2 = null;
		String pw2 = null;

		int[] pay = { 20000, 20000, 20000, 20000, 40000, 40000, 60000, 60000, 80000, 80000, 100000, 100000 };
		int[] roomNum = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112 };
		int[] person = { 2, 2, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10 };
		int[] room = new int[12];
		int[] num2 = new int[12];
		int num = 0;
		int pay2 = 0;
		int money = 0;

		while (!moon) {

			System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
			System.out.println("�ڡ١ڡ١� ���� Ȯ�� �ʼ����� Ȯ�� ��Ź�帳�ϴ� �١ڡ١ڡ�");
			System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ� ī�� �����Դϴ� �ڡ١ڡ١ڡ١ڡ١ڡ١ڡ�");
			System.out.println("1) �� ����");
			System.out.println("2) ���� Ȯ��");
			System.out.println("3) ���� ���");
			System.out.println("4) ������ ���");
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
					} else if (room[i] != 0) {
						System.out.println("�ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
						System.out.println(" ============== �̺�Ʈ ���� ============== ");
						System.out.println();
						System.out.println(" " + roomNum[i] + "ȣ " + roomName[i] + " " + person[i] + "�� " + pay[i] + "��"
								+ " �� ���� �Ұ� ��");
					}
					System.out.println();
				}

				break;

			case 3:

				while (num != 66) {

					System.out.println("������ Ȯ��");
					System.out.print("�̸��� �����ּ��� >> ");
					name = sc.next();
					int idx = -1; // �ε����� ���� �������� ���� -1

					for (int i = 0; i < room.length; i++) {
						if (name.equals(name2[i]) && num2[i] != 0 && room[i] == 1) {
							idx = i;
							break;
						}
					}

					if (idx != -1) {
						System.out.println(name2[idx] + "������ ����");
						System.out.println(roomNum[idx] + "ȣ " + roomName[idx] + " " + person[idx] + "��");
						System.out.println("���� ��ȣ " + num2[idx] + "��");
					} else {
						System.out.println("������� ���� �̸��̰ų� �����ϴ�");
						System.out.println("�ٽ� �Է��ϼ���");
					}

//					for (int i = 0; i < num2.length; i++) {
//						System.out.println(room[i] + " < > " + num2[i] + " < > " + name2[i]);
//					}

					System.out.print("1) ���� ����ϱ�, 66) �ڷΰ��� >> ");
					num = sc.nextInt();

					switch (num) {
					case 1:

						System.out.print("���� ����� �̸� >> ");
						name = sc.next();
						System.out.print("���� ����� �����ȣ >> ");
						num = sc.nextInt();
						int idx2 = -1;

						for (int i = 0; i < room.length; i++) {
							if (name.equals(name2[i]) && num2[i] == num && room[i] == 1) {
								idx2 = i;
								break;
							}
						}

						if (idx2 != -1) {
							room[idx2] = 0;
							num2[idx2] = 0;
							name2[idx2] = null;
							System.out.println("���� ��ҵǾ����ϴ�");
							System.out.println(money + "�� ȯ�ҵ˴ϴ�");
						} else {
							System.out.println("������� ���� �̸��̰ų� ���� ��ȣ�Դϴ�");
							System.out.println("�̸� �� ���� ��ȣ �ٽ� Ȯ���ϼ���");
						}

						break;

					}
				}

				break;

			case 4:

				while (num != 77) {

					System.out.println("������ ��带 �̿��ϱ� ���� �α���");
					System.out.print("���̵� �Է� >> ");
					id2 = sc.next();
					System.out.print("��й�ȣ �Է� >> ");
					pw2 = sc.next();

					if (id.equals(id2) && pw.equals(pw2)) {
						System.out.println("������ ��ũ ������");
					} else {
						System.out.println("�ٽ� �Է��ϼ���");
						break;
					}

					System.out.println("�ڡٰ����ڴ� ȯ���մϴ� ��ȣ�� �����ϼ���ڡ�");
					System.out.println("========== 1) �� �̸� ���� ==========");
					System.out.println("========== 2) �� ���� ���� ==========");
					System.out.println("============ 77) ������ ============");
					System.out.print("��ȣ �Է� >> ");
					num = sc.nextInt();

					switch (num) {
					case 1:

						while (num != 123) {

							System.out.println("�� ����Դϴ�");
							for (int i = 0; i < room.length; i++) {
								System.out.println(i + 1 + "�� " + roomName[i]);
							}

							System.out.println("�����Ͻðڽ��ϱ�?");
							System.out.println("1) YES, 123) NO");
							System.out.print("��ȣ �Է� >> ");
							num = sc.nextInt();

							switch (num) {
							case 1:

								System.out.println("�� �̸��� �����մϴ�");
								System.out.println("��� ���� �����ϰڽ��ϱ�?");
								System.out.print("�� ��ȣ ���� >> ");
								num = sc.nextInt();
								System.out.println("������ �� �̸��� �Է��ϼ���");
								roomName2 = sc.next();

								for (int i = 0; i < room.length; i++) {
									roomName[num - 1] = roomName2;
								}
								System.out.println(roomName[num - 1] + "���� �����");

								break;

							}

						}

						break;

					case 2:

						while (num != 234) {

							System.out.println("�� �����Դϴ�");
							for (int i = 0; i < room.length; i++) {
								System.out.println(i + 1 + "�� " + roomName[i] + " ����" + pay[i] + "��");
							}

							System.out.println("�����Ͻðڽ��ϱ�?");
							System.out.println("1) YES, 234) NO");
							System.out.print("��ȣ �Է� >> ");
							num = sc.nextInt();

							switch (num) {
							case 1:

								System.out.println("�� ������ �����մϴ�");
								System.out.println("��� �� ������ �����ϰڽ��ϱ�?");
								System.out.print("�� ��ȣ ���� >> ");
								num = sc.nextInt();
								System.out.println("������ �� ������ �Է��ϼ���");
								pay2 = sc.nextInt();

								for (int i = 0; i < room.length; i++) {
									pay[num - 1] = pay2;
								}
								System.out.println(pay[num - 1] + "������ �����");

								break;

							}

						}

						break;
					}

				}

				break;

			case 99:

				moon = true;
				System.out.println("���α׷� ����");

				break;

			}

		}

	}
}
