package kr.co.dong;

import java.util.Arrays;
import java.util.ArrayList;

public class Test45 {
	public static void main(String[] args) {
		int n = 118372;
		String tmp = String.valueOf(n);
        char[] ch = tmp.toCharArray();
        Arrays.sort(ch);
        for(int i =0 ; i < ch.length; i++) {
        	System.out.print(ch[i] + ", ");
        }
        String tmp1 = ch.toString();
        System.out.println(tmp1);
        StringBuffer bs = new StringBuffer(tmp1);
        bs.reverse();
        String tmp2 = bs.toString();
        System.out.println(tmp2);
        long answer = Long.parseLong(tmp2);
        System.out.println(answer);
	}
}
