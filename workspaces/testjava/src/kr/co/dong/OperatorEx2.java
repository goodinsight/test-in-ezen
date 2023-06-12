package kr.co.dong;

public class OperatorEx2 {

	public static void main(String[] args) {
		int i = 5;
		int j = 5;
		
		System.out.println(i++);
		System.out.println(++j);
		System.out.println("i = "+i+", j = "+j);
		
		int x = 5;
		x = x++ - ++x;
		System.out.println(x);
		
		i = -10;
		i = +i;
		System.out.println(i);
		i = -i;
		System.out.println(i);
			}

}
