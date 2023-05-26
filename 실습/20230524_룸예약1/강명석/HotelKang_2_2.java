package kr.co.dong.checkpoint // ���ο� ���� ���� ȣ�� ���� ver2

import java.util.Scanner;

public class HotelKang_2_2 {
	public static void main(String[] args) {
		
		int[] romNum = new int[7];   // romNum[0] 20�� romNum[1] 40�� romNum[2] ���� 
		                             // romNum[3] 20�� ���� 1�� 4��  romNum[4] 40�� ���� 2�� 
		                             // romNum[5] ���డ��20���� romNum[6] ���డ�� 40���� 

		String[][] rom20 = null;     // ������� 20��
		String[][] rom40 = null;     // ������� 40��
		
		Scanner scan = new Scanner(System.in);
		
		// ���Է�                                       // �������� ���� ��� �ö����� while ������ �ۼ��� �� - �ð��� ��� 0���ϸ� 1ȸ �ɸ�
		System.out.println("ȣ�� � ���α׷��� �����մϴ�. ��� ���� ��ġ�� �Է��� �ּ���");
		System.out.println("�Է� 20��>");
		romNum[0] = scan.nextInt();
		if(romNum[0]<=0) {
			System.out.println("�ּ� 1�� �̻� �����ϼž� �մϴ�. "); // �ʱ� �� ���� ���� Ȯ�� ��Ÿ Ȯ�ΰ�
			System.out.println("�Է� 20��>");
			romNum[0] = scan.nextInt();
		}

		System.out.println("�Է� 40��>");
		romNum[1] = scan.nextInt();
		if(romNum[1]<=0) {
			System.out.println("�ּ� 1�� �̻� �����ϼž� �մϴ�. "); // �ʱ� �� ���� ���� Ȯ�� ��Ÿ Ȯ�ΰ�
			System.out.println("�Է� 40��>");
			romNum[1] = scan.nextInt();
		}
		
		romNum[2] = romNum[0] + romNum[1];	// romNum[2]
		
		//�ǹ� ���� ��� ���� �Լ�
		romNum[3] = romNum[0] / 4;
		if(romNum[0]%4!=0)
			romNum[3] = romNum[3] + 1; 	   // 20�� romNum[3] �����Ǵ� ���� ��
		
		romNum[4] = romNum[1] / 2;		
		if(romNum[1]%2!=0)
			romNum[4] = romNum[4] + 1;	   // 40�� romNum[4] �����Ǵ� ���� ��
		
//		System.out.println(romNum[3]);    // �� ���� ��� Ȯ��
//		System.out.println(romNum[4]);
		
					
		// 20�� �迭 ����                    // ��(�Ʒ�, ��)���� ��ü romNum[2]                 ��Ƽ���� int��  intValue1 = Integer.parseInt(str1)
									       // ���� ��(�Ʒ�, ��)���� ��ü rom20.length                            str1 = Integer.toString(intValue1)
		                                   // ��(��, �׸�)���� rom20[0].length
		
		rom20 = new String[romNum[0]][8];  // rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
				                           // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                                           // rom20[0][6] ������ȣ	, rom20[0][7]������ 		                 
		// 40�� �迭 ����
       	rom40 = new String[romNum[1]][8];  // rom40[0][0] count, rom40[0][1] ȣ��, rom40[0][2] ��뿩��
       			                           // rom40[0][3] ���̸�, rom40[0][4] ����, rom40[0][5] ������̸�
                                           // rom40[0][6] ������ȣ, rom40[0][7]������      

//		System.out.println(rom20.length);
//		System.out.println(rom20[0].length); // �� ���� Ȯ��	
       	
     // �ʱ�ȭ �Է� 
// 1. rom20, rom40 [0][0] count
       	for(int i=0; i<rom20.length; i++)
       		rom20[i][0] = Integer.toString(i+1); // rom20[i][0]�� ī��Ʈ�� 0���Ͱ� �ƴ϶� 1���� �����ϰ� i+1 ��  �ܼ��Է� ��ȣ ���� ����       	
       	for(int i=0; i<rom40.length; i++)
       		rom40[i][0] = Integer.toString(i+1); // rom40[i][0]�� ī��Ʈ�� 0���Ͱ� �ƴ϶� 1���� �����ϰ� i+1 ��  �ܼ���� ��ȣ ���� ����     	
       	
// * ���Ȯ�� *
//       	for(int i=0; i<rom20.length; i++)  // ������ 0�� 1���� �����ϴ� ������ �Է�Ȯ��
//       		System.out.println(rom20[i][0]);  
//       	for(int i=0; i<rom40.length; i++)  // ������ 0�� 1���� �����ϴ� ������ 
//       		System.out.println(rom40[i][0]); 
     
// 2. ��ȣ�� �ʱ�ȭ rom20
       	int romTmp = 100;
       	int floor20 = 4;
       	int floor40 = 2;
       	int floorCounter = 0;

       	for(int i=1; i<=rom20.length; i++) {        			
  			rom20[i-1][1] = Integer.toString(romTmp+i- floor20*floorCounter); // rom20[i][1]�� ���� 1���� 4���� 20���� ������ 4��
  				if(i%floor20==0) {
  					romTmp = romTmp + 100;
 				    floorCounter++;
 				   rom20[i-1][7]="20";
  				}
       		}
			romTmp = romTmp + 100;      		
       	for(int i=1; i<=rom40.length; i++) {  
       		floorCounter = (i-1)/floor40;
  			rom40[i-1][1] = Integer.toString(romTmp + i - floor40*floorCounter); // rom20[i][1]�� ���� 1���� 2���� 40���� ������ �� 2��
  				if(i%floor40==0) {
  					romTmp = romTmp + 100;
  				    floorCounter++;
  				   rom40[i-1][7]="40";
  				}
       		}    		
// * ���Ȯ�� *
//       	for(int i=0; i<rom20.length; i++)  // 
//       		System.out.println(rom20[i][1]);  
//       	for(int i=0; i<rom40.length; i++)  // 
//       		System.out.println(rom40[i][1]);       	
       	
// 3. �� ���� ���� �ʱ�ȭ 	 rom20[0][2] rom40[0][2]��뿩��
        for(int i=0; i<rom20.length; i++)
        	rom20[i][2] = "O"; // rom20[i][0]�� ��� O, �̻�� X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][2] = "O"; // rom40[i][0]�� ��� O, �̻�� X  
           	
// * ���Ȯ�� *
//       	for(int i=0; i<rom20.length; i++)  // 
//       		System.out.println(rom20[i][2]);  
//       	for(int i=0; i<rom40.length; i++)  //  
//       		System.out.println(rom40[i][2]); 

// 4. ���̸�	rom20[0][3]                           // �ϴ� ũ�⺰ 1������ ���� ���, ���� VVIP
        for(int i=0; i<rom20.length; i++)
        	rom20[i][3] = "Gold"; // rom20[i][0]�� ��� O, �̻�� X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][3] = "VVIP"; // rom40[i][0]�� ��� O, �̻�� X  
           	
// 5. �氡�� rom20[0][4] ����                       // �ϴ� ũ�⺰ 1������ ���� 4��, ���� 8��     
        for(int i=0; i<rom20.length; i++)
        	rom20[i][4] = "40,000��"; // rom20[i][0]�� ��� O, �̻�� X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][4] = "80,000��"; // rom40[i][0]�� ��� O, �̻�� X  
 
           	
// 6. ������̸� �ʱ� ���� �̵��            rom20[0][5] ������̸�
        for(int i=0; i<rom20.length; i++)
        	rom20[i][5] = "�̵��";        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][5] = "�̵��";
// * ���Ȯ�� *
//           	for(int i=0; i<rom20.length; i++)  // 
//           		System.out.println(rom20[i][5]);  
//           	for(int i=0; i<rom40.length; i++)  //  
//           		System.out.println(rom40[i][5]); 
           	
// 7. ���� �����ȣ => ������� ��뿹�� rom20[0][6] ������ȣ   => �����ȣ �������� ���ȣ + 1004
        for(int i=0; i<rom20.length; i++)
        	rom20[i][6] = rom20[i][1] + Integer.toString(1002); // rom20[i][0]�� ī��Ʈ�� 0���Ͱ� �ƴ϶� 1���� �����ϰ� i+1 ��  �ܼ��Է� ��ȣ ���� ����
        														// ���뿩�� ���� �����ȣ 1002�� 20��
        for(int i=0; i<rom40.length; i++)
        	rom40[i][6] = rom40[i][1] + Integer.toString(1004); // rom40[i][0]�� ī��Ʈ�� 0���Ͱ� �ƴ϶� 1���� �����ϰ� i+1 ��  �ܼ���� ��ȣ ���� ���� 
		                                                        // ���뿩�� ���� �����ȣ 1004�� 40��       
// * ���Ȯ�� *
//       	for(int i=0; i<rom20.length; i++)  // 
//       		System.out.println(rom20[i][6]);  
//       	for(int i=0; i<rom40.length; i++)  //  
//       		System.out.println(rom40[i][6]); 
       	
// 7. �ý��� ���� ��
        boolean power = false;
        int menu = 0;
        
