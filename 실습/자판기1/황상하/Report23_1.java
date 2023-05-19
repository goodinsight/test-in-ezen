package checkPoint;

import java.util.Scanner;

public class Report23 {

	public static void main(String[] args) {
		// 1. 음료 자판기를 구현하자.
		// 2. 음료 3종ㅇ류 종류 / 가격별도 / 재고수
		// 3. 시작과 동시에 화면에 메뉴를 보여준다
		// 3-1.음료의 종류 와 가격 , 재고수, 거스름돈 반환/ 돈입력 등
		// (99. 자판기 종료)
		// 4. 99이외의 숫자인 경우 화면메뉴 보여주기.

		boolean power = false; // 전원
		// 메뉴 입력값, 받은 돈, 음료이름1/2/3, 가격 1/2/3, 거스름돈
		int button = 0;
		int money = 0;
		int change = 0;
		String drink1 = "coca zero";
		String drink2 = "pepsi zero";
		String drink3 = "cidar zero";
		int drink1_s = 10;
		int drink2_s = 9;
		int drink3_s = 8;
		int drink1_m = 1000;
		int drink2_m = 2000;
		int drink3_m = 3000;

		Scanner scan = new Scanner(System.in);

		while (!power) {
			System.out.println("======================");
			System.out.println("         자판기         ");
			System.out.println("======================");
			System.out.println("     1. 음료수 확인하기　　 ");
			System.out.println("     99. 종료하기　　　　　 ");
			System.out.println("======================");
			System.out.println("   메뉴를 선택해 주세요 : ");
			button = scan.nextInt();
			
			while (button != 99) {				
				if (button == 1) {
					System.out.println("=============================");
					System.out.printf("%s(%d원) / 재고량(%d개)\n", drink1, drink1_m, drink1_s);
					System.out.printf("%s(%d원) / 재고량(%d개)\n", drink2, drink2_m, drink2_s);
					System.out.printf("%s(%d원) / 재고량(%d개)\n", drink3, drink3_m, drink3_s);
					System.out.println("=============================");
					System.out.println("        1. 금액 투입하기         ");
					System.out.println("        99. 종료 하기           ");
					System.out.println("=============================");
					System.out.println("      메뉴를 선택해 주세요 :       ");
					button = scan.nextInt();
					if (button == 1) {
						System.out.println("=========================");
						System.out.println("   투입할 금액을 입력해주세요 :      ");
						System.out.println("=========================");
						money += scan.nextInt();

						while (button != 99) {
							System.out.println("=============================");
							System.out.printf("      현재 잔액 : %d원\n", money);
							System.out.println("=============================");
							System.out.printf("1. %s(%d원) / 재고량(%d개)\n", drink1, drink1_m, drink1_s);
							System.out.printf("2. %s(%d원) / 재고량(%d개)\n", drink2, drink2_m, drink2_s);
							System.out.printf("3. %s(%d원) / 재고량(%d개)\n", drink3, drink3_m, drink3_s);
							System.out.println("4. 금액 추가 투입하기");
							System.out.println("99. 종료하기 (거스름돈 반환)        ");
							System.out.println("=============================");
							System.out.println("      메뉴를 선택해 주세요 :       ");
							button = scan.nextInt();
							if (button == 1) {
								if (money >= drink1_m && drink1_s != 0) {
									money -= drink1_m;
									drink1_s -= 1;
									System.out.println("=============================");
									System.out.println("     " + drink1 + "가 나왔습니다.");
								} else if (drink1_s == 0) {
									System.out.println("=============================");
									System.out.println("          재고 부족");
									System.out.println("     다른 상품을 선택해주세요.");
								} else {
									System.out.println("=============================");
									System.out.println("          잔액 부족");
									System.out.println("      금액을 더 입력해주세요.");
								}
							} else if (button == 2) {
								if (money >= drink2_m && drink2_s != 0) {
									money -= drink2_m;
									drink2_s -= 1;
									System.out.println("=============================");
									System.out.println("     " + drink2 + "가 나왔습니다.");
								} else if (drink2_s == 0) {
									System.out.println("=============================");
									System.out.println("          재고 부족");
									System.out.println("     다른 상품을 선택해주세요.");
								} else {
									System.out.println("=============================");
									System.out.println("          잔액 부족");
									System.out.println("      금액을 더 입력해주세요.");
								}
							} else if (button == 3) {
								if (money >= drink3_m && drink3_s != 0) {
									money -= drink3_m;
									drink3_s -= 1;
									System.out.println("=============================");
									System.out.println("     " + drink3 + "가 나왔습니다.");
								} else if (drink2_s == 0) {
									System.out.println("=============================");
									System.out.println("          재고 부족");
									System.out.println("     다른 상품을 선택해주세요.");
								} else {
									System.out.println("=============================");
									System.out.println("          잔액 부족");
									System.out.println("      금액을 더 입력해주세요.");
								}
							} else if (button == 4) {
								System.out.println("=========================");
								System.out.println("   투입할 금액을 입력해주세요 :      ");
								System.out.println("=========================");
								money += scan.nextInt();
							} else if (button == 99) {
								System.out.println("=============================");
								System.out.printf("     %d원이 반납 되었습니다.\n", money);
								System.out.println("=============================");
								power = true;
							} else {
								System.out.println("=============================");
								System.out.println("     올바른 메뉴를 선택해 주세요. ");
							}
						}
					} else if (button == 99) {
						power = true;
					} else {
						System.out.println("=============================");
						System.out.println("     올바른 메뉴를 선택해 주세요. ");
						button = 1;
					}
				} else if (button == 99) {
					power = true;
				} else {
					System.out.println("======================");
					System.out.println(" 올바른 메뉴를 선택해 주세요.");
					break;
				}
			}
		}
		System.out.println("자판기 종료!!");
	}
}
