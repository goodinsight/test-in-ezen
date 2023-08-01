package kr.co.dong;

public class test1 {
	public static void main(String[] args) {
		String a = "1001110";
		int b = binaryOneCount(a);
		System.out.println(b);
		
	}
	 public static int binaryOneCount(String b){
	        int len1 = b.length();
	        int len2 = b.replace("1","").length();
	        return len1-len2;
	    }
	 public static String integerToBinary(int a){
	        String tmp = Integer.toBinaryString(a);
	        return tmp;
	    }
}
