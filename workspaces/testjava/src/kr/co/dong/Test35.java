
package kr.co.dong;

import java.util.ArrayList;

public class Test35 {
	public static void main(String[] args) {
		String s = "aaabb";
		int answer = 0;
        char[] ch = s.toCharArray();
        int sameCount = 0;
        int diffCount = 0;
        ArrayList<String> list = new ArrayList<String>(); 
        for(int i = 0; i< ch.length; i++){
            for(int j = i; j<ch.length; j++){
                if(ch[i]==ch[j])
                    sameCount++;
                else
                    diffCount++;
                if(sameCount == diffCount){
                    list.add(s.substring(i,j));
                    i = j;                    
                    break;
                }else if(j==ch.length-1){
                    list.add(s.substring(i));
                    i = j;
                    break;
                }
            }   
        }
        answer = list.size();
        System.out.println(answer);
        
        
	}
}
