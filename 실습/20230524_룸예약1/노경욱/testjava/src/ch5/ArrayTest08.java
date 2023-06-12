package ch5;

public class ArrayTest08 {
	public static void main(String[] args) {
//		로또 생성기(1~10)
		int[] lotto = null; // 선언
		lotto = new int[6]; // 생성

//		번호받기
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 10) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;                          //for문에 i값을 줄여서 다시시도
				}
			}
		}
//		중복처리

//		번호들 출력
		for (int n : lotto) {
			System.out.print(n + ", ");
		}
	}
}
