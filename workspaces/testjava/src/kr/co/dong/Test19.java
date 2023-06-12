package kr.co.dong;

public class Test19 {
	public static void main(String[] args) {
		String A = "hello";
		String B = "ohell";
		String tmp = A;
        int answer = 0;
        int count = 0;
        for(int i =0; i<A.length(); i++){
            tmp = tmp.charAt(A.length()-1) + tmp.substring(0,A.length()-1);
            System.out.println(tmp);
            count++;
            if(tmp != B)
                continue;
            else
                answer = count;
                break;
        }
        if (count == A.length())
            answer = -1;
        else
            answer = count;
        System.out.println(answer);
	}
}
