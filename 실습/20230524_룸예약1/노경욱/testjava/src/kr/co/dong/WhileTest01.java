package kr.co.dong;

import java.util.Scanner;

public class WhileTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		������ �Է¹޾Ƽ� ����ϰ�
//		999 ������ �ý��� ����!
		boolean done = false;
		int num = 0;
		Scanner scan = new Scanner(System.in);

		while (!done) {
			System.out.print("Input Data: ");
			num = scan.nextInt();
			if (num == 999) {
				break;
			}
//			} else {
//				System.out.println("�Է¹��� ����: " + num);
//			}
			System.out.println("�Է¹��� ����: " + num);
		}

		System.out.println("End");
	}

}
