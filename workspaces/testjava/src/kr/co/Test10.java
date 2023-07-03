package kr.co;

import java.util.Arrays;

public class Test10 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 100, 99, 98 };
		int answer = 0;
		int[] tmp = arr.clone();
		int sum = arr.length;
		while(true){
			sum = arr.length;
			int[] tmp1 = tmp.clone();
			System.out.println("tmp:" + Arrays.toString(tmp));
			System.out.println("tmp1:" + Arrays.toString(tmp1));
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i] >= 50 && tmp[i] % 2 == 0) {
					tmp[i] /= 2;
				} else if (tmp[i] < 50 && tmp[i] % 2 == 1) {
					tmp[i] = tmp[i] * 2 + 1;
				}
			}
			System.out.println("tmp:" + Arrays.toString(tmp));
			System.out.println("tmp1:" + Arrays.toString(tmp1));
			for (int i =0; i<tmp.length; i++) {
				if(tmp[i] == tmp1[i]) {
					sum -= 1;
				}
			}
			System.out.println(sum);
			if (sum == 0)
				break;
			answer += 1;
		}
		System.out.println(answer);

	}
}
