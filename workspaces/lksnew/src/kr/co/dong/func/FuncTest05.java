package kr.co.dong.func;

public class FuncTest05 {
	public static void main(String[] args) {
		printView(10, "$");
		printView(3, "&");
		printView(5, "*%#");
	}

	private static void printView(int i, String string) {
		// 특수문자와 횟수를 입력받아서 그 횟수만큼 특수문자 반복출력
		for (int a=0; a<i; a++) {
			System.out.print(string);
		}
		System.out.println();
	}
}
