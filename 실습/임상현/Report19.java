package kr.co.dong;

import java.util.Scanner;

public class Report19 {
	public static void main(String[] args) {
		boolean power = false;
		
		Scanner scan = new Scanner(System.in);
		boolean admin_on = false;
		String pwd = "admin";
		int juice1_sell = 0, juice2_sell = 0, juice3_sell = 0;
		int sel1 = 0, sel2 = 0, sel3 = 0;
		int money = 0, juice1_price = 1000, juice2_price = 1500, juice3_price = 2000;
		int juice1_inventory = 5, juice2_inventory = 5, juice3_inventory = 0;
		String juice1 = "사이다", juice2 = "콜라", juice3 = "커피"; 
		while(!power) {
			if(juice1_inventory + juice2_inventory + juice3_inventory == 0) {
				System.out.println("재고 소진으로 종료합니다.");
				power = true;
			}
			int choice = 0;
			System.out.println("=================================================================================");
			System.out.printf("(1)%s(%d원), (2)%s(%d원), (3)%s(%d원), (4)돈 입력, (5)거스름돈, (0)자판기 종료\n", juice1, juice1_price, juice2, juice2_price, juice3, juice3_price);
			System.out.println("=================================================================================");
			System.out.printf("재고는 각 %s : " + juice1_inventory +"개, %s : " + juice2_inventory + "개, %s : " + juice3_inventory + "개 남았습니다", juice1, juice2, juice3);
			if(money >= 2000) {
				System.out.printf("구매 가능 : (1)%s(%d원), (2)%s(%d원), (3)%s(%d원)\n", juice1, juice1_price, juice2, juice2_price, juice3, juice3_price);
			} else if(money >= 1500){
				System.out.printf("구매 가능 : (1)%s(%d원), (2)%s(%d원)\n", juice1, juice1_price, juice2, juice2_price);
			} else if(money >= 1000) {
				System.out.printf("구매 가능 : (1)%s(%d원)\n", juice1, juice1_price);
			} else if(money > 0){
				System.out.println("구매 가능한 음료가 없습니다. (4)돈 입력, (5)거스름돈 받기");
			}
			System.out.println("남은 금액은 : " + money +"원 입니다.");
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
					
				case 1:
					if(money >= juice1_price && juice1_inventory > 0) {
						System.out.printf("%s가 나왔습니다. \n", juice1);
						money -= juice1_price;
						juice1_inventory--;
						juice1_sell += juice1_price;
					} else if(money < juice1_price) {
						System.out.println("금액이 부족합니다.");
					} else {
						System.out.println("재고가 부족합니다.");
					} break;

				case 2:
					if(money >= juice2_price && juice2_inventory > 0) {
						System.out.printf("%s가 나왔습니다. \n", juice2);
						money -= juice2_price;
						juice2_inventory--;
						juice2_sell += juice2_price;
					} else if(money < juice2_price) {
						System.out.println("금액이 부족합니다.");
					} else {
						System.out.println("재고가 부족합니다.");
					} break;
					
				case 3:
					if(money >= juice3_price && juice3_inventory > 0) {
						System.out.printf("%s가 나왔습니다. \n", juice3);
						money -= juice3_price;
						juice3_inventory--;
						juice3_sell += juice3_price;
					} else if(money < juice3_price) {
						System.out.println("금액이 부족합니다.");
					} else {
						System.out.println("재고가 부족합니다.");
					} break;
					
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
							System.out.print("재고관리 : (1)" + juice1 + " (2)" + juice2 + " (3)" + juice3 + " : ");
							sel2 = scan.nextInt();
							switch (sel2) {
							case 1:
								System.out.println(juice1 +"의 재고는 : " + juice1_inventory);
								System.out.print("(1)추가(감소), (0)돌아가기 : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
								case 1:
									int num = 0;
									System.out.print("추가(감소) 수량을 입력하세요 : ");
									num = scan.nextInt();
									juice1_inventory += num;
									System.out.println(juice1 +"의 재고량 : " + juice1_inventory);
									break;
								}
								break;
								
							case 2:
								System.out.println(juice2 +"의 재고는 : " + juice2_inventory);
								System.out.print("(1)추가(감소), (0)돌아가기 : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
								case 1:
									int num = 0;
									System.out.print("추가(감소) 수량을 입력하세요 : ");
									num = scan.nextInt();
									juice2_inventory += num;
									System.out.println(juice2 +"의 재고량 : " + juice2_inventory);
									break;
								}
								break;
								
							case 3:
								System.out.println(juice3 +"의 재고는 : " + juice3_inventory);
								System.out.print("(1)추가(감소), (0)돌아가기 : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
								case 1:
									int num = 0;
									System.out.print("추가(감소) 수량을 입력하세요 : ");
									num = scan.nextInt();
									juice3_inventory += num;
									System.out.println(juice3 +"의 재고량 : " + juice3_inventory);
									break;
								}
								break;
								
							default:
								System.out.println("잘못된 입력값입니다.");
								break;
							}
							break;
						case 2:
							System.out.print("변경할 제품을 선택해주세요 (1)" + juice1 + " (2)" + juice2 + " (3)" + juice3 + " : ");
							int num = 0;
							num = scan.nextInt();
							switch (num) {
							case 1:
								System.out.print("(1)제품변경, (2)가격변경 : ");
								num = scan.nextInt();
								switch (num) {
								case 1:
									System.out.print("변경할 제품명을 입력해주세요 : ");
									String name = scan.next();
									System.out.println(juice1 +"가 " + name + "으로 변경되었습니다.");
									juice1 = name;
									break;

								case 2:
									System.out.print("변경할 가격을 입력해주세요 : ");
									int price = scan.nextInt();
									System.out.println(juice1 +"의 가격이 " + juice1_price + "원에서 " + price + "원으로 변경되었습니다.");
									juice1_price = price;
									break;
								default:
									System.out.println("잘못된 입력입니다.");
									break;
									
								}
								break;

							case 2:
								System.out.print("(1)제품변경, (2)가격변경 : ");
								num = scan.nextInt();
								switch (num) {
								case 1:
									System.out.print("변경할 제품명을 입력해주세요 : ");
									String name = scan.next();
									System.out.println(juice2 +"가 " + name + "으로 변경되었습니다.");
									juice2 = name;
									break;

								case 2:
									System.out.print("변경할 가격을 입력해주세요 : ");
									int price = scan.nextInt();
									System.out.println(juice2 +"의 가격이 " + juice2_price + "원에서 " + price + "원으로 변경되었습니다.");
									juice2_price = price;
									break;
								default:
									System.out.println("잘못된 입력입니다.");
									break;
							}
							case 3:
								System.out.print("(1)제품변경, (2)가격변경 : ");
								num = scan.nextInt();
								switch (num) {
								case 1:
									System.out.print("변경할 제품명을 입력해주세요 : ");
									String name = scan.next();
									System.out.println(juice3 +"가 " + name + "으로 변경되었습니다.");
									juice3 = name;
									break;

								case 2:
									System.out.print("변경할 가격을 입력해주세요 : ");
									int price = scan.nextInt();
									System.out.println(juice3 +"의 가격이 " + juice3_price + "원에서 " + price + "원으로 변경되었습니다.");
									juice3_price = price;
									break;
								default:
									System.out.println("잘못된 입력입니다.");
									break;
								}
							}
							break;
							
						case 3:
							int result = juice1_sell + juice2_sell + juice3_sell;
							System.out.println("총 수익은 " + result + "원입니다.");
							break;
					
						case 4:
							System.out.print("변경할 비밀번호 : ");
							String npwd = scan.next();
							pwd = npwd;
							break;
						}
					}
			}
					//관리자 모드 끝
			default:
				break;
			}
		}
		scan.close();
		System.out.println("자판기 종료.");


		
	// 배열	
