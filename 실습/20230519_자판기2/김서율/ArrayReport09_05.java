package kr.co.dong.ArrayCheckPoint;

import java.util.Scanner;

import javax.naming.CompoundName;

public class ArrayReport09_05 {
	public static void main(String[] args) {
//		�迭�� : dName, dPrice, dAmount 
//		������ ���� : 3����
		
//		1. ����
		
		String[] dName = {"ȫ��", "����", "����"};
		int[] dPrice = {1500, 1000, 2000};
		int[] dAmount = {10, 20, 5};
	
		Scanner scan = null;
		
//		2. ����
		
		scan = new Scanner(System.in);
//		scan�� ���� ����
		int choiceMenu = 0;		//�޴����� ����
		int inputMoney = 0;		//�� �Է�
		int Amount = 0;			//��� ����
		
		boolean power = false;		//���� ���� ����
		int change = 0;				//�ܵ� ����
		
//		2-1 �� ����

//		3. �Է�
		
		while(!power) {				//power�� true
			// �޴� ����
			System.out.println();
			System.out.println("==============< MENU >==============");
			System.out.println("0.���� 10.�Ž����� ��ȯ 11.��� 99.����");	//�����ڸ�� : 77
			System.out.println("------------------------------------");
			for(int i=0; i<dName.length; i++) {
				System.out.print((i+1) + "." + dName[i] + "(" + dPrice[i] + ") ");
			}
			System.out.println();
			System.out.println("====================================");
			System.out.print("�޴��� �����ϼ��� > ");
			choiceMenu = scan.nextInt();
		
//		4. �޴��� ���� �б�		//�迭-for���� �̿��Ͽ� ����ȭ
			switch (choiceMenu) {
			case 0:
				System.out.print("���� �־��ּ���. > ");
				inputMoney = inputMoney + scan.nextInt();
				System.out.println();
				System.out.println("���� ���Ǳ� ���� �ݾ��� " + inputMoney + "�� �Դϴ�.");
				
				break;
			case 1:	//���࿡ ȫ���� �����ߴٸ� ���Աݾ��� 1500������ ��ξ��ϰ�, 1500������ ������ -> ���� �����մϴ�. ��� ������ -> ��� �����մϴ�. 
//				(���� dAmount--;)
				if(inputMoney<dPrice[0]) {
					System.out.println("�ݾ��� �����մϴ�. > 0.����");
					
				} else if(inputMoney>dPrice[0] && dAmount[0]!=0) {		//dAmount[0]>0
					System.out.println("�����Ͻ� ���ᰡ ���ɴϴ�.");
					dAmount[0]--;
					inputMoney = inputMoney-dPrice[0];
					System.out.println("���� ���Ǳ� ���� �ݾ��� " + inputMoney + "�� �Դϴ�.");
					
//				} else if(dAmount[0]==0) {
				} else {
					System.out.println("��� �����մϴ�.");
				}
				
				
				break;
			case 2:
				if(inputMoney<dPrice[1]) {
					System.out.println("�ݾ��� �����մϴ�. > 0.����");
					
				} else if(inputMoney>dPrice[1] && dAmount[1]!=0) {		//dAmount[1]>0
					System.out.println("�����Ͻ� ���ᰡ ���ɴϴ�.");
					dAmount[1]--;
					inputMoney = inputMoney-dPrice[1];
					System.out.println("���� ���Ǳ� ���� �ݾ��� " + inputMoney + "�� �Դϴ�.");
					
				} else {
					System.out.println("��� �����մϴ�.");
				}
				
				break;
				
			case 3:
				if(inputMoney<dPrice[2]) {
					System.out.println("�ݾ��� �����մϴ�. > 0.����");
					
				} else if(inputMoney>dPrice[2] && dAmount[2]!=0) {		//dAmount[0]>0
					System.out.println("�����Ͻ� ���ᰡ ���ɴϴ�.");
					dAmount[2]--;
					inputMoney = inputMoney-dPrice[2];
					System.out.println("���� ���Ǳ� ���� �ݾ��� " + inputMoney + "�� �Դϴ�.");
					
				} else {
					System.out.println("��� �����մϴ�.");
				}
				break;
				
			case 10:	//���࿡ ���Ǳ� ���� �ݾ��� ���� ���ñݾ׺��� �� ũ�ٸ� -> �ܵ� ��ȯ
				System.out.println("�ܵ��� ��ȯ�˴ϴ�.");
				change = inputMoney;
				System.out.println("��ȯ�� �ݾ��� " + change + "�� �Դϴ�.");
				inputMoney = 0;
				
				break;
				
			case 11:	//���
				for(int i=0; i<dAmount.length; i++) {
					System.out.println(dName[i] + "�� �������� " + dAmount[i] + "�Դϴ�.");
				}
				
				break;
				
			case 77:	//�����ڸ��
				boolean admin = false;
				int choiceSetup = 0;
				String setUp1 = "���ắ��", setUp2 = "���ݺ���", setUp3 = "����������";
				
				String pw = "���";
//				System.out.print("��й�ȣ�� �Է��ϼ���. > ");
				pw = scan.next();
				
				if(pw.equals("���")) {
					while(!admin) {
						System.out.println();
						System.out.println("�����ڸ��� ��ȯ�մϴ�.");
						System.out.println("--------------------------------------------");
						System.out.println("1."+setUp1+" 2."+setUp2+" 3."+setUp3+" 4.����");		//���� �� �ٽ� �ʱ� �޴���
						System.out.println("--------------------------------------------");
						System.out.println("��ȣ�� �����ϼ���. > ");
						choiceSetup = scan.nextInt();
						
						switch (choiceSetup) {
						case 1:
							for(int i=0; i<dName.length; i++) {
								System.out.println("���� " + (i+1) + "�� ������ �̸��� " + dName[i] + "�Դϴ�.");
								System.out.print((i+1) + "�� ���Ḧ �����ϼ���. > ");
								dName[i] = scan.next();
								System.out.println("����� " + (i+1) + "�� ����� " + dName[i] + "�Դϴ�.");
								System.out.println();
							}
							break;
							
						case 2:
							for(int i=0; i<dPrice.length; i++) {
								System.out.println("���� " + (i+1) + "�� ������ ������ " + dPrice[i] + "�Դϴ�.");
								System.out.print("������ " + (i+1) + "�� ������ ������ �����ϼ���. > ");
								dPrice[i] = scan.nextInt();
								System.out.println("����� " + (i+1) + "�� ������ ������ " + dPrice[i] + "�Դϴ�.");
								System.out.println();
							}
							break;
							
						case 3:
							for(int i=0; i<dAmount.length; i++) {
								System.out.println("���� " + (i+1) + "�� ������ �������� " + dAmount[i] + "�Դϴ�.");
								System.out.print((i+1)+"�� ������ ��� �����ϼ���. > ");
								dAmount[i] = scan.nextInt();
								System.out.println((i+1)+"�� ������ ���� " + dAmount[i] + "�Դϴ�.");
								
							}
					
							break;
						case 4:
							admin = true;
							System.out.println("�����ڸ�带 �����մϴ�.");
							break;

						default:
							System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
							break;
						}
					}
					System.out.println("�����ڸ�� ����.");
//				} else {
//					System.out.println("��й�ȣ�� �ٽ� �Է��ϼ���.");
				}
				
				break;
				
			case 99:	//PowerOff
				power = true;
				System.out.println("���Ǳ⸦ �����մϴ�.");
				break;
				

			default:
				System.out.println("�޴��� �ٽ� ������ �ּ���.");
				break;
			}
		}
			System.out.println("���Ǳ⸦ �����մϴ�.");
	}
}
