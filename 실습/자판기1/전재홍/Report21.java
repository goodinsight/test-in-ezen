package kr.co.dong;

import java.util.Scanner;

public class Report21 {

	public static void main(String[] args) {
		// 
		
		boolean power = false; // ����
		
		int sel = 0; // �޴� ���� 
		int item1p=1200, item2p=1500, item3p=2000,item4p=5000, charge=0, coin=0;
		int item1n=99, item2n=99, item3n=99, intem4n=99;

		String item1="Coke";
		String item2="Juice";
		String item3="Energy drink";
		String item4="Jin tonic";
		
		System.out.println("Hi �� ���Ǳ��� :)=========== ���� �������� ǰ���� ");
		System.out.println("1"+item1 + " : "  + item1p + " won");
		System.out.println("2"+item2 + " : " + item2p + " won");
		System.out.println("3"+item3 + " : " + item3p + " won");
		System.out.println("4"+item4 + " : " + item4p + " won");		
		System.out.println("===================== �Դϴ�. ����� ���Ͻø� ������ ����(�Է�)���ּ���.");
		System.out.print("�Է� = ");
		
		Scanner sc = new Scanner(System.in);
		
		while(!power) {
			
			coin += sc.nextInt();
			System.out.println("���� �� �ݾ��� ���� " + coin + "�Դϴ�.");
			
//			System.out.println("�޴��� �������ּ���");
//			sel = sc.nextInt();
			
			switch(sel) {
			
			case 1:
				System.out.println(item1);
				
				break;
		
			case 2:
				System.out.println(item2);
				break;
			case 3:
				System.out.println(item3);
				break;
			case 4:
				System.out.println(item4);
				break;
			case 5:
				System.out.println("���� �ݾ���" + "��ȯ �˴ϴ�.");
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
			
			
		}
		System.out.println("���Ǳ� ����");
		

	}//main ed


}//class ed
