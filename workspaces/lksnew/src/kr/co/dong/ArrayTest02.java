package kr.co.dong;

import java.util.Scanner;

public class ArrayTest02 {
	public static void main(String[] args) {
//		01���� �����͸� console�� �Է¹޾Ƽ� ����Ѵ�.

//		1.����
		String[] dName = null;
		Scanner scan = null;
		int size = 4; //ũ��
		
//		1-1.����
		dName = new String[size];
		scan = new Scanner(System.in);
		
//		2. �Է�
		for (int i = 0; i < dName.length; i++) {
			System.out.println("dName[" + i + "]�� �� ���Ḧ �Է� > : ");
			dName[i] = scan.nextLine();
		}

//		3. ó��
		
//		4. ���
		for (int i = 0; i < dName.length; i++) {
			System.out.println("dName[" + i + "] = " + dName[i]);
		}

	}
}
