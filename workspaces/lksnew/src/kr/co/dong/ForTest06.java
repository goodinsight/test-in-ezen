package kr.co.dong;

public class ForTest06 {
	public static void main(String[] args) {
//		1부터 10까지의 합 구한다
//		단 출력형식 " 1+2+3+ ~~~ + 9 = 55"
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			System.out.print(i);
			sum += i;
			if (i == 10) {
				break;
			} else {
				System.out.print(" + ");
			}
		}
		System.out.println(" = " + sum);
	}
}
