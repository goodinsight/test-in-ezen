package kr.co.dong;

import java.util.Scanner;

public class WhileTest01 {
	public static void main(String[] args) {
//		������ �Է¹޾Ƽ� ����ϰ�
//		999 ������ �ý��� ����(�ݺ��� Ż��)
		int num = 0;
		Scanner scan = new Scanner(System.in);
		
		boolean stop = false;
		
		while(!stop){
			System.out.print("Input Data (stop => 999):");
			num = scan.nextInt();
			if (num == 999) {
//				break;
				stop = true;
			} 
			System.out.println("�Է¹��� ����: " + num);

//			if (num == 999) {
//				break;
//			} else {
//				System.out.println("�Է¹��� ����: " + num);
//			}
		}
		
		System.out.println("END!!");
	}
}
