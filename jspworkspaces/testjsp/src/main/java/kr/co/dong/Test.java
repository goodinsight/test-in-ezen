package kr.co.dong;

import java.util.ArrayList;
public class Test {
	public static void main(String[] args) {
		String s = "110010101001";
		int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        while(true){
            int len1 = s.length();
            s = s.replace("0", "");
            int len2 = s.length();
            list.add(len1-len2);
            s = String.valueOf(Integer.parseInt(s, 2));
            System.out.println(s);
            if(s.equals("1"))
                break;
        }
        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i));
        }
	}
}
