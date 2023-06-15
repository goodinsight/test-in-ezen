package VendingMachine;

import java.util.Scanner;

public class JapangiMenu {
	static Scanner sc= new Scanner(System.in);
	public static int menu() {
		System.out.println("============메뉴 보여주기===============");
		System.out.println("1.손님 보여주기");
		System.out.println("2.관리자모드 ");
		System.out.println("99. 종료하기(아직 안 만듬)");
		System.out.println("=====================================");
		int menu = sc.nextInt();
		return menu;
	}
		
}