		// ��Ȳ�� ����
		System.out.println("                ������Ȳ��                    ");
		System.out.println("-----------------------------------------------");
		System.out.println("                     -- 20�� --                      ");
		for(int i=0; i< rom20.length; i++) {
			System.out.printf(" %sȣ(%s)����(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
			
			if( (i+1)%2 == 0)
				System.out.println();
			
		}
		System.out.println("                     -- 40�� --                      ");
		for(int i=0; i< rom20.length; i++) {
			System.out.printf(" %sȣ(%s)����(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
			
			if( (i+1)%2 == 0)
				System.out.println();
		}
		
		System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
		System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
		System.out.println("               8. ������        9. ����");
		// ��Ȳ�� ����
		
        while(!power) {   	
			System.out.println("��ɼ��� => "); // ��ɼ���
			menu = scan.nextInt();       	
        	
        	
        	
        	switch (menu) {
				case 1: // ���� ���� Ȯ��
					System.out.println("20���� ��Ȳ");
					System.out.println("��ġ ���ȣ ����   ���̸�   ����      ����    ��ҹ�ȣ  ũ��"  );
					for(int i=0; i<rom20.length; i++) {
						System.out.printf(" %s   %s   %s   %s  %s   %s    %s\n", rom20[i][0], rom20[i][1], rom20[i][2],
								rom20[i][3], rom20[i][4], rom20[i][5], rom20[i][6] , rom20[i][7]);
					}
					System.out.println("40���� ��Ȳ");
					System.out.println("��ġ ���ȣ ����   ���̸�   ����      ����    ��ҹ�ȣ   ũ��"  );
					for(int i=0; i<rom40.length; i++) {
						System.out.printf(" %s   %s   %s   %s  %s   %s    %s\n", rom40[i][0], rom40[i][1], rom40[i][2],
					rom40[i][3], rom40[i][4], rom40[i][5], rom40[i][6], rom40[i][7]);
					}
					// rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
                    // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                    // rom20[0][6] ������ȣ
					
				break; 
				
				case 2: // �濹�� => ����
// 1. ���� �� ���� üũ : �濩�� Ȯ�� + ���� ���ɿ��� �˸�
// ���� ���� romNum[5] ���డ��20����, romNum[6] ���డ�� 40����, rom20[i][2], rom40[i][2] ��� O, �̻�� X
					for(int i=0; i<rom20.length; i++) // 20�� üũ // 1�� for, if ��ȣ ����
						if(rom20[i][2]=="O")
							romNum[5]++;
					
					for(int i=0; i<rom40.length; i++) //40�� üũ // 1�� for, if ��ȣ ����
						if(rom40[i][2]=="O")
							romNum[6]++;

					if(romNum[5]==0 && romNum[6]==0) 
						System.out.println("���డ���� ���� �����ϴ�. ȣ�ڿ��� Tel. 000-0000-000");	  //1�� if ����
					
// *Ȯ�� �� ī��Ʈ��	System.out.println(romNum[5]);
//					System.out.println(romNum[6]);
					
			
// 2. ����ȭ�� 		// ȭ�� ���÷��� �ʿ� // rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
                    // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                    // rom20[0][6] ������ȣ rom20[0][3] = "Gold"	 rom40[0][3] = "VVIP"
					
					// ��Ȳ�� ����
					System.out.println("                ������Ȳ��                    ");
					System.out.println("-----------------------------------------------");
					System.out.println("                     -- 20�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ(%s)����(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println();
					System.out.println("                     -- 40�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ(%s)����(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println("-----------------------------------------------");					
		            // ��Ȳ�� ����
			
// 3. ����			20�� 40�� ũ�⸦ ������	
					// rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
                    // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                    // rom20[0][6] ������ȣ  rom20.length    rom40.length
					String selectRom = null;
					String Recheck = null;
					String inputName = null;
					int chNum = 0;              // �濡 ���� idx �ӽ�����
					
					System.out.println("���ϴ� �� ȣ���� ������ �ּ��� ex) 101> ");
					selectRom = scan.next();
					
					System.out.println("������ �̸��� �־� �ֽø� ������ �Ϸ�˴ϴ�. ex) ȫ�浿> ");
					inputName = scan.next();
										
// * �Է�Ȯ��  		System.out.println(selectRom);
//					System.out.println(inputName);
//					System.out.println(Recheck);					
//�������� ������ // ���ȣ�� 20������ 40������ ���� ���� �߰� ; �̻���ϱ���
						
						for(int i=0; i<rom20.length; i++) {
							if(selectRom.equals(rom20[i][1])) {
								chNum = i;
								rom20[chNum][2] = "X";
								rom20[chNum][5] = inputName;
								System.out.println("������ ���� �����ȣ�Դϴ�. �߱���Ͻʽÿ�. <��� Ȥ�� Ȯ�ν� �ʿ���>");
								System.out.printf("���� �����ȣ�� < %s > �Դϴ�. \n", rom20[chNum][6] );
							}
						}
	
						for(int i=0; i<rom40.length; i++) {
							if(selectRom.equals(rom40[i][1])) {
								chNum = i;
								rom40[chNum][2] = "X";
								rom40[chNum][5] = inputName;
								System.out.println("������ ���� �����ȣ�Դϴ�. �߱���Ͻʽÿ�. <��� Ȥ�� Ȯ�ν� �ʿ���>");
								System.out.printf("���� �����ȣ�� < %s > �Դϴ�. \n", rom40[chNum][6] );
							}
						}	

					// ��Ȳ�� ����
					System.out.println("                ������Ȳ��                    ");
					System.out.println("-----------------------------------------------");
					System.out.println("                     -- 20�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ(%s)����(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println("                     -- 40�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ(%s)����(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println("-----------------------------------------------");	
					System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
					System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
					System.out.println("               8. ������        9. ����");
		            // ��Ȳ�� ����
					
				break;  
				
				case 3: // ������� 
					//������� : serch �̸� => idxȮ�� => ��� idx�� ���� ��
					// rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
                    // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                    // rom20[0][6] ������ȣ  rom20.length    rom40.length
					
					String checkName = null;
					int checkReNum = 0;
					String inputTmp = null;
					
					System.out.println("���� ��Ҹ� �����ϼ̽��ϴ�. ");
					System.out.println("���� ��������� ID�� �̸�, �н������ �����ȣ �Դϴ�.");	
					System.out.println("1. ��� ID(�̸�) �Է� >");
					checkName = scan.next();
					System.out.println("2. �ּ� PASS(�����ȣ) �Է� >");
					inputTmp = scan.nextLine();
										
					for(int i=0; i<rom20.length; i++) {	// 20�� üũ		
						if( (rom20[i][5]==checkName)&& (rom20[checkReNum][6]==inputTmp) ) {
							checkReNum = i;
							System.out.printf("%s���� %sȣ ������ ��ҵǾ����ϴ�.", rom20[checkReNum][5], rom20[checkReNum][1] );
							rom20[checkReNum][5]="OOO";  // ���� ��� �̸� ����
							rom20[checkReNum][2]="0";      // ���� ��� ��뿩�� 
						}
					}	
					for(int j=0; j<rom40.length; j++) {	// 40�� üũ		
						if(rom20[j][5]==checkName) {
							checkReNum = j;
							System.out.printf("%s���� %sȣ ������ ��ҵǾ����ϴ�.", rom40[checkReNum][5], rom40[checkReNum][1] );
							rom40[checkReNum][5]="OOO";  // ���� ��� �̸� ����
							rom40[checkReNum][2]="0";      // ���� ��� ��뿩�� 
						}
					}
					
					// ��Ȳ�� ����
					System.out.println("                ������Ȳ��                    ");
					System.out.println("-----------------------------------------------");
					System.out.println("                     -- 20�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ(%s)����(%s)          ", rom20[i][1], rom20[0][3], rom20[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println("                     -- 40�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ(%s)����(%s)          ", rom40[i][1], rom40[0][3], rom40[i][2]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println("-----------------------------------------------");	
					System.out.println("====== �Ʒ� �޴��� ���ؼ� �������ּ��� ======");
					System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
					System.out.println("               8. ������        9. ����");
		            // ��Ȳ�� ����
					
			
				break;
				
				case 8: // ������

				break;
				
				case 9: // ��������
					power = true;
					System.out.println("��� ��û������ ������ �Ǿ����ϴ�. �����մϴ�.");	
				break;

				default:
					System.out.println("�������� ������ �ƴմϴ�. �ٽ� ������ �ּ��� ");
				break;
				
			} //end of switch
	
        } //end of while
		System.out.println("���� �ý��� ����.");
	} // end of main
	
} // end of class
