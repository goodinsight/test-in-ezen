package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report11 {
	
	public static void main(String[] args) {
//		1 ���� ���Ǳ� ����
//		2 ���� 3���� / ���� ���� / ��� ����
//		3 ���۰� ���ÿ� ȭ�鿡 �޴� ǥ��
//		3-1	������ ���� �� ����, ���, �Ž�����ȯ, ���Է� ��
//			99.���Ǳ� ����
//		4. 99 �̿��� ������ ��� ȭ�� �޴� ǥ��
		
		
//		�����ڸ�� ����, ���� ���� ��ǰ ����
		
		
		boolean power=false; // ����
		int mInput=-1;
		int dInput=-1;
		
		int money=0;
		int cha=0;
		
		int rem1=5;
		int rem2=5;
		int rem3=5;
		
		int cost1=1200;
		int cost2=1000;
		int cost3=800;
		
		String menu1 ="�ݶ�";
		String menu2 ="Ŀ��";
		String menu3 ="����";
		
		Scanner scan=new Scanner(System.in);
		
		while(!power) {
			System.out.println();
			System.out.println("[ ���� ���Ǳ� ]");
			System.out.printf("%s / %4d�� / ��� : %d%n", menu1, cost1, rem1);
			System.out.printf("%s / %4d�� / ��� : %d%n", menu2, cost2, rem2);
			System.out.printf("%s / %4d�� / ��� : %d%n", menu3, cost3, rem3);
			System.out.printf("���� �� : %d��%n", money);
			System.out.printf("(1)�� ���� (2)���� ���� (3)�Ž��� ��ȯ (99)���Ǳ� ����%n");
			System.out.print("����� �Է����ּ��� : ");
			mInput=scan.nextInt();
			
			input1:
			switch (mInput) {
			case 1:
				int tmp=0;
				while(!power) {
					System.out.print("�󸶳� �ְڽ��ϱ�? : ");
					tmp=scan.nextInt();
					if(tmp<0) {
						System.out.println("�ùٸ� �ݾ��� �Է����ּ���.");
					}
					else {
						money+=tmp;
						break;
					}
				}	// end of while(!power) in case 1
				break;
			
			case 2:
				while(!power){
					System.out.println();
					System.out.printf("(1)%s / %4d�� / %d%n(2)%s / %4d�� / %d%n(3)%s / %4d�� / %d%n", menu1, cost1, rem1, menu2, cost2, rem2, menu3, cost3, rem3);
					System.out.printf("���� �� : %d%n", money);
					System.out.printf("���Ḧ �������ּ��� (99=ó������) : ");
					dInput=scan.nextInt();
					switch (dInput) {
					case 1:
						if(money<cost1) {
							System.out.printf("%n***���� �����մϴ�.***%n");
							break input1;
						}
						else if(rem1<=0) {
							System.out.printf("%n***%s ��� �����ϴ�.***%n", menu1);
							break;
						}
						else {
							System.out.printf("%s�� 1�� �����߽��ϴ�.%n", menu1);
							money-=cost1;
							rem1--;
						}
						break;
					case 2:
						if(money<cost2) {
							System.out.printf("%n***���� �����մϴ�.***%n");
							break input1;
						}
						else if(rem2<=0) {
							System.out.printf("%n***%s ��� �����ϴ�.***%n", menu2);
							break;
						}
						else {
							System.out.printf("%s�� 1�� �����߽��ϴ�.%n", menu2);
							money-=cost2;
							rem2--;
						}
						break;
					case 3:
						if(money<cost3) {
							System.out.printf("%n***���� �����մϴ�.***%n");
							break input1;
						}
						else if(rem3<=0) {
							System.out.printf("%n***%s ��� �����ϴ�.***%n", menu3);
							break;
						}
						else {
							System.out.printf("%s�� 1�� �����߽��ϴ�.%n", menu3);
							money-=cost3;
							rem3--;
						}
						break;
					case 99:
						break input1;
	
					default:
						System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
						continue;
					}	// end of switch(dInput)
					
				}	// end of while(!power) in case 2
			
			case 3:	
				cha=money;
				money=0;
				System.out.printf("�Ž��� %d���� ��ȯ�մϴ�.%n", cha);
				break;
			
			case 99:
				power=true;
				break;

			default:
				System.out.printf("%n�ùٸ� ���ڸ� �Է����ּ���.%n");
				break;
			}	// end of switch(mInput)
			
		}	// end of while(!power)
		
		scan.close();
		System.out.println("���Ǳ� ����");
		
		
	}	// end of main

}	// end of class
