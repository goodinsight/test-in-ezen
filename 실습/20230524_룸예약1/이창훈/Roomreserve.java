package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Roomreserve {
	// �迭�ȿ� ���ڰ� 1�̸� ����Ϸ� , 0�̸� ������
	public static void main(String[] args) {
		int[] room = new int[12];
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("============================================");
			System.out.println("���ϴ� �޴��� �����ϼ���.");
			System.out.println("1: �����ϱ� 2: ��������ϱ� 3:���ǻ��º���");
			int select = scan.nextInt();

			switch (select) {
			case 1:
				while (true) {
					System.out.println("������ ���� �����ϼ���. (���డ��:��) (ó������: 0��)");

					for (int i = 0; i < room.length; i++) { // ���డ���� ȣ�� �����ֱ�
						if (room[i] == 1) {
							System.out.print(i + 1 + "ȣ��: " + "�� ");
						} else {
							System.out.print(i + 1 + "ȣ��: " + "�� ");
						}
						if (i == room.length / 2) {
							System.out.println();
						}
					}

					select = scan.nextInt();
					if (select == 0) {
						break;
					} else if (select > 12 || select < 1) {
						System.out.println("���� ȣ���Դϴ�.");
						break; // �ε����ϰ� ���.. �Ʒ� if�� if�ȿ� if�� �ٲٸ� �����Ҽ� �������ϴ�
					}

					if (room[select - 1] == 1) { // ����ó������
						System.out.println("�̹� ����� ���Դϴ�.");
					} else {
						System.out.println(select + "ȣ�� ���� �Ϸ�");
						room[select - 1] = 1;
						break;
					}
				}
				continue;

			case 2:
				System.out.println("��������� ȣ���� �Է����ּ���. (ó������: 0��)");

				select = scan.nextInt();

				if (select == 0) {
					continue;
				} else if (select > 12 || select < 1) {
					System.out.println("���� ȣ���Դϴ�.");
					continue;
				}

				if (room[select - 1] == 1) { // ����ó������
					System.out.println("������ ����߽��ϴ�.");
					room[select - 1] = 0;
				} else {
					System.out.println("������ �ȵǾ��ִ� ���Դϴ�.");
					continue;
				}

			case 3:
				System.out.println("���� ȣ�� ��Ȳ�Դϴ�. ���డ��:��");
				for (int i = 0; i < room.length; i++) {
					if (room[i] == 1) {
						System.out.print(i + 1 + "ȣ��: " + "�� ");
					} else {
						System.out.print(i + 1 + "ȣ��: " + "�� ");
					}
					if (i == room.length / 2) {
						System.out.println();
					}
				}
				System.out.println();
				continue;

			case 99:
				break;
				
			default:
				continue;

			}
			scan.close();
			System.out.println("���α׷� ����~!~!~!");
			
		}

	}

}
