/*
 * Ư�����ڿ� Ƚ���� �Է¹޾Ƽ� �� Ƚ����ŭ Ư������ �ݺ� ���
 * printView(10, "$");
 * 
 * ==>"$$$$$$$$$$"
 * 
 * printView(3,"&")
 *  ===> "&&&"
 */


package kr.co.dong.func;

import java.util.Scanner;

public class FuncTest04 {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// �޴� �����ֱ�
		// 1. �μ��� �� ���ϱ�. 2. ������ 3. �� �� ������ ���� ���ϱ�

		boolean done = false;
		int sel = 0;

		while (!done) {
			System.out.println("1. �μ��� �� ���ϱ� 2. ������ 3. �� �� ���� ������ �� ���ϱ� ");
			sel = scan.nextInt();

			switch (sel) {
			case 1:
				System.out.println("First Num : ");
				int a = scan.nextInt();
				System.out.println("Last Num : ");
				int b = scan.nextInt();
				int result = a + b;
				System.out.println(result);
				break;
			case 2:
				print99danAll();
				break;
			case 3:
				break;
			case 99:
				done = true;
			default:
				break;
			}
		}
		System.out.println("end!!");
	}

	// 1�� �Լ�
	static void add(int a, int b) {
		int result = a + b;
		System.out.println("�μ��� �� : " + result);
	}

	// 2�� �Լ�
	static void print99danAll() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + " = " + (j * i) + " ");
			}
			System.out.println();
		}
	}
	// 3�� �Լ�

}
