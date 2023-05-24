package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Hotel23_1 {

	public static void main(String[] args) {
		// ����ִ� ���� = 0 , ����� ���� = 1
		Scanner scan = new Scanner(System.in);

		int[] room = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int roomNumber = -1;
		int menu = 0;
		String check0 = "���డ�ɡ�";
		String check1 = "����Ұ��ɡ�";
		boolean power = false;

		while (!power) {
			System.out.println("=======================");
			System.out.println("       ȣ�ڿ��༭��");
			System.out.println("=======================");
			System.out.println("      1. �����ϱ�");
			System.out.println("      2. �������");
			System.out.println("      3. ������� Ȯ��");
			System.out.println("      99. �����ϱ�");
			System.out.println("=======================");
			System.out.print("    �޴��� �Է����ּ��� : ");
			menu = scan.nextInt();
			switch (menu) {
			case 1: // ȣ�� ����
				System.out.println("=======================");
				System.out.print(" �����Ͻ� �� ��ȣ�� �Է��� �ּ���(1~12) : ");
				roomNumber = scan.nextInt();
				if(roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 0) {
					room[roomNumber-1] = 1;
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					System.out.println("   "+roomNumber+"�� ���� ���� �Ǿ����ϴ�.");
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				}else if (roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 1) {
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					System.out.println("   �̹� ������ �� ���Դϴ�.");
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				}else {
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					System.out.println("   ���������ʴ� �� ��ȣ�Դϴ�.");
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				}
				break;
			case 2: // ȣ�� �������
				System.out.println("=======================");
				System.out.print(" ����Ͻ� �� ��ȣ�� �Է��� �ּ���(1~12) : ");
				roomNumber = scan.nextInt();
				if(roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 0) {
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					System.out.println("   ������� ���� ���Դϴ�.");
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				}else if (roomNumber>0 && roomNumber<=room.length && room[roomNumber-1] == 1) {
					room[roomNumber-1] = 0;
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					System.out.println("   "+roomNumber+"�� ���� ��� �Ǿ����ϴ�.");
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				}else {
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
					System.out.println("   ���������ʴ� �� ��ȣ�Դϴ�.");
					System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				}
				break;
			case 3: // ȣ�� ����Ȯ��
				System.out.println("=======================");
				for (int i=0 ; i<room.length; i++) {
					System.out.print(i+1+"�� �� : ");
					if(room[i] == 0) {
						System.out.println(check0);
					}else {
						System.out.println(check1);
					}			
				}
				break;
			case 99: // ���α׷� ����
				power = true;
				break;
			default: // �� �� ��ȣ �Է½�
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				System.out.println("   �ùٸ� ��ȣ�� �Է����ּ���.");
				System.out.println("�١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١ڡ١�");
				break;
			}
		}
		System.out.println("�̿��� �ּż� �����մϴ�.");
	}
}
