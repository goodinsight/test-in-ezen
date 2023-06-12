package kr.co.dong;

public class Test13 {
	public static void main(String[] args) {
		String[] intStrs = {"0123456789","9876543210","9999999999999"};
		int k = 50000;
		int s = 5;
		int l = 5;
		
		
		String tmp = "";
        for (int i = 0; i < intStrs.length; i++) {
            if (intStrs[i].length() >= s+l){
                String str = intStrs[i].substring(s, s+l);
                if (Integer.parseInt(str) > k){
                    tmp += str+",";
                }    
            }
        }
        String[] temp = tmp.split(",");
        int[] answer = new int[temp.length];
        for (int i = 0; i<temp.length; i++){
            answer[i] = Integer.parseInt(temp[i]);
        }
	}
}
