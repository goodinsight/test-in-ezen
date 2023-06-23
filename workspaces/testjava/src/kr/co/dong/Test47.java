package kr.co.dong;

import java.util.ArrayList;

public class Test47 {
	public static void main(String[] args) {
		int n = 9999999;
		ArrayList<Integer> list = new ArrayList<>();
		int answer = 0;
		int cnt = 0;
		list.add(2);
		for (int i = 3; i <= n; i+=2) {
			for (int j = 0; j < Math.sqrt(n); j++) {
				cnt = 1;
				if (i % list.get(j) == 0) {
					cnt = 0;
					break;
				}
				if(j == list.size() - 1)
					break;
			}
			if (cnt == 1) {
				list.add(i);
			}
		}
		answer = list.size();
		System.out.println(answer);
	}
}
