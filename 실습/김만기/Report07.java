package kr.co.man;

import java.util.Scanner;

public class Report07 {
	
	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� ���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1 ������ ������ ����, ����, �Ž����� ��ȯ, �� �Է� ��
//			99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��Ŵ� �����ֱ�
		
		boolean power = false;  										// �� ��
		
//		�Ŵ��Է°�, ���� ��, ���� �̸�1, 2, 3 / ����1, 2, 3 / �Ž�����
		
		Scanner scan = new Scanner(System.in);
		
		String a = "COLA";												// �޴� ������ ���� ���ڿ� ����
		String b = "CIDA";												
		String c = "COFFEE";											
		String insert = "";												// �޴� �Է��� ���� ����
		final int cola = 500;											// ������ ����� 
		final int cida = 1000;
		final int coffee = 1500;
		
		
		System.out.println("\t���Ǳ�");
		while(!power) {
			int input = scan.nextInt();									// �� �ֱ�
			if(input >= coffee) {										// ���Ḧ �̱� ���� �ݾ�
				
				
				while(input > 0) {										//�ܾ��� ��� �����ϰų� �Ž����� ��ȯ�� ���ý� ���� ����
					System.out.println("     ���� ���� ����");
					System.out.println(a + "\t" + b + "\t" + c);
					System.out.println("�����\t" + "�����\t" + " ����� ");
					System.out.println("�ܾ� : " + input);
					
					insert = scan.next();								//���� ����
					insert = insert.toUpperCase();						//�ҹ��ڷ� �Է����� �� ������ �빮�ڷ� ��ȯ								
				
					if(a.equals(insert) || insert.equals("�ݶ�")) {		// �޴� �Է�
						System.out.println("�ֹ��Ͻ� " + a + "�Դϴ�.");
						input -= cola;									// �޴� ������ �ܾ� ���
						System.out.println("�ܾ� : " + input);
						System.out.println();
					
					}
					else if(b.equals(insert) || insert.equals("���̴�")) {
						System.out.println("�ֹ��Ͻ� " + b + "�Դϴ�.");
						input -= cida;
						System.out.println("�ܾ� : " + input);
						System.out.println();
						
					}
					else if(c.equals(insert) || insert.equals("Ŀ��")) {
						System.out.println("�ֹ��Ͻ� " + c + "�Դϴ�.");
						input -= coffee;
						System.out.println("�ܾ� : " + input);
						System.out.println();
						
					}
					else if(insert.equals("��")) {						// "��" �Է½� �Ž����� ��ȯ
						System.out.println("�Ž����� " + input + "�Դϴ�");
						input = 0;
						System.out.println("�ܾ� : " + input);
						System.out.println();
						
					}
					else if(insert.indexOf('0') > 0) {
						input += Integer.parseInt(insert);
					}
					else if(input == 0) {								// �ܾ� ��� ������ ���� ����
						break;
					}
					else {
						System.out.println("�ٽ� �Է����ּ���");
					}
				}
				
				
			}
			else if(input >= cida) {
	
				
				while(true) {
					System.out.println("     ���� ���� ����");
					System.out.println(a + "\t" + b + "\t" + c);
					System.out.println("�����\t" + "�����\t" + " ����� ");
					System.out.println("�ܾ� : " + input);
					
					insert = scan.next();
					insert = insert.toUpperCase();
				
					if(a.equals(insert) || insert.equals("�ݶ�")) {
						System.out.println("�ֹ��Ͻ� " + a + "�Դϴ�.");
						input -= cola;
						System.out.println("�ܾ� : " + input);
						System.out.println();
					}
					else if(b.equals(insert) || insert.equals("���̴�")) {
						System.out.println("�ֹ��Ͻ� " + b + "�Դϴ�.");
						input -= cida;
						System.out.println("�ܾ� : " + input);
						System.out.println();
					}
					else if(insert.equals("��")) {
						System.out.println("�Ž����� " + input + "�Դϴ�");
						input = 0;
						System.out.println("�ܾ� : " + input);
						System.out.println();
						break;
					}
					else if(input == 0) {
						break;
					}
					else {
						System.out.println("�ٽ� �Է����ּ���");
					}
				}
			}
			else if(input >= cola) {
	
				
				while(true) {
					System.out.println("     ���� ���� ����");
					System.out.println(a + "\t" + b + "\t" + c);
					System.out.println("�����\t" + "�����\t" + " ����� ");
					System.out.println("�ܾ� : " + input);
					
					insert = scan.next();
					insert = insert.toUpperCase();
					if(a.equals(insert) || insert.equals("�ݶ�")) {
						System.out.println("�ֹ��Ͻ� " + a + "�Դϴ�.");
						input -= cola;
						System.out.println("�ܾ� : " + input);
						System.out.println();
					}
					else if(insert.equals("��")) {
						System.out.println("�Ž����� " + input + "�Դϴ�");
						input = 0;
						System.out.println("�ܾ� : " + input);
						System.out.println();
						break;
					}
					else if(input == 0) {
						break;
					}
					else {
						System.out.println("�ٽ� �Է����ּ���");
					}
				}
				
			}
			else {
				System.out.println("�ݾ��� �����մϴ�.");
				System.out.println("�ܾ� : " + input);
			}
//			power = true;			
		}
		System.out.println("���Ǳ� ����!!");
	}

}
