package kr.co.dong.CheckPoint;

import java.util.Scanner;

public class CheckTest01_3 {

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
		
//		=> �߰����� : 1. ���ǱԸ�(ũ��)�� ���۰� ���ÿ� �Է���
//				   2. ȣ�ڹ��ȣ/ȣ�ڹ��(��-�ξ�/������ ��) / �����ο� / ����
//				   3. ����� �����ڸ� / �����ȣ(��ҽ� �ʿ�) ��
//				   4. ��Ÿ �ʿ��� ���(�����ڸ��)
		
		
		boolean power = false;
		int [] room = {0,0,0,0,0,0,0,0,0,0,0,0};  // �� ȣ�� �ε���
		int menu = 0;     // �޴� ��ȣ ���� 
		int select = 0;   // ȣ�� ����
		int cancel = 0;   // ��� �� ȣ�� ����
		int manage = 0;   // ������ ��� �Է� �ޱ�
		
		String [] name = new String [12];  // ȣ�� �̸�����
		int [] num = new int [12];     // ȣ�� �ο�����
		int [] price = {60000, 60000, 80000, 80000, 80000, 80000, 80000, 80000, 80000, 120000, 240000, 240000};
		   // ȣ�� ���ݼ���
		
		int nameChange1 = 0;  //ȣ�� �̸� ���� ����
		String nameChange2 = " ";  //ȣ�� �̸� ���� ĭ 
		
		int numChange1 = 0;    //ȣ�� �ο� ���� ����
		int numChange2 = 0;    //ȣ�� �ο� ���� ĭ
		
		int priceChange1 = 0;  // ���� ���� ȣ�� ����
		int priceChange2 = 0;  //ȣ�� ���� ���� ĭ
		
		String [] reserveName = new String [12];   // ������ ����
		String [] reserveNum = new String [12];    // ����� �����ȣ
		String [] cancelName = new String [12];
		String [] cancelNum = new String [12];

		name[0] = "�̱۷�1";
		name[1] = "�̱۷�2";
		name[2] = "�����1";
		name[3] = "�����2";
		name[4] = "�����3";
		name[5] = "Ʈ����1";
		name[6] = "Ʈ����2";
		name[7] = "Ʈ����3";
		name[8] = "�𷰽���";
		name[9] = "�йи���";
		name[10] = "����Ʈ��1";
		name[11] = "����Ʈ��2";
		
		num[0] = 1;
		num[1] = 1;
		num[2] = 2;
		num[3] = 2;
		num[4] = 2;
		num[5] = 2;
		num[6] = 2;
		num[7] = 2;
		num[8] = 2;
		num[9] = 8;
		num[10] = 10;
		num[11] = 10;

		
		reserveName [0] = " ";
		reserveName [1] = " ";
		reserveName [2] = " ";
		reserveName [3] = " ";
		reserveName [4] = " ";
		reserveName [5] = " ";
		reserveName [6] = " ";
		reserveName [7] = " ";
		reserveName [8] = " ";
		reserveName [9] = " ";
		reserveName [10] = " ";
		reserveName [11] = " ";
		
		reserveNum [0] = " ";
		reserveNum [1] = " ";
		reserveNum [2] = " ";
		reserveNum [3] = " ";
		reserveNum [4] = " ";
		reserveNum [5] = " ";
		reserveNum [6] = " ";
		reserveNum [7] = " ";
		reserveNum [8] = " ";
		reserveNum [9] = " ";
		reserveNum [10] = " ";
		reserveNum [11] = " ";
		
		cancelName [0] = " ";
		cancelName [1] = " ";
		cancelName [2] = " ";
		cancelName [3] = " ";
		cancelName [4] = " ";
		cancelName [5] = " ";
		cancelName [6] = " ";
		cancelName [7] = " ";
		cancelName [8] = " ";
		cancelName [9] = " ";
		cancelName [10] = " ";
		cancelName [11] = " ";
		
		cancelNum [0] = " ";
		cancelNum [1] = " ";
		cancelNum [2] = " ";
		cancelNum [3] = " ";
		cancelNum [4] = " ";
		cancelNum [5] = " ";
		cancelNum [6] = " ";
		cancelNum [7] = " ";
		cancelNum [8] = " ";
		cancelNum [9] = " ";
		cancelNum [10] = " ";
		cancelNum [11] = " ";
		
		
		Scanner scan = new Scanner(System.in);
		
