package kr.co.dong.func;

public class FuncTest05 {
	public static void main(String[] args) {
		printView(10, "$");
		printView(3, "&");
		printView(5, "*%#");
	}

	private static void printView(int i, String string) {
		// Ư�����ڿ� Ƚ���� �Է¹޾Ƽ� �� Ƚ����ŭ Ư������ �ݺ����
		for (int a=0; a<i; a++) {
			System.out.print(string);
		}
		System.out.println();
	}
}
