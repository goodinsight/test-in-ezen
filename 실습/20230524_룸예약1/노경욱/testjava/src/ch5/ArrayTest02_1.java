package ch5;

import java.util.Scanner;

public class ArrayTest02_1 {
	public static void main(String[] args) {
//	01번의 데이터를 콘솔로 입력받아서 출력한다.
//	1.선언
		String[] dName = null; // 배열선언
		Scanner scan = null;
		int size = 4; // 크기
//	1-1생성
		dName = new String[size];
		scan = new Scanner(System.in);

//	2. 입력
//		System.out.print("1st Drink Name : ");
//		dName[0] = scan.nextLine();
//		System.out.print("2st Drink Name : ");
//		dName[1] = scan.nextLine();
//		System.out.print("3st Drink Name : ");
//		dName[2] = scan.nextLine();
//		System.out.print("4st Drink Name : ");
//		dName[3] = scan.nextLine();

//	2-1. 입력 for문으로
		for (int i = 0; i < dName.length; i++) {
			System.out.println(i + 1 + "st Drink Name : ");
			dName[i] = scan.nextLine();
		}
//	3.처리

//	4.출력
//		System.out.println("1st Drink Name : " + dName[0]);
//		System.out.println("2st Drink Name : " + dName[1]);
//		System.out.println("3st Drink Name : " + dName[2]);
//		System.out.println("4st Drink Name : " + dName[3]);

//	4-1.출력 for문
		for (int i = 0; i < dName.length; i++) {
			System.out.println(i + 1 + "st Drink Name : " + dName[i]);
		}
	}
}