/*
		int money = 0;
		String[] juice = {"사이다", "콜라", "커피"};
		int[] price = {1000, 1500, 2000};
		int[] inventory = {5, 5, 5};
		
		while(!power) {
			int choice = 0;
			if(inventory[0] + inventory[1] + inventory[2] == 0) {
				System.out.println("재고 소진으로 종료합니다.");
				System.out.println("거스름 돈이 반환됩니다." + money + "원 반환");
				money = 0;
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			System.out.println("(1)" + juice[0] + "("+price[0] + "원), (2)" + juice[1] + "("+price[1] + "원), (3)" + juice[2] + "(" + price[2] + "원), (4)돈 입력, (5)거스름돈, (0)자판기 종료");
			System.out.println("=================================================================================");
			System.out.println("재고는 각 " + juice[0] + " : " + inventory[0] +"개, " + juice[1] + " : " + inventory[1] + "개, " + juice[2] + " : " + inventory[2] + "개 남았습니다");
			if(money < inventory[0]) {
				System.out.println("구매 가능한 음료가 없습니다. (4)돈 입력, (5)거스름돈 받기");
			} else {
				System.out.print("구매 가능한 음료 : ");
				for(int i = 0; i < price.length; i++) {
					if(money >= price[i]) {
						System.out.print("(" + (i+1) + ")" + juice[i] + "(" + price[i] + ")");
						if((money < price[i]) || !(i == 2)) {
							System.out.print(", ");
						}
					}
				}
				System.out.println();
			} // end of else
			System.out.println("남은 금액은 : " + money +"원 입니다.");
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
				if(money >= price[choice] && inventory[choice] > 0) {
					System.out.println(juice[choice] + "가 나왔습니다.");
					money -= price[choice];
					inventory[choice] --;
				} else if(money < price[choice]){
					System.out.println("금액이 부족합니다.");
				} else {
					System.out.println("재고가 부족합니다.");
				}
				
			default:
				break;
			}
		}
		System.out.println("자판기 종료.");
*/
	}
}
