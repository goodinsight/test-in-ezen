package ch5;

import java.util.Scanner;

public class ArrayTest2_2 {
	public static void main(String[] args) {
//	5type �����̸� �Է��ϰ� ����ϱ�
		String[] zoo = new String[5];

		for (int i = 0; i < zoo.length; i++) {
			System.out.print("�������� " + (i + 1) + "��° ���� ������ �Է��ϼ���: ");
			Scanner scan = new Scanner(System.in);
			zoo[i] = scan.next();
		}

		System.out.println();
		
		for (int i = 0; i < zoo.length; i++) {
			System.out.println("�������� " + (i + 1) + "��° ������: " + zoo[i]);
		}
	}
}
