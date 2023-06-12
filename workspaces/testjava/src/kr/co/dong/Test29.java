package kr.co.dong;

public class Test29 {
	public static void main(String[] args) {
		int n = 100;
		int m = 4;
		int[] section = new int[100000];
		int answer = 0;
        int idx = 0;
                
        while(true){
            int sum = 0;
            
            for(int i = idx; i<section.length; i++){
            	if(i != section.length-1)
            		sum += section[i+1] - section[i] + 1;
//            		System.out.println("1");
                if(sum >= m) {
                    idx = i+1;
//                    System.out.println("2");
                	break;
                }
            }
//            System.out.println("3");
            answer ++;
            if(idx == section.length -1){
//            	System.out.println("4");
            	answer ++;
                break;
            }
        }   
        System.out.println("answer : "+answer);
	}
}
