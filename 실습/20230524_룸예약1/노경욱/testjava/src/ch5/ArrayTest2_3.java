package ch5;

import java.util.Scanner;

public class ArrayTest2_3 {
	public static void main(String[] args) {
		int all = 5;
		String[] name = new String[all];
		String[] hobby = new String[all];
		String[] blood = new String[all];

		for (int i = 0; i < all; i++) {
			System.out.print((i + 1) + "��° ģ���� �̸��� �Է��ؼ���: ");
			Scanner scan1 = new Scanner(System.in);
			name[i] = scan1.next();

			System.out.print((i + 1) + "��° ģ���� ��̸� �Է����ּ���: ");
			Scanner scan2 = new Scanner(System.in);
			hobby[i] = scan2.next();

			System.out.println((i + 1) + "��° ģ���� �������� �Է����ּ���: ");
			Scanner scan3 = new Scanner(System.in);
			blood[i] = scan3.next();
		}

		for (int i = 0; i < all; i++) {
			System.out.println((i + 1) + "��° ģ���� �̸��� " + name[i]);
			System.out.println((i + 1) + "��° ģ���� ��̴� " + hobby[i]);
			System.out.println((i + 1) + "��° ģ���� �������� " + blood[i]+"��\n");
		}
	}
}
