/*
 * 2���� �ֻ����� �ַܼ� �Է¹޾Ƽ� �� ���� 5, 7, 10�̸� "��÷", �ƴϸ� "��÷�� �ƴմϴ�."
 */
package kr.co.dong;

import java.util.Scanner;

public class IfTset04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0, num2 = 0, hap = 0;
		
		System.out.print("ù��° �ֻ����� �Է��Ͻÿ�: ");
		Scanner scan1 = new Scanner(System.in);
		num1 = scan1.nextInt();
		
		System.out.print("�ι�° �ֻ����� �Է��Ͻÿ�: ");
		Scanner scan2 = new Scanner(System.in);
		num2 = scan2.nextInt();
		
		hap = num1 + num2;
		
		if (hap == 5 || hap == 7 || hap == 10) {
			System.out.println("��÷�Դϴ�.");
		}else {
			System.out.println("��÷�� �ƴմϴ�.");
		}
	}

}
