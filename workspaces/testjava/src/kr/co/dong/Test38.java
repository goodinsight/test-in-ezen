package kr.co.dong;

public class Test38 {
	public static void main(String[] args) {
		int a = 3;
		int b = 1;
		int n = 20;
		
		int answer = 0;
		int newByung = 0;
		int binByung = 0;
		
		newByung = n / a;
		binByung = n % a;
		while(true) {
			answer += newByung;
			System.out.println(answer);
			int nB = newByung;
			newByung = ((newByung+binByung) / a) * b;
			System.out.println(newByung);
			binByung = (nB % a + binByung) % a;
			System.out.println(binByung);

			if(newByung == 0)
				break;
		}	
		System.out.println(answer);
	}
}
