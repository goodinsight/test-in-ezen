package reportt;

import java.util.Scanner;

public class room_V2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// ���� �Ը� �ޱ� �� ����
		System.out.println("���� �Ը� �Է��ϼ���");
		int how = scan.nextInt();
		int tmp = 0, tmp2 = 0;

		String tmp1 = "";
		int[][] room = new int[how][5]; // 0 �̸� 1 �����ο� 2 ���� 3 �����Ȳ(�����-1 �̿������-0) 4 ���� ��ȣ
		String[][] roomTag = new String[how][2]; // 0 ȣ��Ư�� 1 �����ڸ�
		boolean power = true;
		boolean power2 = true;

		for (int i = 0; i < room.length; i++) {
			// �� Ư�� ����, ���� ����
			how = (int) (Math.random() * 2 + 1);
			if (how == 1) {
				roomTag[i][0] = "�����̾�";
				room[i][2] = 150000;
			} else {
				roomTag[i][0] = "�Ϲ�";
				room[i][2] = 75000;
			}
			// ������ �� �̸��� 101 102 �̷�������
			room[i][0] = 100 + (i + 1);
			// �����ο� ����
			how = (int) (Math.random() * 3 + 1);
			room[i][1] = how;
			// ��� �̿�������
			room[i][3] = 0;
		}
		for (int i = 0; i < room.length; i++) {
			System.out.printf("�̸�: %dȣ �����ο�: %d ����: %d Ư��: %s�̸� ", room[i][0], room[i][1], room[i][2], roomTag[i][0]);
			if (room[i][3] == 1) {
				System.out.println("����Ǿ����ϴ�.");
			} else {
				System.out.println("����Ǿ������ʽ��ϴ�");
			}
		}

		System.out.println();

		while (power) {
			power2 = true;
			System.out.println("1: �����ϱ� /// 2: ������� /// 3: �����Ȳ /// 4: ����");
			tmp = scan.nextInt();
			switch (tmp) {
			default:
				System.out.println("�ٽ� �Է��� �ּ���");
				break;
			case 4:
				power = false;
				System.out.println("�����մϴ�...");
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					if (room[i][3] == 1) {
						System.out.println(room[i][0] + "���� ����Ǿ��ֽ��ϴ�");
					} else {
						System.out.println(room[i][0] + "���� ���డ���մϴ�");
					}
				}
				break;
			case 1:
				System.out.println("������ ���� ��ȣ�� �Է��� �ּ���(101�� ����)");
				tmp = scan.nextInt();
				if (room[tmp - 101][3] == 1) {
					System.out.println("�� ���� �̹� ���� �Ǿ� �ֽ��ϴ�");
				} else {
					System.out.println("�����ڸ��� �Է��� �ּ���");
					tmp1 = scan.next();
					roomTag[tmp - 101][1] = tmp1;
					System.out.println("�����ȣ 4�ڸ��� �Է��� �ּ���");
					tmp2 = scan.nextInt();
					room[tmp - 101][4] = tmp2;
					System.out.println(roomTag[tmp - 101][1] + "�� ����Ǿ����ϴ�");
					room[tmp - 101][3] = 1;
				}
				break;
			case 2:
				System.out.println("��������� ���� ��ȣ�� �Է��� �ּ���(101�� ����)");
				tmp = scan.nextInt();
				if (room[tmp - 101][3] == 0) {
					System.out.println(room[tmp - 101][0] + "�� ����Ǿ� ���� ���� �����Դϴ�");
				} else {
					while (power2) {
						System.out.println("�����ȣ�� �Է��� �ּ��� (0�Է½� ����)");
						tmp2 = scan.nextInt();
						if (tmp2 == 0) {
							power2 = false;
							break;
						} else if (room[tmp - 101][4] == tmp2) {
							System.out.println("������ ����Ͽ����ϴ�");
							room[tmp - 101][3] = 0;
						} else {
							System.out.println("�����ȣ�� �ٸ��ϴ�");
						}
					}
				}
				break;
			}
		}
	}
}
