package kr.co.dong.checkpoint // ���ο� ���� ���� ȣ�� ���� ver2
                    // ver2.1 ���� ���� 2���� + 1���� �迭 5/25
                    // ver2.2 ���� �� ��� ���� 5/26 ����
                    // ver2.3 ���÷��� ���� �� ������� 5/26 ����
                    // ver2.4 ������ ���� 5/26 ����

import java.util.Scanner;

public class HotelKang_2_4 {
	public static void main(String[] args) {
		
		int[] romNum = new int[9];   // romNum[0] 20�� romNum[1] 40�� romNum[2] ���� 
		                             // romNum[3] 20�� ���� 1�� 4��  romNum[4] 40�� ���� 2�� 
		                             // romNum[5] ���డ��20���� romNum[6] ���డ�� 40���� 
									 // romNum[7] ������20�� romNum[8] ������40��
		
		for(int i=0; i<romNum.length; i++)           // ���� �ʱ��
			romNum[i] = 0;

		String[][] rom20 = null;     // ������� 20��
		String[][] rom40 = null;     // ������� 40��
		final int PASS = 1004; 
		
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
                                           // rom20[0][6] ������ȣ	, rom20[0][7]�ο��� 		                 
		// 40�� �迭 ����
       	rom40 = new String[romNum[1]][8];  // rom40[0][0] count, rom40[0][1] ȣ��, rom40[0][2] ��뿩��
       			                           // rom40[0][3] ���̸�, rom40[0][4] ����, rom40[0][5] ������̸�
                                           // rom40[0][6] ������ȣ, rom40[0][7] �ο���     
       	final String MAX20 = "4��"; // 20�� �ִ�����ο�
       	final String MAX40 = "8��"; // 40�� �ִ�����ο�   
       	
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
        
        // ** ���̸��� �ִ� ���ߺ� �������� ��ġ��
        String[] roomNameRand = { "Nice", "Good", "Like", "Need", "Time", 
        						  "Life", "Work", "Hope", "Fear", "Rain",
        						  "Fire", "Snow", "Love", "Mind", "Star",
        						  "Rain", "Song", "Wind", "Idea", "Game",
        						  "Team", "Luck", "Gift", "Book", "Home",
        						  "Tree", "Bird", "Hand", "Word", "Pick",
        						  "Gold", "VVIP", "Mine"
        };
        rom20[0][3]="Gift";
        rom40[0][3]="Good";
                
        for(int i=0; i<rom20.length; i++){
        	int ranNumRom1 = (int)(Math.random()*28) +1;
        	{for(int j=0; j<i; j++) {
        		rom20[i][3] = roomNameRand[ranNumRom1];  // �������� ���̸� ��ġ 28���� 
        		if(rom20[i][3]==rom20[j][3]) {
        			ranNumRom1 = (int)(Math.random()*28) +1;
        			rom20[j][3] = roomNameRand[ranNumRom1];
        		}
        		
        	}  // �������� ���̸� ��ġ 28����
        		
        	}
        	ranNumRom1 = 0;
        }
        for(int i=0; i<rom40.length; i++) {
        	int ranNumRom2 = (int)(Math.random()*28) +1;
        	rom40[i][3] = roomNameRand[ranNumRom2]; // rom40[i][0]�� ��� O, �̻�� X    
    		ranNumRom2 = 0; //�ʱ�ȭ  
        } // => ������ �ִ��� ũ�ν� üũ �ϰ� ���� ��	

           	
// 5. �氡�� rom20[0][4] ����                       // �ϴ� ũ�⺰ 1������ ���� 4��, ���� 8��     
        for(int i=0; i<rom20.length; i++)
        	rom20[i][4] = "40000"; // rom20[i][0]�� ��� O, �̻�� X        	
        for(int i=0; i<rom40.length; i++)
        	rom40[i][4] = "80000"; // rom40[i][0]�� ��� O, �̻�� X  
 
           	
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
        
// 8. �ο��� Ȯ�� rom20[0][7] ������ȣ  20���� 4��, 40���� 8��
        for(int i=0; i<rom20.length; i++)
        	rom20[i][7] = "4��"; // �ܼ��Է� ��ȣ ���� ����
        for(int i=0; i<rom40.length; i++)
        	rom40[i][7] = "8��"; // �ܼ��Է� ��ȣ ���� ����	 
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
		System.out.println("===============================================");
		System.out.println("                   -- 20�� --                      ");
		for(int i=0; i< rom20.length; i++) { // �ο��� // 
			System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
			if( (i+1)%2 == 0) {
				System.out.println();
				for(int j=0; j<2; j++) {
				System.out.printf("       ���� : %s��           ", rom20[i][4]);					
			   }
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("                   -- 40�� --                      ");
		for(int i=0; i< rom20.length; i++) {
			System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
			if( (i+1)%2 == 0) {
				System.out.println();
				for(int j=0; j<2; j++) {
				System.out.printf("       ���� : %s��           ", rom40[i][4]);	
			   }
				System.out.println();	
			}
		}
		System.out.println();                                            
		System.out.println("     ====== �Ʒ� �޴��� ���ؼ� �������ּ��� =====      ");
		System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
		System.out.println("              8. ������        9. ����");
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
					// ��Ȳ�� ����
					System.out.println("                ������Ȳ��                    "); 
					System.out.println("===============================================");
					System.out.println("                   -- 20�� --                      ");
					for(int i=0; i< rom20.length; i++) { // �ο��� // 
						System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
						
						if( (i+1)%2 == 0)
							System.out.println();
						
					}
					System.out.println("                   -- 40�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
						
						if( (i+1)%2 == 0)
							System.out.println();
					}
					System.out.println();                                            
					System.out.println("     ====== �Ʒ� �޴��� ���ؼ� �������ּ��� =====      ");
					System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
					System.out.println("              8. ������        9. ����");
					// ��Ȳ�� ����
					
					
				break; 
				
				case 2: // �濹��
// 1. ���� �� ���� üũ : �濩�� Ȯ�� + ���� ���ɿ��� �˸�
// ���� ���� romNum[5] ���డ��20����, romNum[6] ���డ�� 40����, rom20[i][2], rom40[i][2] ��� O, �̻�� X
					for(int i=0; i<rom20.length; i++) // 20�� üũ // 1�� for, if ��ȣ ����
						if(rom20[i][2].equals("X"))
							romNum[5]++;
					
					for(int i=0; i<rom40.length; i++) //40�� üũ // 1�� for, if ��ȣ ����
						if(rom40[i][2].equals("X"))
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
					System.out.println("===============================================");
					System.out.println("                   -- 20�� --                      ");
					for(int i=0; i< rom20.length; i++) { // �ο��� // 
						System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("       ���� : %s��           ", rom20[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println("                   -- 40�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("        ���� : %s��           ", rom40[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println();                                            
					System.out.println("     ====== �Ʒ� �޴��� ���ؼ� �������ּ��� =====      ");
					System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
					System.out.println("              8. ������        9. ����");
					// ��Ȳ�� ����
			
// 3. ����			20�� 40�� ũ�⸦ ������	
					// rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
                    // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                    // rom20[0][6] ������ȣ  rom20.length    rom40.length
					String selectRom = null;
					String inputName = null;
					String inputMem = null;
					
					int chNum = 0;              // �濡 ���� idx �ӽ�����
					
					System.out.println("���ϴ� �� ȣ���� ������ �ּ��� ex) 101> ");
					selectRom = scan.next();
					
					System.out.println("�����ϴ� �ο����� (?)�� �˷��ּ��� ex) 1�� or 1 > ");
					inputMem = scan.next();
// ==> �۾��Ұ�						// ���� �ο��� ���Ƽ� �ٸ� ������ �̵� ���					

					
					System.out.println("������ �̸��� �־� �ֽø� ������ �Ϸ�˴ϴ�. ex) ȫ�浿> ");
					inputName = scan.next();
					
										
// * �Է�Ȯ��  		System.out.println(selectRom);
//					System.out.println(inputName);				
//�������� ������ // ���ȣ�� 20������ 40������ ���� ���� �߰� ; �̻���ϱ���
						
						for(int i=0; i<rom20.length; i++) {
							if(selectRom.equals(rom20[i][1])) {
								chNum = i;
								rom20[chNum][2] = "X";
								rom20[chNum][5] = inputName;
								rom20[chNum][7] = inputMem;
								System.out.println("������ ���� �����ȣ�Դϴ�. �߱���Ͻʽÿ�. <��� Ȥ�� Ȯ�ν� �ʿ���>");
								System.out.printf("���� �����ȣ�� < %s > �Դϴ�. \n", rom20[chNum][6] );
							}
						}
	
						for(int i=0; i<rom40.length; i++) {
							if(selectRom.equals(rom40[i][1])) {
								chNum = i;
								rom40[chNum][2] = "X";
								rom40[chNum][5] = inputName;
								rom40[chNum][7] = inputMem;
								System.out.println("������ ���� �����ȣ�Դϴ�. �߱���Ͻʽÿ�. <��� Ȥ�� Ȯ�ν� �ʿ���>");
								System.out.printf("���� �����ȣ�� < %s > �Դϴ�. \n", rom40[chNum][6] );
							}
						}	

						// ��Ȳ�� ����
						System.out.println("                ������Ȳ��                    "); 
						System.out.println("===============================================");
						System.out.println("                   -- 20�� --                      ");
						for(int i=0; i< rom20.length; i++) { // �ο��� // 
							System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
							if( (i+1)%2 == 0) {
								System.out.println();
								for(int j=0; j<2; j++) {
								System.out.printf("       ���� : %s��           ", rom20[i][4]);					
							   }
								System.out.println();
							}
						}
						System.out.println("                   -- 40�� --                      ");
						for(int i=0; i< rom20.length; i++) {
							System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
							if( (i+1)%2 == 0) {
								System.out.println();
								for(int j=0; j<2; j++) {
								System.out.printf("       ���� : %s��           ", rom40[i][4]);					
							   }
								System.out.println();
							}
						}
						System.out.println();                                            
						System.out.println("     ====== �Ʒ� �޴��� ���ؼ� �������ּ��� =====      ");
						System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
						System.out.println("              8. ������        9. ����");
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
					inputTmp = scan.next();
										
					for(int i=0; i<rom20.length; i++) {	// 20�� üũ		
						if( rom20[i][5].equals(checkName) && rom20[checkReNum][6].equals(inputTmp)) {
							checkReNum = i;
							System.out.printf("%s���� %sȣ ������ ��ҵǾ����ϴ�. \n", rom20[checkReNum][5], rom20[checkReNum][1] );
							System.out.println("�����մϴ�. ������ �ٽ� ������.");
							rom20[checkReNum][5]="�̵��";  // ���� ��� �̸� ����
							rom20[checkReNum][2]="O";      // ���� ��� ��뿩�� 
							rom20[checkReNum][7]=MAX20;
						}
					}	
					for(int j=0; j<rom40.length; j++) {	// 40�� üũ		
						if( rom40[j][5].equals(checkName) && rom40[checkReNum][6].equals(inputTmp)) {
							checkReNum = j;
							System.out.printf("%s���� %sȣ ������ ��ҵǾ����ϴ�.\n", rom40[checkReNum][5], rom40[checkReNum][1] );
							System.out.println("�����մϴ�. ������ �ٽ� ������.");
							rom40[checkReNum][5]="�̵��";  // ���� ��� �̸� ����
							rom40[checkReNum][2]="O";      // ���� ��� ��뿩�� 
							rom40[checkReNum][7]=MAX40;
						}
					}
					
					
					// ���� �ο� ����			
					for(int i=0; i<rom20.length; i++) {	// 20�� üũ	
						if( rom20[i][2].equals("X")) {
							romNum[7]++;  // �Ѹ� ���� - ������
						}
					}	
					
					for(int i=0; i<rom40.length; i++) {	// 40�� üũ		
						if( rom40[i][2].equals("X")) {
							romNum[8]++;  // �Ѹ� ���� - ������
						}
					}
					// ���� �ο� ����						
					
					// ��Ȳ�� ����
					System.out.println("                ������Ȳ��                    "); 
					System.out.println("===============================================");
					System.out.println("                   -- 20�� --                      ");
					for(int i=0; i< rom20.length; i++) { // �ο��� // 
						System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("       ���� : %s��           ", rom20[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println("                   -- 40�� --                      ");
					for(int i=0; i< rom20.length; i++) {
						System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
						if( (i+1)%2 == 0) {
							System.out.println();
							for(int j=0; j<2; j++) {
							System.out.printf("       ���� : %s��           ", rom40[i][4]);					
						   }
							System.out.println();
						}
					}
					System.out.println();                                            
					System.out.println("     ====== �Ʒ� �޴��� ���ؼ� �������ּ��� =====      ");
					System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
					System.out.println("              8. ������        9. ����");
					// ��Ȳ�� ����
					
			
				break;
				
				case 8: // ������
					
					int inputPass = 0;
					int adminMenu = 0;		
					int adminOnOff = 1;
					System.out.print("������ ��ȣ�� �Է����ּ��� : ");
					inputPass = scan.nextInt();
					if (inputPass == PASS) {

						while(adminOnOff != 2) {

							System.out.println("=========== �Ʒ� �޴��� ���ؼ� �������ּ��� ==========");
							System.out.println("1. ������Ȳ(���ȣ�� �� ���)      2. ���� ��Ȳ");
							System.out.println("3. ���ݺ���     4. �̸� ����      9. ����");
							System.out.println("===============================================");
							System.out.println("������ ���� ��� ���̽��ϴ�.");
							System.out.println("�޴� ����>");	
							
							adminMenu = scan.nextInt(); // �޴��Է�
							
							
							switch (adminMenu) {
							case 1:
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
								System.out.println();
								System.out.println("== ������Ȳ ==");	
//���� ���� romNum[5] ���డ��20����, romNum[6], 20 �����ο� romNum[7], 40�����ο� romNum[8] ���డ�� 40����								
								// ���� ȣ�� �̸� �ο� ǥ�� �����ڰ� �־�� ����, ����ȣ��, �̸�, �ο� ǥ��								

								System.out.println(" ��ȣ  ��ȣ��  ������̸�  �ο���");
								for(int i=0; i<rom20.length; i++) {	// 20�� üũ	
									if( rom20[i][2].equals("X")) {
										romNum[7]++;  // �Ѹ� ���� - ������
										System.out.printf("  %d    %s      %s    %s \n",romNum[7], rom20[i][1], rom20[i][5], rom20[0][7]);								
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40�� üũ		
									if( rom40[i][2].equals("X")) {
										romNum[8]++;  // �Ѹ� ���� - ������
										System.out.printf(" %d %s %s %s",romNum[8], rom40[i][1], rom40[i][5], rom40[0][7]);								
									}
								}
								
								System.out.printf("1. 20���� ����ȣ�� : %s�� \n", romNum[7]);
								System.out.printf("2. 40���� ����ȣ�� : %s�� \n", romNum[8]);
								System.out.printf(" ��ü ���� ȣ�� : �� %d ��", (romNum[7]+romNum[8]));
								
								break;	
								
							case 2:
								// ���� �ο� ����			
								for(int i=0; i<rom20.length; i++) {	// 20�� üũ	
									if( rom20[i][2].equals("X")) {
										romNum[7]++;  // �Ѹ� ���� - ������
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40�� üũ		
									if( rom40[i][2].equals("X")) {
										romNum[8]++;  // �Ѹ� ���� - ������
									}
								}
								// ���� �ο� ����	
							
								// String => int : intValue1 = Integer.parseInt(str1)
								// int => String :  str1 = Integer.toString(intValue1)
										
								System.out.println("== ���� ��Ȳ ==");
								System.out.printf("1. 20���� > ���� %d ��, ����� = %7d \n", romNum[7], romNum[7]*Integer.parseInt(rom20[0][4]) ); // ���ϰ��̶� ����, ���� ����
								System.out.printf("2. 40���� > ���� %d ��, ����� = %7d \n", romNum[8], romNum[8]*Integer.parseInt(rom40[0][4]) ); // ���ϰ��̶� ����, ���� ����
								System.out.printf(" �հ� ������ = ��%d �Դϴ�. \n", romNum[7]*Integer.parseInt(rom20[0][4])+ romNum[8]*Integer.parseInt(rom40[0][4]) ); // ���ϰ��̶� ����, ���� ����

								break;
		
							case 3:
								String changRom = null;
								int changeMoney = 0;
								
								System.out.println("== ���� ��Ȳǥ 20���� ==");
								for(int i=0; i<rom20.length; i++) 	// 20�� üũ	
									System.out.printf("%sȣ : %s�� \n", rom20[i][1], rom20[i][4]);   // 1���̶� ��ȣ ����

								System.out.println("== ���� ��Ȳǥ 40���� ==");
								for(int i=0; i<rom40.length; i++) 	// 40�� üũ		
									System.out.printf("%sȣ : %s�� \n", rom40[i][1], rom40[i][4]);   // 1���̶� ��ȣ ����

								System.out.println("������ ������ ȣ���� ������ �ּ��� ex) 101 >");
								changRom = scan.next();
								
								// �������� �ǵ��
								
								for(int i=0; i<rom20.length; i++) {	// 20�� üũ	
									if( rom20[i][1].equals(changRom) ) {
										System.out.printf("������ ������ %s �Դϴ�. ���氡���� �Է��ϼ��� >", rom20[i][4] );
										System.out.println("����� ������ �˷��ּ���. >");
										changeMoney = scan.nextInt();
										rom20[i][4] = Integer.toString(changeMoney);
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40�� üũ		
									if( rom40[i][1].equals(changRom) ) {
										System.out.printf("������ ������ %s �Դϴ�. ���氡���� �Է��ϼ��� >", rom40[i][4] );
										System.out.println("����� ������ �˷��ּ���. >");
										changeMoney = scan.nextInt();
										rom40[i][4] = Integer.toString(changeMoney);
									}
								}
								
								break;
								
								// rom20[0][0] count, rom20[0][1] ȣ��, rom20[0][2] ��뿩��
		                        // rom20[0][3] ���̸�, rom20[0][4] ����, rom20[0][5] ������̸�
                                // rom20[0][6] ������ȣ	, rom20[0][7]�ο��� 	
								
							case 4:
								String changRomName = null;
								String chageName = null;
								
								System.out.println("== 20���� �� �̸� ==");
								for(int i=0; i<rom20.length; i++) 	// 20�� üũ	
									System.out.printf("%s %s", rom20[i][1], rom20[i][3]);   // 1���̶� ��ȣ ����

								System.out.println("== ���� ��Ȳǥ 40���� ==");
								for(int i=0; i<rom40.length; i++) 	// 40�� üũ		
									System.out.printf("%s %s", rom40[i][1], rom20[i][3]);   // 1���̶� ��ȣ ����

								System.out.println("�̸��� ������ ȣ���� ������ �ּ��� ex) 101 >");
								changRom = scan.next();
								
								// �������� �ǵ��
								
								for(int i=0; i<rom20.length; i++) {	// 20�� üũ	
									if( rom20[i][1].equals(changRomName) ) {
										System.out.println("������ �̸� �Է� >");
										chageName = scan.next();
										rom20[i][3] = null;
										rom20[i][3] = chageName;
										System.out.printf("%s ȣ�� �̸��� ��%s�ڷ� ����Ǿ����ϴ�. \n", rom20[i][1], rom20[i][3] );
									}
								}	
								
								for(int i=0; i<rom40.length; i++) {	// 40�� üũ		
									if( rom40[i][1].equals(changRomName) ) {
										System.out.println("������ �̸� �Է� >");
										chageName = scan.next();
										rom40[i][3] = null;
										rom40[i][3] = chageName;
										System.out.printf("%s ȣ�� �̸��� ��%s�ڷ� ����Ǿ����ϴ�. \n", rom40[i][1], rom40[i][3] );
									}
								}								
								break;
								
							case 5:
								
								break;
								
							case 9:
								adminOnOff = 2;
								
								// ��Ȳ�� ����
								System.out.println("                ������Ȳ��                    "); 
								System.out.println("===============================================");
								System.out.println("                   -- 20�� --                      ");
								for(int i=0; i< rom20.length; i++) { // �ο��� // 
									System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom20[i][1], rom20[i][3], rom20[i][2], rom20[i][7]);
									if( (i+1)%2 == 0) {
										System.out.println();
										for(int j=0; j<2; j++) {
										System.out.printf("       ���� : %s��           ", rom20[i][4]);					
									   }
										System.out.println();
									}
								}
								System.out.println("                   -- 40�� --                      ");
								for(int i=0; i< rom20.length; i++) {
									System.out.printf(" %sȣ (%s) ����(%s_Max %s)  ", rom40[i][1], rom40[i][3], rom40[i][2], rom40[i][7]);
									if( (i+1)%2 == 0) {
										System.out.println();
										for(int j=0; j<2; j++) {
										System.out.printf("       ���� : %s��           ", rom40[i][4]);					
									   }
										System.out.println();
									}
								}
								System.out.println();                                            
								System.out.println("     ====== �Ʒ� �޴��� ���ؼ� �������ּ��� =====      ");
								System.out.println("1. ��ȲȮ��     2. ���� �ϱ�     3. ���� ���");
								System.out.println("              8. ������        9. ����");
								// ��Ȳ�� ����
								
								System.out.println("������ ��尡 �����˴ϴ�.. �����մϴ�.");								
								break;

							default:
								System.out.println("�������� ������ �ƴմϴ�. �ٽ� ������ �ּ��� ");
								break;
							}
							
							
							
						} // end of ������
					} // emd of ������ ��ȣ ���� if
					
					else {
						System.out.println("������ ��尡 ���� �˴ϴ�.");
					}
					
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
