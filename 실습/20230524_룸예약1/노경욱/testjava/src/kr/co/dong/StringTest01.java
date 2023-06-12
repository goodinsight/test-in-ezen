package kr.co.dong;

public class StringTest01 {
	public static void main(String[] args) {
		String str = "Do not sleeping!!";

		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(3));
		System.out.println(str.charAt(4));
		System.out.println(str.charAt(5));

		int len = str.length();
		System.out.println("문자열의 길이: " + len);
		
		for (int i = 0; i < len;i++) {
			System.out.print(str.charAt(i));
		}
		System.out.println();
		
		System.out.println(str.contains("ot"));
		System.out.println(str.indexOf('D'));
	}
}
