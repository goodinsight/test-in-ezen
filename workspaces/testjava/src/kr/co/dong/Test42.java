package kr.co.dong;

public class Test42 {
	public static void main(String[] args) {
		String new_id = "z-+.^.";
		String answer = "";
        new_id = new_id.toLowerCase();
        for(int i = 0; i < new_id.length(); i++){
            char ch = new_id.charAt(i);
            if(('a'<= ch && ch <='z') || ('0'<= ch && ch <= '9') || ch == '-' || ch == '_' || ch =='.')
                answer += ch;
        }
        for(int i = 0; i < answer.length(); i++){
            if(i == 0 && answer.charAt(i) == '.'){
                answer = answer.substring(1);
                i--;
                System.out.println("1   " +answer);
            }else if(answer.charAt(i) == '.'){
                if(i+1 < answer.length() && answer.charAt(i+1) == '.'){
                    answer = answer.replace("..",".");
                    i--;
                }
            }else if(i == answer.length()-1 && answer.charAt(i) == '.'){
                answer =answer.substring(0,answer.length()-1);
                i--;
            }
        }
        if(answer.length() == 0)
            answer = "a";
        if(answer.length() >= 16)
            answer = answer.substring(0,15);
        if(answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0,answer.length()-1);
        if(answer.length()<=2)
            answer +=answer.charAt(answer.length()-1);
        if(answer.length()<=2)
            answer +=answer.charAt(answer.length()-1);
        System.out.println("2    " + answer);
	}
}
