package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report09_11 {
	public static void main(String[] args) {
//		1. ���� ���Ǳ⸦ ��������
//		2. ���� 3���� / ���� ���� / ����
//		3. ���۰� ���ÿ� ȭ�鿡 �޴��� �����ش�.
//		3-1		������ ������ ����, ����, �Ž����� ��ȯ, �� �Է� ��
//				99. ���Ǳ� ����
//		4. 99�̿��� ������ ��� ȭ��޴� �����ֱ�
		
//		1. ���� ���� -> �ʿ��� ���� : ���� 1,2,3 ���� 1,2,3 �Ž�����
		boolean power = false;	//����
		String beverage1 = "��";
		String beverage2 = "Ŀ��";
		String beverage3 = "�̿�����";
//		String option1 = "����";
//		String option2 = "����";
		
		int price1 = 1000;
		int price2 = 2000;
		int price3 = 1500;
		
		int amount1 = 10;
		int amount2 = 10;
		int amount3 = 10;
		
		int choiceMenu = 0;
		int inputMoney = 0;
		int change = 0;
		
//		�޴��Է°�, ���� ��, �����̸� 1,2,3, ����1,2,3 , �Ž�����
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
//			1. �޴� �����ֱ�
			System.out.println();
			System.out.println("==================<<  MENU  >>===================");
			System.out.println("0. ����  1. "+beverage1+"("+price1+") 2. "+beverage2+"("+price2+")  3. "+beverage3+"("+price3+")");
			System.out.println("-------------------------------------------------");
			System.out.println("10. �Ž����� ��ȯ 11. ���Ȯ�� 99. ���Ǳ� ����	");
			System.out.println("=================================================");
			
//			2. �޴� ����
			System.out.print("�޴��� �����ϼ���. > ");
			choiceMenu = scan.nextInt();
//			System.out.println();

//			3. �� �Է�
//			if(choiceMenu==1 || choiceMenu==2 || choiceMenu==3) {
//				System.out.print("���� �־��ּ���. > ");
//				inputMoney = inputMoney + scan.nextInt();
//			}
			
//			4. �޴��� ���� �б�
			switch(choiceMenu) {
			
			case 0:
				System.out.print("�ݾ��� �־��ּ���. > ");
				inputMoney += scan.nextInt();
				System.out.println("> ���� ���Ǳ� ���� �ݾ��� "+ inputMoney +"���Դϴ�.");
				break;
				
			case 1:
				System.out.printf("> ���Ե� �ݾ��� %d�� �Դϴ�. %n", inputMoney);
				System.out.println("> �����Ͻ� ������ ������ " + price1 + "�� �Դϴ�.");
				
				if(inputMoney<price1) {
					System.out.print("���� �����մϴ�. ���� �� �־��ּ���. --> 0. ����");
					System.out.println();
					
				} else if(inputMoney>price1) {
					System.out.println("> �����Ͻ� ���ᰡ ���ɴϴ�.");
//					System.out.println("�ܵ��� ��ȯ�ϼ���. --> 10. �Ž����� ��ȯ");
					inputMoney -= price1;
					amount1--;
				}
			
				break;
			
			case 2:
				System.out.printf("> ���Ե� �ݾ��� %d�� �Դϴ�. %n", inputMoney);
				System.out.println("> �����Ͻ� ������ ������ " + price2 + "�� �Դϴ�.");

				if(inputMoney<price2) {
					System.out.print("���� �����մϴ�. ���� �� �־��ּ���. --> 0. ����");
					System.out.println();
					
				} else if(inputMoney>price2 && amount2 != 0) {
					System.out.println("> �����Ͻ� ���ᰡ ���ɴϴ�.");
					inputMoney -= price2;
					amount2--;
				}
			
				break;
			
			case 3:
				System.out.printf("> ���Ե� �ݾ��� %d�� �Դϴ�. %n", inputMoney);
				System.out.println("> �����Ͻ� ������ ������ " + price3 + "�� �Դϴ�.");

				if(inputMoney<price3) {
				System.out.print("���� �����մϴ�. ���� �� �־��ּ���. --> 0. ����");
				System.out.println();
				
				}else if(inputMoney>price3 && amount3 != 0) {
				System.out.println("> �����Ͻ� ���ᰡ ���ɴϴ�.");
				inputMoney -= price3;
				amount3--;
				}
				
				break;
				
			case 10:
				System.out.println("> �ܵ��� ��ȯ�˴ϴ�.");
				change = inputMoney;
				System.out.println(change);
				inputMoney=0;
				
				break;
			case 11:
				System.out.printf("> ���� 1.���� �������� %d�� �Դϴ�. %n", amount1);
				System.out.println();
				System.out.printf("> ���� 2.Ŀ���� �������� %d�� �Դϴ�. %n", amount2);
				System.out.println();
				System.out.printf("> ���� 3.�̿������� �������� %d�� �Դϴ�. %n", amount3);
				System.out.println();
				break;
			case 99:
				power = true;
				System.out.println("���Ǳ⸦ �����մϴ�.");
				
				break;
				
			default:
				System.out.println("�޴��� �ٽ� �����ϼ���.");
				
			}
			
		}
		System.out.println("POWER OFF");
	}
}
