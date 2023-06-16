package kr.co.dong.vendingMachine;

import java.util.Scanner;

public class Menu implements Menuable {
	public static Scanner scan = new Scanner(System.in);
	@Override
	public void showTitle(String str) {
		// �޴��� Ÿ��Ʋ�� �����ش�
		System.out.println(topLine);
		System.out.println("                           "+str+"                         ");
		System.out.println(bottomLine);
	}

	@Override
	public String askChoice(String str) {
		// �޴����� ����� �ϰ� �ε����� ��ȯ
		System.out.println(topLine);
		System.out.println(str);
		
		return scan.nextLine();
	}

}
