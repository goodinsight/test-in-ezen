package kr.co;

public class Test15 {
	public static void main(String[] args) {
		String[] quiz = {"-3 - -4 = -3", "-5 + -6 = -11"};
		String[] answer = new String[quiz.length];
        int[] plus = new int[quiz.length];
        int[] minus = new int[quiz.length];
        int[] equal = new int[quiz.length];
        for(int i = 0; i<quiz.length; i++){
            plus[i] = quiz[i].indexOf(" + ");
            minus[i] = quiz[i].indexOf(" - ");
            equal[i] = quiz[i].indexOf(" = ");
        }
        int a = 0;
        int b = 0;
        int sum = 0;
        for(int i = 0; i<quiz.length; i++){
            if(plus[i] != -1){
                a = Integer.parseInt(quiz[i].substring(0,plus[i]));
                b = Integer.parseInt(quiz[i].substring(plus[i]+3,equal[i]));
                sum = Integer.parseInt(quiz[i].substring(equal[i]+3));
                if(a+b == sum)
                    answer[i] = "O";
                else
                    answer[i] = "X";
                
            }else if(minus[i] != -1){
                a = Integer.parseInt(quiz[i].substring(0,minus[i]));
                b = Integer.parseInt(quiz[i].substring(minus[i]+3,equal[i]));
                sum = Integer.parseInt(quiz[i].substring(equal[i]+3));
                if(a-b == sum)
                    answer[i] = "O";
                else
                    answer[i] = "X";
            }
        }
        for(int i = 0; i<quiz.length; i++)
        	System.out.println(answer[i]);
	}
}
