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
//		String menu = "1. coke(1500��) 2. pepsi(3000��) 3. cake(5000��)";
//
////		vending ����Ʈ ����
//		List<VendingMea> vending = new ArrayList<VendingMea>();
//
////		coke, pepsi, cake ����
//		VendingMea coke = new VendingMea("coke", 20, 1500);
//		VendingMea pepsi = new VendingMea("pepsi", 20, 3000);
//		VendingMea cake = new VendingMea("cake", 20, 5000);
//
////		vending ����Ʈ�� ��ǰ�߰�
//		vending.add(coke);
//		vending.add(pepsi);
//		vending.add(cake);
//		
//		System.out.println("���Ǳ� �۵� ����");
//		while (power) {
//			moneyPrint();
//			System.out.println("1. ���Ա� 2. ���� 3.�ܱ� ��ȯ 0. ����");
//			int sel = scan.nextInt();
//			switch (sel) {
//			case 0:
//				System.out.println("���Ǳ⸦ �����մϴ�");
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
//			System.out.println("�ܾ��� �����մϴ�");
//		}else {
//			System.out.println(tin.getDrinkName()+"�� �����Ǿ����ϴ�");
//			money -= tin.getDrinkPrice();
//		}
//	}
//
//	private static void moneySubt() {
//		System.out.println("�ݾ��� ��ȯ�մϴ�: " + money);
//		money = 0;
//	}
//
//	private static void moneyAdd() {
//		System.out.println("�Ա��� �ݾ��� �Է����ּ���");
//		money += scan.nextInt();
//	}
//
//	private static void moneyPrint() {
//		System.out.println("���� �ܾ���: " + money + " �Դϴ�");
//	}
//}
