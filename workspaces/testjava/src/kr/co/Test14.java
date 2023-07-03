package kr.co;

public class Test14 {
	public static void main(String[] args) {
		String my_string = "Bcad";
		String answer = "";
        String tmp = my_string.toLowerCase();
        int[] temp = new int[tmp.length()];
        for(int i = 0; i< tmp.length(); i++){
            temp[i] = tmp.charAt(i) - 'a';
        }
        for(int i = 0; i< tmp.length(); i++){
        	System.out.println(temp[i]);
        }
             
        for(int i = 0; i< tmp.length(); i++){
            for(int j = 0; j< i; j++){
                if(temp[i] < temp[j]){
                    int t = temp[i];
                    temp[i] = temp[j];
                    temp[j] = t;
                }
            }
        }
        for(int i = 0; i< tmp.length(); i++){
        	System.out.println(temp[i]);
        }
        for(int i = 0; i< answer.length(); i++){
            answer += (char)(temp[i] +'a');
        }
        System.out.println(answer);
	}
}
