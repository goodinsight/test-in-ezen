package kr.co.dong;

import java.util.Scanner;

public class Report21_1{
	
	public static void main(String[] args) {
		
		boolean power = false; // ����
				
		int item1p=1200, item2p=1500, item3p=2000, charge=0; 
		int item1n=99, item2n=99, item3n=99;

		String item1="Coke";
		String item2="Juice";
		String item3="Energy drink";
		
		
		System.out.println("Hi �� ���Ǳ��� ���� �������� ǰ���� ");
		
		System.out.println(item1 + " : "  + item1p + " won");
		System.out.println(item2 + " : " + item2p + " won");
		System.out.println(item3 + " : " + item3p + " won");
		
		System.out.println("�Դϴ�. ����� ���Ͻø� ������ �������ּ���.");
		
		
		Scanner sc = new Scanner(System.in);
		
		
		while(!power) { // 1200 1500 2000
	
			int coin = sc.nextInt();
			System.out.println("���� �� �ݾ��� ���� " + coin + "�Դϴ�.");
			
			
			
			if (coin >= 1200) {
				System.out.print("���� ���� �� ����� " + item1 + "�Դϴ�.\r");
				System.out.println("0 = �̴´�. 1 = ���� �ʴ´�. 2 = ������ �� �ִ´�.");
				
				Scanner sel = new Scanner(System.in);
				int ch = sel.nextInt();
					
					if(0 == ch) {
						
						item1n -= 1;
						charge = coin - item1p;
						coin -= 1200;
						System.out.println(item1 + "��/�� �����˴ϴ�." );
						System.out.println("���� �ݾ��� "+ charge + "�Դϴ�.");
						System.out.println(item1 + "�� ���� ���� " + item1n + " �� �Դϴ�.");
						
							if(0 >= coin) {
								System.out.println("�߸��� �Է��Դϴ�. �ùٸ� ������ �������ּ���.");
							
											
							}
					
					}else if(1 == ch) {
												
						System.out.println("�ݾ��� ��ȯ�˴ϴ�.");
						charge = coin - coin; 
						System.out.println("���� �ݾ��� "+ charge + "�Դϴ�.");
			
			}else if (coin >=1500) {
				System.out.println(item2);
			}else if (coin >=2000) {
				System.out.println(item3);
			}
	
			}

		}
	
		System.out.println("���Ǳ� ����");
		
		
	}//main ed

}//class ed
