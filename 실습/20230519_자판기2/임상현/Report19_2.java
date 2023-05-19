package kr.co.dong;

import java.util.Scanner;

public class Report19_2 {
	public static void main(String[] args) {
		// 선언
		int money = 0;
		String[] dName = {"사이다", "콜라", "커피"};
		int[] dPrice = {1000, 1500, 2000};
		int[] dAmount = {5, 5, 5};
		int sel1 = -1, sel2 = -1, sel3 = -1, sell = 0;
		String pwd = "admin";
		boolean admin_on = false;
		boolean power = false;
		Scanner scan = new Scanner(System.in);
		
		
		while(!power) {
			int choice = 0;
			if(dAmount[0] + dAmount[1] + dAmount[2] == 0) { // 재고확인, 재고가 0일시 거스름돈 반환 후 자판기 종료
				System.out.println("재고 소진으로 종료합니다.");
				System.out.println("거스름 돈이 반환됩니다." + money + "원 반환");
				money = 0;
				power = true;
				break;
			}
			System.out.println("=================================================================================");
			System.out.println("(1)" + dName[0] + "("+ dPrice[0] + "원), (2)" + dName[1] + "("+dPrice[1] + "원), (3)" + dName[2] + "(" + dPrice[2] + "원), (4)돈 입력, (5)거스름돈, (0)자판기 종료");
			System.out.println("=================================================================================");
			System.out.println("재고는 각 " + dName[0] + " : " + dAmount[0] +"개, " + dName[1] + " : " + dAmount[1] + "개, " + dName[2] + " : " + dAmount[2] + "개 남았습니다");
			int buy = 0;
			for(int i = 0; i < dPrice.length; i++) { // 구매 가능한 음료가 있는지 확인
				if(money > dPrice[i]) {
					buy++;
				}
			}
			if(buy <= 0) {
					System.out.println("구매 가능한 음료가 없습니다. (4)돈 입력, (5)거스름돈 받기");
			} else {
			System.out.print("구매 가능한 음료 : ");
			for(int i = 0; i < dPrice.length; i++) {
				if(money >= dPrice[i]) { // dPrice의 i 번째 인덱스 값보다 money가 큰 경우 dName 해당 인덱스의 구매 가능
					System.out.print("(" + (i+1) + ")" + dName[i] + "(" + dPrice[i] + ")");
					if((money < dPrice[i]) || !(i == 2)) {
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
			case 0: // 자판기 종료
				power = true;
				break;
			
			case 5: // 거스름돈 반환
				System.out.println(money + "원이 반환되었습니다.");
				money = 0;
				break;
				
			case 4: // 돈 투입
				System.out.print("넣을 금액을 입력해주세요 : ");
				money += scan.nextInt();
				break;
				
			case 1: case 2: case 3: // 음료 선택 시
				choice --;
				if(money >= dPrice[choice] && dAmount[choice] > 0) { // 돈이 선택한 음료의 가격 이상이며 선택한 음료의 재고가 1개 이상인지 확인
					System.out.println(dName[choice] + "가 나왔습니다.");
					money -= dPrice[choice]; // 돈에서 선택한 음료의 가격을 뺀다.
					dAmount[choice] --; // 재고 감소
				} else if(money < dPrice[choice]){ // 돈이 음료의 가격보다 적다면
					System.out.println("금액이 부족합니다.");
				} else { // 재고가 0개 이하라면
					System.out.println("재고가 부족합니다.");
				}
				
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
							for(int i = 0; i < dName.length; i++) {
								System.out.print("(" + (i+1) + ")" + dName[i]);
								if(i != dName.length-1) { // 마지막에는 ,가 나오지 않도록 하기 위해
									System.out.print(", ");
								}
							}
							System.out.println(" : ");
						
							sel2 = scan.nextInt();
							sel2--; // 인덱스와 값을 맞춰주기 위해서
						
								System.out.println(dName[sel2] +"의 재고는 : " + dAmount[sel2]);
								System.out.print("(1)추가(감소), (0)돌아가기 : ");
								sel3 = scan.nextInt();
								switch(sel3){
								case 0:
									break;
									
								case 1:
									int num = 0;
									System.out.print("추가(감소) 수량을 입력하세요 : ");
									num = scan.nextInt();
									dAmount[sel2] +=  num;
									System.out.println(dName[sel2] + "의 재고량 : " + dAmount[sel2]);
									break;
								}
								break;
						case 2:
							System.out.print("변경할 제품을 선택해주세요 ");
							for(int i = 0; i < dName.length; i++) {
								System.out.print("(" + (i+1) + ")" + dName[i]);
								if(i != dName.length-1) {
									System.out.print(", ");
								}
							}
							int change = 0;
							change = scan.nextInt();
							change--; // 인덱스와 값을 맞춰주기 위해서
							int num = 0;
							System.out.print("(1)제품변경, (2)가격변경 : ");
							num = scan.nextInt();
							switch (num) {
							
							case 0:
								break;
								
							case 1:
								System.out.print("변경할 제품명을 입력해주세요 : ");
								String name = scan.next();
								System.out.println(dName[change] +"가 " + name + "으로 변경되었습니다.");
								dName[change] = name;
								break;
									
							case 2:
								int price = 0;
								System.out.print("변경할 가격을 입력해주세요 : ");
								price = scan.nextInt();
								System.out.println(dName[change] +"의 가격이 " + dName[change] + "원에서 " + price + "원으로 변경되었습니다.");
								dPrice[change] = price;
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
				}
			default:
				break;
			}
		}
		scan.close();
		System.out.println("자판기 종료.");
	}
}
