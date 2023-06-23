package kr.co.dong;

public class Test46 {
	public static void main(String[] args) {
		String s ="        ";
//		String s ="  TrY  HeLlO   WoRlD       ";
		String answer = "";
        String[] tmp = s.split(" ");
        for(int i = 0; i< tmp.length; i++)
        	System.out.println(tmp[i]);
        for(int i = 0; i< tmp.length; i++){
            if(tmp[i]!=" "){
                for(int j = 0; j<tmp[i].length(); j++){
                    if(j % 2 == 0){
                        answer += String.valueOf(tmp[i].charAt(j)).toUpperCase();
                        System.out.println(answer);
                    }
                    else {
                        answer += String.valueOf(tmp[i].charAt(j)).toLowerCase();
                        System.out.println(answer);
                    }
                }
                if(i != tmp.length - 1)
                    answer +=" ";
            }
        }
        while(s.length()!=answer.length()){
        	answer +=" ";
        }
        System.out.println("\""+answer+"\"");
	}
}
