/*
���� -> �ҽ��ۼ� 
-> �����
Ű���忡 ���� �Է� �ۼ�
��12���� �ְ� => ����? �迭? => �迭 room[12]
�Է±������� menu����: 1,2,3, 99�� �Է¹���
1�� �������� ���� ���� ���ȣ�� ���� 1�̸� �������
	1 -> ȣ�ǹ�ȣ ����(1~12) => ������¿��� Ȯ��
	-> ���డ�ɻ��� -> ����ǽ� -> ȣ��Ȯ�� => �޴��� ����
	-> ����Ұ����� -> ȣ�ǹ�ȣ ����(1~12) or �޴��� �ϱ�
2�� ���� ��� �������(���� -> ����) ���ȣ 0�̸� ����
	2 -> ȣ�ǹ�ȣ����(1~12) -> ��Ұ��ɿ���
	-> ��Ұ��� : �ش�ȣ���� ���� 0���� -> �޴� ����
	-> ��ҺҰ� : ����������� ���̶�� ǥ�� => �޴�����
3�� ���� ���� ȣ�� ȭ�� // 1�� ��� "�����:*" 0�ΰ�� "���డ��*"
99�� ���� ���� ���α׷� ����
 */
package kr.co.dong.checkpoint;

import java.util.Scanner;

