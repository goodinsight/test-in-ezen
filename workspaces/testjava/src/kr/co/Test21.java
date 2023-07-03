package kr.co;

public class Test21 {
	public static void main(String[] args) {

		String a = "582";
		String b = "734";
		String sum = "";
		int ollim = 0;
		if (a.length() < b.length()) {
			for (int i = 0; i < b.length() - a.length(); i++) {
				a = "0" + a;
			}
		} else {
			for (int i = 0; i < a.length() - b.length(); i++) {
				b = "0" + b;
			}
		}
		int len = a.length();
		for (int i = 0; i < len; i++) {
			if (a.charAt(a.length() - 1) - '0' + b.charAt(b.length() - 1) - '0' + ollim < 10) {
				System.out.println("a");
				sum += (char) (a.charAt(a.length() - 1) - '0' + b.charAt(b.length() - 1) + ollim);
				System.out.println(sum);
				a = a.substring(0, a.length() - 1);
				b = b.substring(0, b.length() - 1);
				System.out.println(a);
				System.out.println(b);
				ollim = 0;
			} else {
				System.out.println("b");
				if(i != len-1)
					sum += (char) (a.charAt(a.length() - 1) - '0' + b.charAt(b.length() - 1) - 10 + ollim);
				else
					sum += "1" +(char)(a.charAt(a.length() - 1) - '0' + b.charAt(b.length() - 1) - 10 + ollim);
				System.out.println(sum);
				a = a.substring(0, a.length() - 1);
				b = b.substring(0, b.length() - 1);
				System.out.println(a);
				System.out.println(b);
				ollim = 1;
			}
		}
		StringBuffer sb = new StringBuffer(sum);
		sb.reverse();
		String answer = sb.toString();
		System.out.println(answer);
	}

	static void print(String[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}
}
