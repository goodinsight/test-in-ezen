package kr.co.dong;

import java.util.Scanner;

public class ForTset09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		���۰��� ���������� �Է¹ް� ������ ���ϱ�
		int hap = 0;
		int startt = 1;
		int lastt = 0;

		while (startt > lastt) {
			System.out.print("���۰��� �Է��Ͻÿ�: ");
			Scanner scan = new Scanner(System.in);
			startt = scan.nextInt();

			System.out.print("���������� �Է��Ͻÿ�: ");
			Scanner scan2 = new Scanner(System.in);
			lastt = scan2.nextInt();
			
			if (startt < lastt) {
				break;
			}
			System.out.println("�ٽ� �Է��ϼ���");
		}

		for (int i = startt; i <= lastt; i++) {
			hap = hap + i;
		}
		System.out.println("����: " + hap);

	}

}
