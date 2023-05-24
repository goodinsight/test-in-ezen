package kr.co.dong.checkPoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {

//		Ű���忡 ���� �Է��ۼ�
//		��12���� �ְ� => ����?�迭? => �迭 room[12]
//		�Է±�������			// menu���� : 1,2,3,99�� �Է¹���
//		1�� ������� �� ���� ����	//room[���ȣ]�� ���� 1�̸� �������
//		1-> ȣ�ǹ�ȣ ����(1~12) -> ������¿��� Ȯ��
//		-> ���డ�ɻ��� -> ����ǽ� -> ȣ��Ȯ�� => �޴��� ����
//		-> ����Ұ����� -> ȣ�ǹ�ȣ ����(1~12) or �޴��� ����
//		2�� ���� ��� �������(����->����),	//room[���ȣ]�� ���� 0�̸� ����
//		2-> ȣ�ǹ�ȣ����(1~12) -> ��Ұ��ɿ���
//		-> ��Ұ��� : �ش�ȣ���� ���� 0���� => �޴�����
//		-> ��ҺҰ� : ����������� ���̶�� ǥ��. => �޴�����
//		3�� ���� ���� ȣ�� Ȯ��,	// 1�� ���� �����:�� "0�ΰ��� "���డ�ɡ�"
//		99�� ���� ���� ���α׷�����
		boolean reserve = false;
		
		char[] room = new char[12];
		
		for (int i = 0; i < room.length; i++) {
			room[i] = '0';
		}
		
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		String judgment = "";
		int choice = 0;

		while (!reserve) {
			System.out.println("�޴��� �������ּ���\n1. ȣ�ǿ���    2. �������    3. ȣ��Ȯ��    99. ����");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				while (true) {
					System.out.println("�����Ͻ� ȣ���� �������ּ���.");
					for (int i = 0; i < room.length; i++) {
						if(i%5 == 0) {
							System.out.println();
						}
						if(room[i] == '0') {
							judgment = "���డ��";
						}else if(room[i] == '1'){
							judgment = "����Ұ���";
						}
						System.out.print(i+1+"��° ȣ��("+judgment+")   ");
					}
					System.out.println("99 �ڷΰ���");
					choice = sc.nextInt();
					if(choice == 99) {
						System.out.println("�Ŵ��� ���ư��ϴ�.");
						break;
					}else if(room[choice-1] == '0') {
						System.out.println("�����Ͻ� "+choice+"��° ȣ���� �����߽��ϴ�.");
						room[choice-1] = '1';
						break;
					}else if(room[choice-1] == '1') {
						System.out.println("�����Ͻ� "+choice+"��° ȣ���� �ٸ��մ��� �����ϼ̽��ϴ�. �ٸ����� ����ּ���.");
					}
				}
				break;
			case 2:
				System.out.println("������ ����Ͻ� ȣ���� �������ּ���.");
				choice = sc.nextInt();
				if(room[choice-1] == '0') {
					System.out.println("�����Ͻ� "+choice+"��° ȣ���� ����Ǿ� ���� �ʽ��ϴ�.");
				}else if(room[choice-1] == '1') {
					System.out.println("�����Ͻ� "+choice+"��° ȣ���� ������ ����߽��ϴ�.");
					room[choice-1] = '0';
				}
				break;
			case 3:
				for (int i = 0; i < room.length; i++) {
					if(i%5 == 0) {
						System.out.println();
					}
					if(room[i] == '0') {
						judgment = "���డ��";
					}else {
						judgment = "����Ұ���";
					}
					System.out.print(i+1+"��° ȣ��("+judgment+")   ");
				}
				System.out.println();
				break;
			case 99:
				reserve = true;
				break;
			default:
				System.out.println("�ٸ� �Ŵ��� �������Դϴ�.");
				break;
			}
		}
		System.out.println("������ �����մϴ�.");
	}
}
