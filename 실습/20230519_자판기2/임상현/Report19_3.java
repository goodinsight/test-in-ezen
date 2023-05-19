package kr.co.dong;

import java.util.Scanner;

public class Report19_3 {
	public static void main(String[] args) {
		String[][] menu = {{"사이다", "1000", "5"}, {"콜라", "1500", "5"}, {"커피", "2000", "5"}}; // 배열을 이중으로 사용하여 인덱스를 속성처럼 사용
		// 각 [][0] : 이름, [][1] : 가격, [][2] : 재고
		String pwd = "admin";
		int money = 0;
		int sel1 = -1, sel2 = -1, sel3 = -1, sell = 0;
		boolean power = false;
		boolean admin_on = false;
		Scanner scan = new Scanner(System.in);
		
		while(!power) {
			int choice = 0;
			int sumAmount = 0;
			for(int i = 0; i < menu.length; i++) {
				sumAmount += Integer.parseInt(menu[i][2]); // menu[i][2]는 String형이기 때문에 int형으로 변환을 위한 Integer.parseInt 사용
			}
			if(sumAmount == 0) {
				System.out.println("재고 소진으로 종료합니다.");
				System.out.println("거스름 돈이 반환됩니다." + money + "원 반환");
				money = 0;
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			for(int i = 0; i < menu.length; i++) {
			System.out.print("(" + (i+1) + ")" + menu[i][0] + "("+ menu[i][1] + "원), ");
			}
					System.out.println("(4)돈 입력, (5)거스름돈, (0)자판기 종료");
			System.out.print("재고는 : ");
			for(int i = 0; i < menu.length; i++) {
			System.out.print(menu[i][0] + " : " + menu[i][2] +"개");
				if(i != 2) {
					System.out.print(", ");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("입니다");
			System.out.println("=================================================================================");
			System.out.println("남은 금액은 : " + money +"원 입니다.");

			int buyMenu = 0;
			for(int i = 0; i < menu.length; i++) {
				if(money > Integer.parseInt(menu[i][1])) {
					buyMenu++; // 구매할 수 있는 음료가 있다면 buyMenu++, 구매할 음료가 없다면 0
			}
			}
			if(buyMenu <= 0) {
				System.out.println("구매 가능한 음료가 없습니다. (4)돈 입력, (5)거스름돈 받기");
			} else { // buyMenu가 0일 경우
				System.out.print("구매 가능한 음료 : ");
				for(int i = 0; i < menu.length; i++) {
					if(money > Integer.parseInt(menu[i][1])) {
						System.out.print("(" + (i+1) + ")" + menu[i][0] + "(" + menu[i][1] + ")");
					}
					if(i != menu.length-1) {
						System.out.print(", ");
					}		
				}
				System.out.println();
			} // end of else
			System.out.print("번호를 입력하세요 : ");
			choice = scan.nextInt();
			
			switch (choice) {
			case 0:
				power = true;
				break;
			
			case 5:
				System.out.println(money + "원이 반환되었습니다.");
				money = 0;
				break;
				
			case 4:
				System.out.print("넣을 금액을 입력해주세요 : ");
				money += scan.nextInt();
				break;
				
			case 1: case 2: case 3:
				choice --;
				if(money >= Integer.parseInt(menu[choice][1]) && Integer.parseInt(menu[choice][2]) > 0) {
					System.out.println(menu[choice][0] + "가 나왔습니다.");
					money -= Integer.parseInt(menu[choice][1]);
					menu[choice][2] = String.valueOf(Integer.parseInt(menu[choice][2]) - 1); // menu[choice][2]의 연산을 위해 parseInt 사용 후 String형 배열에 다시 넣기 위한 valoueOf 사용
					sell += Integer.parseInt(menu[choice][1]);
				} else if(money < Integer.parseInt(menu[choice][1])){
					System.out.println("금액이 부족합니다.");
				} else {
					System.out.println("재고가 부족합니다.");
				}
				break;
				// 관리자 모드
			case 77:
				String input = null;
				System.out.print("비밀번호(초기 비밀번호는 admin입니다.) : ");
				input = scan.next();
				if(!(pwd.equals(input))) {
					System.out.println("비밀번호가 틀립니다.");
				} else {
					admin_on = false;
					while(!admin_on) {
						
						System.out.print("(1)재고관리, (2)제품(가격)변경, (3)수익금, (4)비밀번호 변경, (0)돌아가기 : ");
						sel1 = scan.nextInt();
						
						switch (sel1) {
						
						case 0:
							admin_on = true;
							break;
						
						case 1:
							System.out.print("재고관리 : ");
							for(int i = 0; i < menu.length; i++) {
								System.out.print("(" + (i+1) + ")" + menu[i][0]);
								if(i != menu.length-1) {
									System.out.print(", ");
								}
							}
							System.out.println(" : ");
						
							sel2 = scan.nextInt();
							sel2--;
								System.out.println(menu[sel2][0] +"의 재고는 : " + menu[sel2][2]);
								System.out.print("(1)추가(감소), (0)돌아가기 : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
									
								case 1:
									int num = 0;
									System.out.print("추가(감소) 수량을 입력하세요 : ");
									num = scan.nextInt();
									menu[sel2][2] = String.valueOf((Integer.parseInt(menu[sel2][2])) + num);
									System.out.println(menu[sel2][0] + "의 재고량 : " + menu[sel2][2]);
									break;
								}
								break;
						case 2:
							System.out.print("변경할 제품을 선택해주세요 ");
							for(int i = 0; i < menu.length; i++) {
								System.out.print("(" + (i+1) + ")" + menu[i][0]);
								if(i != menu.length-1) {
									System.out.print(", ");
								}
							}
							int change = 0;
							change = scan.nextInt();
							change--;
							int num = 0;
							System.out.print("(1)제품변경, (2)가격변경 : ");
							num = scan.nextInt();
							switch (num) {
							
							case 0:
								break;
								
							case 1:
								System.out.print("변경할 제품명을 입력해주세요 : ");
								String name = scan.next();
								System.out.println(menu[change][0] +"가 " + name + "으로 변경되었습니다.");
								menu[change][0] = name; 
								break;
									
							case 2:
								int price = 0;
								System.out.print("변경할 가격을 입력해주세요 : ");
								price = scan.nextInt();
								System.out.println(menu[change][0] +"의 가격이 " + menu[change][1] + "원에서 " + price + "원으로 변경되었습니다.");
								menu[change][2] = String.valueOf(price);
								break;
							}
							break;
							
						case 3:
							System.out.println("수익금 : " + sell + "원");
							break;
							
						case 4:
							System.out.print("변경할 비밀번호 : ");
							String npwd = scan.next();
							pwd = npwd;
							break;
							
						default:
							System.out.println("잘못된 입력값입니다.");
							break;
						} // switch1
					} // while(!admin_on)
				}// else
			default:
				break;
			}
		}
		scan.close();
	}
}
