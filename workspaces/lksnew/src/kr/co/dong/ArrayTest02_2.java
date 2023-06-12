package kr.co.dong;

import java.util.Scanner;

public class ArrayTest02_2 {
	public static void main(String[] args) {
		
//		5type 동물 이름 입력하고 출력하기
		String[] animal = null;
		Scanner scan = null;
		int num = 5;
		
		animal = new String[num];
		scan = new Scanner(System.in);
		
		for (int i = 0; i < animal.length; i++) {
			System.out.println(i +"번 동물 입력 : ");
			animal[i] = scan.nextLine();
		}
	
		for (int i = 0; i < animal.length; i++) {
			System.out.println("animal[" + i + "] = " + animal[i]);
		}
	}
}
