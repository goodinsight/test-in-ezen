package kr.co.dong;

public class WhileTest02 {
	public static void main(String[] args) {
//		1부터 10까지 합 구하기 -> while문으로
		int sum1 = 0;

		for (int i = 1; i <= 10; i++) {
			sum1 += i;
		}
		System.out.println("합 : " + sum1);

		int i = 0;
		int sum2 = 0;
		while (i <= 10) {
			sum2 += i;
			i++;
		}
		System.out.println("합 : " + sum2);
	}
}
