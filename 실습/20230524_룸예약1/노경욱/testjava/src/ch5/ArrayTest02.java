package ch5;

import java.util.Scanner;

public class ArrayTest02 {
	public static void main(String[] args) {
//		01���� �����͸� �ַܼ� �Է¹޾Ƽ� ����Ѵ�.
		String[] dName = new String[4];

		for (int i = 0; i < dName.length; i++) {
			System.out.print("dName[" + i + "]�� ���� ���� �Է��Ͻÿ�: ");
			Scanner scan = new Scanner(System.in);
			dName[i] = scan.next();
			System.out.println();
		}

		for (int i = 0; i < dName.length; i++) {
			System.out.println("dName[" + i + "] = " + dName[i]);
		}
	}
}
