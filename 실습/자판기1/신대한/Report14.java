package kr.co.dong;

import java.util.Scanner;

public class Report14 {
	
	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ����/ ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ���� �� ����, ����, �Ž����� ��ȯ, ���Է� ��
//			99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�
		
		boolean power = false;	//����
//		�޴��Է°�, ���� ��, ����1,2,3 , �Ž�����
		Scanner sc = new Scanner(System.in);
		
		String choice = "";	// ���� ����
		
		String menu1 = "��������Ʈ";
		String menu2 = "��ī�ݶ�";
		String menu3 = "��������";
		
		int menu1pay = 2000;
		int menu2pay = 2500;
		int menu3pay = 1500;
		
		int payment = 0;	// ������
		int payment1 = 0;	// �߰�����
		
		int change = 0;		// �ܵ�
		
		String menuchoice = "";	// �Ŵ�����
		while(!power) {
			System.out.println("���Ḧ �����ϼ���.\n1. ��������Ʈ, 2. ��ī�ݶ�, 3. ��������");
			
			menuchoice = sc.next();
			
			if(menuchoice.equals("1")||menuchoice.equals("��������Ʈ")) {
				System.out.println(menu1+"�� �����ϼ̽��ϴ� ������ " + menu1pay+"�� �Դϴ�.");
				System.out.print("�����Ͻ� �ݾ��� �־��ּ���");
				payment = sc.nextInt();
				if(payment >= menu1pay) {
					change = payment - menu1pay;
					System.out.println("�������� "+payment+"�Ž������� "+change+" ���Դϴ�.");
				}else {
					while(true) {
						System.out.println("�ݾ��� �����մϴ�.\n"+(menu1pay - payment)+"�� �߰����� �Ͻðڽ��ϱ�??y/n");
						choice = sc.next();
						if(choice.equalsIgnoreCase("y")) {
							System.out.println("�߰������Ͻ� �ݾ��� �Է����ּ���.");
							payment1 = sc.nextInt();
							payment += payment1;
							System.out.println("�߰� �����Ͻ� �ݾ��� "+ payment1+"���̰� �����ݾ���" + payment+"���Դϴ�.");
							if(payment >= menu1pay) {
								change = payment - menu1pay;
								System.out.println("�������� "+payment+"�Ž������� "+change+" ���Դϴ�.");
								break;
							}
						}else if(choice.equalsIgnoreCase("n")){
							System.out.println("������ �����մϴ� �����Ͻ� �ݾ��� ȯ���ص帮�ڽ��ϴ�." + payment+"��");
							break;
						}else {
							System.out.println("y/n�߿����� �Է����ּ���.");
						}
						
					}
				}
			}else if(menuchoice.equals("2")||menuchoice.equals("��ī�ݶ�")) {
				System.out.println(menu2+"�� �����ϼ̽��ϴ� ������ " + menu2pay+"�� �Դϴ�.");
				System.out.print("�����Ͻ� �ݾ��� �־��ּ���");
				payment = sc.nextInt();
				if(payment >= menu2pay) {
					change = payment - menu2pay;
					System.out.println("�������� "+payment+"�Ž������� "+change+" ���Դϴ�.");
				}else {
					while(true) {
						System.out.println("�ݾ��� �����մϴ�.\n"+(menu2pay - payment)+"�� �߰����� �Ͻðڽ��ϱ�??y/n");
						choice = sc.next();
						if(choice.equalsIgnoreCase("y")) {
							System.out.println("�߰������Ͻ� �ݾ��� �Է����ּ���.");
							payment1 = sc.nextInt();
							payment += payment1;
							System.out.println("�߰� �����Ͻ� �ݾ��� "+ payment1+"���̰� �����ݾ���" + payment+"���Դϴ�.");
							if(payment >= menu2pay) {
								change = payment - menu2pay;
								System.out.println("�������� "+payment+"�Ž������� "+change+" ���Դϴ�.");
								break;
							}
						}else if(choice.equalsIgnoreCase("n")){
							System.out.println("������ �����մϴ� �����Ͻ� �ݾ��� ȯ���ص帮�ڽ��ϴ�." + payment+"��");
							break;
						}else {
							System.out.println("y/n�� �Է����ּ���.");
						}
						
					}
				}
			}else if(menuchoice.equals("3")||menuchoice.equals("��������")) {
				System.out.println(menu3+"�� �����ϼ̽��ϴ� ������ " + menu3pay+"�� �Դϴ�.");
				System.out.print("�����Ͻ� �ݾ��� �־��ּ���");
				payment = sc.nextInt();
				if(payment >= menu3pay) {
					change = payment - menu3pay;
					System.out.println("�������� "+payment+"�Ž������� "+change+" ���Դϴ�.");
				}else {
					while(true) {
						System.out.println("�ݾ��� �����մϴ�.\n"+(menu3pay - payment)+"�� �߰����� �Ͻðڽ��ϱ�??y/n");
						choice = sc.next();
						if(choice.equalsIgnoreCase("y")) {
							System.out.println("�߰������Ͻ� �ݾ��� �Է����ּ���.");
							payment1 = sc.nextInt();
							payment += payment1;
							System.out.println("�߰� �����Ͻ� �ݾ��� "+ payment1+"���̰� �����ݾ���" + payment+"���Դϴ�.");
							if(payment >= menu3pay) {
								change = payment - menu3pay;
								System.out.println("�������� "+payment+"�Ž������� "+change+" ���Դϴ�.");
								break;
							}
						}else if(choice.equalsIgnoreCase("n")){
							System.out.println("������ �����մϴ� �����Ͻ� �ݾ��� ȯ���ص帮�ڽ��ϴ�." + payment+"��");
							break;
						}else {
							System.out.println("y/n�� �Է����ּ���.");
						}
						
					}
				}
			}else if(!menuchoice.equals("99")){		// ����ó��
				System.out.println("�ٸ� �Ŵ��� �������Դϴ�.");
			}else {
				power = true;
			}
			
		}// ���Ǳ� ����
		
		System.out.println("���Ǳ� ����!!");
		sc.close();
	}
	
}
