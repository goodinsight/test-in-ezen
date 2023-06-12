package kr.co.dong.func;

public class FunTest01 {
	public static void main(String[] args) {
//		두수의 합 구하기
		int n1 = 0, n2 = 0;
		int s = 0;
//		입력
		n1 = 20;
		n2 = 30;
//		처리: 두수의 합을 구하는 함수
		s = sum(n1, n2);

		System.out.println("합 : " + s);
		
		sum2(n1, n2);
		
	}

	static int sum(int n1, int n2) {
		return n1 + n2;
	}
	static void sum2(int n1, int n2) {
		System.out.println("합 : " + (n1+n2));
	}
}
