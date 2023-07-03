package kr.co;

public class Test29 {
	public static void main(String[] args) {
		String t = "10203";
		String p = "15";
		
        int answer = 0;
        for(int i = 0; i < t.length()-p.length()+1; i++){
            for(int j = 0; j<p.length(); j++){  
                if(p.charAt(j) - t.substring(i,p.length()+i).charAt(j) > 0) {
                    answer++;
                	break;
                }else if(p.charAt(j) - t.substring(i,p.length()+i).charAt(j)< 0) {
                	break;
                }
                if(j == p.length()-1 && p.charAt(j) - t.substring(i,p.length()+i).charAt(j) == 0) {
                	answer++;
                }
            }
        }
        System.out.println(answer);
	}
}
