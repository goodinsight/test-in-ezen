package kr.co.dong.note;

import java.util.Scanner;

public class Note02 {

	public static void main(String[] args) {

		/*
		 * Ű���忡 ���� �Է� �ۼ� �� 12���� �ְ� => ����/�迭 => �迭 room[12] �Է� �������� // �޴� ���� : 1.2.3.99��
		 * �Է¹��� 1�� ���� ���� ���� ���� // ��[���ȣ]�� ���� 1�̸� ������� -> ȣ�� ��ȣ ���� (1~12) -> ������� ���� Ȯ��
		 * -> ���డ�� ���� -> ���� �ǽ� -> ȣ�� Ȯ�� => �޴��� ���� ���� �Ұ� ���� -> ȣ�ǹ�ȣ ���� (12) or �޴��� ���� 2��
		 * ���� ��� ���� ���(����-> ����) // ��[���ȣ]�� ���� 0�̸� ���� 2-> ȣ�ǹ�ȣ����(1~12) -> ��Ұ��� ���� -> ��Ұ���
		 * : �ش�ȣ���� ���� 0���� => �޴����� -> ��ҺҰ� : ������� ���� ���̶�� ǥ�� => �޴����� 3�� ���� ���� ȣ�� Ȯ�� //
		 * 
		 * 1�� ���� "����� : ��" 0�� ��� "���డ�ɡ�" 99 ���α׷� ���� // ���� ������ �ϴ� ���α׷�.
		 * 
		 * 2023/05/24 3�� ȣ��Ȯ��(12���� ��) ���� �� 1�� ���� -> 2�� ���� ��� ȣ�� Ȯ���� ���డ�� �� ���� �Ұ��� Ȯ�θ�
		 * �����ϸ� ��. 1���� ������ ������ �Ǵ� ȣ���� ������ �ϰ�, 3�� ȣ�� Ȯ�ο��� ������ �Ϸ� �� ���� Ȯ�� ���� 2�� ���� ��Ҵ� 1��
		 * ������ �� ���� ������ �����. ������ ����� ���� 3. ȣ�� Ȯ�ο��� ������ ��� �� ���� Ȯ�� �ؾ� ��. 3���� ���Ǳ� �޴� ȭ��
		 * 3������ ȣ�� Ȯ���� �Ǹ� -> 1. ���� �Ͻðڽ��ϱ�? 2. ���� 3�� -> ���� �Ͻðڽ��ϱ� ���ý� 1�� ���� ȭ������ 3�� ->
		 * ������ ���� ��ư
		 *
		 * 2023/05/25 �߰� ���� => 1. ���� �Ը�� ���۰� ���ÿ� �Է� 2. ȣ�� ���ȣ/ ȣ�ڹ��(ex : �ξ�
		 * /���ٴٵ�....���)/���� �ο�/ ���� 3. ����� �����ڸ�/ ���� ��ȣ (��ҽ� �ʿ�) �� 4. ��Ÿ �ʿ��� ��� (������ ���)
		 *
		 * 1) ���� �Ը� ����. 2) ȣ�� ȭ�鿡�� => ȣ�� �� ��ȣ �� �ο�(0�ν�) ���� ��� �����ֱ� 3) ���� ȭ�鿡�� ������ �̸� ��
		 * ��ȭ��ȣ �Է� => ���� ��ҽ� ��� ���� & ������� ���� 4) ������ ��� => ������ Ȯ�� �� ������ �� ���� �Ⱓ(0��) �߰� �ο�
		 * �߻��� �߰���ݱ��� �Ҽ� ��������........
		 *
		 * �ξ� size %3 ==0 �����̾� size %3 == 1 ���ٴٵ� else
		 */

		int guestRoom = 101;
		boolean res = false;
		int[] num = null;
		num = new int[guestRoom];

		for (int i = 0; i < num.length; i++) {
			num[i] = 0;
		}
		int choice = 0;
		Scanner scan = new Scanner(System.in);

		int size = 0;

		System.out.println("��ü ������ ���� �������ּ��� : ");
		size = scan.nextInt();
		int[] room = new int[size];
		for (int i = 0; i < room.length; i++)
			System.out.println((i + 1) + "���� ������ ���� �Ǿ����ϴ�.");

		while (!res) {

			System.out.println("1. ���� 2. ���� ��� 3. ȣ�� Ȯ�� 99. ����");
			choice = scan.nextInt();

			switch (choice) {
			case 99:
				System.out.println("�̿��� �ּż� �����մϴ�.");
				res = true;
				break;

			case 3:
				String reserve = null;

				for (int i = 0; i < room.length; i++) {
					if (room[i] == 0) {
						reserve = " ���� ���� ";
					} else {
						reserve = "���� �Ұ�";
					}
					System.out.println((i + 1) + "ȣ�� : " + reserve); // reserve ���� Ȯ��
				}
				break;

			case 1:
				int roomNum = 0; // ���� num
				String[] roomName = { "�ξ�", "�����̾�", "���ٴٵ�" };

				System.out.println("���� �Ͻ� ȣ���� �������ּ��� : ");
				roomNum = scan.nextInt();
				if (roomNum >= 1 && roomNum <= size) {
					if (size % 3 == 0) {
						System.out.println(roomName[0] + " ���� ���� �Ͻðڽ��ϱ�?");
					} else if (size % 3 == 1) {
						System.out.println(roomName[1] + " ���� ���� �Ͻðڽ��ϱ�?");
					} else {
						System.out.println(roomName[2] + " ���� ���� �Ͻðڽ��ϱ�?");
					}

					int temp = roomNum - 1;
					if (room[temp] != 0) {
						System.out.println("���� �� �� �����ϴ�.");
					} else
						System.out.println("���� �Ͻðڽ��ϱ�? 1. ���� 2.����");
					int choiceNum = 0;
					choiceNum = scan.nextInt();
					switch (choiceNum) {
					case 1:
						if (choiceNum == 1) {
							System.out.println(roomNum  + "���� �Ǿ����ϴ�.");
							room[temp] = 1;
						}
					case 2:
						if (choiceNum == 2) {
							break;
						}
					}
				}
				break;
			case 2:
				int cancle = 0;
				System.out.println("���� ��� ȣ���� �������ּ���. 0. ���ư���");
				cancle = scan.nextInt();
				if (cancle >= 1 && cancle <= size) {
					int temp = cancle - 1;
					if (room[temp] == 0) {
						System.out.println(" ������� ���� ���Դϴ�.");
					} else {
						System.out.println(cancle + "ȣ���� ���� ��� �Ǿ����ϴ�.");
						room[temp] = 0;
						break;
					}
				} else {
					System.out.println("�߸� �Է� �Ǿ����ϴ�.");
					break;
				}
			} // switch(choice)����
		} // while ����
	}
}
