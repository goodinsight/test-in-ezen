package kr.co.dong.checkPoint;

import java.util.Scanner;

import javax.naming.CompoundName;

public class Report09 {
	public static void main(String[] args) {
//		�迭�� : dName, dPrice, dAmount 
//		������ ���� : 3����
		
//		1. ����
		
		String[] dName = {"�Ƹ޸�ī��", "��", "��ũƼ"};
		int[] dPrice = {1500, 2000, 1000};
		int[] dAmount = {1, 10, 5};
	
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
			System.out.println("=============< MENU >=============");
			System.out.println(" 	 0.���� 1.���� ����");
			System.out.println("----------------------------------");
			System.out.println(" 10.�Ž����� ��ȯ  11.���  99.����");	//�����ڸ�� : 77
			System.out.println("==================================");
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
				
			case 1:
				boolean beverageMenu = false; 
				int choiceBeverage = 0;
				
					while(!beverageMenu) {
						System.out.println();
						System.out.println("=========================<BEVERAGE>=========================");
						System.out.println("0.���");
						System.out.println("1." + dName[0] + "(" + dPrice[0] + "��, " + dAmount[0] + "��) 2." + dName[1] + "(" + dPrice[1] + "��, " + dAmount[1] + "��) 3." + dName[2] + "(" + dPrice[2] + "��, " + dAmount[2] + "��)");
						
//						for(int i=0; i<dName.length; i++) {
//						System.out.println((i+1) + "." + dName[i] + "(" + dPrice[i] + ") " + "(���: " + dAmount[i] + ")");
//						}
						System.out.println("============================================================ ");
						System.out.println();
						System.out.println("���Ḧ �����ϼ���. > ");
						choiceBeverage = scan.nextInt();
						
						switch (choiceBeverage) {
							
						case 0 :
							beverageMenu = true;
							System.out.println("����ȭ������ ���ư��ϴ�.");
							break;
							
						case 1: case 2: case 3:
							if(dAmount[choiceBeverage-1] ==0) {
								System.out.println("��� �����մϴ�.");
								break;
							}
							
							else if(inputMoney<dPrice[choiceBeverage-1]) {
								System.out.println("�ݾ��� �����մϴ�. > 0.����");
								
							} else if(inputMoney>dPrice[choiceBeverage-1] && dAmount[choiceBeverage-1]!=0) {		//dAmount[0]>0
								System.out.println("�����Ͻ� ���ᰡ ���ɴϴ�.");
								dAmount[choiceBeverage-1]--;
								inputMoney = inputMoney-dPrice[choiceBeverage-1];
								System.out.println("���� ���Ǳ� ���� �ݾ��� " + inputMoney + "�� �Դϴ�.");
								beverageMenu = true;
								break;
							}
							
							break;
						
						default:
							System.out.println("��ȣ�� �ٽ� �����ϼ���.");
							break;
							
						}
					}
					
					break;
				
			case 10:	
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
				String setUp1 = "���� ����", setUp2 = "���� ����", setUp3 = "������ ����";
				
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
							int menuSetup = 0;
								
							System.out.println();
							System.out.println("< ���� ���� >------------------------------");
							System.out.println("0.��� 1." + dName[0] + " 2." + dName[1] + " 3." + dName[2]);
							System.out.println("-----------------------------------------");
							System.out.print("������ ���Ḧ �����ϼ���. > ");
							menuSetup = scan.nextInt();
							
							boolean Change1 = false;
							while(!Change1) {
								switch (menuSetup) {
								case 0:
									System.out.println("> ���� ȭ������ ���ư��ϴ�.");
									Change1 = true;
									
									break;
									
								case 1: case 2: case 3:
										System.out.print(menuSetup + ". " + dName[menuSetup-1] + "�� �����ϼ���. > ");
										dName[menuSetup-1] = scan.next();
										System.out.println();
										System.out.println("����� " +menuSetup + "�� ����� " + dName[menuSetup-1] + "�Դϴ�.");
										
										dAmount[menuSetup-1] = 0;
										System.out.print("����� ������ ��� �����ϼ���. > ");
										dAmount[menuSetup-1] = scan.nextInt();
										System.out.println("���� " + dName[menuSetup-1] + "�� �������� " + dAmount[menuSetup-1] + "�� �Դϴ�.");

										System.out.println();
										System.out.println("> ���� ȭ������ ���ư��ϴ�.");
										Change1 = true;
										
										break;
//								
								default:
									System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
									break;

								}
							}
							break;
							
						case 2:
							int priceSetup = 0;
							
							System.out.println();
							System.out.println("< ���� ���� ���� >-----------------------------------------------");
							System.out.println("0.��� 1." + dName[0] + "(" + dPrice[0] + "��) 2." + dName[1] + "(" + dPrice[1] + "��) 3." + dName[2] + "(" + dPrice[2] + "��)");
							System.out.println("--------------------------------------------------------------");
							System.out.print("������ ���� �� ���Ḧ �����ϼ���. > ");
							priceSetup = scan.nextInt();

							boolean change2 = false;
							while(!change2) {
								switch (priceSetup) {
								case 0:
									System.out.println("> ���� ȭ������ ���ư��ϴ�.");
									change2 = true;
									break;
							
								case 1: case 2: case 3:
									System.out.print(dName[priceSetup-1] + "(" + dPrice[priceSetup-1] + "��)�� ������ �����ϼ���. > ");
									dPrice[priceSetup-1] = scan.nextInt();
									System.out.println();
									System.out.println(dName[priceSetup-1] + "�� ����� ������ " + dPrice[priceSetup-1] + "�Դϴ�.");
									
									System.out.println("> ���� ȭ������ ���ư��ϴ�.");
									change2 = true;
									
									break;

								default:
									System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
									break;
								}
							}
							
							break;
							
						case 3:
							int amountSetup = 0;
							
							System.out.println();
							System.out.println("< ������ ���� >-----------------------------------------------");
							System.out.println("0.��� 1." + dName[0] + "(" + dAmount[0] + "��) 2." + dName[1] + "(" + dAmount[1] + "��) 3." + dName[2] + "(" + dAmount[2] + "��)");
							System.out.println("-------------------------------------------------------------");
							System.out.print("�������� ���� �� ���Ḧ �����ϼ���. > ");
							amountSetup = scan.nextInt();
							
							boolean change3 = false;
							while(!change3) {
								switch (amountSetup) {
								case 0:
									System.out.println("> ���� ȭ������ ���ư��ϴ�.");
									change3 = true;
									break;
									
								case 1: case 2: case 3:
									System.out.print(dName[amountSetup-1] + "(" + dAmount[amountSetup-1] + "��)�� ��� �����ϼ���. > ");
									dAmount[amountSetup-1] = scan.nextInt();
									System.out.println();
									System.out.println(dName[amountSetup-1] + "�� ����� �������� " + dAmount[amountSetup-1] + "�Դϴ�.");
									
									System.out.println("���� ȭ������ ���ư��ϴ�.");
									change3 = true;
									
									break;
									
								default:
									System.out.println("��ȣ�� �ٽ� �Է��ϼ���.");
									break;
								}
								
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
				break;
				

			default:
				System.out.println("�޴��� �ٽ� ������ �ּ���.");
				break;
			}
		}
			System.out.println("���Ǳ⸦ �����մϴ�.");
	}
}
