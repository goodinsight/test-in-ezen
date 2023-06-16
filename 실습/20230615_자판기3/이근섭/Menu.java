package kr.co.dong.vendingMachine;

import java.util.Scanner;

public class Menu implements Menuable {
	public static Scanner scan = new Scanner(System.in);
	@Override
	public void showTitle(String str) {
		// 메뉴의 타이틀을 보여준다
		System.out.println(topLine);
		System.out.println("                           "+str+"                         ");
		System.out.println(bottomLine);
	}

	@Override
	public String askChoice(String str) {
		// 메뉴에서 고르라고 하고 인덱스를 반환
		System.out.println(topLine);
		System.out.println(str);
		
		return scan.nextLine();
	}

}
