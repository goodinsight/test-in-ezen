package kr.co.dong;

import java.util.Scanner;

public class Report21_2 {

	public static void main(String[] args) {
		// 
		
		boolean power = false; // ����
		
		int sel = 0; // �޴� ���� 
		int item1p=1200, item2p=1500, item3p=2000,item4p=5000, coin=0; // �� ����
		int item1n=12, item2n=13, item3n=15, item4n=12; //��� ����

		//�׸��
		String item1="Coke";
		String item2="Juice";
		String item3="Energy drink";
		String item4="Jin tonic";
		
		System.out.println("Hi I'm vending machine :) ================ | ���� ��������");
		System.out.println("========================================== | ǰ��� �Դϴ�");
		System.out.println("1. "+item1 + " : "  + item1p + " won ============ X " + item1n + " ===== | ����� ���Ͻø�");
		System.out.println("2. "+item2 + " : " + item2p + " won =========== X " + item2n + " ===== | ������ ����");
		System.out.println("3. "+item3 + " : " + item3p + " won ==== X " + item3n + " ===== | (�Է�)���ּ���");
		System.out.println("4. "+item4 + " : " + item4p + " won ======= X " + item4n + " ===================");		
		System.out.println("========================================================");
		System.out.print("�Է� = \r");
		
		
		Scanner sc = new Scanner(System.in);
		
		while(!power) {
			
			coin += sc.nextInt();
			
			if(item1n+item2n+item3n+item4n == 0){
				System.out.println("\r���Ե� �ݾ� + coin + �� ��ȯ �˴ϴ�.");
				coin-=coin;
				System.out.println("���� ��⿡ ���� �Ǿ��ִ� �ݾ���" + coin +"�Դϴ�.");
				System.out.println("��� �������� ��� ������ ����˴ϴ�.");
				power = true;
			}else{
				System.out.println("���� �� �ݾ��� ���� " + coin + " won �Դϴ�, �޴��� �������ּ���.\r");			
				System.out.println("�� "+ item1 + " �� " + item2 + " �� " + item3 + " �� "+ item4 + " �� �ܵ� ��ȯ");		
				
			}
			
			
			sel = sc.nextInt();
			
			switch(sel) {
						
				case 1:
								
					if (coin<item1p) {
						System.out.println("=================== �ܾ��� �����մϴ� ===================");
						System.out.println("=========== ������ �ݾ�" +coin+ "�� ��ȯ �˴ϴ�.===========");
						
						coin-=coin;
						
									
					}else if(item1n == 0) {
						System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
						System.out.println("���� �� �ݾ��� ���� " + coin + "�Դϴ�.");
						
					}else{
					item1n -= 1; coin-=item1p;
						System.out.println("�����Ͻ� ����"+item1+"�� �� �����˴ϴ�. ===== - ��� "+item1n);
						System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
					}
				
					break;
					
		
				case 2:
					
					if (coin<item2p) {
						System.out.println("=================== �ܾ��� �����մϴ� ===================");
						System.out.println("=========== ������ �ݾ�" +coin+ "�� ��ȯ �˴ϴ�.===========");
									
					}else if(item2n <= 0) {
						System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
						
					}else{
					item2n -= 1; coin-=item2p;
						System.out.println("�����Ͻ� ����"+item2+"�� �� �����˴ϴ�. ===== - ��� "+item2n);
						System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
					}
					
					break;
			case 3:
				if (coin<item3p) {
					System.out.println("=================== �ܾ��� �����մϴ� ===================");
					System.out.println("=========== ������ �ݾ�" +coin+ "�� ��ȯ �˴ϴ�.===========");
									
					}else if(item3n <= 0) {
						System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
						
					}else{
					item3n -= 1; coin-=item3p;
						System.out.println("�����Ͻ� ����"+item3+"�� �� �����˴ϴ�. ===== - ��� "+item3n);
						System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
					}
				break;
			case 4:
				if (coin<item4p) {
					System.out.println("=================== �ܾ��� �����մϴ� ===================");
					System.out.println("=========== ������ �ݾ�" +coin+ "�� ��ȯ �˴ϴ�.===========");
									
					}else if(item4n <= 0) {
						System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
						
					}else{
					item4n -= 1; coin-=item4p;
						System.out.println("�����Ͻ� ����"+item4+"�� �� �����˴ϴ�. ===== - ��� "+item4n);
						System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
					}
				
					break;
			case 5:
					System.out.println("�ݾ� " + coin + " won �� ��ȯ �˴ϴ�.");
					System.out.println("=================================");
				coin-=coin;
					System.out.println("���� �ݾ��� "+ coin + " won �Դϴ�." );
					System.out.println();
					// �Ž����� ��ȯ
				break;
				
			case 77:// �����ڸ��
				// ���� �����ϴ� ��ɵ�
				
			case 99:
				power = true;
				System.out.println("��� ������ ����˴ϴ�.");
					
				
					 
					 
				break;
			
			default:		
			
				System.out.println("�߸� �����̽��ϴ�.");
				
			}	
			
				if (!power) {
				
					System.out.println("�߰��� �̿��� ���Ͻø� ������ ���� ���ּ���. 0 = ������ ���� �ʴ´�." );
					System.out.print("�Է� = " );		
				
			}
			
		}
		System.out.println("���Ǳ� ����");
		
		
	}//main ed


}//class ed
