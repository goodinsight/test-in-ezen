package kr.co.dong;

public class Test30 {
	public static void main(String[] args) {
		int n = 8;
		int m = 4;
		int[] section = {2, 3, 6};
		
		int answer = 0;
		int sum = 1;
		for (int i = 0; i < section.length-1; i++) {
			if(section[i+1] - section[i] < m && sum < m) {
				sum += section[i+1]- section[i];
				System.out.println("1");
				System.out.println("answer : "+answer);
				System.out.println("sum : "+sum);
			}else if(section[i+1] - section[i] == m ) {
				answer++;
				i++;
				sum = 1;
				System.out.println("2");
			}else {
				answer++;
				sum = 1;
				System.out.println("3");
			}
		}

		if(section[section.length-1] - section[section.length-2] >= m) {
			answer ++;
			System.out.println("4");
		}else if(sum + section[section.length-1] - section[section.length-2] > m ) {
			answer ++;
			System.out.println("5");
		}
		
		System.out.println("answer : "+answer);
	}
}
