package kr.co.dong;

import java.util.Scanner;

public class Report_01_12 {
	public static void main(String[] args) {
//		����
		int productCount = 3; // �Ǹ� ��ǰ ���� ���� �� ��� ����
		
		int power1 = 1; // ���Ǳ� ����ġ	
		int power2 = 1; // ������ ����ġ
		
		String[] dName = null; // ��ǰ��
			dName = new String[productCount];           // ���߿� ����
			dName[0] = "�ݶ�";
			dName[1] = "����";
			dName[2] = "����";
		
		int[] dPrice = null; // ����
			dPrice = new int[productCount];                // ��ǰ �ʱ� ����
			dPrice[0] = 1000;
			dPrice[1] = 2000;
			dPrice[2] = 3000;
		
		int[] dAmount = null; // ����
			dAmount = new int[productCount];                // ��ǰ ���� �ܰ�
			dAmount[0] = 5;
			dAmount[1] = 5;
			dAmount[2] = 5;
		
		int[] sAmount = null; // ����
			sAmount = new int[4];                // ���Ǳ� �� �ܵ� Ȯ�� ����
			sAmount[0] = 2; //50000��
			sAmount[1] = 10; //10000��
			sAmount[2] = 20; //5000��
			sAmount[3] = 100; //1000��

			int[] sMoney = null; // �ܵ� ��
			sMoney = new int[4];                // �ܵ��� �⺻ ����
			sMoney[0] = 50000; //50000��
			sMoney[1] = 10000; //10000��
			sMoney[2] = 5000; //5000��
			sMoney[3] = 1000; //1000��
			
			int[] smAmount = null; // ����
			smAmount = new int[4];                // ȯ������ �ܵ� ����
			smAmount[0] = 0; //50000��
			smAmount[1] = 0; //10000��
			smAmount[2] = 0; //5000��
			smAmount[3] = 0; //1000��
			
		
		int[] sale = null;
		sale = new int[productCount];  // �Ǹż��� => ���� ����
		
		int inCoin = 0; // ���� ��
		int inMenu = 0; // �޴� ���� ��ư		
		
		Scanner scan = new Scanner(System.in); // ��ĳ�� ȣ��
		
		while(power1!=0) { // 0�� �ƴϸ� ��� ����
			System.out.println("----------------------------- Menu -----------------------------");
			System.out.println("1. �� �ֱ�        2. �� �����ޱ�        99. ����         90. �����ڸ��");
			System.out.println();
			System.out.println("--------------------------- ��ǰ ���� ---------------------------");
			System.out.printf("11. %s(�ܿ�����%d)      12. %s(�ܿ�����%d)         13. %s(�ܿ�����%d) \n", dName[0], dAmount[0],  dName[1], dAmount[1],  dName[2], dAmount[2]); //���߿� �迭������ ��
			System.out.printf("    %d��                %d��                    %d��     \n", dPrice[0], dPrice[1], dPrice[2]);
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			
			System.out.print("���� ������ �ּ���>"); // ��������
			inMenu = scan.nextInt(); // �޴� �Է�			
			
			switch (inMenu) { // main switch
			
			case 1: // �� �ֱ�
				int count = 0;
				count++;
				
				if (count == 1) {
					System.out.printf("�ּ� ���Աݾ��� 1000�� �Դϴ�. \n"); //�ּ� �ݾ� Ȯ�� �ʱ� ��� ���� �����
				}
				else {
					System.out.printf(" \n");
				}

				while (true) {
					System.out.printf("���� �־� �ּ���.> \n");
					inCoin = inCoin + scan.nextInt();
					
					if(inCoin <sMoney[3]) { // �ּ� �Է� �ݾ� Ȯ��
						System.out.println("���� �����մϴ�. ");
						System.out.printf("���� �ܾ��� %d �Դϴ�. \n", inCoin);
					}	
					if (inCoin>=sMoney[3]) { // ���� ������ ���� ����        // sMoney[0] = 50000; //50000��
						if(inCoin <sMoney[2]) {                         // sMoney[1] = 10000; //10000��
							sAmount[3] = sAmount[3] + inCoin/sMoney[3]; // sMoney[2] = 5000; //5000��
						}                                               // sMoney[3] = 1000; //1000��
						else if(inCoin >=sMoney[2] && inCoin <sMoney[1] ) {
							sAmount[2] = sAmount[2] + 1;
							inCoin = inCoin - sMoney[2];
							sAmount[3] = sAmount[3] + inCoin/sMoney[3];
						}
						else if(inCoin >=sMoney[3] && inCoin <sMoney[0] ) {
							int manCc = inCoin/sMoney[1];
							sAmount[1] = sAmount[1] + manCc;
							inCoin = inCoin - sMoney[1]*manCc;
							sAmount[2] = sAmount[2] + 1;
							inCoin = inCoin - sMoney[2];
							sAmount[3] = sAmount[3] + inCoin/sMoney[3];
						}
						else if(inCoin >sMoney[0]) {
							int ohmanCc = inCoin/sMoney[0];
							int manCc = inCoin/sMoney[1];
							sAmount[0] = sAmount[0] + ohmanCc;
							inCoin = inCoin - sMoney[0]*ohmanCc;							
							sAmount[1] = sAmount[1] + manCc;
							inCoin = inCoin - sMoney[1]*manCc;
							sAmount[2] = sAmount[2] + 1;
							inCoin = inCoin - sMoney[2];
							sAmount[3] = sAmount[3] + inCoin/sMoney[3];
						}
						
						break;
					}
						
				}
				break;
		
			case 2: // ���� ã��
//				sMoney[0] = 50000; //50000��
//				sMoney[1] = 10000; //10000��
//				sMoney[2] = 5000; //5000��
//				sMoney[3] = 1000; //1000��
				
//				smAmount[0] = 0; //50000��
//				smAmount[1] = 0; //10000��
//				smAmount[2] = 0; //5000��
//				smAmount[3] = 0; //1000��
				
				if(inCoin==0) {
					System.out.println("�������� �ܵ��� �����ϴ�. �����մϴ�. ");
					System.out.println("�ý��� ���Ḧ���Ͻø� 99���� �����ֽʽÿ�. ");
				}			
				System.out.println("�ܵ��� = " + inCoin + "�Դϴ�. �����մϴ�. ");
				
				
//				������ �ܵ� ��� �ۼ� �Ұ�
				
				inCoin =0;
				break;		
				
			case 11: // ��ǰ1
				if(dAmount[0]>0) { // ��ǰ1 ���Ž� ��� ������ ��� ���� �˸���, �ܾ� �� �޴� �˸�
					if (inCoin >= dPrice[0]) {
						System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", dName[0]);
						inCoin = inCoin - dPrice[0];
						dAmount[0] = dAmount[0] - 1;
						sale[0] = sale[0] + 1;
						System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
					} else {
						System.out.println("�ܾ��� �����մϴ�. ==> 1. ���ֱ⸦ �����ּ���");
						break;
					}
				} // end of if ��� ������ 
				else {
					System.out.println("��� �����ϴ�. �ٸ� �޴� ������ �ּ���. \n");
					System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
				} // end of else ��� ���� �� 
				break;

			case 12: // ��ǰ1
				if(dAmount[1]>0) { // ��ǰ2 ���Ž� ��� ������ ��� ���� �˸���, �ܾ� �� �޴� �˸�
					if (inCoin >= dPrice[1]) {
						System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", dName[1]);
						inCoin = inCoin - dPrice[1];
						dAmount[1] = dAmount[1] - 1;
						sale[1] = sale[1] + 1;
						System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
					} else {
						System.out.println("�ܾ��� �����մϴ�. ==> 1. ���ֱ⸦ �����ּ���");
						break;
					}
				} // end of if ��� ������ 
				else {
					System.out.println("��� �����ϴ�. �ٸ� �޴� ������ �ּ���. \n");
					System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
				} // end of else ��� ���� �� 
				break;
				
			case 13: // ��ǰ3
				if(dAmount[2]>0) { // ��ǰ3 ���Ž� ��� ������ ��� ���� �˸���, �ܾ� �� �޴� �˸�
					if (inCoin >= dPrice[2]) {
						System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", dName[2]);
						inCoin = inCoin - dPrice[2];
						dAmount[2] = dAmount[2] - 1;
						sale[2] = sale[2] + 1;
						System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
					} else {
						System.out.println("�ܾ��� �����մϴ�. ==> 1. ���ֱ⸦ �����ּ���");
						break;
					}
				} // end of if ��� ������ 
				else {
					System.out.println("��� �����ϴ�. �ٸ� �޴� ������ �ּ���. \n");
					System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
				} // end of else ��� ���� �� 
				break;
				
			case 90: // ������ ���
				int pass = 1234; // ������ �ʱ� ��ȣ
				int tmp22 = 0;
				System.out.print("������ ��ȣ�� �Է����ּ��� : ");
				tmp22 = scan.nextInt();
				if (tmp22 == pass) {
					
			
					int adminMenu =0;
				
					while(power2 !=2) {
						System.out.println("-------------------------- admin Menu ---------------------------");
						System.out.println("1. ��� ����Ȯ��     2. ���� ����");
						System.out.println("3. �����         4. ���� ����");
						System.out.println("5. �ܵ� ���� Ȯ��    6. �Ǹų���");
						System.out.println("9. �н����� ����    10. �����޴�");
						System.out.println("-----------------------------------------------------------------");
						System.out.println();
						System.out.println("���ϴ� ������ȣ�� �����ּ���>");
				
						adminMenu = scan.nextInt();
				
						switch (adminMenu) { // ������ ����ġ
					
						case 1: // ��� ����Ȯ��	
							for(int i=0; i<productCount; i++) {
								System.out.printf("%s (�ܰ���� %d) \n", dName[i], dAmount[i]);
							}
							System.out.println();
							break;
						
						case 2: // ���� ����	
							for(int i=0; i<productCount; i++) {
								System.out.printf("%s (�ܰ���� %d) \n", dName[i], dPrice[i]);
							}
							break;
						
						case 3: // �����
							int changeNum = 0;
							int changePlma = 0;
							int changeCount = 0;	
						
							for(int i=0; i<productCount; i++) {
								System.out.println((i+1) + dName[i]);
							}
							System.out.println("����� ��ǰ ��ȣ�� �־��ּ���>");
							changeNum = scan.nextInt();
						
							System.out.println("������ 1�� ���Ҵ� 2��?");
							changePlma = scan.nextInt();
						
							System.out.println("���� ������ �־��ּ���?");
							changeCount = scan.nextInt();
						
							switch (changeNum) {
							
							case 1:
								if(changePlma==1) {                           
									dAmount[0] = dAmount[0] + changeCount;
								}
								else if(changePlma==1) {
									dAmount[0] = dAmount[0] - changeCount;	
								}		
								System.out.println("����� �Ϸ� : " + dName[0] + ":" + dAmount[0]);
								break;
							case 2:
								if(changePlma==1) {
									dAmount[1] = dAmount[1] + changeCount;
								}
								else if(changePlma==1) {
									dAmount[1] = dAmount[1] - changeCount;	
								}
								System.out.println("����� �Ϸ� : " + dName[1] + ":" + dAmount[1]);
								break;
							case 3:
								if(changePlma==1) {
									dAmount[2] = dAmount[2] + changeCount;
								}
								else if(changePlma==1) {
									dAmount[2] = dAmount[2] - changeCount;	
								}
								System.out.println("����� �Ϸ� : " + dName[2] + ":" + dAmount[2]);
								break;
							
							default:
								System.out.println(" �߸��� �Է��Դϴ�. ��õ� ���ּ���>");
								break;
							}	
						
						case 4: // ���� ����	
							int changeNum2 = 0;
							int changeMoney = 0;
							int onoff = 0; 
							for(int i=0; i<productCount; i++) {
								System.out.println((i+1) + dName[i]);
							}
						
							System.out.println("������ ������ ��ǰ��ȣ�� �˷��ּ���>");
							changeNum2 = scan.nextInt();
							String tmp = null;
							
								switch (changeNum2) {
								case 1:
									System.out.println("�ݾ��� �����ּ���>");
									dPrice[0] = scan.nextInt();
									System.out.println("�� ������ = " +  dPrice[0] +"�� ����Ǿ����ϴ�.");
									break;
								case 2:
									System.out.println("�ݾ��� �����ּ���>");
									dPrice[1] = scan.nextInt();
									System.out.println("�� ������ = " +  dPrice[1] +"�� ����Ǿ����ϴ�.");
									break;								
								case 3:
									System.out.println("�ݾ��� �����ּ���>");
									dPrice[2] = scan.nextInt();
									System.out.println("�� ������ = " +  dPrice[2] +"�� ����Ǿ����ϴ�.");
									break;														
								default:
									break;
								}

								break;

						case 5: //�ܵ� ���� Ȯ��	
							for(int i=0; i<sAmount.length; i++) {
								System.out.println(sMoney[i] + "���� = " + sAmount[i] + "��" );
							}
							break;
						
						case 6: //�Ǹ� ����
							System.out.println("���� ������� �Ʒ��� �����ϴ�. ");
							for(int i=0; i< productCount; i++) {
								System.out.println(dName[i] +" : " + dPrice[i] + "�� => " + sale[i] + "�� �Ǹ�");					
							}
							System.out.println("     ���Ǹűݾ� :" + (dPrice[0]*sale[0] + dPrice[1]*sale[1] + dPrice[2]*sale[2]) + "��");
							break;
						
						case 10: // ���� �޴�
							power2 = 2;
							System.out.println("���� ����ȭ������ �Ѿ� ���ϴ�. ");
							break;
						default:
							System.out.println(" �߸��� ������ȣ�Դϴ�. �ٽ� ������ =>");
							break;
					}	
						} // end of ������ ����ġ
					} // end of while
					break;
				
				case 99: // ������ ����
					power1 = 0;
					System.out.println("\n �ý����� �����մϴ�.");
				break;
				
				default:
					System.out.println(" �۵��� ������ �߻��Ͽ����ϴ�. �ٽ� �޴� ������ ��Ź�帳�ϴ�.");
				break;
				
			} //end of switch main

		} // end of while

	} // end of main
}
// end of class