public class ArrayTest03 {
	public static void main(String[] args) {
		// ����
		int[] room = {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0}; // ���� �����ʱ� ���̺�
		int[] reserRoom = new int [12];
		int input =0;
		int roomNum = 0;
		int checkNum = 0;
		
		boolean power = false;
		
		// �Է�
		Scanner scan = new Scanner(System.in); // ��ĳ�� ȣ��
		
		// ���÷���
		System.out.println("========== ������Ʈ ȣ�� �� ���� ==========");
		System.out.println("   1ȣ    2ȣ   3ȣ   4ȣ    5ȣ    6ȣ");
		for(int i=0; i<room.length/2; i++) { // room ��ü ������� �ʱ�ȭ
			System.out.printf("   %2d ", room[i] );
		}
		System.out.println();
		System.out.println("   7ȣ    8ȣ   9ȣ  10ȣ   11ȣ   12ȣ");
		for(int i=6; i<room.length; i++) { // room ��ü ������� �ʱ�ȭ
			System.out.printf("   %2d ", room[i] );
		}
		System.out.println();
		
		System.out.println();
		System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
		System.out.println("1. �濹��      2. ���� ���     3. ȣ��Ȯ��");
		System.out.println("                            99. ����");
		
//		������
	
		while(!power) {
			
			System.out.println("��ɼ��� => "); // ��ɼ���
			input = scan.nextInt();
			
			for(int i=0; i<room.length; i++) { // ���� �ݿ�
				reserRoom[i] = room[i];
			}

			switch (input) {
			
			case 1: // ����
				System.out.println("�����ϰ� ���� ���� ��ȣ ���� => (����Ϸ�1ǥ��, ��� 0ǥ��) ");
				roomNum = scan.nextInt();
				
				if(roomNum >12) {
					System.out.println("���ȣ�� 1~12�����Դϴ�. �ٽ� ��Ź�帳�ϴ�.");
					System.out.println("�����ϰ� ���� ���� ��ȣ ���� => (����Ϸ�1ǥ��, ��� 0ǥ��) ");	
					roomNum = scan.nextInt();
				}	
								
					if(reserRoom[roomNum-1] ==0 && roomNum <=12 && roomNum >0) {						
						System.out.printf("�����Ͻ� ���� %d �Դϴ�. �����մϴ�. \n", roomNum);
						System.out.println("�����Ͻ� ���ȣ�� ������� 1�� ����˴ϴ�.");	
						System.out.println();
						room[roomNum-1] = 1; // ���� ���ȣ Ȯ��
						// ����� ���� �� �迭�� �� �ݿ�
						for(int i=0; i<room.length; i++) {
							reserRoom[i] = room[i];
						}
											
						//resen
						System.out.println("========== ������Ʈ ȣ�� �� ���� ==========");
						System.out.println("   1ȣ    2ȣ   3ȣ   4ȣ    5ȣ    6ȣ");				
						for(int i=0; i<room.length/2; i++) { // room ��ü ������� �ʱ�ȭ
							System.out.printf("   %2d ", reserRoom[i] );
						}
						System.out.println();
						System.out.println("   7ȣ    8ȣ   9ȣ  10ȣ   11ȣ   12ȣ");
						for(int i=6; i<room.length; i++) { // room ��ü ������� �ʱ�ȭ
							System.out.printf("   %2d ", reserRoom[i]);
						}
						System.out.println();

						System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
						System.out.println("1. �濹��      2. ���� ���     3. ȣ��Ȯ��");
						System.out.println("                            99. ����");
						// resen ����
						
					} // end of if
					else {
						System.out.println("������ �Ϸ�� ���Դϴ�. 0���� ǥ��� ���� ������ �ּ���");
						break;
					}
				
				break;

			case 2: // �������
				System.out.println("������ ����ϰ� ���� ���ȣ =>");
				checkNum = scan.nextInt();
				
				if(reserRoom[checkNum-1] == 0 ) { // �Է°�Ȯ��
					System.out.println("�� ���Դϴ�. �ٸ� ȣ���� �����ϽŰ� �����ϴ�.");
					System.out.println("Ȯ���� ��Ȯ�� ���ȣ�� �����ϼ���>");
					
					checkNum = scan.nextInt();
				}
	
				if(reserRoom[checkNum-1] ==1 && checkNum <=12 && checkNum >0) {
					System.out.printf("���� ��� ���� %d �Դϴ�. �����մϴ�. \n", checkNum);
					System.out.println("�����Ͻ� ���� ��һ��� 0���� ����˴ϴ�.");
					System.out.println();
					reserRoom[checkNum-1] = 0; // ���� ���ȣ Ȯ��	
					
					//resen
					System.out.println("========== ������Ʈ ȣ�� �� ���� ==========");
					System.out.println("   1ȣ    2ȣ   3ȣ   4ȣ    5ȣ    6ȣ");				
					for(int i=0; i<room.length/2; i++) { // room ��ü ������� �ʱ�ȭ
						System.out.printf("   %2d ", reserRoom[i] );
					}
					System.out.println();
					System.out.println("   7ȣ    8ȣ   9ȣ  10ȣ   11ȣ   12ȣ");
					for(int i=6; i<room.length; i++) { // room ��ü ������� �ʱ�ȭ
						System.out.printf("   %2d ", reserRoom[i]);
					}
					System.out.println();

					System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
					System.out.println("1. �濹��      2. ���� ���     3. ȣ��Ȯ��");
					System.out.println("                            99. ����");
					// resen ����
				}
			
				break;				
				
			case 3: // Ȯ��
				System.out.println("�� ȣ�� ���� ����");
				for(int i=1; i<=reserRoom.length; i++) {
					if(reserRoom[i-1]==1) {
						System.out.printf("%4dȣ : �����   ��", i );				
					}
					else {
						System.out.printf("%4dȣ : ���డ�� ��", i );						
					}
					if(i%4==0)
						System.out.println();
				}
				System.out.println();
				
				//resen
				System.out.println("========== ������Ʈ ȣ�� �� ���� ==========");
				System.out.println("   1ȣ    2ȣ   3ȣ   4ȣ    5ȣ    6ȣ");				
				for(int i=0; i<room.length/2; i++) { // room ��ü ������� �ʱ�ȭ
					System.out.printf("   %2d ", reserRoom[i] );
				}
				System.out.println();
				System.out.println("   7ȣ    8ȣ   9ȣ  10ȣ   11ȣ   12ȣ");
				for(int i=6; i<room.length; i++) { // room ��ü ������� �ʱ�ȭ
					System.out.printf("   %2d ", reserRoom[i]);
				}
				System.out.println();

				System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
				System.out.println("1. �濹��      2. ���� ���     3. ȣ��Ȯ��");
				System.out.println("                            99. ����");
				// resen ����
				
				break;
				
			case 99: //����
				power = true;
				System.out.println("��� ��û������ ������ �Ǿ����ϴ�. �����մϴ�.");	
				break;

			default:
				System.out.println("�������� ������ �ƴմϴ�. �ٽ� ������ �ּ��� ");
				break;
			}
			
		} // end of while
	System.out.println("���� �ý��� ����.");
} // end of main
} // end of class
