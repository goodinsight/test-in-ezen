package kr.co.dong;

import java.util.Arrays;

public class Test09 {
	public static void main(String[] args) {
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		int N = 5;
		
		int[] answer = new int[N];
		float[] rate = new float[N+1];
		int[] tmp = new int[N+1];
		for (int i = 0; i < N+1; i++)
			tmp[i] = i + 1;
		Arrays.sort(stages);
		int idx = 0;
		int cnt = 0;
		int sumofcnt = 0;
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] == tmp[idx]) {
				cnt++;
			} else {
				sumofcnt += cnt;
				rate[idx] = cnt / (float) (stages.length - sumofcnt);
				cnt = 0;
				idx++;
				i--;
			}
			if(sumofcnt + cnt == stages.length && i== stages.length-1) {
				rate[idx] = 1.0F;
			}	
		}
		for (int i = 0; i <rate.length; i++) {
			System.out.print(rate[i] + ", ");
		}
		System.out.println();
		for (int i = rate.length-2; i >= 0; i--) {
			for (int j = rate.length-2; j > i; j--) {
				if (rate[i] < rate[j]) {
					float tmp1 = rate[i];
					rate[i] = rate[j];
					rate[j] = tmp1;
					int tmp2 = tmp[i];
					tmp[i] = tmp[j];
					tmp[j] = tmp2;
				}
			}
		}
		for (int i = 0; i <answer.length; i++) {
			answer[i] = tmp[i];
			System.out.println(answer[i] + ", ");
		}
	}
}
