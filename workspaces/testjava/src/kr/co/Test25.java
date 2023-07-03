package kr.co;

public class Test25 {
	public static void main(String[] args) {
		int balls = 5;
		int share = 3;
		float answer = 1;
		
		for (int i = balls, j = 1, k = 1; i>= 1; i--, j++, k++) {
			answer *=(float)i;
			if(j <= share)
				answer /=(float)j;
			if(k <= balls - share)
				answer /=(float)k;
		}
		System.out.println(answer);
	}
}
