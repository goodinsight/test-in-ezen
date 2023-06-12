package kr.co.dong.ioclasses;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		String str = "���,��,��,�������,�質��,������";
		StringTokenizer tokenstr = null;
		
		tokenstr = new StringTokenizer(str, ",");
		System.out.println(tokenstr);
		System.out.println(tokenstr.countTokens());
		
		int count = tokenstr.countTokens();
		for(int i = 0; i<count; i++) {
			String data = tokenstr.nextToken();
			System.out.println(data);
		}
	}
}
