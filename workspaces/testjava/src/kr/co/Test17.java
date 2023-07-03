package kr.co;

public class Test17 {
	public static void main(String[] args) {
		String my_string = "people";
		String answer = my_string;
        for(int i =0; i < answer.length(); i++){
            if(answer.substring(i+1).contains(answer.charAt(i)+"")){
                answer = answer.substring(0,i+1)+answer.substring(i+1).replace(answer.charAt(i)+"","");
                System.out.println(answer);
                i--;
            }
        }
        System.out.println("ÃÖÁ¾ : " + answer);
	}
}
