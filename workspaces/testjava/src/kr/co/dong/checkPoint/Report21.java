package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report21 {
	
	public static void main(String[] args) {
		
//	Report21_d item1 = new Report21_d(); // ���Ǳ� ������ ������ ��
//	Report21_d item2 = new Report21_d(); 
//	Report21_d item3 = new Report21_d(); 
//	Report21_d item4 = new Report21_d(); 
	
//	item1.dName ="Coke";
//	item1.dAmount = 15;
//	item1.dPrice = 1200;
//			
//	item2.dName ="Juice";
//	item2.dAmount = 20;
//	item2.dPrice = 1500;
//		
//	item3.dName = "Energy Drink";
//	item3.dAmount = 20;
//	item3.dPrice = 2000;
//		
//	item4.dName = "Jin Tonic"; // ������ ���� ���� 3���� �϶�� �ϼ����� ���� �տ� ���������� �ĺ��� �Ǵ°� ���Ƽ� �׸��� 4���� ����
//	item4.dAmount = 15;
//	item4.dPrice = 5000; // �̰� ¦���� ����ϱ� �迭�� ǥ���ؾ��Ѵٰ� �� �����ߴٰ� ġ�� ������
		
		
	String[] dName = { "Coke", "Juice", "Energy Drink", "Jin Tonic"};
	String[] dNum = { "��", "��", "��", "��"}; // �̰� ���� ����� �� ���Ǽ��� �������� ������ ǰ����
	int[] dAmount = { 15, 20, 20, 15};
	int[] dPrice = { 1200, 1500, 2000, 5000};
	int vCash = 100000; // ���� ������ ž�� �ϴ°͵� �����ص���
	int coin = 0; // ������ �ϴ� ����
	int sel = 0; // �޴� ����
	boolean power = false; // ���� ���Ǻ�
	
	System.out.println("Hi I'm vending machine :) ================ | ���� ��������");
	System.out.println("========================================== | ǰ��� �Դϴ�");
	System.out.println(dNum[0]+". "+dName[0] + " : "  + dPrice[0] + " won ============ X " + dAmount[0] + " ===== | ����� ���Ͻø�");
	System.out.println(dNum[1]+". "+dName[1] + " : " + dPrice[1] + " won =========== X " + dAmount[1] + " ===== | ������ ����");
	System.out.println(dNum[2]+". "+dName[2] + " : " + dPrice[2] + " won ==== X " + dAmount[2] + " ===== | (�Է�)���ּ���");
	System.out.println(dNum[3]+". "+dName[3] + " : " + dPrice[3] + " won ======= X " + dAmount[3] + " ===================");		
	System.out.println("========================================================");
	System.out.print("�Է� = \r");
	
	// _4 ���� ������Ʈ ���� - ������ ���ؼ� �Է��ϴ� ��Ŀ��� �迭���ٰ� ���� �ִ� ������� ���� ��
	
	// ���� �����ذ����� ��¦ �и� ������ �־ �ð��� �����ߴµ� Ctrl + 2 ,r �� ���� �� ���� ���� ��ü�� �� �� �־���
	
	Scanner sc = new Scanner(System.in);
	
	while(!power) {
		
		coin += sc.nextInt();
		
		if((dAmount[0]+dAmount[1]+dAmount[2]+dAmount[3])==0){
			System.out.println("======= ���Ե� �ݾ� " + coin + "won �� ��ȯ �˴ϴ�. =======");
			coin-=coin;
			System.out.println("���� ��⿡ ���� �Ǿ��ִ� �ݾ���" + coin +"�Դϴ�.");
			System.out.println("��� �������� ��� ������ ����˴ϴ�.");
			power = true;
		}else if(coin>=10){
			System.out.println("���� �� �ݾ��� ���� " + coin + " won �Դϴ�.\r");			
			System.out.println("�ش� ���� ������ �ݾ׿� �ش�Ǵ� ��ǰ�� ǥ�õ˴ϴ�.\r");			
			
				for(int i=0; i<dName.length; i++) {
					
					if(coin >= dPrice[i]){
						System.out.print(dNum[i] + " "+ dName[i]+" ");
						
					}
					
					
				
		}
		
		
//			System.out.println("�� "+ dName[0] + " �� " + dName[1] + " �� " + dName[2] + " �� "+ dName[3] + " �� �ܵ� ��ȯ ");
		
		}
		
		
		sel = sc.nextInt();
		
		switch(sel) {
					
			case 1:
							
				if (coin<dPrice[0]) {
					System.out.println("=================== �ܾ��� �����մϴ� ===================");
					System.out.println("============= ������ �ݾ�" +coin+ " won �� ��ȯ �˴ϴ�.=============");
					
					coin-=coin;
					
								
				}else if(dAmount[0] == 0) {
					System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
					System.out.println("���� �� �ݾ��� ���� " + coin + "�Դϴ�.");
					
				}else{
				dAmount[0] -= 1; coin-=dPrice[0];
					System.out.println("�����Ͻ� ����"+dName[0]+"�� �� �����˴ϴ�. ===== - ��� "+dAmount[0]);
					System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
				}
			
				break;
				
	
			case 2:
				
				if (coin<dPrice[1]) {
					System.out.println("=================== �ܾ��� �����մϴ� ===================");
					System.out.println("============= ������ �ݾ� " +coin+ " won �� ��ȯ �˴ϴ�.=============");
								
				}else if(dAmount[1] <= 0) {
					System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
					
				}else{
				dAmount[1] -= 1; coin-=dPrice[1];
					System.out.println("�����Ͻ� ����"+dName[1]+"�� �� �����˴ϴ�. ===== - ��� "+dAmount[1]);
					System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
				}
				
				break;
		case 3:
			if (coin<dPrice[2]) {
				System.out.println("=================== �ܾ��� �����մϴ� ===================");
				System.out.println("============= ������ �ݾ� " +coin+ " won �� ��ȯ �˴ϴ�.=============");
								
				}else if(dAmount[2] <= 0) {
					System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
					
				}else{
				dAmount[2] -= 1; coin-=dPrice[2];
					System.out.println("�����Ͻ� ����"+dName[2]+"�� �� �����˴ϴ�. ===== - ��� "+dAmount[2]);
					System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
				}
			break;
		case 4:
			if (coin<dPrice[3]) {
				System.out.println("=================== �ܾ��� �����մϴ� ===================");
				System.out.println("============= ������ �ݾ� " +coin+ " won �� ��ȯ �˴ϴ�.=============");
								
				}else if(dAmount[3] <= 0) {
					System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
					
				}else{
				dAmount[3] -= 1; coin-=dPrice[3];
					System.out.println("�����Ͻ� ����"+dName[3]+"�� �� �����˴ϴ�. ===== - ��� "+dAmount[3]);
					System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
				}
			
				break;
		case 5:
				System.out.println("�ݾ� " + coin + " won �� ��ȯ �˴ϴ�.");
				System.out.println("=================================");
			coin-=coin;
				System.out.println("���� �ݾ��� "+ coin + " won �Դϴ�." );
				System.out.println();
				// �Ž����� ��ȯ
			break;
			
		case 6: 
				sel =0;
				System.out.println("�߰� ���� �� �ݾ��� �Է� �ϼ���");
				System.out.print("�Է� = ");
				coin += sc.nextInt();
				
			break;
		
			
//			
		case 77:// ������ ���
			
			System.out.println("������ ��忡 �����մϴ�.");
			System.out.println("Password�� �Է����ּ���.");
			String pswd = sc.next();
			
			if("3002".equals(pswd)) {
				
					boolean adminpower = false; // ������ ��� ����
					int tmpNum = 0, swNum = 0;
					String sw = null, tmp = null;
				
				while(!adminpower) {
					
					System.out.println("===============================================");
					System.out.println("==========Administrator Mode Activate==========");
					System.out.println("===============================================");
					System.out.println("1.ǰ�� �̸� �ٲٱ� 2.��� ����. 3. �������� 4.�����ڸ�� ������");
				
						int admin=sc.nextInt();
				
						switch(admin) { // ���� �޴� ����
				 					 	
						case 1:
					
						System.out.println("ǰ�� �̸��� �����մϴ�. ���� �� ǰ���� �����ϼ���");
						System.out.println("�� "+ dName[0] + " �� " + dName[1] + " �� " + dName[2] + " �� "+ dName[3]);
									
							int	menu=sc.nextInt();		
							
							switch(menu) { // ���� ���� �޴� 1234 ����
					
							case 1: 
								
								System.out.println("ǰ��"+ dName[0]+ "��/�� ���� �� ǰ����� �Է����ּ���.");
								sw = sc.next();
																
								tmp=dName[0];
								dName[0]=sw;
								sw = tmp;
								break;
						
							case 2:
								
								System.out.println("ǰ��"+ dName[1]+ "��/�� ���� �� ǰ����� �Է����ּ���.");
								sw = sc.next();
																	
								tmp=dName[1];
								dName[1]=sw;
								sw = tmp;
								break;
								
							case 3: 
								
								System.out.println("ǰ��"+ dName[2]+ "��/�� ���� �� ǰ����� �Է����ּ���.");
								sw = sc.next();
															
								tmp=dName[2];
								dName[2]=sw;
								sw = tmp;
								break;
								
							case 4:	
								
								System.out.println("ǰ��"+ dName[3]+ "��/�� ���� �� ǰ����� �Է����ּ���.");
								sw = sc.next();
															
								tmp=dName[3];
								dName[3]=sw;
								sw = tmp;
								break;
								
							default:
								break;
							}
							break;
							
						case 2:
							
							System.out.println("ǰ�� ��� �����մϴ�. ���� �� ǰ���� ��� �����ϼ���");
							System.out.println("�� "+ dName[0] + " X " + dAmount[0] + " �� " + dName[1] + " X " + dAmount[1] + " �� " + dName[2] + " X " + dAmount[2] + " �� "+ dName[3] +" X " + dAmount[3]);
							
							menu=sc.nextInt();	
							
							switch(menu) {
																																						
							case 1:
								
								System.out.println(dName[0] + "�� ��� ���� �� ������ �Է����ּ���. ���� ��� : "+ dAmount[0]);
								sw = sc.next();
																
								tmpNum =dAmount[0];
								dAmount[0] = swNum;
								swNum = tmpNum;
								break;
								
							case 2:
								
								System.out.println(dName[1] + "�� ��� ���� �� ������ �Է����ּ���. ���� ��� : "+ dAmount[1]);
								sw = sc.next();
																
								tmpNum =dAmount[1];
								dAmount[1] = swNum;
								swNum = tmpNum;
								break;
								
							case 3:
								
								System.out.println(dName[2] + "�� ��� ���� �� ������ �Է����ּ���. ���� ��� : "+ dAmount[2]);
								sw = sc.next();
																
								tmpNum =dAmount[2];
								dAmount[2] = swNum;
								swNum = tmpNum;
								break;
								
							case 4:
								
								System.out.println(dName[3] + "�� ��� ���� �� ������ �Է����ּ���. ���� ��� : "+ dAmount[3]);
								sw = sc.next();
																
								tmpNum =dAmount[3];
								dAmount[3] = swNum;
								swNum = tmpNum;
								break;
						
							default:
								break;
							}
							break;	
							
						case 3:
							
							System.out.println("ǰ�� �� ������ �����մϴ�. ���� �� ǰ���� �����ϼ���");
							System.out.println("�� "+ dName[0] + " �� " + dName[1] + " �� " + dName[2] + " �� "+ dName[3]);
										
							
							menu=sc.nextInt();	
							switch(menu) {
							
								case 1:
								
									System.out.println(dName[0] + "�� ���� �� ������ �Է����ּ���. ���� ���� : "+ dPrice[0]);
									sw = sc.next();
																
									tmpNum =dPrice[0];
									dPrice[0] = swNum;
									swNum = tmpNum;
									break;
									
								case 2:
									
									System.out.println(dName[1] + "�� ���� �� ������ �Է����ּ���. ���� ���� : "+ dPrice[1]);
									sw = sc.next();
																
									tmpNum =dPrice[1];
									dPrice[1] = swNum;
									swNum = tmpNum;
									break;
									
								case 3:
									
									System.out.println(dName[2] + "�� ���� �� ������ �Է����ּ���. ���� ���� : "+ dPrice[2]);
									sw = sc.next();
																
									tmpNum =dPrice[2];
									dPrice[2] = swNum;
									swNum = tmpNum;
									break;
									
								case 4:
									
									System.out.println(dName[3] + "�� ���� �� ������ �Է����ּ���. ���� ���� : "+ dPrice[3]);
									sw = sc.next();
																
									tmpNum =dPrice[3];
									dPrice[3] = swNum;
									swNum = tmpNum;
									break;
									
								default:
									break;
							}
							break;
							
						
						case 4:
							adminpower = true;
							System.out.println("������ ��尡 ����˴ϴ�.");
							
							break;
					
					}
					break;
							
			}
				
						
					
					
					
				
				// ���� �����ϴ� ��ɵ�
				
			}else {
				
				System.out.println("Password�� Ʋ�Ƚ��ϴ�..!");
				System.out.println("��� ������ ���Ͽ�");
				
				
		}
			System.out.println("������ ��尡 ����ǰ� ��������� ����˴ϴ�.");
			break;// ������ ����� break;
			
			
		case 99:
			power = true;
			System.out.println("��� ������ ����˴ϴ�.");
			
				 
			break;
		
		default:
			System.out.println("�߸� �����̽��ϴ�.");
			break;
		
			
		}	
		
			if (!power) {
			
				System.out.println("�̿��� ��� �Ͻ÷��� ������ ���� ���ּ���. 0 = ������ ���� �ʴ´�." );
				System.out.print("�Է� = " );		
			
			}else if(coin<dPrice[0]) {
				
			
				
			}
			
	}
	System.out.println("���Ǳ� ����");
	
	}

}

