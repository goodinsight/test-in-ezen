package kr.co.dong;

public class ForTest02 {
	public static void main(String[] args) {

		//		1+2+3+4+5 ~ +9 +10 의 값을 구하세요
		int i  = 0;
		int n = 10;
		int sum = 0;
		for (i = 1; i <= n; i++) {
			sum += i;
			System.out.println("i=" + i + " 일때 sum = " + sum);
		}
		System.out.println("최종값은:" + sum);
	}
}
