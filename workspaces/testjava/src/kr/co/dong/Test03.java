package kr.co.dong;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Test03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int firstDice = -1;
		System.out.print("ù��° �ֻ����� �Է�(1~6) : ");
		firstDice = scan.nextInt();
		int secondDice = -1;
		System.out.print("�ι�° �ֻ����� �Է�(1~6) : ");
		secondDice = scan.nextInt();
		int sum = firstDice + secondDice;
		int[] prize = {5, 7, 10};
		
		if (IntStream.of(prize).anyMatch(x -> x == sum)) {
			System.out.println("��÷");
		}else {
			System.out.println("��÷�� �ƴմϴ�.");
		}
		scan.close();
	}
}
