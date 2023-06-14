package kr.co.dong.shopping;

import java.util.Scanner;

public class Etc {
	static Scanner scan = new Scanner(System.in);
	
	public static String inputMS(String msg) {
		System.out.print(msg);
		return scan.next();
	}
	public static int inputMD(String msg) {
		System.out.print(msg);
		return scan.nextInt();
	}
}
