/*
 * �迭�� ���� ���� �ܿ� �۾� 
 * ver15 �Էµ� for ������ ����
 * ver16 �ܵ���� for ������ ����
 * ver17 �Է� ���� case ���� while ������ ���� 
 * ver18 ��� ���� case���� while ������ ����
 */
package kr.co.dong.checkPoint;

import java.util.Scanner;

public class Report_01_19 {
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
			sAmount[0] = 1; //50000��
			sAmount[1] = 1; //10000��
			sAmount[2] = 1; //5000��
			sAmount[3] = 1; //1000��

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
			
			int pass = 1234; // ������ �ʱ� ��ȣ
			
		
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
					int inCoinTmp = 0;
					inCoinTmp = inCoin;
					
					if (inCoin>=sMoney[3]) { // ���� ������ ���� ����  						
						if(inCoin <sMoney[2]) {   
							for(int i=3; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;			
							}
							inCoin = inCoinTmp;
						}                                               
						
						else if(inCoin >=sMoney[2] && inCoin <sMoney[1] ) { // 5000�� �̻� 1���� �̸�
							for(int i=2; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;
							}
							inCoin = inCoinTmp;	
						}
						else if(inCoin >=sMoney[1] && inCoin <sMoney[0] ) { //1���� �̻� 5���� �̸�
							for(int i=1; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;
							}
							inCoin = inCoinTmp;	
						}
						else if(inCoin >sMoney[0]) { // 5���� �̻��϶�
							for(int i=0; i<=3; i++) {	
								int tmp = 0;
								tmp = inCoin/sMoney[i];
								sAmount[i] = sAmount[i] + tmp;
								inCoin = inCoin - sMoney[i] * tmp;
							}
							inCoin = inCoinTmp;	
						}
						inCoin = inCoinTmp; // ������� �Է°����� ���� �Ǿ� �ʱ� ���� �ٽó־���
						break;
					}	
				}
				break;
		
			case 2: // ���� ã��
				
				if(inCoin==0) {
					System.out.println("�������� �ܵ��� �����ϴ�. �����մϴ�. ");
					System.out.println("�ý��� ���Ḧ���Ͻø� 99���� �����ֽʽÿ�. ");
				}
				
				System.out.println("�ܵ��� = " + inCoin + "�Դϴ�. �����մϴ�. ");
				
				if(inCoin<sMoney[2]) { // 5000�� �̸�
					for(int i=3; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("�ܵ��� %d�� ȭ�� + %d�� �Դϴ�. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];
					}
				}					
				else if(inCoin>=sMoney[2] && inCoin <sMoney[1]) { // 5000�� �̻� 10000�� �̸�
					for(int i=2; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("�ܵ��� %d�� ȭ�� + %d�� �Դϴ�. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];
					}
				}				
				else if(inCoin>=sMoney[1] && inCoin <sMoney[0]) { // 10000�̻� 50000�� �̸�		
					for(int i=1; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("�ܵ��� %d�� ȭ�� + %d�� �Դϴ�. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];		
					}
				}				
				else if(inCoin>=sMoney[0]) { // 50000�� �̻�
					for(int i=0; i<=3; i++) {				
						smAmount[i] = inCoin/sMoney[i];
						System.out.printf("�ܵ��� %d�� ȭ�� + %d�� �Դϴ�. \n", sMoney[i], smAmount[i]);	
						inCoin = inCoin - smAmount[i]*sMoney[i];		
					}
				}				
				inCoin =0;
				break;		
				
				case 11: case 12: case 13:
					
				while(true) { 
					int choice = 0;
					choice = inMenu - 11;
					
					if(dAmount[0]>0) {
						if (inCoin >= dPrice[choice]) {
							System.out.printf("\n%s�� �ϴ� ���ⱸ�� �ֽ��ϴ�. �����մϴ�. \n", dName[choice]);
							inCoin = inCoin - dPrice[choice];
							dAmount[choice] = dAmount[choice] - 1;
							sale[choice] = sale[choice] + 1;
							System.out.printf("�ܾ��� %d �Դϴ�. \n", inCoin);
							break;
						} else {
							System.out.println("�ܾ��� �����մϴ�. ==> 1. ���ֱ⸦ �����ּ���");
							break;
						}				
					}
				}
				break;
		
			case 90: // ������ ���
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
						
							while(true) {
								if(changePlma==1) {                           
								dAmount[changeNum-1] = dAmount[changeNum-1] + changeCount;
								}
								else if(changePlma!=1) {
									dAmount[changeNum-1] = dAmount[changeNum-1] - changeCount;	
								}		
							System.out.println("����� �Ϸ� : " + dName[changeNum-1] + ":" + dAmount[changeNum-1]);
							break;
								
							}
						
						case 4: // ���� ����	
							int changeNum2 = 0;
							for(int i=0; i<productCount; i++) {
								System.out.println((i+1) + dName[i]);
							}
						
							System.out.println("������ ������ ��ǰ��ȣ�� �˷��ּ���>");
							changeNum2 = scan.nextInt();
							
								while(true) {
									
									if(changeNum2>productCount) {
										System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է��� �ּ���>");
									}
									else {
									dPrice[changeNum2-1] = scan.nextInt();
									System.out.println("�� ������ = " +  dPrice[changeNum2-1] +"�� ����Ǿ����ϴ�.");
									break;
									}
								}

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
							
						case 9: // �н����� ����
							System.out.println("���� �н����带 �Է��� �ּ���>");
							tmp22 = scan.nextInt();
							if (tmp22 == pass) {
							System.out.println("������ �� ��ȣ�� �Է��ؼ�����. ���� 4�ڸ�");
							tmp22 = scan.nextInt();	
							pass = tmp22; // ������ �ʱ� ��ȣ
							}
							System.out.println("��ȣ�� �����Ͽ����ϴ�. �߱���ϼ���. \n �������������� �̵��մϴ�. \n ");

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
