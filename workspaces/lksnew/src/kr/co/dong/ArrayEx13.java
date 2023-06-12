package kr.co.dong;

public class ArrayEx13 {
	public static void main(String[] args) {
		char[] hex = {'C', 'A', 'F', 'E'};
		String answer = "";
		String[] binary = {"0000", "0001", "0010", 
				"0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
		for (int i = 0; i<hex.length; i++) {
			if (hex[i] >='0' && hex[i] <= '9') {
				answer += binary[hex[i]-'0'];
			} else {
				answer += binary[hex[i]-'A'+10];
			}
		}
		String a = new String(hex);
		System.out.println("16진수 hex = "+a+"를 2진수로 바꾸면,");
		System.out.println(answer);
	}
}
