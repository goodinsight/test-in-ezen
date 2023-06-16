//package vendingMMMM;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class vendingControl {
//	public static Scanner scan = new Scanner(System.in);
//	public static int money;
//
//	public static void main(String[] args) {
//		boolean power = true;
//		String menu = "1. coke(1500원) 2. pepsi(3000원) 3. cake(5000원)";
//
////		vending 리스트 생성
//		List<VendingMea> vending = new ArrayList<VendingMea>();
//
////		coke, pepsi, cake 생성
//		VendingMea coke = new VendingMea("coke", 20, 1500);
//		VendingMea pepsi = new VendingMea("pepsi", 20, 3000);
//		VendingMea cake = new VendingMea("cake", 20, 5000);
//
////		vending 리스트에 제품추가
//		vending.add(coke);
//		vending.add(pepsi);
//		vending.add(cake);
//		
//		System.out.println("자판기 작동 시작");
//		while (power) {
//			moneyPrint();
//			System.out.println("1. 돈입금 2. 구매 3.잔금 반환 0. 종료");
//			int sel = scan.nextInt();
//			switch (sel) {
//			case 0:
//				System.out.println("자판기를 종료합니다");
//				power = false;
//				break;
//			case 1:
//				moneyAdd();
//				break;
//			case 2:
//				viewMenu(menu);
//				int sell = scan.nextInt();
//				switch(sell) {
//				case 1: case 2: case 3:
//					sell(sell,vending);
//					break;
//				}
//				break;
//			case 3:
//				moneySubt();
//				break;
//			}
//		}
//	}
//
//
//	private static void viewMenu(String menu) {
//		System.out.println(menu);
//		
//	}
//
//
//	private static void sell(int sell, List<VendingMea> vending) {
//		VendingMea tin = vending.get(sell-1);
//		if (money < tin.getDrinkPrice()) {
//			System.out.println("잔액이 부족합니다");
//		}else {
//			System.out.println(tin.getDrinkName()+"가 제공되었습니다");
//			money -= tin.getDrinkPrice();
//		}
//	}
//
//	private static void moneySubt() {
//		System.out.println("금액을 반환합니다: " + money);
//		money = 0;
//	}
//
//	private static void moneyAdd() {
//		System.out.println("입금할 금액을 입력해주세요");
//		money += scan.nextInt();
//	}
//
//	private static void moneyPrint() {
//		System.out.println("현재 잔액은: " + money + " 입니다");
//	}
//}
