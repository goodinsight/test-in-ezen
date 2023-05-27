package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest07 {
public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] room = { 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0 }; // ���� ȣ�� ������� 0 -> ���� ����, 1 -> ���� �Ұ���
//		int mainMenu = 0;	// �޴��� ��ȣ�� �����ϱ����� ����
//		int subMenu = 0;	// ���� ȭ�鿡�� �޴��� �����ϱ� ���� ����
		int selectMenu = 0;
		
		String[] reservationStatus = { "�ٿ��� ���ɡ�", "�ڿ���Ұ��ɡ�" }; // room[]�� ���� ���� ������ ���ɿ��θ� �����ֱ� ���� ���ڿ� �迭
		String answer = null;	// ���� ���ÿ� ���� �亯�� ���ڷ� �Է¹޴� ����
		
		// ���α׷��� �����ϱ� ������ �ݺ��ؼ� ���� �޴��� �ҷ��ֱ����� while�� ���
		hotel:
		while(true) {
			System.out.println("========================================================================================");
			
			// �迭�� �ݺ����� �����Ͽ� ���� �޴��� ���
			for(int i=1; i<=room.length; i++) {
				
				// room[]�� ���� 0 �� 1�� �̷���� �ֱ� ������ ������¸� �����ִ� reservationStatus[]�� �̿�
				System.out.printf("[%2dȣ%s ] \t", i, reservationStatus[room[i-1]]);
				if(i % 4 == 0) {
					System.out.println();
					System.out.println("========================================================================================");
				}
			}
			System.out.println();
			System.out.println("���Ͻô� �޴��� ��ȣ�� �������ּ���");
			System.out.println("[1.����] [2.�������] [3.ȣ��Ȯ��] [99.����]");
			selectMenu = scan.nextInt();
			
			// ���θ޴����� �Ѿ�� �ι�° �޴�ȭ��
			switch(selectMenu) {
			
			//�����ϴ� �޴�
			case 1:
				System.out.print("ȣ���� �������ּ���. : ");
				selectMenu = scan.nextInt();
				
				// room[]�� ���� 0 �� 1�� �̷���� �ֱ� ������ ������¸� �����ִ� reservationStatus[]�� �̿�
				System.out.println("�����Ͻ� ȣ���� "+reservationStatus[room[selectMenu-1]]+"�Դϴ�."); 
				
				if(room[selectMenu-1] == 0) {
					System.out.println(selectMenu+"ȣ�� ���� �Ͻðڽ��ϱ�?");
					System.out.println("�� / �ƴϿ�");
					answer = scan.next();
					
					// ����Ȯ���� ���� �亯�� �޴� answer�� "��" / "�ƴϿ�"�� �´��� Ȯ��
					// "�ƴϿ�" �Է½� �ʱ� ����ȭ������ �̵�
					if(answer.equals("��")) {
						room[selectMenu-1] = 1;
						System.out.println(selectMenu+"ȣ�� ���� �Ǿ����ϴ�.");
					}
					else if(answer.equals("�ƴϿ�")){
						break;
					}
					else {
						System.out.println("�߸��� �Է��Դϴ�.");
						break;
					}
					
				}
				else if(room[selectMenu-1] == 1) {
					break;
				}
				break;
				
			//������ ����ϴ� �޴�
			case 2:
				System.out.print("ȣ���� �������ּ���. : ");
				selectMenu = scan.nextInt();
				
				if(room[selectMenu] == 0) {
					System.out.println("������� ���� ���Դϴ�.");
				}
				else if(room[selectMenu] == 1) {
					System.out.println(selectMenu+"ȣ�� ������ ����Ͻðڽ��ϱ�?");
					System.out.println("�� / �ƴϿ�");
					answer = scan.next();
					
					if(answer.equals("��")) {
						room[selectMenu-1] = 0;
						System.out.println(selectMenu+"ȣ�� ������ ����Ͽ����ϴ�.");
					}
					
					// "�ƴϿ�" �Է½� �ʱ� ����ȭ������ �̵�
					else if(answer.equals("�ƴϿ�")){
						break;
					}
					else {
						System.out.println("�߸��� �Է��Դϴ�.");
						break;
					}
				}
			case 3:
				break;
				
			// 99 �Է½� hotel : while�� break ���α׷� ����
			case 99:
				System.out.println("[�������α׷��� �����մϴ�]");
				break hotel;
			default:
				System.out.println("[�߸��� �Է��Դϴ�.]");
			}
		}
	}

}
