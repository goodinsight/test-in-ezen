package kr.co.dong.report;

import java.util.Scanner;

public class Report21_5 {
	
	public static void main(String[] args) {
		
		String[] dName = { "Coke", "Sprite", "Coke zero", "Sprite zero","Monster", "Redbull", "Tonic Water","Ginger ale", "Banana Milk","Straw Berry"};
		int[] dAmount = { 15, 20, 20, 15, 15, 20, 15, 15, 20, 15}; 		// ��� ����
		int[] dPrice = { 1200, 1200, 1200, 1200, 2000, 2000, 1500, 1500, 1200, 1200,};
//		int vCash = 100000; // ���� ������ ž�� �ϴ°͵� �����ص���
		int coin = 0; // ���Աݾ� ����
		int sel = 0; // �޴� ����
		boolean power = false; // ���� ���Ǻ�
		
		System.out.println("Hi I'm vending machine :) ================================");
		System.out.println("| ���� �������� ǰ��� �Դϴ� ����� ���Ͻø� ������ ���� (�Է�)���ּ���|");
		
			for(int i=0; i<dName.length; i++) {
				System.out.println((char)(9312+i) +". "+ dAmount[i] + " * "+dName[i] + " : "  + dPrice[i] + " won  ");
			}//���� ¦�Ἶ���� ���� ���� char �ƽ�Ű�ڵ�� Ư�����ڸ� �Է��غ�
		
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
			}else if(coin>=dPrice[0]){ // ���� ���� ǰ���� ������ �־���� ���� ���� ������ �� �ռ��� [0]
				System.out.println("���� �� �ݾ��� ���� " + coin + " won �Դϴ�.\r");			
				System.out.println("�ش� ���� ������ �ݾ� ����� ���� ������ ��ǰ�� ǥ�õ˴ϴ�.");	
				System.out.println("�޴��� �������ּ���.");	
				
					for(int i=0; i<dName.length; i++) {
						
						if(coin >= dPrice[i]){
							System.out.print((char)(9312+i) + " "+ dName[i]+" ");
						}
											
					}
						
			}else {
				
				System.out.println("���� �� �ݾ��� ���� " + coin + " won �Դϴ�.\r");			
				System.out.println("�ش� ���� ������ �ݾ� ����� ���� ������ ��ǰ�� ǥ�õ˴ϴ�.");	
				System.out.println("�޴��� �������ּ���.");	
				System.out.println((char)(9312) +""+ (char)(9313) + " Insert Coin " + (char)(9312+8) + (char)(9312+8) + " Vender Power Off" + "\r�Է� = ");	
				// ���Ŀ� �ֱ׷��� ȭ���غ����ҵ�
					for(int i=0; i<dName.length; i++) {
						
						if(coin >= dPrice[i]){
							System.out.print((char)(9312+i) + " "+ dName[i]+" ");
						}
										
					}
			}
						
			sel = sc.nextInt();
			
			switch(sel) {
						
				case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9: case 10:
								
					sel--;
					
					if (coin<dPrice[sel]) {
						System.out.println("=================== �ܾ��� �����մϴ� ===================");
						System.out.println("============= ������ �ݾ�" +coin+ " won �� ��ȯ �˴ϴ�.=============");
						
						coin-=coin;
															
					}else if(dAmount[sel] == 0) {
						System.out.println("�����Ͻ� ������ ��� �����ϴ�.");
						System.out.println("���� �� �ݾ��� ���� " + coin + "�Դϴ�.");
						
					}else{
					dAmount[sel] -= 1; coin-=dPrice[sel];
						System.out.println("�����Ͻ� ����"+dName[sel]+"�� �� �����˴ϴ�. ===== - ��� "+dAmount[sel]);
						System.out.println("===================== ���� ���� �ݾ��� " + coin + " �Դϴ�. \r");
					}
				
					break;
					
			case 11:
					System.out.println("�ݾ� " + coin + " won �� ��ȯ �˴ϴ�.");
					System.out.println("=================================");
				coin-=coin;
					System.out.println("���� �ݾ��� "+ coin + " won �Դϴ�." );
					System.out.println();
					// �Ž����� ��ȯ
				break;
				
			case 12: 
				
					System.out.println("�߰� ���� �� �ݾ��� �Է� �ϼ���");
										
				break;
						
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
								
								for(int i=0; i<dName.length; i++) {
								System.out.println((char)(9312+i)+". "+ dName[i]+ " ");
								}
										
								int	menu=sc.nextInt();		
									menu--;
								
								switch(menu) { // ���� ���� �޴� 1234 ����
									
								case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:	case 10:							
									
									System.out.println("ǰ��"+ dName[menu]+ "��/�� ���� �� ǰ����� �Է����ּ���.");
									sw = sc.next();
																	
									tmp=dName[0];
									dName[0]=sw;
									sw = tmp;
									break;							
															
								default:
									break;
								}
								break;
								
							case 2:
								
								System.out.println("ǰ�� ��� �����մϴ�. ���� �� ǰ���� ��� �����ϼ���");
								
								for(int i=0; i<dName.length; i++) {
									System.out.println((char)(9312+i)+". "+ dName[i] +" * "+ dAmount[i]+ " ");
									}
																
								menu=sc.nextInt();	
								menu--;
								switch(menu) {
																																							
								case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:	case 10:
									
									System.out.println(dName[menu] + "�� ��� ���� �� ������ �Է����ּ���. ���� ��� : "+ dAmount[menu]);
									sw = sc.next();
																	
									tmpNum =dAmount[menu];
									dAmount[menu] = swNum;
									swNum = tmpNum;
									break;
																								
								default:
									break;
								}
								break;	
								
							case 3:
								
								System.out.println("ǰ�� �� ������ �����մϴ�. ���� �� ǰ���� �����ϼ���");
								for(int i=0; i<dName.length; i++) {
									System.out.println((char)(9312+i)+". "+ dName[i] +" : "+ dPrice[i]+ " won");
									}
								
								menu=sc.nextInt();	
								menu--;
								switch(menu) {
								
									case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: case 9:	case 10:
									
										System.out.println(dName[menu] + "�� ���� �� ������ �Է����ּ���. ���� ���� : "+ dPrice[menu]);
										sw = sc.next();
																	
										tmpNum =dPrice[menu];
										dPrice[menu] = swNum;
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
						
							default:
								break;
						}
							
							if(adminpower != true){
								System.out.println("��⸦ ������ϱ� ������ ��������� ����˴ϴ�.");
								
							}
							
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
				}
			
			}
		sc.close();
		System.out.println("���Ǳ� ����");
		
	} //Main ed
}//Class ed