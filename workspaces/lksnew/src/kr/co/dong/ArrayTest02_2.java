package kr.co.dong;

import java.util.Scanner;

public class ArrayTest02_2 {
	public static void main(String[] args) {
		
//		5type ���� �̸� �Է��ϰ� ����ϱ�
		String[] animal = null;
		Scanner scan = null;
		int num = 5;
		
		animal = new String[num];
		scan = new Scanner(System.in);
		
		for (int i = 0; i < animal.length; i++) {
			System.out.println(i +"�� ���� �Է� : ");
			animal[i] = scan.nextLine();
		}
	
		for (int i = 0; i < animal.length; i++) {
			System.out.println("animal[" + i + "] = " + animal[i]);
		}
	}
}
