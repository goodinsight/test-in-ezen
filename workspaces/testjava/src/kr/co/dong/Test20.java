package kr.co.dong;

public class Test20 {
	public static void main(String[] args) {
		String my_str = "abc1Addfggg4556b";
		int n = 6;
//		String my_str = "abcdef123";
//		int n = 3;
				
		String[] answer = new String[(my_str.length()-1)/n+1];
        for (int i = 0; i < answer.length; i++){
            answer[i] = my_str.substring(0,n);
            System.out.println(answer[i]);
            if(i != answer.length) {
            	my_str = my_str.substring(n);
            	System.out.println(my_str);
            }
        }
        
        for (int i =0; i< answer.length; i++) {
        	System.out.println(answer[i]);
        }
	}
}