		while (!power) { 
			System.out.println("                                                             ");
			System.out.println("                                    �ؿ����                    ");
			System.out.println("                              �̿��Ͻ� �޴��� �����ּ���.            ");
			System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
			System.out.println("                                ��. �� ���� �ϱ�");
			System.out.println("                                ��. �� ���� ���");
			System.out.println("                                ��. ȣ�� ���� ��Ȳ ");
			System.out.println("                                ��.  ȣ�� ���� ");
//			System.out.println("                                ���. ������ ��� ");
			System.out.println("                                ���.  ����   ");
			System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
			menu = scan.nextInt();
			
			switch (menu) {
			case 1:
				System.out.println("������������������������������������������������������INFORMATION��������������������������������������������������������������");
				System.out.println("��   �� ȣ�� �̸�              �� �ִ� ���� �ο�                  �� ����      ��");
				System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
				for (int i=0; i<room.length; i++) {
					System.out.println("��"+(i+1)+"ȣ�� - '"+name[i]+"'               "+num[i]+"�� ����                "+"�� "+price[i]+"��       ��");
				}
				System.out.println("����������������������������������������������������������������������������������������������������������������������������������������");
			
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				System.out.println("                          > �� ���� �ϱ� �Դϴ�.");
				System.out.println("                         > �����Ͻ� ȣ���� �����ּ���.");
				select = scan.nextInt();
				System.out.println(select+"ȣ���� ���� �Ͽ����ϴ�.");
				if (room[select-1]==1) {
					System.out.println(select+"ȣ���� �̹� ������ �Ǿ� �־� ������ �Ұ����մϴ�");
					System.out.println("> �޴��� ���ư��ϴ�. �޴��� �ٽ� �������ּ���");
					System.out.println();
					break;
				}
				System.out.println(select+"ȣ���� ������ �����մϴ�.");
				System.out.println("> �����Ͻ÷��� ������ ������ �����ּ���.");
				reserveName[select-1] = scan.next();
				System.out.println(reserveName[select-1]+"�� "+select+"ȣ���� ���� �Ǿ����ϴ�.");
				reserveName[select-1] = reserveName[select-1];
				room[select-1] = 1; 
				System.out.println("�����ȣ�� : "+230525+select+select+"�� �Դϴ�. �����մϴ�.");
				reserveNum[select-1] = "230525"+select+select;
			    System.out.println();
				 
				break;
			case 2:
				System.out.println("> �� ���� ��� �Դϴ�.");
				System.out.println("> ���� ����Ͻ� ȣ���� �����ּ���.");
				cancel = scan.nextInt();
				System.out.println(cancel+"ȣ���� ���� �Ͽ����ϴ�.");
				if (room[cancel-1]==1) {
					System.out.println(cancel+"ȣ���� ��Ұ� �����մϴ�.");
					System.out.println("> ����Ͻ÷��� ������ ������ �����ּ���.");
					cancelName[cancel-1] = scan.next();
					if (reserveName[cancel-1].equals(cancelName[cancel-1])) {
						System.out.println(cancelName[cancel-1]+"�� "+cancel+"ȣ�� ������ Ȯ�εǾ����ϴ�.");
						cancelName[cancel-1] = " ";
						System.out.println("> �����ȣ�� �Է����ּ���.");
						cancelNum[cancel-1] = scan.next();
						if (reserveNum[cancel-1].equals(cancelNum[cancel-1])) {
							System.out.println("> �����ȣ�� Ȯ�� �Ǿ����ϴ�.");
							System.out.println(cancel+"ȣ���� ������ ��ҵǾ����ϴ�. �����մϴ�.");
							cancelNum[cancel-1] = " ";
							room[cancel-1] = 0;
							break;
						}else {
							System.out.println("> �����ȣ�� ��ġ���� �ʽ��ϴ�.");
							System.out.println("> Ȯ�� �� �ٽ� �Է����ּ���.");
							System.out.println("> �޴��� ���ư��ϴ�.");
							System.out.println();
							break;
						}
					}else {
						System.out.println("> �����ڰ� ��Ͽ� �����ϴ�.");
						System.out.println("> Ȯ�� �� �ٽ� �Է����ּ���.");
						System.out.println("> �޴��� ���ư��ϴ�.");
						System.out.println();
						break;
					}
					
				}else {
					System.out.println(cancel+"ȣ���� ������ �Ǿ����� �ʽ��ϴ�.");
					System.out.println("> Ȯ�� �� �ٽ� �Է����ּ���.");
					System.out.println("> �޴��� ���ư��ϴ�.");
				}
				break;
			case 3:
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				System.out.println("�ġġġġġġġġġ�[ ���� ȣ�� ������Ȳ�Դϴ�. ]�ġġġġġġġġġ�");
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				for (int i=0; i<room.length; i++) {
					System.out.print((i+1)+"ȣ�� / "+ name[i]+") : "+ room[i]);
					if (room[i]==0) {
						System.out.println("  �� ���డ�� O");
					}else if(room[i]==1) {
						System.out.println("  �� ����Ұ��� X");
					}
				}
				break;
			
			case 4:
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				System.out.println("�ġġġġġġġġġ�  [  ȣ�� ���� �Դϴ�. ]  �ġġġġġġġġġ�");
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				System.out.println("     ȣ�� �̸� �� �ִ밴���ο� ������ �� �� �ֽ��ϴ�.  ");
				System.out.println("�ġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġġ�");
				for (int i=0; i<room.length; i++) {
					System.out.println((i+1)+"ȣ�� �̸� : '"+name[i]+"' �� �����ο� : (�ִ�)"+num[i]+"�� ����"+" �� ���� : "+"�� "+price[i]+"��");
				}
				
				break;
				
			case 77:
				System.out.println("�ܡܡܡܡܡܡܡܡܡܡܡ� [ ������ ����Դϴ�.] �ܡܡܡܡܡܡܡܡܡܡܡ�");
				System.out.println("�ܡܡܡܡܡܡܡܡ� ���ϴ� �޴��� ��ư�� �����ּ���. �ܡܡܡܡܡܡ�");
				System.out.println();
				System.out.println("1. ȣ�� �̸� ����   2. ���� �ο� ����  3. ȣ�� ���� ����");
				manage = scan.nextInt();
				
				if (manage==1) {
					System.out.println("> ȣ�� �̸� �����Դϴ�.");
					System.out.println("> �̸� ������ ���ϴ� ȣ���� �����ּ���.");
					nameChange1 = scan.nextInt();
			
					System.out.println("> ���� �̸��� "+name[nameChange1-1]+"�Դϴ�.");
					System.out.println("> ������ �̸��� �Է����ּ���.");
					nameChange2 = scan.next();
					System.out.println(name[nameChange1-1]+"���� "+nameChange2+"�� ���� �Ǿ����ϴ�.");
					name[nameChange1-1] = nameChange2;	
					break;
				}else if (manage==2) {
					System.out.println("> ���� �ο� �����Դϴ�.");
					System.out.println("> ���� �ο� ������ ���ϴ� ȣ���� �����ּ���.");
					numChange1 = scan.nextInt();
					
					System.out.println("> ���� �ο��� "+num[numChange1-1]+"�Դϴ�.");
					System.out.println("> ������ �ο��� �Է����ּ���.");
					numChange2 = scan.nextInt();
					System.out.println(num[numChange1-1]+"�� ���� "+numChange2+"������ ���� �Ǿ����ϴ�.");
					num[numChange1-1] = numChange2;
					break;
				}
				 else if (manage==3) {
				    System.out.println("> ȣ�� ���� �����Դϴ�.");
				    System.out.println("> ȣ�� ���� ������ ���ϴ� ȣ���� �����ּ���.");
				    priceChange1 = scan.nextInt();
				
				    System.out.println("> ���� ������ "+price[priceChange1-1]+"�Դϴ�.");
				    System.out.println("> ������ ������ �Է����ּ���.");
				    priceChange2 = scan.nextInt();
				    System.out.println("��"+price[priceChange1-1]+"�� ���� "+"��"+priceChange2+"������ ���� �Ǿ����ϴ�.");
			    	price[priceChange1-1] = priceChange2;
				    break;
			    }
		
			case 99:
				power = true;
				System.out.println(">>> �ý����� �����մϴ�.");
				break;
			}

		}

	}

}
