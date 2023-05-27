package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest05 {
	public static void main(String[] args) {
//		* ���� -> �ҽ��ۼ� -> �����
//		* Ű���忡 ���� �Է��ۼ�
//		* ��12���� �ְ� ==> ����?�迭? ==> �迭 room[12] (reserve ���࿩�ΰ� �����Ϳ� �������)

//		* �Է±�������                                //menu���� : 1,2,3,99�� �Է¹���
//		* 1�� �������� ���� ����,                     // room[���ȣ]�� ���� 1�̸� �������
//		*     1 -> ȣ�ǹ�ȣ ����(1~12) -> ���� ���¿��� Ȯ��
//		*       -> ���డ�ɻ��� -> ����ǽ� -> ȣ��Ȯ�� -> �޴��� ����

//		* 2�� ���� ��� �������(����->����),             // room[���ȣ]�� ���� 0�̸� ����
//		*        2  -> ȣ�ǹ�ȣ ����(1~12) -> ��Ұ��� ����
//		*     -> ��Ұ��� : �ش�ȣ���� ���� 0���� -> �޴�����
//		*   -> ��ҺҰ� : ������� ���� ���̶�� ǥ�� -> �޴�����

//		* 3�� �������� ȣ��Ȯ��, //1�� ���� "����ʡ�" 0�ΰ��� "���డ�ɡ�"
//		* 99�� ���� ���� ���α׷� ����.

		boolean power = false;
		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // �� ȣ�� �ε���
		int menu = 0; // �޴� ��ȣ ����
		int select = 0; // ȣ�� ����
		int cancel = 0; // ��� �� ȣ�� ����

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println("                                          ");
			System.out.println("                 �ؿ����                    ");
			System.out.println("           �̿��Ͻ� �޴��� �����ּ���.            ");
			System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
			System.out.println("           ��. �� ���� �ϱ�");
			System.out.println("           ��. �� ���� ���");
			System.out.println("           ��. ȣ�� Ȯ�� ");
			System.out.println("           ���.  ����   ");
			System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
			menu = scan.nextInt();

			switch (menu) {
			case 1:
				System.out.println("> �� ���� �ϱ� �Դϴ�.");
				System.out.println("> �����Ͻ� ȣ���� �����ּ���.");
				select = scan.nextInt();
				System.out.println(select + "ȣ���� ���� �Ͽ����ϴ�.");
				if (room[select - 1] == 1) {
					System.out.println(select + "ȣ���� ������ �Ұ����մϴ�");
					System.out.println("�޴��� ���ư��ϴ�. �޴��� �ٽ� �������ּ���");
					System.out.println();
					break;
				}
				System.out.println(select + "ȣ���� ������ �����մϴ�.");
				System.out.println(select + "ȣ���� ����Ǿ����ϴ�.");
				room[select - 1] = 1;
				System.out.println();

				break;
			case 2:
				System.out.println("> �� ���� ��� �Դϴ�.");
				System.out.println("> ���� ����Ͻ� ȣ���� �����ּ���.");
				cancel = scan.nextInt();
				System.out.println(cancel + "ȣ���� ���� �Ͽ����ϴ�.");
				if (room[cancel - 1] == 1) {
					System.out.println(cancel + "ȣ���� ��Ұ� �����մϴ�.");
					System.out.println(cancel + "ȣ���� ��ҵǾ����ϴ�.");
					room[cancel - 1] = 0;
					System.out.println();
					break;
				}
				System.out.println("������ �Ǿ����� �ʾ� ��Ұ� �Ұ��մϴ�.");
				System.out.println();
				break;
			case 3:
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				System.out.println("�ġġġġġġġġġġ� ���� ȣ�� ������Ȳ�Դϴ�.�ġġġġġġġġġġ�");
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				for (int i = 0; i < room.length; i++) {
					System.out.print((i + 1) + "ȣ��) : " + room[i]);
//					System.out.println();
					if (room[i] == 0) {
						System.out.println("  �� ���డ�� O");
					} else if (room[i] == 1) {
						System.out.println("  �� ����Ұ��� X");
					}
				}
				break;

			case 99:
				power = true;
				System.out.println("�ý����� �����մϴ�.");
				break;
			}

		}

	}

}
