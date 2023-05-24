package reportt;

import java.util.Scanner;

public class Report12_room {
	public static void main(String[] args) {
		int[] room = new int[12];
		Scanner scan = new Scanner(System.in);
		boolean power = false;
		int tmp = 0, tmp2 = 0;

		while (!power) {
			System.out.println("1: �� �����ϱ� /// 2: �� ���� ����ϱ� /// 3: ȣ�� Ȯ�� /// 99: ����");
			int menu = scan.nextInt();
			switch (menu) {
			case 99:
				System.out.println("�ý��� ����");
				power = true;
				break;
			case 3:
				System.out.println("ȣ�� Ȯ���ϱ�");
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 1) {
						System.out.println((i + 1) + "ȣ���� ����Ǿ����ϴ�.");
					} else {
						System.out.println((i + 1) + "ȣ���� ���� ����");
					}
				}
				break;
			case 2:
				System.out.print("����Ͻ� ȣ�� ��ȣ�� �Է����ּ���:");
				tmp = scan.nextInt();
				System.out.println(tmp+"ȣ����...");
				if (room[tmp-1] == 1) {
					System.out.println("��� ����");
					System.out.println("����Ͻðڽ��ϱ�? (��������ϱ�:1 ���ư���:0):");
					tmp2 = scan.nextInt();
					if (tmp2 == 1) {
						room[tmp-1] = 0;
						System.out.println(tmp + "ȣ���� ������ ����߽��ϴ�");
					}
				} else {
					System.out.println("������� ���� ���Դϴ�");
				}
				break;
			case 1:
				while (true) {
					System.out.print("ȣ�� ��ȣ�� �Է����ּ���(0�� ����):");
					tmp = scan.nextInt();
					if (tmp == 0) {
						break;
					} else if (room[tmp - 1] == 1) {
						System.out.println(tmp + "ȣ���� ���� �Ұ����մϴ�");
					} else {
						room[tmp - 1] = 1;
						System.out.println(tmp + "ȣ���� ����Ǿ����ϴ�");
						break;
					}
				}
				break;
			}

		}
	}
}
