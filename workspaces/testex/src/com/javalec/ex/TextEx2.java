package com.javalec.ex;


public class TextEx2 {
    public static void main(String[] args){
    	String my_string1 = "He11oWor1d";
    	String overwrite_string1 = "lloWorl";
        int s1 = 2;
        String my_string2 = "Program29b8UYP";
        String overwrite_string2 = "merS123";
        int s2 = 7;
        
        Solution result1 =new Solution();
        String a = result1.solution(my_string1, overwrite_string1, s1);
        Solution result2 =new Solution();
        String b = result2.solution(my_string2, overwrite_string2, s2);
        System.out.println(a);
        System.out.println(b);
        }
    }
class Solution {
	public String solution(String my_string, String overwrite_string, int s) {
		String answer = "";
		for (int i = s; i < s + overwrite_string.length(); i++){
			char ch = my_string.charAt(i);
			answer = my_string.replace(ch, overwrite_string.charAt(i-s));
		}
		return answer;
	}
}