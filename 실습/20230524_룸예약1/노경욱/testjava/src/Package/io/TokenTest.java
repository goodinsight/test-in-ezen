package Package.io;

import java.util.StringTokenizer;

public class TokenTest {
	public static void main(String[] args) {
		String str = "사과,배,강,사과나무,배나무,감나무";
//		,를 기준으로 추출하기
		StringTokenizer tokenstr = null;

		tokenstr = new StringTokenizer(str, ",");
		System.out.println(tokenstr);
		System.out.println(tokenstr.countTokens());
		int count = tokenstr.countTokens();

		for (int i = 0; i < count; i++) {
			String data = tokenstr.nextToken();
			System.out.println(data);
		}
	}
}
