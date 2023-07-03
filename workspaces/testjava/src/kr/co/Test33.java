package kr.co;

public class Test33 {
	public static void main(String[] args) {
		String[] babbling ={"ayayeayayeayayemaya", "uyeuu", "yeyeye", "yemawooyemawoo", "ayaayaa","eye","woo","ye","aya","maye"};
		int answer = 0;
        for(int i = 0; i<babbling.length; i++){
            int len = babbling[i].length();
            babbling[i] = babbling[i].replaceFirst("yeye","");
            if(babbling[i].length() != len) {
            	System.out.println(1+babbling[i]);
            	System.out.println("continue");
            	continue;
            }
            babbling[i] = babbling[i].replaceFirst("woowoo","");
            if(babbling[i].length() != len){
            	System.out.println(2+babbling[i]);
            	System.out.println("continue");
            	continue;
            }
            babbling[i] = babbling[i].replaceFirst("mama","");
            if(babbling[i].length() != len){
            	System.out.println(3+babbling[i]);
            	System.out.println("continue");
            	continue;
            }
            babbling[i] = babbling[i].replaceFirst("ayaaya","");
            if(babbling[i].length() != len){
            	System.out.println(4+babbling[i]);
            	System.out.println("continue");
            	continue;
            }
            for(int j = 0; j<7; j++){
                babbling[i] = babbling[i].replaceFirst("ye","");
                babbling[i] = babbling[i].replaceFirst("woo","");
                babbling[i] = babbling[i].replaceFirst("ma","");
                babbling[i] = babbling[i].replaceFirst("aya","");
              
            }
            System.out.println(5+babbling[i]);
            if(babbling[i].length() == 0)
                answer++;
        }   
        System.out.println(answer);
	}
}
