package kr.co.dong.report.checkpoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Ãß°¡»çÇ× : °´½Ç±Ô¸ð´Â ½ÃÀÛ°ú µ¿½Ã¿¡ º¸¿© ÁÙ¼öÀÖÀ½ (ÀÔ·Â)
		int count = 0;
		int roomNum = 101;
		String tmp = "";
//				sc.room
//				sc.room¡é 4¡æ ¦¢ ¹æ ¹øÈ£  ¦¢ °´½Ç ÃÖ´ëÀÎ¿ø ¦¢ °¡°Ý ¦¢
//			
		
			System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
			System.out.println("¦¢   ¾ßÁ»³îÀÚ ¼÷¹Ú¿¹¾à sys.V1 ÀÔ´Ï´Ù. °´½Ç ±Ô¸ð¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.   ¦¢");
			System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
			
			System.out.println(" ¡á¡á¡á¡á ÀÔ·Â = ");
						
		int rooms = sc.nextInt();
		String[][] roomType = new String[rooms][3];
		String[][] pInfo = new String[rooms][2]; // ¿¹¾àÀÚ Á¤º¸
		String tmp2 ="";
		int[][] room = new int[rooms][3];
			for(int i=0; i<room.length; i++) { 
				
				if(i%2==0){
//					 ¹æ Á¾·ù¸¦ 2°³·Î °¡Á¤ ÇßÀ»¶§ 2·Î ³ª´³À»¶§ ³ª¸ÓÁö°¡ 1ÀÌ³Ä 0ÀÌ³Ä·Î ³»º¼ ¼ö ÀÖÀ»°Å °°À½
//					 ¹æ Á¾·ù¸¦ 3°³·Î ÇÏ¸é 3À¸·Î ³ª´²¼­ 1ÀÌ³Ä 2³Ä 0ÀÌ³Ä ½ÄÀ¸·Î 
					roomType[i][0] ="´õºí";
					room[i][1] = 2;
					room[i][2] = 50000;
				}else{
					roomType[i][0] ="Æ®À©";
					room[i][1] = 3;
					room[i][2] = 70000;
				}

			}
			
		
		int menu = 0; // ¸Þ´º ÁøÀÔÀ» À§ÇØ ¼±¾ð
		boolean power = false;
					
			while(!power) {
				
				System.out.println(" ¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¨¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
				System.out.println(" ¦¢ ¦¨ ¦¨¦£¦¡¦¤¦£¦¡¦¤¦£¦¡¦¤¦£¦¨¦¤¦£¦¤¦£¦£¦¡¦¤¦¨  ¦£¦¡¦¤¦£¦¡¦¤           ¦¢  ¾ßÁ»³îÀÚ  ¦¢");
				System.out.println(" ¦¢ ¦¦¦¨¦¥¦§¦¡¦©¦£¦¡¦¥¦¢¦¢¦¢¦¢¦¢¦¢¦¢¦¢¦¢¦¢¦¢¦¢¦¢  ¦£¦¡¦¥¦§¦¡¦©     ¢Ý¢Û    ¦¢  ¼÷¹Ú¿¹¾à  ¦¢");
				System.out.println(" ¦¢  ¦ª ¦ª ¦ª¦¦¦¡¦¥¦¦¦¡¦¥¦ª ¦ª¦¥¦¦¦¥¦¦¦¡¦¥¦ª¦¡¦¥¦¦¦¡¦¥¦ª ¦ª           ¦¢  sys.V1  ¦¢");
				System.out.println(" ¦§¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦ª¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦©");
				System.out.println(" ¦¢  1.¿¹¾à    2.¿¹¾àÃë¼Ò    3.¿¹¾à»óÅÂÈ®ÀÎ    99.¿¹¾àÄÜ¼ÖÁ¾·á   ¦¢");
				System.out.println(" ¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
				System.out.println(" ¡á¡á¡á¡á ÀÔ·Â = ");
				
				menu = sc.nextInt();
				
				switch(menu){ // Å« ¸Þ´º 
						
				case 1: // 1.¿¹¾àÇÏ±â
					
					
					System.out.println(" ÇöÀç ¿¹¾àÀÌ °¡´ÉÇÑ È£½Ç ¸ñ·ÏÀÔ´Ï´Ù ¸î ¹ø¹æÀ» ¿¹¾àÇÏ½Ã°Ú½À´Ï±î? °´½Ç ±Ô¸ð : " + room.length + " ½Ç\n");
					
					
					for(int i =0; i<room.length; i++) {// ¿¹¾à ¿©ºÎ È®ÀÎ
						
						
						
						if(0 == room[i][0]){
							
							System.out.println(" ¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
							System.out.printf("   °´½Ç Á¾·ù : " + roomType[i][0]+" ¦¢");
							System.out.printf(" Åõ¼÷ Á¤¿ø : " + room[i][1]+"ÀÎ ¦¢");
							System.out.printf("¡¼%4dÈ£ £ü °¡´É ¡½",(i+roomNum)); // ¹æ¹øÈ£ ÇØ°á
							System.out.printf(" ±Ý¾× : " +room[i][2]+" won \n");
							System.out.println(" ¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
							
						}else{
							System.out.println(" ¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
							System.out.printf("°´½Ç Á¾·ù : " + roomType[i][0]);
							System.out.printf("Åõ¼÷ Á¤¿ø : " + room[i][1]+"ÀÎ");
							System.out.printf("¡¼%4dÈ£ £ü ºÒ°¡ ¡½\n",(i+roomNum));
							System.out.printf("±Ý¾× : " +room[i][2]+" won");
							System.out.println(" ¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
						}
						
					}	
					
					int rv = 0; // ¿¹¾àÇÒ ¹æ °í¸£´Â º¯¼ö
					rv = sc.nextInt(); // ¹æ ¹øÈ£ ¼±ÅÃ
					rv-=roomNum; // ¹æ ¹øÈ£¸¦ ÀÔ·ÂÇÏ¸é ±× ¹æÀÌ ¼±ÅÃ µÉ ¼ö ÀÖµµ·Ï ÇÔ
					
														
					//		sc.room¡é 1¡æ roomType Àº ½ºÆ®¸µÇüÅÂ·Î(ÅØ½ºÆ® Ä¡È¯) ¦¢ ¹æ ¸íÄª ¦¢ ¿¹¾àÀÚ ÀÌ¸§ ³Ö´Â °ø°£ ¦¢ ¿¹¾àÀÚ ÇÚµåÆù¹øÈ£ ¦¢
							if(0==room[rv][0]) {
							System.out.println(" "+(char)(9312) +" ¿¹¾àÇÏ±â " +(char)(9313)+ " µ¹¾Æ°¡±â ");
						
							int rvs = 0; // ¼±ÅÃÇÑ ¹æÀ» ¿¹¾àÇÏ´Â º¯¼ö
							rvs = sc.nextInt();
															
							switch(rvs){
								case 1:// ¿¹¾àÇÏ±â°¡ °¡´ÉÇÑ È£½Ç ¿¹¾àÇÏ±â
									System.out.println("´ëÇ¥ ¿¹¾àÀÚ ¼ºÇÔ°ú ¿¬¶ôÃ³¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.(¶ç¾î¾²±â±¸ºÐ)");
									pInfo[rv][0] = sc.next();
									pInfo[rv][1] = sc.next();
																								
																			
									room[rv][0] =1;
															
										System.out.println("¿¹¾à µÇ¾ú½À´Ï´Ù.");
										
										
										
										break;
										
										
									case 2:// µ¹¾Æ°¡±â
										System.out.println("È£½Ç ¼±ÅÃ È­¸éÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
										break;
										
									default:// 1,2 ÀÌ¿Ü ÀÔ·Â ÇßÀ» ¶§
										System.out.println("Àß¸ø µÈ ÀÔ·ÂÀÔ´Ï´Ù.");
										break;
								}
								break;
							}
						
					
						
				case 2: // 2.Ãë¼ÒÇÏ±â
					System.out.println(" ÇöÀç Ãë¼Ò°¡ °¡´ÉÇÑ È£½Ç ¸ñ·ÏÀÔ´Ï´Ù ¸î ¹ø¹æÀ» Ãë¼ÒÇÏ½Ã°Ú½À´Ï±î?");
						
					for(int i =0; i<room.length; i++) {
						// Ãë¼Ò °¡´É ¿©ºÎ È®ÀÎ
						if(1 == room[i][0]){							
							
							System.out.print(" "+(i+1) + " Ãë¼Ò°¡´É ");
						}else{
							System.out.print(" "+(i+1) + " ¹Ì ¿¹¾à ");
						}
						
						
					}
					
					rv = sc.nextInt(); // ¹æ ¹øÈ£ ¼±ÅÃ
					rv--;
					
						if(1==room[rv][0]) {
						System.out.println(" "+(char)(9312) +" Ãë¼ÒÇÏ±â " +(char)(9313)+ " µ¹¾Æ°¡±â ");
					
						int rvs = 0; // ¼±ÅÃÇÑ ¹æÀ» Ãë¼ÒÇÏ´Â º¯¼ö
						rvs = sc.nextInt();
														
						switch(rvs){
							case 1:// Ãë¼ÒÇÏ±â°¡ °¡´ÉÇÑ È£½Ç Ãë¼ÒÇÏ±â
								System.out.println("´ëÇ¥ ¿¹¾àÀÚ ¼ºÇÔ°ú ¿¬¶ôÃ³¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.(¶ç¾î¾²±â±¸ºÐ)");
								tmp2 = sc.next();
								tmp = sc.next();
								
								if(pInfo[rv][0]==tmp2 && pInfo[rv][1]==tmp) {
									
									room[rv][0]=0;
								}
									
													
									System.out.println("¿¹¾àÀÌ Ãë¼Ò µÇ¾ú½À´Ï´Ù.");
									break;
									
									
								case 2:// µ¹¾Æ°¡±â
									System.out.println("È£½Ç ¼±ÅÃ È­¸éÀ¸·Î µ¹¾Æ°©´Ï´Ù.");
									break;
									
								default:// 1,2 ÀÌ¿Ü ÀÔ·Â ÇßÀ» ¶§
									System.out.println("Àß¸ø µÈ ÀÔ·ÂÀÔ´Ï´Ù.");
									break;
									
							}
						}
					break;
					
				case 3:
					System.out.println(" ¿¹¾à ÇöÈ²À» Á¶È¸ÇÕ´Ï´Ù.");
					
					for(int i =0; i<room.length; i++) { // ¿¹¾à ¿©ºÎ È®ÀÎ
						if(0 == room[i][0]){
							System.out.print(" "+(char)(9312+i) + " °ø½Ç ");
						}else{
							System.out.print(" "+(char)(9312+i) + " ¿¹¾à ");
						}
						count++;
						if(count%5==0) {
							System.out.println();
							System.out.println();
						}
					}
					System.out.println();
					
					
					break;
					
				case 77:
					System.out.println("¦£¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¤");
					System.out.println("                    °ü¸®ÀÚ ¸ðµå¿¡ ÁøÀÔÇÕ´Ï´Ù.                      ");
					System.out.println("                     ºñ¹Ð¹øÈ£¸¦ ÀÔ·ÂÇØÁÖ¼¼¿ä.                      ");
					System.out.println("                  HINT : ¸¸µçÀÌ ¿¬¶ôÃ³ µÞÀÚ¸®                     ");
					System.out.println("¦¦¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¥");
					System.out.println(" ¡á¡á¡á¡á ÀÔ·Â = ");	
					
					String pswd = sc.next();
					
					if("3002".equals(pswd))
						
						boolean adminpower = false; // °ü¸®ÀÚ ¸ðµå Àü¿ø
						int tmpNum = 0, swNum = 0;
						String sw = null , tmp = null;
						
						while(!adminpower) {
							
							System.out.println("¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á");
							System.out.println("¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á Administrator Mode Activate ¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á");
							System.out.println("¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á¡á");
							System.out.println("0.±â±âÁ¤»ê 1.Ç°¸ñ ÀÌ¸§ ¹Ù²Ù±â 2.Àç°í Á¶Á¤. 3. °¡°ÝÁ¶Á¤ 4.°ü¸®ÀÚ¸ðµå ³ª°¡±â");
						
								int admin=sc.nextInt();
						
								switch(admin) {// ¾îµå¹Î ¸Þ´º Á¢±Ù
								
								case 4:
									adminpower = true;
									System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
									System.out.println("°ü¸®ÀÚ ¸ðµå°¡ Á¾·áµË´Ï´Ù.");
									
									break;
							
								default:
									break;
							}
								
								if(adminpower != true){
									System.out.println("¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡¦¡");
									System.out.println("±â±â¸¦ Àç½ÃÀÛÇÏ±â Àü±îÁö º¯°æ»çÇ×ÀÌ ÀúÀåµË´Ï´Ù.\n");
								}
								
								}
					
					break;
					
					
					
				case 99:
					power = true;
					System.out.println("±â±â Àü¿øÀÌ Á¾·áµË´Ï´Ù.");
					
					break;
					
				default:// 1,2 ¸Þ´º ÀÌ¿Ü ÀÔ·Â ÇßÀ» ¶§
					System.out.println("Àß¸ø µÈ ÀÔ·ÂÀÔ´Ï´Ù.");
					break;
				
					}
				
			
				
			
			
			
			
			}

	}//main ed

}//class ed

/*


20230525 Ãß°¡»çÇ× °´½Ç±Ô¸ð´Â ½ÃÀÛ°ú µ¿½Ã¿¡ º¸¿©Áà¾ßÇÔ (ÀÔ·Â) 
		È£ÅÚ¹æ ¹øÈ£(¼ö½ÄÀ¸·Î ÇØ°á)¶û È£ÅÚ¹æ ¸í(½Ì±Û/´õºí)/°´½ÇÃÖ´ëÀÎ¿ø/°¡°Ý
		¿¹¾à½Ã ¿¹¾àÀÚ ¸í /¿¹¾à¹øÈ£ µî
		°ü¸®ÀÚ¸ðµå¶ó´ø°¡ ¾ß³îÀÚ ¸ðµå



ÀÔ·Â±¸¼º¿¡¼­ 	// menu º¯¼ö: 1,2,3,99¸¦ ÀÔ·Â¹ÞÀ½

1À» ´©¸¥°æ¿ì´Â ¹æÀÇ ¿¹¾à,	 // room[¹æ¹øÈ£]ÀÇ °ªÀÌ 1ÀÌ¸é ¿¹¾à»óÅÂ


1-> È£½Ç¹øÈ£ ¼±ÅÃ(1~12)-> ¿¹¾à»óÅÂ¿©ºÎ È®ÀÎ

	>¿¹¾à°¡´É»óÅÂ-> ¿¹¾à½Ç½Ã->È£½ÇÈ®ÀÎ=> ¸Þ´º·Î º¹±Í ->
	¿¹¾àºÒ°¡»óÅÂ-> È£½Ç¹øÈ£ ¼±ÅÃ(1~12) or ¸Þ´º·Î º¹±Í

2¸¦ ´©¸¥ °æ¿ì ¿¹¾àÃë¼Ò(¿¹¾à->°ø½Ç), // room[¹æ¹øÈ£]ÀÇ °ªÀÌ 0ÀÌ¸é °ø½Ç

2-> È£½Ç¹øÈ£¼±ÅÃ(1~12)-> Ãë¼Ò°¡´É¿©ºÎ

	->Ãë¼Ò°¡´É: ÇØ´çÈ£½ÇÀÇ °ªÀ» 0À¸·Î=> ¸Þ´ºº¹±Í
	->Ãë¼ÒºÒ°¡: ¿¹¾àµÇÁö¾ÊÀº ¹æÀÌ¶ó°í Ç¥½Ã.=> ¸Þ´ºº¹±Í

*3¸¦ ´©¸¥ °æ¿ì´Â È£½Ç È®ÀÎ, // 1ÀÎ °æ¿ì´Â "¿¹¾àµÊ: ¡Ú "0ÀÎ°æ¿ì´Â "¿¹¾à°¡´É¡Ù"

99¸¦ ´©¸¥ °æ¿ì´Â ÇÁ·Î±×·¥Á¾·á.

package kr.co.dong.checkPoint;
import java.util.Scanner; // ScannerÅ¬·¡½º¸¦ ºÒ·¯µéÀÎ´Ù.
rt.jar ÆÄÀÏ¿¡ ÀÖ´Â Å¬·¡½ºµéÀ» »ç¿ëÇÒ¼ö ÀÖ°Ô ÇØÁØ´Ù.

*/