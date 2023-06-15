package kr.co.dong;

public class Test09 {
	public static void main(String[] args) {
		String answer = "";
        int mode = 0;
        String ret = "";
        String code = "abc1abc1abc";
        
        for (int idx = 0; idx < code.length(); idx++){
            if (mode == 0) {
                if (code.charAt(idx) != '1') {
                    if (idx % 2 == 0) {
                        ret += code.charAt(idx);
                    }
                } else{
                    mode = 1;
                }
            } else if (mode == 1) {
                if (code.charAt(idx) != '1') {
                    if (idx % 2 == 1) {
                        ret += code.charAt(idx);
                    }
                } else{
                    mode = 0;
                }
            }
        }
        answer  = ret;
        System.out.println(answer);
	}
}
