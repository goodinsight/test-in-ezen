/*
 *  �ۼ��� : ������				
 *  ��¥ : 2023.05.15
 */

package kr.co.dong;

import java.util.Scanner;

public class Report15 {

	public static void main(String[] args) {
		
//		1. ���� ���Ǳ� ����
//		2. ���� 3���� ���� / ���� ����/ ��� ��
//		3. ���۰� ���ÿ� ȭ�鿡 �޴� ���
//		3-1. ������ ������ ����, ��� ��, �ܾ�, �� �Է� ��
//				99�Է½� ���Ǳ� ����.
//		4. 99 �̿��� ������ ��� ȭ��޴� �����ֱ�
		
		boolean power = false; //����
//		�޴� �Է°�, ���� ��, �����̸�1, 2, 3/����1, 2, 3, �Ž��� ��
		Scanner scan = new Scanner(System.in);
		
		int input;
		int balance = 0;
		int mode = 0; 
//			0 : �ʱ� ȭ��, 1 : ���� �ݾ� �Է�, 2: ����ó��(���н�, ���� ���� ���. �ݾ� ����, ��� ����)
//			3 : �ܾ� ��ȯ, 4: ����
		
		
		String drink1name = "Ŀ��";
		int drink1price = 1200, drink1stock = 3;
		
		String drink2name = "����";
		int drink2price = 2900, drink2stock = 5;
		
		String drink3name = "�����";
		int drink3price = 2500, drink3stock = 7;
		
		int targetDrink = 0, targetPrice = 0, targetStock = 0;
		String targetName = "";
		
		while(!power) {
			
			switch(mode) 
			{
				case 0://�ʱ� ȭ��
					System.out.println("\n\n--���Ǳ�-----------------------");//���� ȭ�� ��¹�
					System.out.printf("��ȣ\t�̸�\t����\t���\n");
					System.out.printf("1\t%s\t%d\t%d\n", drink1name, drink1price, drink1stock);
					System.out.printf("2\t%s\t%d\t%d\n", drink2name, drink2price, drink2stock);
					System.out.printf("3\t%s\t%d\t%d\n", drink3name, drink3price, drink3stock);
					System.out.println("�ܾ� : "+ balance);
					System.out.println("-----------------------------");
					
					System.out.println("�Է� �ȳ�"
							+ "\n 0\t: �ݾ� ���� "
							+ "\n 1~3\t: �ش� ���� ����"
							+ "\n 4\t: �ܾ� ȸ�� "
							+ "\n 99\t: ����\n");//���� ��ɾ� ����
					
					System.out.print("�����Ͻð� ���� �ൿ�� �Է����ּ���.\n>>");
					input = scan.nextInt();
					
					switch(input) 
					{
						case 0:
							mode = 1;
							break;
						case 1: case 2: case 3:
							targetDrink = input;
							mode = 2;
							break;
						case 4:
							mode = 3;
							break;
						case 99:
							mode = 4;
							break;
						default :
							System.out.println("�߸��� �Է��Դϴ�.");
					}
					
					break;
					
					
				case 1://�ݾ� ����
					System.out.print("���� �ݾ��� �Է����ּ���. \n>>");
					input = scan.nextInt();
					
					if(input >= 0)
					{
						balance += input;
					}
					else
					{
						System.out.println("�߸��� �Է��Դϴ�.");
					}
							
					mode = 0;
					break;
					
					
				case 2://���� ����
					//Ÿ�� ����
					switch(targetDrink) 
					{
						case 1:
							targetPrice = drink1price;
							targetStock = drink1stock;
							targetName = drink1name;
							break;
						case 2:
							targetPrice = drink2price;
							targetStock = drink2stock;
							targetName = drink2name;
							break;
						case 3:
							targetPrice = drink3price;
							targetStock = drink3stock;
							targetName = drink3name;
					}
					
					//���� �� ��� ����
					if(balance < targetPrice)
					{
						System.out.println("�ܾ��� �����մϴ�.");
						mode = 0;
						break;
					}
					else if(targetStock == 0)
					{
						System.out.println("��� �����մϴ�.");
						mode = 0;
						break;
					}
					else
					{
						balance -= targetPrice;
					}
					
					//��� ���� �� ���Թ� ���
					switch(targetDrink) 
					{
						case 1:
							drink1stock--;
							break;
						case 2:
							drink2stock--;
							break;
						case 3:
							drink3stock--;
					}
					System.out.printf("%s��(��) �����մϴ�.\n", targetName);
					System.out.printf("�ܾ� : %d -> %d\n", balance+targetPrice, balance);
					
					mode = 0;
					break;
					
					
				case 3://�ܾ� ȸ��
					System.out.printf("�ܾ� %d���� ȸ���մϴ�.", balance);//�ܾ� ��� �� ���� ����
					balance = 0;
					mode = 0;
					break;
				
					
				case 4://����
					System.out.println("�ŷ��� �����մϴ�.");
					power = true;
			}
			
		}
		
		
	}

}
