package kr.co.dong;

import java.util.ArrayList;

public class Test44 {
	public static void main(String[] args) {
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		String[] answer = new String[n];
		for(int i = 0; i<answer.length; i++) {
			answer[i] = "";
		}
		for (int i = 0; i < n; i++) {
			String tmp1 = Integer.toBinaryString(arr1[i]);
			String tmp2 = Integer.toBinaryString(arr2[i]);
			System.out.println(tmp1);
			System.out.println(tmp2);
			for(int j = 0 ; j<n ; j++){
                if(tmp2.length() < n){
                    tmp2 = "0"+tmp2;
                }else if(tmp1.length() < n){
                    tmp1 = "0"+tmp1;
                }
                if(tmp1.length() == n && tmp2.length() == n)
                    break;
            }
			System.out.println(tmp1);
			System.out.println(tmp2);
			for (int j = 0; j < tmp1.length(); j++) {
				if (tmp1.charAt(j) == '0' && tmp2.charAt(j) == '0')
					answer[i] += " ";
				if (tmp1.charAt(j) == '1' || tmp2.charAt(j) == '1')
					answer[i] += "#";
			}
			System.out.println(answer[i]);
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}

	}
}
