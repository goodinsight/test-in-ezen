package com.javalec.ex;


public class TextEx3 {
    public static void main(String[] args){
    	String my_string1 = "He11oWor1d";
    	String overwrite_string1 = "lloWorl";
        int s1 = 2;
        String my_string2 = "Program29b8UYP";
        String overwrite_string2 = "merS123";
        int s2 = 7;
        
        Solution1 result1 =new Solution1();
        String a = result1.solution(my_string1, overwrite_string1, s1);
        Solution1 result2 =new Solution1();
        String b = result2.solution(my_string2, overwrite_string2, s2);
        System.out.println(a);
        System.out.println(b);
        }
    }
class Solution1 {
	public String solution(String my_string, String overwrite_string, int s) {
		String answer = "";
		for (int i = 0 ; i < my_string.length(); i++) {
			if (i < s) {
				answer += my_string.charAt(i);
			}else if (i < s + overwrite_string.length()) {
				answer += overwrite_string.charAt(i-s);
			}else {
				answer += my_string.charAt(i);
			}
		}

		return answer;
	}
}