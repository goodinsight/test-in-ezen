package VendingMachine;

import java.util.Scanner;

public class JapangiMenu {
	static Scanner sc= new Scanner(System.in);
	public static int menu() {
		System.out.println("============�޴� �����ֱ�===============");
		System.out.println("1.�մ� �����ֱ�");
		System.out.println("2.�����ڸ�� ");
		System.out.println("99. �����ϱ�(���� �� ����)");
		System.out.println("=====================================");
		int menu = sc.nextInt();
		return menu;
	}
		
}
