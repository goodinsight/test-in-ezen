package kr.co.dong;

import java.util.Scanner;

public class ArrayTest02_3 {
	public static void main(String[] args) {
		
//		5���� ����� �̸��� ��� �׸��� ������ �Է��ϱ�
		
		String[] name = null;
		String[] hobby = null;
		String[] bloodtype = null;
		Scanner scan = null;
		int num = 1; // ũ��
		
		name = new String[num];
		hobby = new String[num];
		bloodtype = new String[num];
		scan = new Scanner(System.in);
		
		for (int i = 0; i < num; i++) {
			System.out.println(i+1 + "��° ����� �̸��� �Է� :");
			name[i] = scan.nextLine();
			System.out.println(i+1 + "��° ����� ��̸� �Է� :");
			hobby[i] = scan.nextLine();
			System.out.println(i+1 + "��° ����� �������� �Է� :");
			bloodtype[i] = scan.nextLine();
			
		}
		
		for (int i = 0; i < num; i++) {
			System.out.printf(i+1+"��° ����� �̸�:%s, ���:%s, ������:%s �Դϴ�.%n", name[i], hobby[i], bloodtype[i]);
		}

	}
}
