package ch5;

import java.util.Scanner;

public class ArrayTest02_1 {
	public static void main(String[] args) {
//	01���� �����͸� �ַܼ� �Է¹޾Ƽ� ����Ѵ�.
//	1.����
		String[] dName = null; // �迭����
		Scanner scan = null;
		int size = 4; // ũ��
//	1-1����
		dName = new String[size];
		scan = new Scanner(System.in);

//	2. �Է�
//		System.out.print("1st Drink Name : ");
//		dName[0] = scan.nextLine();
//		System.out.print("2st Drink Name : ");
//		dName[1] = scan.nextLine();
//		System.out.print("3st Drink Name : ");
//		dName[2] = scan.nextLine();
//		System.out.print("4st Drink Name : ");
//		dName[3] = scan.nextLine();

//	2-1. �Է� for������
		for (int i = 0; i < dName.length; i++) {
			System.out.println(i + 1 + "st Drink Name : ");
			dName[i] = scan.nextLine();
		}
//	3.ó��

//	4.���
//		System.out.println("1st Drink Name : " + dName[0]);
//		System.out.println("2st Drink Name : " + dName[1]);
//		System.out.println("3st Drink Name : " + dName[2]);
//		System.out.println("4st Drink Name : " + dName[3]);

//	4-1.��� for��
		for (int i = 0; i < dName.length; i++) {
			System.out.println(i + 1 + "st Drink Name : " + dName[i]);
		}
	}
}
