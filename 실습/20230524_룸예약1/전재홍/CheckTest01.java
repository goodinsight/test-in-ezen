package kr.co.dong.report.checkpoint;

import java.util.Scanner;

public class CheckTest01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 蹺陛餌о : 偌褒敘賅朝 衛濛婁 翕衛縑 爾罹 還熱氈擠 (殮溘)
		int count = 0;
		int roomNum = 101;
		String tmp = "";
//				sc.room
//				sc.room⊿ 4⊥ 弛 寞 廓��  弛 偌褒 譆渠檣錳 弛 陛問 弛
//			
		
			System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
			System.out.println("弛   撿覬啾濠 熨夢蕨擒 sys.V1 殮棲棻. 偌褒 敘賅蒂 殮溘п輿撮蹂.   弛");
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			
			System.out.println(" ﹥﹥﹥﹥ 殮溘 = ");
						
		int rooms = sc.nextInt();
		String[][] roomType = new String[rooms][3];
		String[][] pInfo = new String[rooms][2]; // 蕨擒濠 薑爾
		String tmp2 ="";
		int[][] room = new int[rooms][3];
			for(int i=0; i<room.length; i++) { 
				
				if(i%2==0){
//					 寞 謙盟蒂 2偃煎 陛薑 ц擊陽 2煎 釭斑擊陽 釭該雖陛 1檜傍 0檜傍煎 頂獐 熱 氈擊剪 偽擠
//					 寞 謙盟蒂 3偃煎 ж賊 3戲煎 釭散憮 1檜傍 2傍 0檜傍 衝戲煎 
					roomType[i][0] ="渦綰";
					room[i][1] = 2;
					room[i][2] = 50000;
				}else{
					roomType[i][0] ="お孺";
					room[i][1] = 3;
					room[i][2] = 70000;
				}

			}
			
		
		int menu = 0; // 詭景 霞殮擊 嬪п 摹樹
		boolean power = false;
					
			while(!power) {
				
				System.out.println(" 忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式成式式式式式式式式式式忖");
				System.out.println(" 弛 成 成忙式忖忙式忖忙式忖忙成忖忙忖忙忙式忖成  忙式忖忙式忖           弛  撿覬啾濠  弛");
				System.out.println(" 弛 戌成戎戍式扣忙式戎弛弛弛弛弛弛弛弛弛弛弛弛弛  忙式戎戍式扣     ＯＭ    弛  熨夢蕨擒  弛");
				System.out.println(" 弛  扛 扛 扛戌式戎戌式戎扛 扛戎戌戎戌式戎扛式戎戌式戎扛 扛           弛  sys.V1  弛");
				System.out.println(" 戍式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式扛式式式式式式式式式式扣");
				System.out.println(" 弛  1.蕨擒    2.蕨擒鏃模    3.蕨擒鼻鷓�挫�    99.蕨擒夔樂謙猿   弛");
				System.out.println(" 戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
				System.out.println(" ﹥﹥﹥﹥ 殮溘 = ");
				
				menu = sc.nextInt();
				
				switch(menu){ // 贖 詭景 
						
				case 1: // 1.蕨擒ж晦
					
					
					System.out.println(" ⑷營 蕨擒檜 陛棟и �ˊ� 跡煙殮棲棻 賃 廓寞擊 蕨擒ж衛啊蝗棲梱? 偌褒 敘賅 : " + room.length + " 褒\n");
					
					
					for(int i =0; i<room.length; i++) {// 蕨擒 罹睡 �挫�
						
						
						
						if(0 == room[i][0]){
							
							System.out.println(" 忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
							System.out.printf("   偌褒 謙盟 : " + roomType[i][0]+" 弛");
							System.out.printf(" 癱熨 薑錳 : " + room[i][1]+"檣 弛");
							System.out.printf("□%4d�� �� 陛棟 ■",(i+roomNum)); // 寞廓�� п唸
							System.out.printf(" 旎擋 : " +room[i][2]+" won \n");
							System.out.println(" 戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
							
						}else{
							System.out.println(" 忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
							System.out.printf("偌褒 謙盟 : " + roomType[i][0]);
							System.out.printf("癱熨 薑錳 : " + room[i][1]+"檣");
							System.out.printf("□%4d�� �� 碳陛 ■\n",(i+roomNum));
							System.out.printf("旎擋 : " +room[i][2]+" won");
							System.out.println(" 戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
						}
						
					}	
					
					int rv = 0; // 蕨擒й 寞 堅腦朝 滲熱
					rv = sc.nextInt(); // 寞 廓�� 摹鷗
					rv-=roomNum; // 寞 廓�ㄧ� 殮溘ж賊 斜 寞檜 摹鷗 腆 熱 氈紫煙 л
					
														
					//		sc.room⊿ 1⊥ roomType 擎 蝶お葭⑽鷓煎(臢蝶お 纂��) 弛 寞 貲蘆 弛 蕨擒濠 檜葷 厥朝 奢除 弛 蕨擒濠 с萄ア廓�� 弛
							if(0==room[rv][0]) {
							System.out.println(" "+(char)(9312) +" 蕨擒ж晦 " +(char)(9313)+ " 給嬴陛晦 ");
						
							int rvs = 0; // 摹鷗и 寞擊 蕨擒ж朝 滲熱
							rvs = sc.nextInt();
															
							switch(rvs){
								case 1:// 蕨擒ж晦陛 陛棟и �ˊ� 蕨擒ж晦
									System.out.println("渠ル 蕨擒濠 撩л婁 翱塊籀蒂 殮溘п輿撮蹂.(嗥橫噙晦掘碟)");
									pInfo[rv][0] = sc.next();
									pInfo[rv][1] = sc.next();
																								
																			
									room[rv][0] =1;
															
										System.out.println("蕨擒 腎歷蝗棲棻.");
										
										
										
										break;
										
										
									case 2:// 給嬴陛晦
										System.out.println("�ˊ� 摹鷗 �飛橉虞� 給嬴骨棲棻.");
										break;
										
									default:// 1,2 檜諼 殮溘 ц擊 陽
										System.out.println("澀跤 脹 殮溘殮棲棻.");
										break;
								}
								break;
							}
						
					
						
				case 2: // 2.鏃模ж晦
					System.out.println(" ⑷營 鏃模陛 陛棟и �ˊ� 跡煙殮棲棻 賃 廓寞擊 鏃模ж衛啊蝗棲梱?");
						
					for(int i =0; i<room.length; i++) {
						// 鏃模 陛棟 罹睡 �挫�
						if(1 == room[i][0]){							
							
							System.out.print(" "+(i+1) + " 鏃模陛棟 ");
						}else{
							System.out.print(" "+(i+1) + " 嘐 蕨擒 ");
						}
						
						
					}
					
					rv = sc.nextInt(); // 寞 廓�� 摹鷗
					rv--;
					
						if(1==room[rv][0]) {
						System.out.println(" "+(char)(9312) +" 鏃模ж晦 " +(char)(9313)+ " 給嬴陛晦 ");
					
						int rvs = 0; // 摹鷗и 寞擊 鏃模ж朝 滲熱
						rvs = sc.nextInt();
														
						switch(rvs){
							case 1:// 鏃模ж晦陛 陛棟и �ˊ� 鏃模ж晦
								System.out.println("渠ル 蕨擒濠 撩л婁 翱塊籀蒂 殮溘п輿撮蹂.(嗥橫噙晦掘碟)");
								tmp2 = sc.next();
								tmp = sc.next();
								
								if(pInfo[rv][0]==tmp2 && pInfo[rv][1]==tmp) {
									
									room[rv][0]=0;
								}
									
													
									System.out.println("蕨擒檜 鏃模 腎歷蝗棲棻.");
									break;
									
									
								case 2:// 給嬴陛晦
									System.out.println("�ˊ� 摹鷗 �飛橉虞� 給嬴骨棲棻.");
									break;
									
								default:// 1,2 檜諼 殮溘 ц擊 陽
									System.out.println("澀跤 脹 殮溘殮棲棻.");
									break;
									
							}
						}
					break;
					
				case 3:
					System.out.println(" 蕨擒 ⑷�窕� 褻�裔桭炴�.");
					
					for(int i =0; i<room.length; i++) { // 蕨擒 罹睡 �挫�
						if(0 == room[i][0]){
							System.out.print(" "+(char)(9312+i) + " 奢褒 ");
						}else{
							System.out.print(" "+(char)(9312+i) + " 蕨擒 ");
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
					System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
					System.out.println("                    婦葬濠 賅萄縑 霞殮м棲棻.                      ");
					System.out.println("                     綠塵廓�ㄧ� 殮溘п輿撮蹂.                      ");
					System.out.println("                  HINT : 虜萇檜 翱塊籀 萌濠葬                     ");
					System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
					System.out.println(" ﹥﹥﹥﹥ 殮溘 = ");	
					
					String pswd = sc.next();
					
					if("3002".equals(pswd))
						
						boolean adminpower = false; // 婦葬濠 賅萄 瞪錳
						int tmpNum = 0, swNum = 0;
						String sw = null , tmp = null;
						
						while(!adminpower) {
							
							System.out.println("﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥");
							System.out.println("﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥ Administrator Mode Activate ﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥");
							System.out.println("﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥﹥");
							System.out.println("0.晦晦薑骯 1.ヶ跡 檜葷 夥紱晦 2.營堅 褻薑. 3. 陛問褻薑 4.婦葬濠賅萄 釭陛晦");
						
								int admin=sc.nextInt();
						
								switch(admin) {// 橫萄團 詭景 蕾斬
								
								case 4:
									adminpower = true;
									System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
									System.out.println("婦葬濠 賅萄陛 謙猿腌棲棻.");
									
									break;
							
								default:
									break;
							}
								
								if(adminpower != true){
									System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
									System.out.println("晦晦蒂 營衛濛ж晦 瞪梱雖 滲唳餌о檜 盪濰腌棲棻.\n");
								}
								
								}
					
					break;
					
					
					
				case 99:
					power = true;
					System.out.println("晦晦 瞪錳檜 謙猿腌棲棻.");
					
					break;
					
				default:// 1,2 詭景 檜諼 殮溘 ц擊 陽
					System.out.println("澀跤 脹 殮溘殮棲棻.");
					break;
				
					}
				
			
				
			
			
			
			
			}

	}//main ed

}//class ed

/*


20230525 蹺陛餌о 偌褒敘賅朝 衛濛婁 翕衛縑 爾罹醜撿л (殮溘) 
		��蘿寞 廓��(熱衝戲煎 п唸)嫌 ��蘿寞 貲(諒旋/渦綰)/偌褒譆渠檣錳/陛問
		蕨擒衛 蕨擒濠 貲 /蕨擒廓�� 蛔
		婦葬濠賅萄塭湍陛 撿啾濠 賅萄



殮溘掘撩縑憮 	// menu 滲熱: 1,2,3,99蒂 殮溘嫡擠

1擊 援艇唳辦朝 寞曖 蕨擒,	 // room[寞廓�β曖 高檜 1檜賊 蕨擒鼻鷓


1-> �ˊЛ醽� 摹鷗(1~12)-> 蕨擒鼻鷓罹睡 �挫�

	>蕨擒陛棟鼻鷓-> 蕨擒褒衛->�ˊа挫�=> 詭景煎 犒敝 ->
	蕨擒碳陛鼻鷓-> �ˊЛ醽� 摹鷗(1~12) or 詭景煎 犒敝

2蒂 援艇 唳辦 蕨擒鏃模(蕨擒->奢褒), // room[寞廓�β曖 高檜 0檜賊 奢褒

2-> �ˊЛ醽ˉ掬�(1~12)-> 鏃模陛棟罹睡

	->鏃模陛棟: п渡�ˊШ� 高擊 0戲煎=> 詭景犒敝
	->鏃模碳陛: 蕨擒腎雖彊擎 寞檜塭堅 ル衛.=> 詭景犒敝

*3蒂 援艇 唳辦朝 �ˊ� �挫�, // 1檣 唳辦朝 "蕨擒脾: ≠ "0檣唳辦朝 "蕨擒陛棟≧"

99蒂 援艇 唳辦朝 Щ煎斜極謙猿.

package kr.co.dong.checkPoint;
import java.util.Scanner; // Scanner贗楚蝶蒂 碳楝菟檣棻.
rt.jar だ橾縑 氈朝 贗楚蝶菟擊 餌辨й熱 氈啪 п遽棻.

*/