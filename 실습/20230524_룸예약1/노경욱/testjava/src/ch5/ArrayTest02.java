package ch5;

import java.util.Scanner;

public class ArrayTest02 {
	public static void main(String[] args) {
//		01번의 데이터를 콘솔로 입력받아서 출력한다.
		String[] dName = new String[4];

		for (int i = 0; i < dName.length; i++) {
			System.out.print("dName[" + i + "]에 넣을 값을 입력하시오: ");
			Scanner scan = new Scanner(System.in);
			dName[i] = scan.next();
			System.out.println();
		}

		for (int i = 0; i < dName.length; i++) {
			System.out.println("dName[" + i + "] = " + dName[i]);
		}
	}
}
