package kr.co;

public class Test30 {
	public static void main(String[] args) {
		String s = "banana";
		char[] ch = s.toCharArray();
		int[] answer = new int[ch.length];
		answer[0] = -1;
		for(int i = 0; i< ch.length; i++) {
			for(int j = 0; j<i; j++) {
				if(ch[i] == ch[j]) {
					answer[i] = i-j;
					System.out.println("i = "+i+", answer["+i+"] = "+ answer[i] );
				}else {
					if(answer[i] == 0)
						answer[i] = -1;
					System.out.println("i = "+i+", answer["+i+"] = "+ answer[i] );
				}
			}
		}
		for(int i = 0; i<answer.length; i++) {
			System.out.print(answer[i]+ ", ");
		}
	}
}
