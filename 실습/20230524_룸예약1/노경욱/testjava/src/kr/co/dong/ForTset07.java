package kr.co.dong;

import java.util.Scanner;

public class ForTset07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1���� �Է¹��� �� ������ �� ���ϱ�
		int hap = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���: ");
		int num = scan.nextInt();

		for (int i = 1; i <= num; i++) {
			hap = hap + i;
		}
		System.out.println(hap);
	}
	

}
