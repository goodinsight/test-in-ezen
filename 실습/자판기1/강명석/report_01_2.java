/*
 * 1. ���� ���Ǳ⸦ ��������
 * 2. ���� 3���� ���� / ���� ���� / ����
 * 3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
 *  3_1 ������ ����, ����, ����, �Ž����� ��ȯ,�� ���Է� 
 *  3_2 99. ���Ǳ� ����
 * 4. 99�̿��� ������ ��� ȭ�� �޴� �����ֱ�  
 */
package kr.co.dong;

import java.util.Scanner;

public class report_01_2 {
	public static void main(String[] args) {
		
		boolean power = false;  // ����
//		�޴��Է°�, ���� ��, ���� �̸�1, 2, 3, ����1, 2, 3, �Ž�����
		int inMoney = 0;
		int plusMoney = 0;
		
		int outMoney = 0;
		int menu = 0;
		int remain = 0;
		int conButton = 0;
		
		int whanta = 0, coke = 0, cida =0;
		int value1 = 500, value2= 1000, value3= 1500;
		
		whanta = value1;
		coke = value2;
		cida = value3;
		
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
					
			System.out.printf("=====���ϴ� �޴��� �������ּ���=====\n");
			System.out.printf("1.whanta(%d��)\n2.coke(%d��) \n3.cida(%d��) \n", value1, value2, value3 );
			System.out.printf("=========���� �־� �ּ���========\n");
			inMoney = scan.nextInt();
			remain = inMoney;
			
			while (remain<value1) {
				remain = inMoney;
				System.out.printf("�ݾ��� �����մϴ�. �� �־� �ּ��� \n");
				inMoney = scan.nextInt();
				remain = remain + inMoney;
					if(remain >= 500)
						break;
			    }		
			
				System.out.printf("�� �ֽ� �ݾ��� %d �Դϴ�. \n", remain);
					
				if(remain>=value1)
				{
					System.out.printf("=====���ϴ� �޴��� �������ּ���=====\n");
					System.out.printf("1.whanta(%d��)\n2.coke(%d��) \n3.cida(%d��) \n", value1, value2, value3 );
				
					menu = scan.nextInt();					
					
					switch (menu) 
					{
					case 1:
						if(remain>=value1) {
							System.out.printf("whanta�� �����ϼ̽��ϴ�.\n \n");
							remain = remain - value1;	
							if(remain<=0)
								break;
						}
						else {
							break;
						}

					case 2:
						if(remain>=value2) {
							System.out.printf("coke�� �����ϼ̽��ϴ�.\n \n");
							remain = remain - value2;
							if(remain<=0)
								break;
						}
						else {
							break;
						}
				
					case 3:
						if(remain>=value3) {
							System.out.printf("cida�� �����ϼ̽��ϴ�.\n \n");
							remain = remain - value3;
							if(remain<=0)
								break;
						}
						else {
							break;
						};
			
					default :
						
						break;
					
					} //end of if(remain>=value1)	
					
					
					System.out.printf("�������ּż� �����մϴ�. ���ⱸ�� ������� �������ſ�. \n");				
					System.out.printf("���� ���� �ܾ��� %d���Դϴ�. \n \n", remain);
					
					System.out.printf("����� 99���� �����ð�, �߰� ������ ���� ���ڸ� �����ּ���.\n");
						
					conButton = scan.nextInt();
					if(conButton==99) {
						break;
					}
				}
				
				
			}
			
		System.out.printf("���Ḧ �����̽��ϴ�. �ܵ� %d�� ���ɴϴ�. �������ſ�.\n", remain);
		System.out.println("���Ǳ� ����");
		
	}
}
