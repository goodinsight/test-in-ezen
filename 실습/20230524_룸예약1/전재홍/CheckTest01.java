package kr.co.dong.report.checkpoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // �߰����� : ���ǱԸ�� ���۰� ���ÿ� ���� �ټ����� (�Է�)
		int count = 0;
		int roomNum = 101;
		String tmp = "";
//				sc.room
//				sc.room�� 4�� �� �� ��ȣ  �� ���� �ִ��ο� �� ���� ��
//			
		
			System.out.println("��������������������������������������������������������������������������������������������������������������");
			System.out.println("��   �������� ���ڿ��� sys.V1 �Դϴ�. ���� �Ը� �Է����ּ���.   ��");
			System.out.println("��������������������������������������������������������������������������������������������������������������");
			
			System.out.println(" ����� �Է� = ");
						
		int rooms = sc.nextInt();
		String[][] roomType = new String[rooms][3];
		String[][] pInfo = new String[rooms][2]; // ������ ����
		String tmp2 ="";
		int[][] room = new int[rooms][3];
			for(int i=0; i<room.length; i++) { 
				
				if(i%2==0){
//					 �� ������ 2���� ���� ������ 2�� �������� �������� 1�̳� 0�̳ķ� ���� �� ������ ����
//					 �� ������ 3���� �ϸ� 3���� ������ 1�̳� 2�� 0�̳� ������ 
					roomType[i][0] ="����";
					room[i][1] = 2;
					room[i][2] = 50000;
				}else{
					roomType[i][0] ="Ʈ��";
					room[i][1] = 3;
					room[i][2] = 70000;
				}

			}
			
		
		int menu = 0; // �޴� ������ ���� ����
		boolean power = false;
					
			while(!power) {
				
				System.out.println(" ��������������������������������������������������������������������������������������������������������������");
				System.out.println(" �� �� ����������������������������������������  ������������           ��  ��������  ��");
				System.out.println(" �� ��������������������������������������������  ������������     �ݢ�    ��  ���ڿ���  ��");
				System.out.println(" ��  �� �� ���������������� ���������������������������� ��           ��  sys.V1  ��");
				System.out.println(" ��������������������������������������������������������������������������������������������������������������");
				System.out.println(" ��  1.����    2.�������    3.�������Ȯ��    99.�����ܼ�����   ��");
				System.out.println(" ��������������������������������������������������������������������������������������������������������������");
				System.out.println(" ����� �Է� = ");
				
				menu = sc.nextInt();
				
				switch(menu){ // ū �޴� 
						
				case 1: // 1.�����ϱ�
					
					
					System.out.println(" ���� ������ ������ ȣ�� ����Դϴ� �� ������ �����Ͻðڽ��ϱ�? ���� �Ը� : " + room.length + " ��\n");
					
					
					for(int i =0; i<room.length; i++) {// ���� ���� Ȯ��
						
						
						
						if(0 == room[i][0]){
							
							System.out.println(" ��������������������������������������������������������������������������������������������������������������������������������������");
							System.out.printf("   ���� ���� : " + roomType[i][0]+" ��");
							System.out.printf(" ���� ���� : " + room[i][1]+"�� ��");
							System.out.printf("��%4dȣ �� ���� ��",(i+roomNum)); // ���ȣ �ذ�
							System.out.printf(" �ݾ� : " +room[i][2]+" won \n");
							System.out.println(" ��������������������������������������������������������������������������������������������������������������������������������������");
							
						}else{
							System.out.println(" ��������������������������������������������������������������������������������������������������������������������������������������");
							System.out.printf("���� ���� : " + roomType[i][0]);
							System.out.printf("���� ���� : " + room[i][1]+"��");
							System.out.printf("��%4dȣ �� �Ұ� ��\n",(i+roomNum));
							System.out.printf("�ݾ� : " +room[i][2]+" won");
							System.out.println(" ��������������������������������������������������������������������������������������������������������������������������������������");
						}
						
					}	
					
					int rv = 0; // ������ �� ���� ����
					rv = sc.nextInt(); // �� ��ȣ ����
					rv-=roomNum; // �� ��ȣ�� �Է��ϸ� �� ���� ���� �� �� �ֵ��� ��
					
														
					//		sc.room�� 1�� roomType �� ��Ʈ�����·�(�ؽ�Ʈ ġȯ) �� �� ��Ī �� ������ �̸� �ִ� ���� �� ������ �ڵ�����ȣ ��
							if(0==room[rv][0]) {
							System.out.println(" "+(char)(9312) +" �����ϱ� " +(char)(9313)+ " ���ư��� ");
						
							int rvs = 0; // ������ ���� �����ϴ� ����
							rvs = sc.nextInt();
															
							switch(rvs){
								case 1:// �����ϱⰡ ������ ȣ�� �����ϱ�
									System.out.println("��ǥ ������ ���԰� ����ó�� �Է����ּ���.(���ⱸ��)");
									pInfo[rv][0] = sc.next();
									pInfo[rv][1] = sc.next();
																								
																			
									room[rv][0] =1;
															
										System.out.println("���� �Ǿ����ϴ�.");
										
										
										
										break;
										
										
									case 2:// ���ư���
										System.out.println("ȣ�� ���� ȭ������ ���ư��ϴ�.");
										break;
										
									default:// 1,2 �̿� �Է� ���� ��
										System.out.println("�߸� �� �Է��Դϴ�.");
										break;
								}
								break;
							}
						
					
						
				case 2: // 2.����ϱ�
					System.out.println(" ���� ��Ұ� ������ ȣ�� ����Դϴ� �� ������ ����Ͻðڽ��ϱ�?");
						
					for(int i =0; i<room.length; i++) {
						// ��� ���� ���� Ȯ��
						if(1 == room[i][0]){							
							
							System.out.print(" "+(i+1) + " ��Ұ��� ");
						}else{
							System.out.print(" "+(i+1) + " �� ���� ");
						}
						
						
					}
					
					rv = sc.nextInt(); // �� ��ȣ ����
					rv--;
					
						if(1==room[rv][0]) {
						System.out.println(" "+(char)(9312) +" ����ϱ� " +(char)(9313)+ " ���ư��� ");
					
						int rvs = 0; // ������ ���� ����ϴ� ����
						rvs = sc.nextInt();
														
						switch(rvs){
							case 1:// ����ϱⰡ ������ ȣ�� ����ϱ�
								System.out.println("��ǥ ������ ���԰� ����ó�� �Է����ּ���.(���ⱸ��)");
								tmp2 = sc.next();
								tmp = sc.next();
								
								if(pInfo[rv][0]==tmp2 && pInfo[rv][1]==tmp) {
									
									room[rv][0]=0;
								}
									
													
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
					break;
					
				case 3:
					System.out.println(" ���� ��Ȳ�� ��ȸ�մϴ�.");
					
					for(int i =0; i<room.length; i++) { // ���� ���� Ȯ��
						if(0 == room[i][0]){
							System.out.print(" "+(char)(9312+i) + " ���� ");
						}else{
							System.out.print(" "+(char)(9312+i) + " ���� ");
						}
						count++;
						if(count%5==0) {
							System.out.println();
							System.out.println();
						}
					}
					System.out.println();
					
					
					break;
					
				case 77:
					System.out.println("��������������������������������������������������������������������������������������������������������������������������");
					System.out.println("                    ������ ��忡 �����մϴ�.                      ");
					System.out.println("                     ��й�ȣ�� �Է����ּ���.                      ");
					System.out.println("                  HINT : ������ ����ó ���ڸ�                     ");
					System.out.println("��������������������������������������������������������������������������������������������������������������������������");
					System.out.println(" ����� �Է� = ");	
					
					String pswd = sc.next();
					
					if("3002".equals(pswd))
						
						boolean adminpower = false; // ������ ��� ����
						int tmpNum = 0, swNum = 0;
						String sw = null , tmp = null;
						
						while(!adminpower) {
							
							System.out.println("��������������������������������������������������������������");
							System.out.println("����������������� Administrator Mode Activate �����������������");
							System.out.println("��������������������������������������������������������������");
							System.out.println("0.������� 1.ǰ�� �̸� �ٲٱ� 2.��� ����. 3. �������� 4.�����ڸ�� ������");
						
								int admin=sc.nextInt();
						
								switch(admin) {// ���� �޴� ����
								
								case 4:
									adminpower = true;
									System.out.println("��������������������������������������������������������������������������������������������������������������������������");
									System.out.println("������ ��尡 ����˴ϴ�.");
									
									break;
							
								default:
									break;
							}
								
								if(adminpower != true){
									System.out.println("��������������������������������������������������������������������������������������������������������������������������");
									System.out.println("��⸦ ������ϱ� ������ ��������� ����˴ϴ�.\n");
								}
								
								}
					
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
		ȣ�ڹ� ��ȣ(�������� �ذ�)�� ȣ�ڹ� ��(�̱�/����)/�����ִ��ο�/����
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