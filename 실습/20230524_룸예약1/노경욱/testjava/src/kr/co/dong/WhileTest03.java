package kr.co.dong;

import java.util.Scanner;

public class WhileTest03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		���� 12345�� �Է¹޾Ƽ� �� �ڸ����� ���� ���ϼ���.
		int num = 0, sum = 0;
		Scanner scan = new Scanner(System.in);

//		�Է�
		System.out.print("������ �Է��ϼ���: ");
		num = scan.nextInt();
		
//		ó��
		while (num != 0) {
			sum = sum + num % 10; //12345�� 10�� ���� ������: 5
			num = num / 10;      //12345�� 10�� ���� ��:1234
		}
		
//		���
		System.out.println(sum);
	}

}
