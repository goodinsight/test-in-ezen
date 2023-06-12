package ch5;

import java.util.Scanner;

public class ArrayTest2_2 {
	public static void main(String[] args) {
//	5type 동물이름 입력하고 출력하기
		String[] zoo = new String[5];

		for (int i = 0; i < zoo.length; i++) {
			System.out.print("동물원에 " + (i + 1) + "번째 넣을 동물을 입력하세요: ");
			Scanner scan = new Scanner(System.in);
			zoo[i] = scan.next();
		}

		System.out.println();
		
		for (int i = 0; i < zoo.length; i++) {
			System.out.println("동물원의 " + (i + 1) + "번째 동물은: " + zoo[i]);
		}
	}
}
