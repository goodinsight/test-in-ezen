package kr.co.dong.checkTest;

import java.util.Scanner;

public class CheckTest21 {
public static void main(String[] args) {
	
	int[] room = new int[12]; 	//	�� 12���� �迭�� ���� * �⺻ �����̴� ���� �صѰ� 
	int menu = 0; // �޴� ������ ���� ����
	Scanner sc = new Scanner(System.in);
	boolean power = false;
				
		while(!power) {
			
			System.out.println(" ��������������������������������������������������������������������������������������������������������������");
			System.out.println(" �� �� ����������������������������������������  ������������           ��  ��������  ��");
			System.out.println(" �� ��������������������������������������������  ������������     �ݢ�    ��  ���ڿ���  ��");
			System.out.println(" ��  �� �� ���������������� ���������������������������� ��           ��  sys.v1  ��");
			System.out.println(" ��������������������������������������������������������������������������������������������������������������");
			System.out.println(" ��  1.����    2.�������    3.�������Ȯ��    99.�����ܼ�����   ��");
			System.out.println(" ��������������������������������������������������������������������������������������������������������������");
			System.out.println("  ����� �Է� = ");
			menu = sc.nextInt();
			
			switch(menu){ // ū �޴� 
					
			case 1: // 1.�����ϱ�
				
				
				System.out.println(" ���� ������ ������ ȣ�� ����Դϴ� �� ������ �����Ͻðڽ��ϱ�? ���� �Ը� : " + room.length +"��");
					
				for(int i =0; i<room.length; i++) { // ���� ���� Ȯ��
					
					if(0 == room[i]){
						System.out.println("������������������\n�� "+(char)(9312+i) + " ���� ��\n������������������");
						
					}else{
						System.out.println("������������������\n�� "+(char)(9312+i) + " �Ұ� ��\n������������������");
					}
					
					if(i==6) {
					
//				System.out.println();
					}
				}
//				System.out.println();
			
				
				int rv = 0; // ������ �� ���� ����
				rv = sc.nextInt(); // �� ��ȣ ����
				rv--;
				
				switch(rv) { // ���� �����ϸ� 0 �Ǵ� null;���� 1�� ġȯ �ϴ� ������ ����� 
				
					case 0: case 1: case 2: case 3: case 4: case 5: case 6:
					case 7: case 8: case 9: case 10: case 11:
								
						if(0==room[rv]) {
						System.out.println(" "+(char)(9312) +" �����ϱ� " +(char)(9313)+ " ���ư��� ");
					
						int rvs = 0; // ������ ���� �����ϴ� ����
						rvs = sc.nextInt();
														
						switch(rvs){
							case 1:// �����ϱⰡ ������ ȣ�� �����ϱ�
									
								room[rv] =1;
														
									System.out.println("���� �Ǿ����ϴ�.");
									break;
									
									
								case 2:// ���ư���
									System.out.println("ȣ�� ���� ȭ������ ���ư��ϴ�.");
									break;
									
								default:// 1,2 �̿� �Է� ���� ��
									System.out.println("�߸� �� �Է��Դϴ�.");
									break;
							}
						}
					
					}
					break;
					
			case 2: // 2.����ϱ�
				System.out.println(" ���� ��Ұ� ������ ȣ�� ����Դϴ� �� ������ �����Ͻðڽ��ϱ�?");
					
				for(int i =0; i<room.length; i++) { // ��� ���� ���� Ȯ��
					if(1 == room[i]){
						System.out.print(" "+(char)(9312+i) + " ��Ұ��� ");
					}else{
						System.out.print(" "+(char)(9312+i) + " �� ���� ");
					}
				}
				
				rv = sc.nextInt(); // �� ��ȣ ����
				rv--;
				
				switch(rv) { // ���� �����ϸ� 0 �Ǵ� null;���� 1�� ġȯ �ϴ� ������ ����� 
				
				case 0: case 1: case 2: case 3: case 4: case 5: case 6:
				case 7: case 8: case 9: case 10: case 11:
							
					if(1==room[rv]) {
					System.out.println(" "+(char)(9312) +" ����ϱ� " +(char)(9313)+ " ���ư��� ");
				
					int rvs = 0; // ������ ���� �����ϴ� ����
					rvs = sc.nextInt();
													
					switch(rvs){
						case 1:// �����ϱⰡ ������ ȣ�� �����ϱ�
								
							room[rv]=0;
												
								System.out.println("������ ��� �Ǿ����ϴ�.");
								break;
								
								
							case 2:// ���ư���
								System.out.println("ȣ�� ���� ȭ������ ���ư��ϴ�.");
								break;
								
							default:// 1,2 �̿� �Է� ���� ��
								System.out.println("�߸� �� �Է��Դϴ�.");
								break;
						}
					}
				
				}
				break;
			case 3:
				System.out.println(" ���� ��Ȳ�� ��ȸ�մϴ�.");
				
				for(int i =0; i<room.length; i++) { // ���� ���� Ȯ��
					if(0 == room[i]){
						System.out.print(" "+(char)(9312+i) + " ���� ");
					}else{
						System.out.print(" "+(char)(9312+i) + " ���� ");
					}
				}
				System.out.println();
				
				
				break;
			case 99:
				power = true;
				System.out.println("��� ������ ����˴ϴ�.");
				
				break;
				
			default:// 1,2 �޴� �̿� �Է� ���� ��
				System.out.println("�߸� �� �Է��Դϴ�.");
				break;
			
				}
			
		
			
		
		
		
		
		}

}//main ed

}//class ed

/*


20230525 �߰����� ���ǱԸ�� ���۰� ���ÿ� ��������� (�Է�) 
	ȣ�ڹ� ��ȣ�� ȣ�ڹ��(����/ŷ/��/����)/�����ִ��ο�/����
	����� ������ �� /�����ȣ ��
	�����ڸ������ �߳��� ���



�Է±������� 	// menu ����: 1,2,3,99�� �Է¹���

1�� �������� ���� ����,	 // room[���ȣ]�� ���� 1�̸� �������


1-> ȣ�ǹ�ȣ ����(1~12)-> ������¿��� Ȯ��

>���డ�ɻ���-> ����ǽ�->ȣ��Ȯ��=> �޴��� ���� ->
����Ұ�����-> ȣ�ǹ�ȣ ����(1~12) or �޴��� ����

2�� ���� ��� �������(����->����), // room[���ȣ]�� ���� 0�̸� ����

2-> ȣ�ǹ�ȣ����(1~12)-> ��Ұ��ɿ���

->��Ұ���: �ش�ȣ���� ���� 0����=> �޴�����
->��ҺҰ�: ����������� ���̶�� ǥ��.=> �޴�����

*3�� ���� ���� ȣ�� Ȯ��, // 1�� ���� "�����: �� "0�ΰ��� "���డ�ɡ�"

99�� ���� ���� ���α׷�����.

package kr.co.dong.checkPoint;
import java.util.Scanner; // ScannerŬ������ �ҷ����δ�.
rt.jar ���Ͽ� �ִ� Ŭ�������� ����Ҽ� �ְ� ���ش�.

*/