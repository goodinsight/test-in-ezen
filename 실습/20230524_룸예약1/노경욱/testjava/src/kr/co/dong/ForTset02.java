package kr.co.dong;

public class ForTset02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		1+2+3+4+5 ~ +9 + 10의 값을 구하세요
		int hap = 0;
		for (int i = 1; i <= 10; i++) {
			hap = hap + i;
			System.out.println("더하는 값: " + i);
			System.out.println("더해진 값: " + hap + "\n");
		}
	}

}
