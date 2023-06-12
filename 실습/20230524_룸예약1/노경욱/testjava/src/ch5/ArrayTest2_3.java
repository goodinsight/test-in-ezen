package ch5;

import java.util.Scanner;

public class ArrayTest2_3 {
	public static void main(String[] args) {
		int all = 5;
		String[] name = new String[all];
		String[] hobby = new String[all];
		String[] blood = new String[all];

		for (int i = 0; i < all; i++) {
			System.out.print((i + 1) + "번째 친구의 이름을 입력해세요: ");
			Scanner scan1 = new Scanner(System.in);
			name[i] = scan1.next();

			System.out.print((i + 1) + "번째 친구의 취미를 입력해주세요: ");
			Scanner scan2 = new Scanner(System.in);
			hobby[i] = scan2.next();

			System.out.println((i + 1) + "번째 친구의 혈액형을 입력해주세요: ");
			Scanner scan3 = new Scanner(System.in);
			blood[i] = scan3.next();
		}

		for (int i = 0; i < all; i++) {
			System.out.println((i + 1) + "번째 친구의 이름은 " + name[i]);
			System.out.println((i + 1) + "번째 친구의 취미는 " + hobby[i]);
			System.out.println((i + 1) + "번째 친구의 혈액형은 " + blood[i]+"형\n");
		}
	}
}
