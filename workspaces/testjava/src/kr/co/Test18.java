package kr.co;

public class Test18 {
	public static void main(String[] args) {
		String bin1 = "0";
		String bin2 = "0";
		int sum1 = 0;
        for(int i = 0; i<bin1.length(); i++){
            sum1 *= 2;
            sum1 += (bin1.charAt(i) - '0');
        }
        int sum2 = 0;
        for(int i = 0; i<bin2.length(); i++){
            sum2 *= 2;
            sum2 += (bin2.charAt(i) - '0');
        }
        int sum = sum1 + sum2;
        System.out.println(sum);
        String tmp = "";
        int count = 0;
        for(count = 0; sum >0; count++){
            tmp += Integer.toString(sum % 2);
            sum /= 2;
        }
        System.out.println(tmp);
        String answer = "";
        for(int i =1; i<=count; i++)
            answer += tmp.charAt(tmp.length()-i);
        System.out.println(answer);
	}
}
