package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report14 {

	public static void main(String[] args){
//		���Ǳ� �۵�����
		boolean power = false;
//		������ ��� �۵�����
		boolean admin = false;
		
		Scanner sc = new Scanner(System.in);
//		���Ǳ⿡ �ִ� �ݾ�
		int money = 0;
//		�����
		String[] dNameStrings = {"�����ս�","��Ű��","��ī������Ʈ","���̴�"};
//		����� ���纻
		String[] dNameStringsclone;
//		���� ���� ���纻
		int[] dPriceclone;
//		���� ����� ���纻
		int[] dAmountclone;
//		���� �ȸ����� ���纻
		int[] dCountclone;
//		���� ����
		int[] dPrice = {2000,1500,1000,500};
//		���� ���
		int[] dAmount = {10,10,10,10};
//		���Ǳ� ���� �ܾ�
		int charge = 100000;
//		���� ���ù�ȣ
		int dChoice = 0;
		int choice = 0;
//		������ �Ŵ� ����
		int adminchoice = 0;
//		������ �Ŵ� ��й�ȣ == admin01
		String adminPass = "";
//		���� ����
		int todayTotal = 0;
//		���� ������ �Ǹ� ����
		int[] dCount = {0,0,0,0};
//		�Ŵ� �߰�
		String newmenu = "";
//		���Ǳ� �ݾ� �߰�
		int chargeplus = 0;
		while (!power) {
			System.out.println("�Ŵ��� �������ּ���");
			System.out.println("0. ���Ǳ⿡ ���ֱ�\t 1.������� \t 2. �ܵ���ȯ  99.����");
				choice = sc.nextInt();
			switch (choice) {
			case 0:
				System.out.print("���Ǳ� �ȿ� ���� �־��ּ���. : ");
					money += sc.nextInt();
				System.out.println("\n���� ���Ǳ� �ȿ� ���� "+ money+"���Դϴ�.");
				break;
			
			case 1 :
				System.out.println("\n�����Ͻ� ���Ḧ �������ּ���.");
				for (int i = 0; i < dNameStrings.length; i++) {
					System.out.println(i+1+"�� "+dNameStrings[i]+"("+dPrice[i]+"��)��� : "+dAmount[i]+"��   ");
				}
				dChoice = sc.nextInt();
						if(dChoice > dNameStrings.length) {
							System.out.println("�ش� �Ŵ��� ���� ���¸Ŵ��Դϴ�.");
						}else if(dPrice[dChoice-1]<=money && dAmount[dChoice-1] != 0) {
							System.out.println("�ֹ��Ͻ� "+ dNameStrings[dChoice-1]+" ���Խ��ϴ�.");
							charge += dPrice[dChoice-1];
							money -= dPrice[dChoice-1];
							dAmount[dChoice-1]--;
							dCount[dChoice-1]++;
							System.out.println("�ܾ��� "+money+"�� �Դϴ�.");
						}else if(dAmount[dChoice-1] == 0) {
							System.out.println("�������ֽ� ����� ��� �����ϴ� ������ �̿����ּ���.");
						}else if(money<dPrice[dChoice-1]){
							System.out.println("�����ݾ��� �����մϴ� ���Ǳ⿡ ���� �� �־��ּ��� : "+(dPrice[dChoice-1] - money)+"��");
						}
			break;
			case 2 :
				if(charge == 0) {
					System.out.println("���Ǳ���� �ܾ��� �����ϴ� �����ڿ��� �������ּ���.");
				}else if(money != 0) {
					System.out.println("�̿����ּż� �����մϴ�. �ܵ��� "+money+"�� �Դϴ�.");
					charge -= money;
					money = 0;
				}else {
					System.out.println("�ܾ��� �����ϴ�. �̿����ּż� �����մϴ�.");
				}
				break;
			case 77 :
				adminPass = sc.next();
				if(adminPass.equals("admin01")) {
					System.out.println("========================================");
					System.out.println("�����ڸ��� �����մϴ�.");
					while (!admin) {
						System.out.println("1. ������  2. ��ǰ����  3. ���ϸ���  4. ���ݺ���  5. ���Ȯ��\n6. �Ŵ��߰�   7. ���Ǳ� �ݾ� ��ȸ   8. ���Ǳ� �ݾ� ����   9. ����");
						adminchoice = sc.nextInt();
						switch(adminchoice) {
							case 1:
								System.out.println("��� �����Ͻ� ��ǰ�� ��ȣ�� �Է����ּ���.");
								System.out.print("0. ���  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"(��� : "+ dAmount[i]+")  ");
								}
								adminchoice = sc.nextInt();
								if(adminchoice > dAmount.length) {
									System.out.println("�Ŵ����� ���ڴ� 1~"+dAmount.length+"���� �����ּ���.\n�����ڸ��� ���ư��ϴ�.");
									break;
								}else if(adminchoice == 0) {
									System.out.println("������ ����մϴ�.");
									break;
								}
								System.out.println("�����Ͻ� ������� �Է����ּ���.");
								dAmount[adminchoice-1] =  sc.nextInt();
								System.out.println("��� �����Ǿ����ϴ�.");
								break;
							case 2:
								System.out.println("�����Ͻ� ��ǰ�� ��ȣ�� �Է����ּ���.");
								System.out.print("0. ���  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"   ");
								}
								adminchoice = sc.nextInt();
								if(adminchoice > dNameStrings.length) {
									System.out.println("�Ŵ����� ���ڴ� 1~"+dNameStrings.length+"���� �����ּ���.\n�����ڸ��� ���ư��ϴ�.");
									break;
								}
								System.out.println("�����Ͻ� ��ǰ�� �̸��� �Է����ּ���.");
								sc.nextLine();
								if(adminchoice == 0) {
									System.out.println("������ ����մϴ�.");
									break;
								}
								dNameStrings[adminchoice-1] = sc.nextLine();
								System.out.println("��ǰ�� ����Ǿ����ϴ� ��� �ٽ� ä���ּ���. --> �Ŵ��� 1��");
								dAmount[adminchoice-1] = 0;
								break;
							case 3:
								for (int i = 0; i < dCount.length; i++) {
									todayTotal = dCount[i] * dPrice[i];
									System.out.print(dNameStrings[i]+"�ȸ����� : "+dCount[i]+"   ");
								}
								System.out.println("\n���� ������� "+todayTotal+"�� �Դϴ�.");
								
								todayTotal = 0;
								break;
							case 4:
								System.out.println("�����Ͻ� ��ǰ�� ��ȣ�� �Է����ּ���.");
								System.out.print("0. ���  ");
								for (int i = 0; i < dNameStrings.length; i++) {
									System.out.print(1+i+". "+dNameStrings[i]+"("+dPrice[i]+"��)   ");
								}
								adminchoice = sc.nextInt();
								if(adminchoice > dPrice.length) {
									System.out.println("�Ŵ����� ���ڴ� 1~"+dPrice.length+"���� �����ּ���.\n�����ڸ��� ���ư��ϴ�.");
									break;
								}else if(adminchoice == 0) {
									System.out.println("������ ����մϴ�.");
									break;
								}
								System.out.println("�����Ͻ� �ݾ��� �Է����ּ���. ");
								dPrice[adminchoice-1] = sc.nextInt();
								System.out.println("������ �Ϸ����ϴ�.");
								break;
							case 5:
								for (int i = 0; i < dAmount.length; i++) {
									System.out.print(i+1+"."+dNameStrings[i]+"(����� : "+dAmount[i]+"��)   ");
								}
								System.out.println("\n");
								break;
							case 6:
								
								System.out.println("�߰��Ͻ� �Ŵ��� �Է����ּ���.\n�Ŵ��߰��� ����ϰ� �����ø� 0���� �����ּ���.");
								sc.nextLine();
								newmenu = sc.nextLine();
								if(newmenu.equals("0")) {
									System.out.println("�����ڸŴ��� ���ư��ϴ�.");
									break;
								}
								dNameStringsclone = dNameStrings.clone();
								dPriceclone = dPrice.clone();
								dAmountclone = dAmount.clone();
								dCountclone = dCount.clone();
								dNameStrings = new String[dNameStrings.length+1];
								dAmount = new int[dAmount.length+1];
								dCount = new int[dCount.length+1];
								dPrice = new int[dPrice.length+1];
								for (int i = 0; i < dNameStringsclone.length; i++) {
									dNameStrings[i] = dNameStringsclone[i];
									dAmount[i] = dAmountclone[i];
									dPrice[i] = dPriceclone[i];
									dCount[i] = dCountclone[i];
								}
								dNameStrings[dNameStringsclone.length] = newmenu;
								System.out.println("�߰��Ͻ� �Ŵ��� ������ �������ּ���.");
								dPrice[dPriceclone.length] = sc.nextInt();
								System.out.println("�Ŵ��� �߰��Ǿ����ϴ� �ش�Ŵ��� ��� �߰����ּ���. -->1");
								break;
								
							case 7:
								System.out.println("���� ���Ǳ� �ȿ� �ܾ��� "+charge+"�� �Դϴ�.");
								break;
							case 8:
								System.out.print("�����Ͻ� �ݾ��� �Է����ּ��� : ");
								chargeplus = sc.nextInt();
								charge += chargeplus;
								System.out.println("������ �Ϸ����ϴ� ���� ���Ǳ�ȿ� �ܾ��� "+charge+"���Դϴ�.");
								break;
							case 9:
								admin = !admin;
								System.out.println("������ ��带 �����մϴ�.");
								System.out.println("==========================================================");
								break;
							default: 
								System.out.println("�ش� �Ŵ����� �������Դϴ�.");
						}	// ������ switch ����
					}		// ������ while ����
					admin = false;
				}
				break;
			case 99 :
				power = !power;
				break;
			default:
				System.out.println("�ٸ� �Ŵ��� �������Դϴ�.");
				break;
			}		//����� switch����
		}			//���Ǳ� ����
		 
		System.out.println("�۵��� �����մϴ�.");
		sc.close();
	}
}